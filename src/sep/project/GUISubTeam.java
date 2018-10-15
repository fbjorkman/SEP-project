package sep.project;

import java.awt.Color;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author harald
 */
public class GUISubTeam {
    public JFrame frame;
    private JButton btnComment;
    private JButton btnDelete;
    private LinkedList<Form> formList;
    private JList<Form> requestList;
    private final ServerConnector sc = new ServerConnector();
    private String user;
    DefaultListModel<Form> model;

    public GUISubTeam(LinkedList<Form> formList, String user) {
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

        JLabel listLabel = new JLabel("Task list:");
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

        btnComment = new JButton("Comment");
        btnComment.setBounds(100, 420, 100, 20);
        frame.getContentPane().add(btnComment);
        btnComment.setBackground(Color.blue);
        btnComment.setForeground(Color.white);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(210, 420, 100, 20);
        frame.getContentPane().add(btnDelete);
        btnDelete.setBackground(Color.red);

        btnComment.addActionListener(actionEvent -> {
            if (requestList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Select a task");
            } else {
                TaskForm selected = (TaskForm) requestList.getSelectedValue();
                new GUICommentTaskForm(selected).setVisible(true);
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
/*
        requestList.addListSelectionListener(selectionEvent -> {
            try {
                Form selected = requestList.getSelectedValue();
                if (selected.type.equals("TaskForm")) {
                    TaskForm t = (TaskForm) selected;
                    if (t.isCommented()) {
                        //if (btnApprove.isShowing()) {
                        btnDelete.show();
                        btnComment.hide();
                        //}
                    } else {
                        btnComment.show();
                        btnDelete.show();
                    }
                }
            } catch (NullPointerException e) {// when selected has been submitted and removed, nullpointer exception will be thrown
                requestList.clearSelection();   // unselect
            }
        });
        */
       
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
