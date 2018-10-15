package sep.project;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harald
 *
 */
public class ClientWorker extends Server implements Runnable {

    private Socket client;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    ClientWorker(Socket client) throws IOException {
        this.client = client;
        inputStream = new ObjectInputStream(client.getInputStream());
        outputStream = new ObjectOutputStream(client.getOutputStream());
    }

    public void run() {
        try {
            Form f = (Form) inputStream.readObject();
            if (f.type.equals("Update")) {  // client sent in request for update
                sendPending(f); // send pending forms to the client
                inputStream.close();
                client.close();
                return;
            } else if (f.type.equals("EventRequestForm")) {
                EventRequestForm e = (EventRequestForm) f;
                if (e.id == 0) { // new event request
                    e.id = getId();
                } else if (e.sender.equals("ProductionManager") || e.sender.equals("ServiceManager")) {
                    handleApproval(e);
                    inputStream.close();
                    client.close();
                    return;
                }
            }
            addForm(f); // add form to right user queue
            inputStream.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addForm(Form f) {
        switch (f.receiver) {
            case "SeniorCS":
                addToList(SeniorCS, f);
                break;
            case "FinancialManager":
                addToList(FinancialManager, f);
                break;
            case "AdminManager":
                addToList(AdminManager, f);
                break;
            case "ProductionManager":
                addToList(ProductionManager, f);
                break;
            case "ServiceManager":
                addToList(ServiceManager, f);
                break;
            case "SeniorHRManager":
                addToList(SeniorHRManager, f);
                break;
            case "Photography":
                addToList(Photography, f);
        }
    }

    private void sendPending(Form f) throws IOException {
        LinkedList<Form> list = new LinkedList<Form>();
        switch (f.sender) {
            case "SeniorCS":
                list = copyAndEmptyList(SeniorCS);
                break;
            case "FinancialManager":
                list = copyAndEmptyList(FinancialManager);
                break;
            case "AdminManager":
                list = copyAndEmptyList(AdminManager);
                break;
            case "ProductionManager":
                list = copyAndEmptyList(ProductionManager);
                break;
            case "ServiceManager":
                list = copyAndEmptyList(ServiceManager);
                break;
            case "SeniorHRManager":
                list = copyAndEmptyList(SeniorHRManager);
                break;
            case "Photography":
                list = copyAndEmptyList(Photography);
        }
        outputStream.writeObject(list);
        outputStream.flush();
        outputStream.close();
    }

    private void handleApproval(EventRequestForm e) {    // checks if event has been approved by two sub-team managers
        int prev;
        if (pendingEvents.get(e.id) == null) {  // no approvals before
            prev = 0;
        } else {
            prev = pendingEvents.get(e.id);
        }
        int current = prev + 1;
        pendingEvents.put(e.id, current);
        int expectedApprovals = 0;
        if (e.food || e.drinks) {
            expectedApprovals++;
        }
        if (e.decor || e.parties || e.photo) {
            expectedApprovals++;
        }
        if (expectedApprovals == current) {
            pendingEvents.remove(e.id);
            addToList(AdminManager, e); // send to AdminManager
        }
        System.out.println("exp: " + expectedApprovals + " current: " + current);
    }
}
