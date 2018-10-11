package sep.project;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author harald
 */
public class Server implements Runnable{

    private ServerSocket server;
    static final int portNumber = 4444;

    static LinkedBlockingQueue<Form> FinancialManager = new LinkedBlockingQueue<Form>();
    static LinkedBlockingQueue<Form> SeniorCS = new LinkedBlockingQueue<Form>();
    static LinkedBlockingQueue<Form> AdminManager = new LinkedBlockingQueue<Form>();
    static LinkedBlockingQueue<Form> ProductionManager = new LinkedBlockingQueue<Form>();
    static LinkedBlockingQueue<Form> ServiceManager = new LinkedBlockingQueue<Form>();

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

    public LinkedList<Form> copyAndEmptyList(LinkedBlockingQueue<Form> list) {
        LinkedList<Form> copy =  new LinkedList<Form>(list);
        list.clear();
        return copy;
    }
}
