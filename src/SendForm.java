package sep.project;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harald
 */
public class SendForm {

    private Socket socket;
    private ObjectOutputStream outputStream = null;
    static final int portNumber = 4444;
    //String name;

    //SendForm(Form F, String name) throws IOException {
    SendForm(Form F) throws IOException {
        //this.name = name;
        try {
            socket = new Socket("random name", portNumber);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(F);
            outputStream.flush();
            outputStream.close();

        } catch (IOException ex) {
            Logger.getLogger(SendForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
