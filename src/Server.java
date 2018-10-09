package sep.project;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author harald
 */
public class Server {

    private ServerSocket server;
    static final int portNumber = 4444;

    LinkedBlockingQueue<Form> FinancialManager = new LinkedBlockingQueue<Form>();
    LinkedBlockingQueue<Form> SeniorCS = new LinkedBlockingQueue<Form>();
    LinkedBlockingQueue<Form> AdminManager = new LinkedBlockingQueue<Form>();
    LinkedBlockingQueue<Form> ProductionManager = new LinkedBlockingQueue<Form>();
    LinkedBlockingQueue<Form> ServiceManager = new LinkedBlockingQueue<Form>();

    public void listenSocket() {
        try {
            server = new ServerSocket(portNumber);
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
        LinkedList<Form> copy;
        copy = new LinkedList<Form>(list);
        list.clear();
        return copy;
    }
}
