package sep.project;

import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class Main implements Runnable {

    public static void main(String args[]) {
        Thread server = new Thread(new Server());
        server.start();
        Thread t1 = new Thread(new Main());
        t1.start();
//        Thread t2 = new Thread(new Main());
//        t2.start();
    }

    @Override
    public void run() {
        try {
            Thread seniorCS = new Thread(new User("SeniorCS"));
            seniorCS.start();
            Thread financialManager = new Thread(new User("FinancialManager"));
            financialManager.start();
            Thread adminManager = new Thread(new User("AdminManager"));
            //adminManager.start();
            Thread prodManager = new Thread(new User("ProductionManager"));
            prodManager.start();
            Thread serviceManager = new Thread(new User("ServiceManager"));
            //serviceManager.start();
            Thread photography = new Thread(new User("Photography"));
            photography.start();
            Thread seniorHR = new Thread(new User("SeniorHRManager"));
            seniorHR.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
