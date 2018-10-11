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
 */
public class ServerConnector {  // for clients sending forms and getting updates

    private Socket server;
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;
    static final int portNumber = 4444;
    String name = "localhost";

    public void sendForm(Form F) throws IOException {
        try {
            server = new Socket(name, portNumber);
            outputStream = new ObjectOutputStream(server.getOutputStream());
            outputStream.writeObject(F);
            outputStream.flush();
            outputStream.close();
            server.close();

        } catch (IOException ex) {
            Logger.getLogger(ServerConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedList<Form> getUpdate(String receiver) throws ClassNotFoundException {
        try {
            server = new Socket(name, portNumber);
            outputStream = new ObjectOutputStream(server.getOutputStream());
            outputStream.writeObject(new Form(receiver, null, "Update"));
            
            inputStream = new ObjectInputStream(server.getInputStream());
            LinkedList<Form> list = (LinkedList<Form>) inputStream.readObject();
            
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            server.close();
            return list;

        } catch (IOException ex) {
            Logger.getLogger(ServerConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
