package sep.project;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCases {

    public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {
        Server s = new Server();
        Thread serverThread = new Thread(s);
        serverThread.start();
        
        createEventRequest();
        addFinancialComment();
        createRecruitmentRequest();
        finalizingEventRequest();
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
        System.out.println("createEventRequest test: " + result);
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
        System.out.println("addFinancialComment test: " + result);
    }

//  Check that job title in recruitment request form submitted by production manager equals job title in
//  recruitment request form received in senior HR manager notification list
    public static void createRecruitmentRequest() throws IOException, ClassNotFoundException {
        String jobTitle = "Photographer";
        RecruitmentForm r = new RecruitmentForm("ProductionManager", "ProductionManager", "2", jobTitle, "Must know how to take photos", "Part time");
        ServerConnector sc = new ServerConnector();
        sc.sendForm(r);
        LinkedList<Form> l = new LinkedList<>();
        while (l.isEmpty()) {   // wait for reply, only used for testing purpose
            l = sc.getUpdate("SeniorHRManager");
        }
        Form f = l.getFirst();
        RecruitmentForm received = (RecruitmentForm) f;
        String result;
        if (received.jobTitle.equals(jobTitle)) {
            result = "passed";
        } else {
            result = "failed";
        }
        System.out.println("createRecruitmentRequest test: " + result);

    }

//  Check that the event request will appear in AdminManagers notification list only when
//  BOTH subteamManagers have confirmed the request
    public static void finalizingEventRequest() throws IOException, InterruptedException, ClassNotFoundException {
        ServerConnector sc = new ServerConnector();
        EventRequestForm e = new EventRequestForm(1, "client", "something", "festival", "2018-10-10", "2018-10-12", 100, true, true, true, true, true, 20000, null);
        e.id = 2;
        LinkedList<Form> l = new LinkedList<>();
        boolean check1, check2;
        e.sender = "ProductionManager";
        e.receiver = "AdminManager";
//        Simulate confirming of eventrequest
        sc.sendForm(e);
        TimeUnit.SECONDS.sleep(1);
        l = sc.getUpdate("AdminManager");
        check1 = l.isEmpty();
        System.out.println(l.toString());
        e.sender = "ServiceManager";
//        Simulate confirming of eventrequest
        sc.sendForm(e);
        TimeUnit.SECONDS.sleep(1);
        l = sc.getUpdate("AdminManager");
        check2 = !l.isEmpty();

        if (check1 && check2) {
            System.out.println("Finalizing event request: passed");
        } else {
            System.out.println("Finalizing event request: failed");
        }

    }
}
