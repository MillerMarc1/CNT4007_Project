import java.io.*;
import java.net.*;

public class PeerThread extends Thread {
    private BufferedReader br;

    public PeerThread(Socket socket) throws Exception {
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        boolean run = true;
        while (run) {
            try {
                String str = br.readLine();
                System.out.println(str);
            } catch (Exception e) {
                run = false;
                interrupt();
            }
        }
    }
}
