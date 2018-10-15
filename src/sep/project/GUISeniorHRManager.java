package sep.project;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GUISeniorHRManager {

    public JFrame frame;
    private JButton btnReview;
    private LinkedList<Form> formList;
    private JList<Form> requestList;
    private final ServerConnector sc = new ServerConnector();
    DefaultListModel<Form> model;

    public GUISeniorHRManager(LinkedList<Form> formList) {
        initialized(formList);
    }

    private void initialized(LinkedList<Form> formList) {
        this.formList = formList;
        frame = new JFrame();
        frame.setBounds(50, 50, 550, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Logged in as Senior HR Manager");
        title.setBounds(10, 10, 200, 20);
        frame.getContentPane().add(title);

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

        btnReview = new JButton("Review");
        btnReview.setBounds(210, 420, 100, 20);
        frame.getContentPane().add(btnReview);
        btnReview.setBackground(Color.blue);
        btnReview.setForeground(Color.white);

        btnReview.addActionListener(actionEvent -> {
            RecruitmentForm selected = (RecruitmentForm) requestList.getSelectedValue();
            GUICommentRecruitmentRequest commentForm = new GUICommentRecruitmentRequest(selected, false);
            commentForm.setVisible(true);

            commentForm.submitButton.addActionListener(aEvent -> {
                formList.remove(selected);
                requestList.clearSelection();
                model.removeElement(selected);
                updateGUI();
                if (!requestList.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Comment submitted: ");
                }
            });
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
