import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
    private  Server server;
    private Socket serverSocket;
    private PrintWriter pw;

    public ServerThread(Socket socket, Server server) {
        this.server = server;
        this.serverSocket = socket;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.serverSocket.getInputStream()));
            this.pw = new PrintWriter(serverSocket.getOutputStream(), true);
            while (true) {
                server.sendMessage(br.readLine());
            }
        } catch (Exception e) {
            server.getServerThreads().remove(this);
        }
    }

    public PrintWriter getPw() {
        return pw;
    }
}
