package sep.project;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUISeniorCS {

    public JFrame frame;
    private JButton btnCreate;
    private JButton btnView;
    private JButton btnApprove;
    private JButton btnReject;
    private JButton btnDelete;
    private LinkedList<Form> formList;
    private JList<Form> requestList;
    private final ServerConnector sc = new ServerConnector();
    DefaultListModel<Form> model;

    public GUISeniorCS(LinkedList<Form> formList) {
        initialized(formList);
    }

    private void initialized(LinkedList<Form> formList) {
        this.formList = formList;
        frame = new JFrame();
        frame.setBounds(50, 50, 550, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Logged in as Senior Customer Service Officer");
        title.setBounds(10, 10, 350, 20);
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
        if (formList != null) {
            for (Form form : formList) {
                model.addElement(form);
            }
        }
        frame.getContentPane().add(requestList);

        btnView = new JButton("View");
        btnView.setBounds(100, 420, 100, 20);
        frame.getContentPane().add(btnView);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(210, 420, 100, 20);
        frame.getContentPane().add(btnDelete);
        btnDelete.setBackground(Color.red);
        btnDelete.setForeground(Color.white);
        btnDelete.hide();

        btnApprove = new JButton("Approve");
        btnApprove.setBounds(210, 420, 100, 20);
        frame.getContentPane().add(btnApprove);
        btnApprove.setBackground(Color.green);
        btnApprove.hide();

        btnReject = new JButton("Reject");
        btnReject.setBounds(320, 420, 100, 20);
        frame.getContentPane().add(btnReject);
        btnReject.setBackground(Color.red);
        btnReject.setForeground(Color.white);
        btnReject.hide();

        btnCreate.addActionListener(actionEvent -> {
            GUIEventRequestForm eventRequest = new GUIEventRequestForm();
            eventRequest.frame.setVisible(true);
        });

        btnView.addActionListener(actionEvent -> {
            if (requestList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Select a request");
            } else {
                Form selected = requestList.getSelectedValue();
                selected.view();
            }
        });

        btnApprove.addActionListener(actionEvent -> {
            Form selected = requestList.getSelectedValue();
            selected.sender = "SeniorCS";
            selected.receiver = "FinancialManager";
            try {
                sc.sendForm(selected);
            } catch (IOException ex) {
                Logger.getLogger(GUISeniorCS.class.getName()).log(Level.SEVERE, null, ex);
            }
            formList.remove(selected);
            requestList.clearSelection();
            model.removeElement(selected);
            updateGUI();
            if (!requestList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Approved request: " + selected);
            }
        });

        btnReject.addActionListener(actionEvent -> {
            Form selected = requestList.getSelectedValue();
            formList.remove(selected);
            requestList.clearSelection();
            model.removeElement(selected);
            updateGUI();
            if (!requestList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Rejected Request: " + selected);
            }
        });

        btnDelete.addActionListener(actionEvent -> {
            Form selected = requestList.getSelectedValue();
            JOptionPane.showMessageDialog(null, "Deleting: " + selected);
            formList.remove(selected);
            requestList.clearSelection();
            model.removeElement(selected);
            updateGUI();
        });

        requestList.addListSelectionListener(selectionEvent -> {
            try {
                Form selected = requestList.getSelectedValue();
                if (selected.type.equals("EventRequestForm")) {
                    EventRequestForm eventRequestForm = (EventRequestForm) selected;
                    if (eventRequestForm.isRejected() || eventRequestForm.isApproved()) {
                        btnDelete.show();
                        btnApprove.hide();
                        btnReject.hide();
                    } else {
                        btnApprove.show();
                        btnReject.show();
                        btnDelete.hide();
                    }
                } else if (selected.type.equals("FinancialRequestForm")) {
                    btnDelete.show();
                    btnApprove.hide();
                    btnReject.hide();
                }
            } catch (NullPointerException e) {// when selected has been submitted and removed, nullpointer exception will be thrown
                requestList.clearSelection();   // unselect
            }

        });
    }

    public void updateGUI() {
        //model.clear();
        if (formList != null) {
            for (Form form : formList) {
                if (!model.contains(form)) {
                    model.addElement(form);
                }
            }
        }
        frame.getContentPane().add(requestList);
    }

}
