import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class PeerProcess {
    public static void main(String[] args) throws Exception {
        int peerID = Integer.valueOf(args[0]);

        ArrayList<Peer> peers = ConfigReader.getPeerInfo();

        // First peer, cannot open any connections
        if (peers.get(0).getPeerID() == peerID) {
            peers.get(0).startPeer();
        } else {
            ArrayList<Peer> peerList = new ArrayList<>();
            // If you are the second peer, connect to peer 1
            if (peers.get(1).getPeerID() == peerID) {
                peerList.add(peers.get(0));
                Server serverThread = peers.get(1).startPeer();
                peers.get(1).connectPeer(peerID, serverThread, peerList);
            }
//            else if (peers.get(2).getPeerID() == peerID) {
//                peerList.add(peers.get(1));
//                Server serverThread = peers.get(1).startPeer();
//                peers.get(1).connectPeer(peerID, serverThread, peerList);
//            }
        }
    }
}