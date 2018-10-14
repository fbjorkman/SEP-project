package sep.project;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIAdminManager {

    public JFrame frame;
    private JButton btnCreate;
    private JButton btnView;
    private JButton btnApprove;
    private JButton btnReject;
    private LinkedList<Form> formList;
    private JList<Form> requestList;
    private final ServerConnector sc = new ServerConnector();
    DefaultListModel<Form> model;

    public GUIAdminManager(LinkedList<Form> formList) {
        initialized(formList);
    }

    private void initialized(LinkedList<Form> formList) {
        this.formList = formList;
        frame = new JFrame();
        frame.setBounds(50, 50, 550, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Logged in as AdminManager");
        title.setBounds(10, 10, 200, 20);
        frame.getContentPane().add(title);

        btnCreate = new JButton("Create event");
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

        btnApprove = new JButton("Approve");
        btnApprove.setBounds(210, 420, 100, 20);
        frame.getContentPane().add(btnApprove);
        btnApprove.hide();

        btnReject = new JButton("Reject");
        btnReject.setBounds(320, 420, 100, 20);
        frame.getContentPane().add(btnReject);
        btnReject.hide();

        btnView.addActionListener(actionEvent -> {
            if (requestList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Select a request");
            } else {
                Form selected = requestList.getSelectedValue();
                selected.view();
            }
        });

        btnApprove.addActionListener(actionEvent -> {
            EventRequestForm selected = (EventRequestForm) requestList.getSelectedValue();
            try {
                sendDecision(selected, true);
            } catch (IOException ex) {
                Logger.getLogger(GUIAdminManager.class.getName()).log(Level.SEVERE, null, ex);
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
            EventRequestForm selected = (EventRequestForm) requestList.getSelectedValue();
            try {
                sendDecision(selected, false);
            } catch (IOException ex) {
                Logger.getLogger(GUIAdminManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            formList.remove(selected);
            requestList.clearSelection();
            model.removeElement(selected);
            updateGUI();
            if (!requestList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Rejected Request: " + selected);
            }
        });

        requestList.addListSelectionListener(selectionEvent -> {
            try {
                Form selected = requestList.getSelectedValue();
                if (selected.type.equals("EventRequestForm")) {
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
            } catch (NullPointerException e) {// when selected has been submitted and removed, nullpointer exception will be thrown
                requestList.clearSelection();// just unselect then
            }

        });
    }

    private void sendDecision(EventRequestForm e, boolean approved) throws IOException {
        e.sender = "AdminManager";
        e.receiver = "SeniorCS";
        if (approved) {
            e.approve();
        } else {
            e.reject();
        }
        sc.sendForm(e);

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
