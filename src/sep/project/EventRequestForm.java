package sep.project;

import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventRequestForm extends sep.project.Form {
    public int id;
    private int recNum;
    private String clientName;
    private String eventName;
    private String eventType;
    private String startDate;
    private String endDate;
    private int expNumAttend;
    private boolean decor;
    private boolean parties;
    private boolean photo;
    private boolean food;
    private boolean drinks;
    private double expBudget;
    private boolean rejected;
    private boolean approved;
    private String comment;
    public EventRequestForm(int recNum, String clientName, String eventName,String eventType,
                            String startDate, String endDate, int expNumAttend,
                            boolean decor, boolean parties, boolean photo, boolean food, boolean drinks,
                            double expBudget, String comment){
        super("GUISeniorCS", "SeniorCS", "EventRequestForm");

        this.recNum = recNum;
        this.clientName = clientName;
        this.eventName = eventName;
        this.eventType = eventType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.expNumAttend = expNumAttend;
        this.decor = decor;
        this.parties = parties;
        this.photo = photo;
        this.food = food;
        this.drinks = drinks;
        this.expBudget = expBudget;
        this.rejected = false;
        this.approved = false;

        this.comment = comment;
    }

    @Override
    public String toString() {
        return ("Event: " + eventName);
    }

    public void viewForm(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(200, 200, 550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel(toString());
        title.setBounds(225, 30, 200, 20);
        frame.getContentPane().add(title);

        JLabel recNumField = new JLabel("Record number: " + recNum);
        recNumField.setBounds(65, 70, 400, 20);
        frame.getContentPane().add(recNumField);

        JLabel clientNameField = new JLabel("Client name: " + clientName);
        clientNameField.setBounds(65, 100, 400, 20);
        frame.getContentPane().add(clientNameField);

        JLabel eventTypeField = new JLabel("Type of event: " + eventType);
        eventTypeField.setBounds(65, 130, 400, 20);
        frame.getContentPane().add(eventTypeField);

        JLabel dateField = new JLabel("Start date: " + startDate + "   End date: " + endDate);
        dateField.setBounds(65, 160, 400, 20);
        frame.getContentPane().add(dateField);

        JLabel expNumAttendField = new JLabel("Expected number of attendees: " + expNumAttend);
        expNumAttendField.setBounds(65, 190, 400, 20);
        frame.getContentPane().add(expNumAttendField);

        JLabel preferencesLable = new JLabel("Preferences: ");
        preferencesLable.setBounds(65, 220, 500, 20);
        frame.getContentPane().add(preferencesLable);

        List<String> prefList = getPreferences();
        if(prefList.size() > 3){
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            for(int i = 0; i < 3; i++){
                s1.append(prefList.get(i));
                s1.append(", ");
            }
            for(int i = 3; i < prefList.size(); i++){
                s2.append(prefList.get(i));
                if(i != prefList.size()-1)
                    s2.append(", ");
            }
            JLabel preferencesField1 = new JLabel(s1.toString());
            JLabel preferencesField2 = new JLabel(s2.toString());
            preferencesField1.setBounds(65, 240, 500, 20);
            preferencesField2.setBounds(65, 260, 500, 20);
            frame.getContentPane().add(preferencesField1);
            frame.getContentPane().add(preferencesField2);
        }
        else {
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < prefList.size(); i++){
                s.append(prefList.get(i));
                if(i != prefList.size()-1)
                    s.append(", ");
            }
            JLabel preferencesField = new JLabel(s.toString());
            preferencesField.setBounds(65, 240, 500, 20);
            frame.getContentPane().add(preferencesField);
        }

        JLabel expBudgetField = new JLabel("Expected budget: " + expBudget);
        expBudgetField.setBounds(65, 300, 400, 20);
        frame.getContentPane().add(expBudgetField);

        switch (receiver){
            case "FinancialManager":
                JLabel newComment = new JLabel("Comment: ");
                newComment.setBounds(65, 320, 400, 20);
                frame.getContentPane().add(newComment);

                JTextArea commentArea = new JTextArea();
                commentArea.setBounds(150, 325, 300, 50);
                frame.getContentPane().add(commentArea);

                JButton btnSend = new JButton("Send");
                btnSend.setBounds(350, 400, 90, 25);
                frame.getContentPane().add(btnSend);

                btnSend.addActionListener(actionEvent -> {
                    EventRequestForm form = new EventRequestForm(
                            recNum, clientName, eventName, eventType, startDate, endDate, expNumAttend,
                            decor, parties, photo, food, drinks, expBudget, commentArea.getText());
                    form.sender = "GUIFinancialManager";
                    form.receiver = "AdminManager";
                    ServerConnector s = new ServerConnector();
                    try {
                        s.sendForm(form);
                    } catch (IOException ex) {
                        Logger.getLogger(GUIFinancialRequestForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame.dispose();
                    JOptionPane.showMessageDialog(null, "Event request sent");
                });
                break;
            case "AdminManager":
                JLabel viewComment = new JLabel("Comment: ");
                viewComment.setBounds(65, 320, 400, 20);
                frame.getContentPane().add(viewComment);

                JLabel commentText = new JLabel(comment);
                commentText.setBounds(150, 320, 400, 20);
                frame.getContentPane().add(commentText);
        }

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(225, 400, 90, 25);
        frame.getContentPane().add(btnClose);

        btnClose.addActionListener(e -> frame.dispose());
    }

    private List<String> getPreferences(){
        List<String> preferences = new ArrayList<>();
        if(decor)
            preferences.add("Decorations");
        if(parties)
            preferences.add("Parties");
        if(photo)
            preferences.add("Photos/filming");
        if(food)
            preferences.add("Breakfast/lunch/dinner");
        if(drinks)
            preferences.add("Soft/hot drinks");

        return preferences;
    }

    public void reject(){
        rejected = true;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void approve(){
        approved = true;
    }

    public boolean isApproved() {
        return approved;
    }
}
