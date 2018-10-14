package sep.project;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventRequestForm extends sep.project.Form {

    public int id;
    public int recNum;
    public String clientName;
    public String eventName;
    public String eventType;
    public String startDate;
    public String endDate;
    public int expNumAttend;
    public boolean decor;
    public boolean parties;
    public boolean photo;
    public boolean food;
    public boolean drinks;
    public double expBudget;
    private int approved;
    public String comment;

    public EventRequestForm(int recNum, String clientName, String eventName, String eventType,
            String startDate, String endDate, int expNumAttend,
            boolean decor, boolean parties, boolean photo, boolean food, boolean drinks,
            double expBudget, String comment) {
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

        this.comment = comment;
    }

    @Override
    public String toString() {
        return ("Event: " + eventName);
    }

    private List<String> getPreferences() {
        List<String> preferences = new ArrayList<>();
        if (decor) {
            preferences.add("Decorations");
        }
        if (parties) {
            preferences.add("Parties");
        }
        if (photo) {
            preferences.add("Photos/filming");
        }
        if (food) {
            preferences.add("Breakfast/lunch/dinner");
        }
        if (drinks) {
            preferences.add("Soft/hot drinks");
        }

        return preferences;
    }

    public void reject() {
        approved = -1;
    }

    public boolean isRejected() {
        return approved < 0;
    }

    public void approve() {
        approved = 1;
    }

    public boolean isApproved() {
        return approved > 0;
    }

    public void view() {
        if (receiver.equals("AdminManager")){
            new GUICommentEventRequest(this, true).setVisible(true);
            return;
        }
        new GUICommentEventRequest(this, false).setVisible(true);
    }

    public void comment() {
        new GUICommentEventRequest(this, true).setVisible(true);
    }
}
