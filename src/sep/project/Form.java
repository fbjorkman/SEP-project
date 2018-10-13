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
        System.out.println(type);
        switch (type){
            case "EventRequestForm":
                EventRequestForm e = (EventRequestForm) this;
                e.viewForm();
                break;
            case "FinancialRequestForm":
                FinancialRequestForm f = (FinancialRequestForm) this;
                f.view();
                break;
            case "TaskForm":
                TaskForm t = (TaskForm) this;
                t.view();
                break;
            case "RecruitmentForm":
                RecruitmentForm r = (RecruitmentForm) this;
                r.view();
                break;
        }
    }
}
