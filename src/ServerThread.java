/*
 * ServerThread.java
 * 
 * Class that extends Thread and creates a server thread to be used
 * 
 */

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
    private  Server server;
    private Socket serverSocket;
    private PrintWriter pw;

    // ServerThread Constructor
    public ServerThread(Socket socket, Server server) {
        this.server = server;
        this.serverSocket = socket;
    }

    // Run thread
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

    // Return print writer
    public PrintWriter getPw() {
        return pw;
    }
}
