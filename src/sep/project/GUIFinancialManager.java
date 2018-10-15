package sep.project;

import java.awt.Color;
import java.io.IOException;
import javax.swing.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIFinancialManager {

    public JFrame frame;
    private JButton btnView;
    private JButton btnApprove;
    private JButton btnReject;
    private JButton btnComment;
    private LinkedList<Form> formList;
    private JList<Form> requestList;
    private final ServerConnector sc = new ServerConnector();
    DefaultListModel<Form> model;
    GUICommentEventRequest commentGUI;

    public GUIFinancialManager(LinkedList<Form> formList) {
        initialized(formList);
    }

    private void initialized(LinkedList<Form> formList) {
        this.formList = formList;
        frame = new JFrame();
        frame.setBounds(70, 50, 550, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        if (formList != null) {
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
        btnApprove.setBackground(Color.green);
        btnApprove.hide();

        btnReject = new JButton("Reject");
        btnReject.setBounds(320, 420, 100, 20);
        frame.getContentPane().add(btnReject);
        btnReject.setBackground(Color.red);
        btnReject.hide();

        btnComment = new JButton("Comment");
        btnComment.setBounds(210, 420, 100, 20);
        frame.getContentPane().add(btnComment);
        btnComment.setForeground(Color.white);
        btnComment.setBackground(Color.blue);
        btnComment.hide();

        btnView.addActionListener(actionEvent -> {
            if (requestList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Select a request");
            } else {
                Form selected = requestList.getSelectedValue();
                selected.view();
            }
        });

        btnApprove.addActionListener(actionEvent -> {
            FinancialRequestForm selected = (FinancialRequestForm) requestList.getSelectedValue();
            selected.receiver = selected.sender;    // reply back to the sender
            selected.sender = "FinancialManager";
            selected.approve();
            try {
                sc.sendForm(selected);
            } catch (IOException ex) {
                Logger.getLogger(GUISeniorCS.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!requestList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Approved request: " + selected);
            }
            formList.remove(selected);
            requestList.clearSelection();
            model.removeElement(selected);
            updateGUI();
        });

        btnReject.addActionListener(actionEvent -> {
            FinancialRequestForm selected = (FinancialRequestForm) requestList.getSelectedValue();
            selected.receiver = selected.sender;    // reply back to the sender
            selected.sender = "FinancialManager";
            selected.reject();
            try {
                sc.sendForm(selected);
            } catch (IOException ex) {
                Logger.getLogger(GUISeniorCS.class.getName()).log(Level.SEVERE, null, ex);
            }
            selected.receiver = "SeniorCS"; // Send copy to seniorCS
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
                JOptionPane.showMessageDialog(null, "Rejected Request: " + selected);
            }
        });

        btnComment.addActionListener(actionEvent -> {
            EventRequestForm selected = (EventRequestForm) requestList.getSelectedValue();
            commentGUI = selected.comment();
            commentGUI.setVisible(true);

            commentGUI.submitButton.addActionListener(aEvent -> {   // listen on submit button in commentGUI
                formList.remove(selected);
                requestList.clearSelection();
                model.removeElement(selected);
                updateGUI();
            });
        });

        requestList.addListSelectionListener(selectionEvent -> {
            try {
                Form selected = requestList.getSelectedValue();
                if (selected.type.equals("FinancialRequestForm")) {
                    btnApprove.show();
                    btnReject.show();
                    btnComment.hide();

                } else {    // EventRequestForm
                    btnApprove.hide();
                    btnReject.hide();
                    btnComment.show();
                }
            } catch (NullPointerException e) {  // when selected has been submitted and removed, nullpointer exception will be thrown
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
