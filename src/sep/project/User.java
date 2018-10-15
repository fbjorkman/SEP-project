package sep.project;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harald
 */
public class User implements Runnable {

    String name;
    LinkedList<Form> notificationList;
    ServerConnector s;
    GUISeniorCS seniorCS;
    GUIFinancialManager financialManager;
    GUIAdminManager adminManager;
    GUISubteamManager productionManager, serviceManager;
    GUISubTeam photography;

    public User(String name) {
        this.name = name;
        this.notificationList = new LinkedList<>();
        s = new ServerConnector();
    }

    public void run() {
        switch (name) {
            case "SeniorCS": // display gui of SeniorCS homepage
                seniorCS = new GUISeniorCS(notificationList);
                seniorCS.frame.setVisible(true);
                break;
            case "FinancialManager":
                financialManager = new GUIFinancialManager(notificationList);
                financialManager.frame.setVisible(true);
                break;

            case "AdminManager":
                adminManager = new GUIAdminManager(notificationList);
                adminManager.frame.setVisible(true);
                break;

            case "ProductionManager":
                productionManager = new GUISubteamManager(notificationList, "ProductionManager");
                productionManager.frame.setVisible(true);
                break;

            case "ServiceManager":
                serviceManager = new GUISubteamManager(notificationList, "ServiceManager");
                serviceManager.frame.setVisible(true);
                break;
                
            case "Photography":
                photography = new GUISubTeam(notificationList, "Photography");
                photography.frame.setVisible(true);
                break;
        }
        Thread updater = new Thread(() -> {
            try {
                requestUpdate();
            } catch (Exception ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        updater.start();

    }

    public void requestUpdate() throws ClassNotFoundException, InterruptedException {
        while (true) {
            notificationList.addAll(s.getUpdate(name)); // add all forms to my notificationList
            switch (name) {
                case "SeniorCS":
                    seniorCS.updateGUI();
                    break;
                case "FinancialManager":
                    financialManager.updateGUI();
                    break;
                case "AdminManager":
                    adminManager.updateGUI();
                    break;
                case "ProductionManager":
                    productionManager.updateGUI();
                    break;
                case "ServiceManager":
                    serviceManager.updateGUI();
                    break;
                case "Photography":
                    photography.updateGUI();
                    break;
            }
            Thread.sleep(1000);
        }
    }

}
