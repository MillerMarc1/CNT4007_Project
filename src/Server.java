import java.net.*;
import java.util.*;

public class Server extends Thread {
    private Set<ServerThread> serverThreads = new HashSet<ServerThread>();
    private ServerSocket socket;
    public Server(String portNum) throws Exception {
        socket = new ServerSocket(Integer.valueOf(portNum));
    }

    public void run() {
        try {
            while (true) {
                ServerThread serverThread = new ServerThread(socket.accept(), this);
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
                serverThread.getPrintWriter().println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<ServerThread> getServerThreads() {
        return serverThreads;
    }
}