package sep.project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author harald
 */
public class GUIFinancialRequestForm extends javax.swing.JFrame {

    public GUIFinancialRequestForm(String user, int reference) {
        initComponents();
        setUserButton(user);
        projectRef.setText(Integer.toString(reference));
    }

    public void setUserButton(String user) {
        switch (user) {
            case "ProductionManager": {
                productionButton.setSelected(true);
                sender = "ProductionManager";
                break;
            }
            case "ServiceManager": {
                serviceButton.setSelected(true);
                sender = "ServiceManager";
                break;
            }
            case "AdminManager": {
                adminButton.setSelected(true);
                sender = "AdministrationManager";
                break;
            }
            case "FinancialManager": {
                financialButton.setSelected(true);
                sender = "FinancialManager";
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        title = new javax.swing.JLabel();
        buttonGroupTitle = new javax.swing.JLabel();
        adminButton = new javax.swing.JRadioButton();
        serviceButton = new javax.swing.JRadioButton();
        productionButton = new javax.swing.JRadioButton();
        financialButton = new javax.swing.JRadioButton();
        projectRefLabel = new javax.swing.JLabel();
        projectRef = new javax.swing.JTextField();
        amount = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        reason = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reasonField = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Financial Request");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        buttonGroupTitle.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        buttonGroupTitle.setText("Requesting department");

        buttonGroup1.add(adminButton);
        adminButton.setText("Administration");
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(serviceButton);
        serviceButton.setText("Services");
        serviceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(productionButton);
        productionButton.setText("Production");
        productionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productionButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(financialButton);
        financialButton.setText("Financial");
        financialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financialButtonActionPerformed(evt);
            }
        });

        projectRefLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        projectRefLabel.setText("Project Reference:");

        projectRef.setEditable(false);
        projectRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectRefActionPerformed(evt);
            }
        });

        amount.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        amount.setText("Required amount:");

        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });

        reason.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        reason.setText("Reason:");

        reasonField.setColumns(20);
        reasonField.setRows(5);
        jScrollPane1.setViewportView(reasonField);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adminButton)
                        .addGap(18, 18, 18)
                        .addComponent(serviceButton)
                        .addGap(9, 9, 9)
                        .addComponent(productionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(financialButton))
                    .addComponent(buttonGroupTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projectRefLabel)
                            .addComponent(amount)
                            .addComponent(reason))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projectRef, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(submitButton)
                        .addGap(172, 172, 172))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(26, 26, 26)
                .addComponent(buttonGroupTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminButton)
                    .addComponent(productionButton)
                    .addComponent(serviceButton)
                    .addComponent(financialButton))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectRefLabel)
                    .addComponent(projectRef, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amount)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reason)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(submitButton)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        sender = "AdministrationManager";
    }//GEN-LAST:event_adminButtonActionPerformed

    private void productionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productionButtonActionPerformed
        sender = "ProductionManager";
    }//GEN-LAST:event_productionButtonActionPerformed

    private void projectRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectRefActionPerformed
    }//GEN-LAST:event_projectRefActionPerformed

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
    }//GEN-LAST:event_amountFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (sender == null || sender.isEmpty() || projectRef.getText().isEmpty() || amountField.getText().isEmpty() || reasonField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data Missing");
        } else {
            FinancialRequestForm f = new FinancialRequestForm(sender, sender, Integer.parseInt(projectRef.getText()), Integer.parseInt(amountField.getText()), reasonField.getText());
            ServerConnector s = new ServerConnector();
            try {
                s.sendForm(f);
            } catch (IOException ex) {
                Logger.getLogger(GUIFinancialRequestForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Data Submitted");
            this.dispose();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void financialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financialButtonActionPerformed
        sender = "FinancialManager";
    }//GEN-LAST:event_financialButtonActionPerformed

    private void serviceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceButtonActionPerformed
        sender = "ServiceManager";
    }//GEN-LAST:event_serviceButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    private String sender;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adminButton;
    private javax.swing.JLabel amount;
    private javax.swing.JTextField amountField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel buttonGroupTitle;
    private javax.swing.JRadioButton financialButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton productionButton;
    private javax.swing.JTextField projectRef;
    private javax.swing.JLabel projectRefLabel;
    private javax.swing.JLabel reason;
    private javax.swing.JTextArea reasonField;
    private javax.swing.JRadioButton serviceButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
