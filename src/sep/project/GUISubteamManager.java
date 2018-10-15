package sep.project;

/**
 *
 * @author harald
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUISubteamManager {

    public JFrame frame;
    private JButton btnCreate;
    private JButton btnView;
    //private JButton btnApprove;
    // private JButton btnReject;
    private JButton btnConfirm;
    private JButton btnDelete;
    private LinkedList<Form> formList;
    private JList<Form> requestList;
    private final ServerConnector sc = new ServerConnector();
    private final String user;
    DefaultListModel<Form> model;

    public GUISubteamManager(LinkedList<Form> formList, String user) {
        this.user = user;
        initialized(formList);
    }

    private void initialized(LinkedList<Form> formList) {
        this.formList = formList;
        frame = new JFrame();
        frame.setBounds(50, 50, 550, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Logged in as " + user);
        title.setBounds(10, 10, 200, 20);
        frame.getContentPane().add(title);

        btnCreate = new JButton("Create new task");
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

        btnConfirm = new JButton("Confirm ready");
        btnConfirm.setBounds(210, 420, 100, 20);
        frame.getContentPane().add(btnConfirm);
        btnConfirm.setBackground(Color.green);
        btnConfirm.hide();

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(320, 420, 100, 20);
        frame.getContentPane().add(btnDelete);
        btnDelete.setBackground(Color.red);
        btnDelete.hide();
        btnCreate.addActionListener(actionEvent -> {
            GUITaskForm task = new GUITaskForm();
            task.setVisible(true);
        });

        btnView.addActionListener(actionEvent -> {
            if (requestList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Select a request");
            } else {
                Form selected = requestList.getSelectedValue();
                selected.view();
            }
        });

        btnConfirm.addActionListener(actionEvent -> {
            if (requestList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Select a request");
            } else {
                EventRequestForm selected = (EventRequestForm) requestList.getSelectedValue();
                selected.sender = user;
                selected.receiver = "AdminManager";
                try {
                    sc.sendForm(selected);
                } catch (IOException ex) {
                    Logger.getLogger(GUISubteamManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                formList.remove(selected);
                requestList.clearSelection();
                model.removeElement(selected);
                updateGUI();
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
                        btnConfirm.show();
                        btnDelete.show();

                    } else {    // taskform with comment
                        btnConfirm.hide();
                        btnDelete.show();
                    }
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
