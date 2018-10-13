package sep.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class GUISeniorCS {
    public JFrame frame;
    private JButton btnCreate;
    private JButton btnView;
    private JButton btnApprove;
    private JButton btnReject;
    private LinkedList<Form> formList;
    private JList<Form> requestList;
    DefaultListModel<Form> model;

    public GUISeniorCS(){ initialized();}

    private void initialized(){
        frame = new JFrame();
        frame.setBounds(50, 50, 550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Logged in as SeniorCS");
        title.setBounds(10, 10, 200, 20);
        frame.getContentPane().add(title);

        btnCreate = new JButton("Create event request");
        btnCreate.setBounds(30, 40, 200, 20);
        frame.getContentPane().add(btnCreate);

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

        btnCreate.addActionListener(actionEvent -> {
            GUIEventRequestForm eventRequest = new GUIEventRequestForm();
            eventRequest.frame.setVisible(true);
        });

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
            Form selected = requestList.getSelectedValue();
            formList.remove(selected);
            updateGUI();
            if(!requestList.isSelectionEmpty())
                JOptionPane.showMessageDialog(null, "Approved request: " + selected);
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
