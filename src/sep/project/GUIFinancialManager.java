package sep.project;

import javax.swing.*;
import java.util.LinkedList;

public class GUIFinancialManager {
    public JFrame frame;
    private JButton btnView;
    private LinkedList<Form> formList;
    private JList<Form> requestList;
    DefaultListModel<Form> model;

    public GUIFinancialManager(LinkedList<Form> formList){ initialized(formList);}

    private void initialized(LinkedList<Form> formList){
        this.formList = formList;
        frame = new JFrame();
        frame.setBounds(70, 50, 550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Logged in as Financial manager");
        title.setBounds(10, 10, 250, 20);
        frame.getContentPane().add(title);

        JLabel listLabel = new JLabel("Request list:");
        listLabel.setBounds(100, 60, 200, 20);
        frame.getContentPane().add(listLabel);

        model = new DefaultListModel<>();
        requestList = new JList<>(model);
        requestList.setBounds(100, 80, 300, 300);
        if(formList != null) {
            for (Form form : formList) {
                model.addElement(form);
            }
        }
        frame.getContentPane().add(requestList);

        btnView = new JButton("View");
        btnView.setBounds(100, 420, 100, 20);
        frame.getContentPane().add(btnView);


        btnView.addActionListener(actionEvent -> {
            if(requestList.isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Select a request");
            }
            else{
                Form selected = requestList.getSelectedValue();
                selected.view();
            }
        });

    }

    public void updateGUI(){
        model.clear();
        if(formList != null) {
            for (Form form : formList) {
                model.addElement(form);
            }
        }
        frame.getContentPane().add(requestList);
    }
}
