package sep.project;

import java.io.Serializable;

/**
 *
 * @author harald
 */
public class Form implements Serializable {
    String sender;
    String receiver;
    String type;
    
    Form(String sender, String receiver, String type){
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
    }
    
    public String toString(){
        return "Type: " + type + " Sender: " + sender + " Receiver: " + receiver;
    }
}
