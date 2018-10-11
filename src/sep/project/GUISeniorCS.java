package sep.project;

import javax.swing.*;

public class GUISeniorCS {
    public JFrame frame;

    public GUISeniorCS(){ initialized();}

    private void initialized(){
        frame = new JFrame();
        frame.setBounds(100, 100, 550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Logged in as SeniorCS");
        title.setBounds(10, 10, 200, 20);
        frame.getContentPane().add(title);


    }
}
