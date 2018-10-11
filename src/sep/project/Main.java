package sep.project;

import java.awt.*;

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
                    GUISeniorCS window2 = new GUISeniorCS();
                    window2.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        catch(Exception e){}
    }
}
