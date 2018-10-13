package sep.project;

/**
 *
 * @author harald
 */
public class GUIViewTaskForm extends javax.swing.JFrame {

    /**
     * Creates new form GUIViewTaskForm
     */
    public GUIViewTaskForm(TaskForm form) {
        initComponents();
        assignTo.setText(form.assignTo);
        budget.setText(Double.toString(form.budget));
        description.setText(form.description);
        projectReference.setText(Integer.toString(form.projectReference));
        priority.setText(priority.getText());
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
        title = new javax.swing.JLabel();
        projectReferenceLabel = new javax.swing.JLabel();
        projectReference = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        scrollPanel = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        budgetLabel = new javax.swing.JLabel();
        assignToLabel = new javax.swing.JLabel();
        budget = new javax.swing.JTextField();
        assignTo = new javax.swing.JTextField();
        priority = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        priorityLabel.setText("Priority:");

        title.setText("Task Form");

        projectReferenceLabel.setText("Project reference:");

        projectReference.setEditable(false);
        projectReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectReferenceActionPerformed(evt);
            }
        });

        descriptionLabel.setText("Description:");

        description.setEditable(false);
        description.setColumns(20);
        description.setRows(5);
        scrollPanel.setViewportView(description);

        budgetLabel.setText("Budget:");

        assignToLabel.setText("Assign to:");

        budget.setEditable(false);
        budget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetActionPerformed(evt);
            }
        });

        assignTo.setEditable(false);
        assignTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToActionPerformed(evt);
            }
        });

        priority.setEditable(false);
        priority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priorityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(budgetLabel)
                    .addComponent(assignToLabel)
                    .addComponent(descriptionLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projectReferenceLabel)
                            .addComponent(priorityLabel))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priority, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(assignTo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(projectReference, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                        .addComponent(assignTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(budgetLabel)
                    .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(priorityLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(priority, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void projectReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectReferenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectReferenceActionPerformed

    private void budgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_budgetActionPerformed

    private void assignToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignToActionPerformed

    private void priorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priorityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField assignTo;
    private javax.swing.JLabel assignToLabel;
    private javax.swing.JTextField budget;
    private javax.swing.JLabel budgetLabel;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField priority;
    private javax.swing.JLabel priorityLabel;
    private javax.swing.JTextField projectReference;
    private javax.swing.JLabel projectReferenceLabel;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}