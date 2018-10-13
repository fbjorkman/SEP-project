package sep.project;

import java.awt.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Main implements Runnable {
    public static void main(String args[]){
        Thread t1 = new Thread(new Main());
        t1.start();
//        Thread t2 = new Thread(new Main());
//        t2.start();
    }

    @Override
    public void run() {
        try{
            EventQueue.invokeLater(() -> {
                try {
//                    GUIEventRequestForm window1 = new GUIEventRequestForm();
//                    window1.frame.setVisible(true);
                    LinkedBlockingQueue<EventRequestForm> testList = new LinkedBlockingQueue<>();
                    EventRequestForm test1 = new EventRequestForm(1, "name1", "type1", "10/11", "11/10", 100, true, true, false, true, true, 10000);
                    EventRequestForm test2 = new EventRequestForm(2, "name2", "type2", "11/12", "12/10", 200, true, true, false, false, false, 10000);
                    EventRequestForm test3 = new EventRequestForm(3, "name3", "type3", "12/13", "13/10", 300, true, true, true, true, true, 10000);
                    testList.add(test1);
                    testList.add(test2);
                    testList.add(test3);
                    GUISeniorCS window2 = new GUISeniorCS(testList);
                    window2.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        catch(Exception e){}
    }
}
