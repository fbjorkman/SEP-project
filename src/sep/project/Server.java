package sep.project;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author harald
 */
public class Server implements Runnable{

    private ServerSocket server;
    static final int portNumber = 4444;
    // id is used to assign id to new event requests
    protected int id = 1;
    // map for checking if an event id has been approved twice
    static ConcurrentHashMap<Integer, Integer> pendingEvents = new ConcurrentHashMap<>();   
    // the notification list of each user
    static LinkedBlockingQueue<Form> FinancialManager = new LinkedBlockingQueue<>();
    static LinkedBlockingQueue<Form> SeniorCS = new LinkedBlockingQueue<>();
    static LinkedBlockingQueue<Form> AdminManager = new LinkedBlockingQueue<>();
    static LinkedBlockingQueue<Form> ProductionManager = new LinkedBlockingQueue<>();
    static LinkedBlockingQueue<Form> ServiceManager = new LinkedBlockingQueue<>();
    static LinkedBlockingQueue<Form> SeniorHRManager = new LinkedBlockingQueue<>();
    static LinkedBlockingQueue<Form> Photography = new LinkedBlockingQueue<>();
    
    public void run() {
        try {
            server = new ServerSocket(portNumber);
            System.out.println("Server started on port " + portNumber);
        } catch (IOException e) {
            System.out.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
        while (true) {
            ClientWorker worker;
            try {
                //server.accept returns a client connection
                worker = new ClientWorker(server.accept()); // worker will handle the client request
                Thread t = new Thread(worker);
                t.start();
            } catch (IOException e) {
                System.out.println("Accept failed: " + portNumber);
                System.exit(-1);
            }
        }
    }

    public void addToList(LinkedBlockingQueue<Form> list, Form f) {
        list.add(f);
    }
    
    public synchronized int getId(){
        return id++;
    }

    public LinkedList<Form> copyAndEmptyList(LinkedBlockingQueue<Form> list) {
        LinkedList<Form> copy =  new LinkedList<Form>(list);
        list.clear();
        return copy;
    }
}
