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
 * TODO: Använd synchronized på respekte lista beroende på request typ.
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
            } else {
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
            case "SeniorCS":
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
            case "SeniorCS":
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
}
