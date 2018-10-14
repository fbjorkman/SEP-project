package sep.project;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIAdminManager {
    public JFrame frame;
    private JButton btnView;
    private JButton btnApprove;
    private JButton btnReject;
    private LinkedList<Form> formList;
    private JList<Form> requestList;
    DefaultListModel<Form> model;

    public GUIAdminManager(LinkedList<Form> formList){ initialized(formList);}

    private void initialized(LinkedList<Form> formList){
        this.formList = formList;
        frame = new JFrame();
        frame.setBounds(50, 50, 550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Logged in as AdminManager");
        title.setBounds(10, 10, 200, 20);
        frame.getContentPane().add(title);

        JLabel listLabel = new JLabel("Request list:");
        listLabel.setBounds(100, 80, 200, 20);
        frame.getContentPane().add(listLabel);

        model = new DefaultListModel<>();
        requestList = new JList<>(model);
        requestList.setBounds(100, 100, 300, 300);
        if(formList != null) {
            for (Form form : formList) {
                model.addElement(form);
            }
        }
        frame.getContentPane().add(requestList);

        btnView = new JButton("View");
        btnView.setBounds(100, 420, 100, 20);
        frame.getContentPane().add(btnView);

        btnApprove = new JButton("Approve");
        btnApprove.setBounds(210, 420, 100, 20);
        frame.getContentPane().add(btnApprove);
        btnApprove.hide();

        btnReject = new JButton("Reject");
        btnReject.setBounds(320, 420, 100, 20);
        frame.getContentPane().add(btnReject);
        btnReject.hide();

        btnView.addActionListener(actionEvent -> {
            if(requestList.isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Select a request");
            }
            else{
                Form selected = requestList.getSelectedValue();
                selected.view();
            }
        });

        btnApprove.addActionListener(actionEvent -> {
            EventRequestForm selected = (EventRequestForm)requestList.getSelectedValue();
            selected.sender = "GUIAdminManager";
            selected.receiver = "SeniorCS";
            selected.approve();
            formList.remove(selected);
            updateGUI();
            if(!requestList.isSelectionEmpty())
                JOptionPane.showMessageDialog(null, "Approved request: " + selected);
            ServerConnector s = new ServerConnector();
            try {
                s.sendForm(selected);
            } catch (IOException ex) {
                Logger.getLogger(GUIFinancialRequestForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            frame.dispose();
        });

        btnReject.addActionListener(actionEvent -> {
            Form selected = requestList.getSelectedValue();
            formList.remove(selected);
            updateGUI();
            if(!requestList.isSelectionEmpty())
                JOptionPane.showMessageDialog(null, "Rejected Request: " + selected);
        });

        requestList.addListSelectionListener(selectionEvent -> {
            Form selected = requestList.getSelectedValue();
            if(selected.type.equals("EventRequestForm")) {
                EventRequestForm eventRequestForm = (EventRequestForm) selected;
                if (eventRequestForm.isRejected()) {
                    if (btnApprove.isShowing()) {
                        btnApprove.hide();
                        btnReject.hide();
                    }
                } else {
                    btnApprove.show();
                    btnReject.show();
                }
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
