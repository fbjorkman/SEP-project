package sep.project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author harald
 */
public class GUIViewFinancialRequest extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    public GUIViewFinancialRequest(FinancialRequestForm form) {
        initComponents();
        requestingDepartment.setText(form.requestingDepartment);
        projectReference.setText(Integer.toString(form.projectReference));
        requiredAmount.setText(Double.toString(form.amount));
        reason.setText(form.reason);
        setStatus(form.approved);
    }
    
    private void setStatus(int approved){
        if (approved > 0) status.setText("Approved");
        if (approved == 0) status.setText("Pending");
        else status.setText("Rejected");
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
        statusLabel = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        requestingDepartmentLabel.setText("Requesting department:");

        requestingDepartment.setText("requesting department");

        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Financial Request Form");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        projectReferenceLabel.setText("Project reference:");

        projectReference.setText("project reference");

        requiredAmountLabel.setText("Required amount:");

        requiredAmount.setText("required amount");

        reasonLabel.setText("Reason:");

        reason.setEditable(false);
        reason.setColumns(20);
        reason.setRows(5);
        jScrollPane1.setViewportView(reason);

        statusLabel.setText("Status:");

        status.setText("status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(requestingDepartmentLabel)
                            .addComponent(projectReferenceLabel)
                            .addComponent(requiredAmountLabel)
                            .addComponent(reasonLabel)
                            .addComponent(statusLabel))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(requiredAmount)
                            .addComponent(projectReference)
                            .addComponent(requestingDepartment)
                            .addComponent(status)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(status))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel projectReference;
    private javax.swing.JLabel projectReferenceLabel;
    private javax.swing.JTextArea reason;
    private javax.swing.JLabel reasonLabel;
    private javax.swing.JLabel requestingDepartment;
    private javax.swing.JLabel requestingDepartmentLabel;
    private javax.swing.JLabel requiredAmount;
    private javax.swing.JLabel requiredAmountLabel;
    private javax.swing.JLabel status;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
