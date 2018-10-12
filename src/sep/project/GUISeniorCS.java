package sep.project;

import javax.swing.*;
import java.util.concurrent.LinkedBlockingQueue;

public class GUISeniorCS {
    public JFrame frame;
    private JButton create;
    private JList<EventRequestForm> requestList;

    public GUISeniorCS(LinkedBlockingQueue<EventRequestForm> formList){ initialized(formList);}

    private void initialized(LinkedBlockingQueue<EventRequestForm> formList){
        frame = new JFrame();
        frame.setBounds(100, 100, 550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Logged in as SeniorCS");
        title.setBounds(10, 10, 200, 20);
        frame.getContentPane().add(title);

        create = new JButton("Create event request");
        create.setBounds(30, 40, 200, 20);
        frame.getContentPane().add(create);

        JLabel listLabel = new JLabel("Request list:");
        listLabel.setBounds(100, 80, 200, 20);
        frame.getContentPane().add(listLabel);

        DefaultListModel<EventRequestForm> model = new DefaultListModel<>();
        requestList = new JList<>(model);
        requestList.setBounds(100, 100, 300, 300);
        if(formList != null) {
            for (EventRequestForm form : formList) {
                model.addElement(form);
            }
        }
        frame.getContentPane().add(requestList);


    }
}
