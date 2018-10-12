package sep.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIEventRequestForm {

    public JFrame frame;
    private JTextField recNumField;
    private JTextField clientNameField;
    private JTextField eventTypeField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField expNumAttendField;
    private JCheckBox decorCB;
    private JCheckBox partiesCB;
    private JCheckBox photoCB;
    private JCheckBox foodCB;
    private JCheckBox drinksCB;
    private JTextField expBudgetField;

    public GUIEventRequestForm() {
        initialized();
    }

    private void initialized() {
        frame = new JFrame();
        frame.setBounds(100, 100, 550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Request for Event Planning");
        title.setBounds(150, 30, 200, 20);
        frame.getContentPane().add(title);

        JLabel recordNumber = new JLabel("Record number");
        recordNumber.setBounds(65, 70, 105, 14);
        frame.getContentPane().add(recordNumber);

        recNumField = new JTextField();
        recNumField.setBounds(200, 70, 250, 20);
        frame.getContentPane().add(recNumField);
        recNumField.setColumns(10);

        JLabel clientName = new JLabel("Client name");
        clientName.setBounds(65, 110, 88, 14);
        frame.getContentPane().add(clientName);

        clientNameField = new JTextField();
        clientNameField.setBounds(200, 110, 250, 20);
        frame.getContentPane().add(clientNameField);
        clientNameField.setColumns(10);

        JLabel eventType = new JLabel("Event type");
        eventType.setBounds(65, 150, 80, 14);
        frame.getContentPane().add(eventType);

        eventTypeField = new JTextField();
        eventTypeField.setBounds(200, 150, 250, 20);
        frame.getContentPane().add(eventTypeField);
        eventTypeField.setColumns(10);

        JLabel startDate = new JLabel("Start date:");
        startDate.setBounds(65, 190, 80, 14);
        frame.getContentPane().add(startDate);

        startDateField = new JTextField();
        startDateField.setBounds(150, 190, 120, 20);
        frame.getContentPane().add(startDateField);

        JLabel endDate = new JLabel("End date:");
        endDate.setBounds(325, 190, 66, 14);
        frame.getContentPane().add(endDate);

        endDateField = new JTextField();
        endDateField.setBounds(400, 190, 120, 20);
        frame.getContentPane().add(endDateField);

        JLabel expNumAttend = new JLabel("Expected number of attendees:");
        expNumAttend.setBounds(65, 230, 220, 14);
        frame.getContentPane().add(expNumAttend);

        expNumAttendField = new JTextField();
        expNumAttendField.setBounds(300, 230, 70, 20);
        frame.getContentPane().add(expNumAttendField);

        JLabel preferences = new JLabel("Preferences: ");
        preferences.setBounds(65, 270, 104, 14);
        frame.getContentPane().add(preferences);

        JLabel decor = new JLabel("Decorations");
        decor.setBounds(90, 300, 88, 14);
        frame.getContentPane().add(decor);

        decorCB = new JCheckBox();
        decorCB.setBounds(65, 297, 20, 20);
        frame.getContentPane().add(decorCB);

        JLabel parties = new JLabel("Parties");
        parties.setBounds(90, 320, 56, 14);
        frame.getContentPane().add(parties);

        partiesCB = new JCheckBox();
        partiesCB.setBounds(65, 317, 20, 20);
        frame.getContentPane().add(partiesCB);

        JLabel photo = new JLabel("Photos/filming");
        photo.setBounds(90, 340, 112, 14);
        frame.getContentPane().add(photo);

        photoCB = new JCheckBox();
        photoCB.setBounds(65, 337, 20, 20);
        frame.getContentPane().add(photoCB);

        JLabel food = new JLabel("Breakfast, lunch, dinner");
        food.setBounds(275, 300, 88, 14);
        frame.getContentPane().add(food);

        foodCB = new JCheckBox();
        foodCB.setBounds(250, 297, 20, 20);
        frame.getContentPane().add(foodCB);

        JLabel drinks = new JLabel("Soft/hot drinks");
        drinks.setBounds(275, 320, 120, 14);
        frame.getContentPane().add(drinks);

        drinksCB = new JCheckBox();
        drinksCB.setBounds(250, 317, 20, 20);
        frame.getContentPane().add(drinksCB);

        JLabel expBudget = new JLabel("Expected budget:");
        expBudget.setBounds(65, 380, 128, 14);
        frame.getContentPane().add(expBudget);

        expBudgetField = new JTextField();
        expBudgetField.setBounds(200, 380, 120, 20);
        frame.getContentPane().add(expBudgetField);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBackground(Color.GREEN);
        btnSubmit.setBounds(100, 430, 90, 25);
        frame.getContentPane().add(btnSubmit);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(350, 430, 90, 25);
        frame.getContentPane().add(btnCancel);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (recNumField.getText().isEmpty() || (clientNameField.getText().isEmpty())
                        || (eventTypeField.getText().isEmpty()) || (startDateField.getText().isEmpty())
                        || endDateField.getText().isEmpty() || expNumAttendField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data Missing");
                } else {
                    sep.project.EventRequestForm f = new sep.project.EventRequestForm(Integer.parseInt(recNumField.getText()), clientNameField.getText(), eventTypeField.getText(),
                            startDateField.getText(), endDateField.getText(), Integer.parseInt(expNumAttendField.getText()),
                            decorCB.isEnabled(), partiesCB.isEnabled(), photoCB.isEnabled(), foodCB.isEnabled(), drinksCB.isEnabled(),
                            Integer.parseInt(expBudgetField.getText()));
                    ServerConnector s = new ServerConnector();
                    try {
                        s.sendForm(f);
                    } catch (IOException ex) {
                        Logger.getLogger(GUIFinancialRequestForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                }

            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }
}
