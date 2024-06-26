import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Peer {

//    public static void main(String[] args) throws Exception {
//        String[] peerInfo;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Enter connection information:");
//        peerInfo = br.readLine().split(" ");
//
//        Server serverThread = new Server(peerInfo[1]);
//        serverThread.start();
//        new Peer().connectPeer(br, peerInfo[0], serverThread);
//    }

    //declare Peer class variables
    private int _peerID;
    private String _hostName;
    private int _listeningPort;
    private boolean _hasFile;
    List<Peer> peersHt = ConfigReader.peersList;

    public Peer (int peerID, String hostName, int listeningPort, boolean hasFile) {
        //constructor for Peer class

        //initialize peerID, hostName, listeningPort, and hasFile for Peer instance
        _peerID = peerID;
        _hostName = hostName;
        _listeningPort = listeningPort;
        _hasFile = hasFile;
    }

    public Peer() {}

    public Server startPeer() throws Exception {
        System.out.println(_peerID);
        System.out.println(_hostName);
        System.out.println(_listeningPort);
        System.out.println(_hasFile);

        Server serverThread = new Server(_listeningPort);
        serverThread.start();

        return serverThread;
        // new Peer().connectPeer(_peerID, serverThread);
    }

    //utility function to allow retrieval of peerID
    public int getPeerID() {

        return _peerID;
    }

    //utility function to allow retrieval of peerID
    public String getHostName() {

        return _hostName;
    }

    //utility function to allow retrieval of peerID
    public int getlisteningPort() {

        return _listeningPort;
    }

    //utility function to allow retrieval of peerID
    public boolean getHasFile() {

        return _hasFile;
    }

    public void connectPeer(int peerID, Server serverThread, List<Peer> peers) throws Exception {
        peers.forEach(peer -> {
            Socket socket = null;
            String hostname = peer.getHostName();
            int port = peer.getlisteningPort();

            // For testing
            hostname = "localhost";
            try {
                socket = new Socket(hostname, port);
                new PeerThread(socket).start();
            } catch (Exception e) {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("invalid");
                }
            }
            System.out.println("Connect Peer: " + serverThread.getServerThreads());
        });
        connection(peerID, serverThread);
    }

    public void connection(int peerId, Server serverThread) {
        try {
            System.out.println("Communicating");
            serverThread.sendMessage(Messages.handshakeMessage(peerId).toString());
            boolean flag = true;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (flag) {
                String message = br.readLine();
                serverThread.sendMessage(message);

                // Check if new peer is online
                System.out.println("Connection: " + serverThread.getServerThreads());

                if (!serverThread.getServerThreads().isEmpty()) {
                    for (int i = 2; i < peersHt.size(); i++) {
                        String hostname = "localhost";
                        Socket socket = null;

                        
                        int port = peersHt.get(i).getlisteningPort();
                        socket = new Socket(hostname, port);
                        new PeerThread(socket).start();
                    }
                }
            }
            System.exit(0);
        } catch (Exception e) {

        }
    }

    // Handshake is sent when connection is established
    public void sendHandshake() {

    }

    // After handshake is completed
    public void sendMessage() {

    }

    public void choke() {

    }

    public void unchoke() {

    } 

    public void interested() {

    }

    public void notInterested() {

    }

    public void have() {

    }

    public void bitfield() {

    }

    public void request() {

    }

    public void piece() {
        
    }
}