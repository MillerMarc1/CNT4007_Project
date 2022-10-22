import java.net.*;
import java.util.*;

public class Server extends Thread {
    private Set<ServerThread> serverThreads = new HashSet<ServerThread>();
    private ServerSocket serverSocket;

    public Server(int portNum) throws Exception {
        serverSocket = new ServerSocket(portNum);
    }

    public void run() {
        try {
            while (true) {
                ServerThread serverThread = new ServerThread(serverSocket.accept(), this);
                serverThreads.add(serverThread);
                serverThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendMessage(String message) {
        try {
            for (ServerThread serverThread : serverThreads) {
                serverThread.getPw().println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Set<ServerThread> getServerThreads() {
        return serverThreads;
    }
}