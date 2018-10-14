package sep.project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author harald
 */
public class GUICommentEventRequest extends javax.swing.JFrame {

    /**
     * Creates new form GUICommentEventRequest
     */
    public GUICommentEventRequest(EventRequestForm e) {
        this.e = e;
        initComponents();
        recordNumber.setText(Integer.toString(e.recNum));
        clientName.setText(e.clientName);
        eventType.setText(e.eventType);
        startDate.setText(e.startDate);
        endDate.setText(e.endDate);
        amount.setText(Double.toString(e.expBudget));
        viewPreferences(e);
    }

    public void viewPreferences(EventRequestForm e) {
        String s = "";
        if (e.decor) {
            s = s.concat(" Decorations ,");
        }
        if (e.parties) {
            s = s.concat(" Parties ,");
        }
        if (e.photo) {
            s = s.concat(" Photos/Filming ,");
        }
        if (e.food) {
            s = s.concat(" Breakfast/Lunch/Dinner ,");
        }
        if (e.drinks) {
            s = s.concat(" Soft/Hot drinks ,");
        }
        if (!s.isEmpty())
            s = s.substring(1, s.length()-1);
        preferences.setText(s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        recordNumber = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clientName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        eventName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        eventType = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        startDate = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        endDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        commentLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comment = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        preferences = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Event Request");

        jLabel2.setText("Record number:");

        recordNumber.setText("recordNumber");

        jLabel3.setText("Client name:");

        clientName.setText("clientName");

        jLabel4.setText("Event name:");

        eventName.setText("eventName");

        jLabel5.setText("Event type:");

        eventType.setText("eventType");

        jLabel6.setText("Start date:");
        jLabel6.setToolTipText("");

        startDate.setText("startDate");

        jLabel7.setText("End date:");

        endDate.setText("endDate");

        jLabel8.setText("Preferences:");

        commentLabel.setText("Comment:");

        comment.setColumns(20);
        comment.setRows(5);
        jScrollPane1.setViewportView(comment);

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

        jLabel10.setText("Amount: ");

        amount.setText("amount");

        preferences.setText("preferences");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(commentLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(submitButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(startDate)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(endDate))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(amount)
                                    .addComponent(preferences)
                                    .addComponent(eventType)
                                    .addComponent(eventName)
                                    .addComponent(clientName)
                                    .addComponent(recordNumber)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1)))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(recordNumber))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clientName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(eventName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(eventType))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDate)
                    .addComponent(jLabel7)
                    .addComponent(endDate)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(preferences))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(amount))
                .addGap(18, 18, 18)
                .addComponent(commentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (comment.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please make a comment");
        } else {
            ServerConnector s = new ServerConnector();
            e.comment = comment.getText();
            e.sender = "FinancialManager";
            e.receiver = "AdminManager";
            try {
                s.sendForm(e);
            } catch (IOException ex) {
                Logger.getLogger(GUIFinancialRequestForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Data Submitted");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private EventRequestForm e;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JLabel clientName;
    private javax.swing.JTextArea comment;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JLabel endDate;
    private javax.swing.JLabel eventName;
    private javax.swing.JLabel eventType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel preferences;
    private javax.swing.JLabel recordNumber;
    private javax.swing.JLabel startDate;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
