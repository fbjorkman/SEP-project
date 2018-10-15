package sep.project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author harald
 */
public class GUIReviewFinancialRequest extends javax.swing.JFrame {

    FinancialRequestForm form;
    ServerConnector sc = new ServerConnector();

    /**
     * Creates new form test
     */
    public GUIReviewFinancialRequest(FinancialRequestForm f) {
        this.form = f;
        initComponents();
        requestingDepartment.setText(form.requestingDepartment);
        projectReference.setText(Integer.toString(form.projectReference));
        requiredAmount.setText(Double.toString(form.amount));
        reason.setText(form.reason);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestingDepartmentLabel = new javax.swing.JLabel();
        requestingDepartment = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        projectReferenceLabel = new javax.swing.JLabel();
        projectReference = new javax.swing.JLabel();
        requiredAmountLabel = new javax.swing.JLabel();
        requiredAmount = new javax.swing.JLabel();
        reasonLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reason = new javax.swing.JTextArea();
        approveButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        requestingDepartmentLabel.setText("Requesting department:");

        requestingDepartment.setText("requesting department");

        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Review Financial Request Form");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        projectReferenceLabel.setText("Project reference:");

        projectReference.setText("project reference");

        requiredAmountLabel.setText("Required amount:");

        requiredAmount.setText("required amount");

        reasonLabel.setText("Reason:");

        reason.setColumns(20);
        reason.setRows(5);
        jScrollPane1.setViewportView(reason);

        approveButton.setBackground(new java.awt.Color(0, 255, 0));
        approveButton.setForeground(new java.awt.Color(0, 0, 0));
        approveButton.setText("Approve");
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });

        rejectButton.setBackground(new java.awt.Color(255, 0, 0));
        rejectButton.setText("Reject");
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(approveButton)
                        .addGap(66, 66, 66)
                        .addComponent(rejectButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(requestingDepartmentLabel)
                            .addComponent(projectReferenceLabel)
                            .addComponent(requiredAmountLabel)
                            .addComponent(reasonLabel))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(requiredAmount)
                            .addComponent(projectReference)
                            .addComponent(requestingDepartment)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(title)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestingDepartmentLabel)
                    .addComponent(requestingDepartment))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectReferenceLabel)
                    .addComponent(projectReference))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requiredAmountLabel)
                    .addComponent(requiredAmount))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reasonLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(approveButton)
                    .addComponent(rejectButton))
                .addContainerGap(175, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
        JOptionPane.showMessageDialog(null, "Approve Financial Request: Press OK to confirm.");
        form.approved = 1;
        try {
            submitDecision();
        } catch (IOException ex) {
            Logger.getLogger(GUIReviewFinancialRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_approveButtonActionPerformed

    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        JOptionPane.showMessageDialog(null, "Reject Financial Request. Press OK to confirm.");
        form.approved = -1;
        try {
            submitDecision();
        } catch (IOException ex) {
            Logger.getLogger(GUIReviewFinancialRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rejectButtonActionPerformed

    private void submitDecision() throws IOException {
        form.receiver = form.sender;    // reply back to the requestor
        form.sender = "FinancialManager";
        sc.sendForm(form);
        if (form.approved == -1) {
            form.receiver = "SeniorCS"; // send a copy to the SeniorCS
            sc.sendForm(form);
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel projectReference;
    private javax.swing.JLabel projectReferenceLabel;
    private javax.swing.JTextArea reason;
    private javax.swing.JLabel reasonLabel;
    private javax.swing.JButton rejectButton;
    private javax.swing.JLabel requestingDepartment;
    private javax.swing.JLabel requestingDepartmentLabel;
    private javax.swing.JLabel requiredAmount;
    private javax.swing.JLabel requiredAmountLabel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
