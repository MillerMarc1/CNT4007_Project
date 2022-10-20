import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Peer {
    public static void main(String[] args) throws Exception {
        String[] connectionInfo;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter connection information:");
        connectionInfo = reader.readLine().split(" ");
        Server serverThread = new Server(connectionInfo[1]);
        serverThread.start();
        new Peer().updateListenToPeers(reader, connectionInfo[0], serverThread);
    }

    public void updateListenToPeers(BufferedReader reader, String username, Server serverThread) throws Exception {
        System.out.println("Enter connection information for peers:");
        String input = reader.readLine();
        String[] inputValues = input.split(" ");

        for (int i = 0; i < inputValues.length; i++) {
            String[] address = inputValues[i].split(":");
            Socket socket = null;

            try {
                socket = new Socket(InetAddress.getByName(address[0]), Integer.valueOf(address[1]));
                new PeerThread(socket).start();
            } catch (Exception e) {
                if (socket != null) {
                    socket.close();
                } else {
                    System.out.println("invalid input. skipping to next step");
                }
            }
        }
        communicate(reader, username, serverThread);
    }

    public void communicate(BufferedReader reader, String username, Server serverThread) {
        try {
            System.out.println("you can now communicate");
            boolean flag = true;
            while (flag) {
                String message = reader.readLine();
                serverThread.sendMessage(message);
            }
            System.exit(0);
        } catch (Exception e) {

        }
    }
}
