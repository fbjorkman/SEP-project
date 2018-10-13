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
        return "Type: " + type + ", Sender: " + sender + ", Receiver: " + receiver;
    }
    
    public void view(){  // receiver is the one viewing the form
        switch (type){
            case "EventRequestForm":
                EventRequestForm e = (EventRequestForm) this;
                if (receiver.equals("SeniorCS")){
                    e.viewForm();
                }
                else if (receiver.equals("FinancialManager")){
                    // anropa metod som visar grafiskt anpassat för user, här ska ett gui med kommentarsfält visas
                    //e.viewFinancial()
                }
                else {  // admin manager
                    e.viewForm();   // admin kan också approve/reject
                }
            case "FinancialRequestForm":
                FinancialRequestForm f = (FinancialRequestForm) this;
                if (receiver.equals("FinancialManager")){

                }
        }
    }
}
