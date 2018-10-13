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
    GUISeniorCS seniorCS;
    
    public User(String name){
        this.name = name;
        this.notificationList  = new LinkedList<>();
        s = new ServerConnector();
        seniorCS = new GUISeniorCS(notificationList);
        seniorCS.frame.setVisible(true);
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

            }
            
            case "FinancialManager" : {
                
            }
            
    }
        
    }
    
    public void requestUpdate() throws ClassNotFoundException, InterruptedException{
        while(true){
            notificationList.addAll(s.getUpdate(name)); // add all forms to my notificationList
            seniorCS.updateGUI();
            Thread.sleep(1000);
        }
    }
    
    
}
