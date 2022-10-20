import java.io.*;
import java.net.*;

public class PeerThread extends Thread {
    private BufferedReader reader;
    public PeerThread(Socket socket) throws Exception {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                String str = reader.readLine();
                System.out.println(str);
            } catch (Exception e) {
                flag = false;
                interrupt();
            }
        }
    }
}
