package sep.project;

import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCases {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Server s = new Server();
        Thread serverThread = new Thread(s);
        serverThread.start();
        createEventRequest();
        addFinancialComment();
    }

    // tests if name of sent eventrequestform is equal to the name of received eventrequestform
    public static void createEventRequest() throws ClassNotFoundException, IOException {

        String test = "name";
        String result;
        EventRequestForm e = new EventRequestForm(1, "client", test, "festival", "2018-10-10", "2018-10-12", 100, true, true, true, false, false, 20000, null);
        ServerConnector sc = new ServerConnector();
        try {
            sc.sendForm(e);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        LinkedList<Form> l = new LinkedList<>();
        while (l.isEmpty()) {   // wait for reply, only used for testing purpose
            l = sc.getUpdate("SeniorCS");
        }
        Form f = l.getFirst();
        EventRequestForm received = (EventRequestForm) f;
        if (received.eventName.equals(test)) {
            result = "passed";
        } else {
            result = "failed";
        }
        System.out.println("CreateEventRequest test: " + result);
    }

    // tests if the comment added and sent via GUI is equal to the comment that is received 
    public static void addFinancialComment() throws ClassNotFoundException, IOException {

        EventRequestForm e = new EventRequestForm(1, "client", "name", "festival", "2018-10-10", "2018-10-12", 100, true, true, true, false, false, 20000, null);
        e.receiver = "FinancialManager";    // enable submit button manually
        GUICommentEventRequest commentGUI = new GUICommentEventRequest(e, true);
        commentGUI.setVisible(true);

        ServerConnector sc = new ServerConnector();
        LinkedList<Form> l = new LinkedList<>();
        while (l.isEmpty()) {   // wait for reply, only used for testing purpose
            l = sc.getUpdate("AdminManager");
        }
        Form f = l.getFirst();
        EventRequestForm received = (EventRequestForm) f;
        String result;
        if (received.comment.equals(commentGUI.getComment())) {
            result = "passed";
        } else {
            result = "failed";
        }
        System.out.println("AddFinancialComment test: " + result);
    }
}
