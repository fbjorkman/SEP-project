package sep.project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author harald
 */
public class GUICommentTaskForm extends javax.swing.JFrame {

    /**
     * Creates new form GUICommentTaskForm
     */
    public GUICommentTaskForm(TaskForm t) {
        this.t = t;
        initComponents();
        projectReference.setText(Integer.toString(t.projectReference));
        assignedTo.setText(t.assignTo);
        description.setText(t.description);
        priority.setText(t.priority);
        budget.setText(Double.toString(t.budget));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        priorityLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        budgetLabel = new javax.swing.JLabel();
        projectReferenceLabel = new javax.swing.JLabel();
        budget = new javax.swing.JTextField();
        projectReference = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        scrollPanel = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        assignToLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comment = new javax.swing.JTextArea();
        assignedTo = new javax.swing.JTextField();
        priority = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        priorityLabel.setText("Priority:");

        submitButton.setBackground(new java.awt.Color(51, 255, 51));
        submitButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        submitButton.setForeground(new java.awt.Color(0, 0, 0));
        submitButton.setText("Submit");
        submitButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        title.setText("Task Form");

        budgetLabel.setText("Budget:");

        projectReferenceLabel.setText("Project reference:");

        budget.setEditable(false);

        projectReference.setEditable(false);

        descriptionLabel.setText("Description:");

        description.setEditable(false);
        description.setColumns(20);
        description.setRows(5);
        scrollPanel.setViewportView(description);

        assignToLabel.setText("Assign to:");

        jLabel1.setText("Comment:");

        comment.setColumns(20);
        comment.setRows(5);
        jScrollPane1.setViewportView(comment);

        assignedTo.setEditable(false);

        priority.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(budgetLabel)
                            .addComponent(descriptionLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(projectReferenceLabel)
                                    .addComponent(priorityLabel)
                                    .addComponent(jLabel1)
                                    .addComponent(assignToLabel))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(assignedTo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(projectReference, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(priority, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(submitButton)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectReferenceLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionLabel)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(assignToLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(assignedTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(budgetLabel)
                    .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priorityLabel)
                    .addComponent(priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        t.sender = t.assignTo;
        t.receiver = t.manager;
        t.comment = comment.getText().trim();
        if (t.comment != null) {
            try {
                sc.sendForm(t);
            } catch (IOException ex) {
                Logger.getLogger(GUICommentTaskForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Task Submitted");
            this.dispose();
        }
        else{
           JOptionPane.showMessageDialog(null, "Please make a comment"); 
        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private TaskForm t;
    private final ServerConnector sc = new ServerConnector();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assignToLabel;
    private javax.swing.JTextField assignedTo;
    private javax.swing.JTextField budget;
    private javax.swing.JLabel budgetLabel;
    private javax.swing.JTextArea comment;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField priority;
    private javax.swing.JLabel priorityLabel;
    private javax.swing.JTextField projectReference;
    private javax.swing.JLabel projectReferenceLabel;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
