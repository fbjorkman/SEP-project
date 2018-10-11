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
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;

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
            }
            else if (f.type.equals("EventRequestForm")) {
                EventRequestForm e = (EventRequestForm) f;
                if (e.id == 0) { // new event request
                    e.id = getId();
                    addForm(e);
                }
                else if (e.sender.equals("ProductionManager") || e.sender.equals("ServiceManager")){
                    handleApproval(e);
                }
            }
            else {
                addForm(f); // add form to right user queue
            }
            
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
            case "GUISeniorCS":
                addToList(SeniorCS, f);
            case "FinancialManager":
                addToList(FinancialManager, f);
            case "AdminManager":
                addToList(AdminManager, f);
            case "ProductionManager":
                addToList(ProductionManager, f);
            case "ServiceManager":
                addToList(ServiceManager, f);
        }
    }

    private void sendPending(Form f) throws IOException {
        LinkedList<Form> list = new LinkedList<Form>();
        switch (f.sender) {
            case "GUISeniorCS":
                list = copyAndEmptyList(SeniorCS);
            case "FinancialManager":
                list = copyAndEmptyList(FinancialManager);
            case "AdminManager":
                list = copyAndEmptyList(AdminManager);
            case "ProductionManager":
                list = copyAndEmptyList(ProductionManager);
            case "ServiceManager":
                list = copyAndEmptyList(ServiceManager);
        }
        outputStream.writeObject(list);
        outputStream.flush();
        outputStream.close();
    }
    
    private void handleApproval(EventRequestForm e){    // checks if event has been approved by two sub-team managers
        if (pendingEvents.get(e.id) == null){   // first approval
            pendingEvents.put(e.id, 1);
        }
        else{   // if already approved by one of the sub-team managers before
            pendingEvents.remove(e.id);
            addToList(AdminManager, e); // send to AdminManager
        }
    }
}
