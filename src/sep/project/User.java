package sep.project;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harald
 */
public class User implements Runnable{
    String name;
    LinkedList<Form> notificationList;
    ServerConnector s;
    
    public User(String name){
        this.name = name;
        this.notificationList  = new LinkedList<Form>();
        s = new ServerConnector();
    }
    
    public void run(){
        Thread updater = new Thread(() -> {
            try {
                requestUpdate();
            } catch (Exception ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        updater.start();
        switch (name) {
            case "SeniorCS" : {// display gui of SeniorCS homepage 
                GUISeniorCS seniorCS = new GUISeniorCS();
                seniorCS.frame.setVisible(true);
            }
            
            case "FinancialManager" : {
                
            }
            
    }
        
    }
    
    public void requestUpdate() throws ClassNotFoundException, InterruptedException{
        while(true){
            notificationList.addAll(s.getUpdate(name)); // add all forms to my notificationList
            Thread.sleep(1000);
        }
    }
    
    
}
