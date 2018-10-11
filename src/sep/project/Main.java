package sep.project;

import java.awt.*;

public class Main implements Runnable {
    public static void main(String args[]){
        Thread t1 = new Thread(new Main());
        Thread t2 = new Thread(new Main());
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        try{
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        sep.project.GUIEventRequestForm window = new sep.project.GUIEventRequestForm();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        catch(Exception e){}
    }
}
