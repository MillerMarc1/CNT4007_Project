/*
 * PeerProcess.java
 * 
 * Class that takes in peerId and begins to set up connections between peers by calling the other classes
 * 
 */

import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;

public class PeerProcess {
    public static void main(String[] args) throws Exception {
        // Take command line peerID input
        int peerID = Integer.valueOf(args[0]);

        // Read PeerInfo.cfg and put peer objects into peers array list
        ArrayList<Peer> peers = ConfigReader.getPeerInfo();

        // Get the number of peers
        int peerCount = peers.size();

        Server serverThread = null;
        // First peer, cannot open any connections
        if (peers.get(0).getPeerID() == peerID) {
            serverThread = peers.get(0).startPeer();

            // System.out.println("Peer 1 has been started, listening for connections...");
            // ServerSocket listener = new ServerSocket(peers.get(0).getlisteningPort());

            // while (true) {
            //     Socket connSocket = listener.accept();
            //     BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
            //     DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());
            //     String clientSentence = inFromClient.readLine();
            // }

        } else {

            // Start each peer and set up communication with previous peers
            ArrayList<Peer> peerList = new ArrayList<>();
            for (int i = 1; i < peerCount; i++) {
                if (peers.get(i).getPeerID() == peerID) {
                    peerList.add(peers.get(i-1));
                    serverThread = peers.get(i).startPeer();
                    peers.get(i).connectPeer(peerID, serverThread, peerList);
                }
            }
        }

        // Read Common.cfg
        //Common common = ConfigReader.getCommon();

        
        
        // Change sleep to while loop that waits for connection
       // Thread.sleep(6000);

        // while (serverThread1.getServerThreads().isEmpty()) {
        //     // Waiting on connection
        // }

        //System.out.println(serverThread1.getServerThreads());

        // Wait until Peer has started connection with other peer
        while (serverThread.getServerThreads().isEmpty()) {
            Thread.sleep(1000);
        }

        // Create p2p connections
        ArrayList<Peer> peerList1 = new ArrayList<>();
        peerList1.add(peers.get(1));
        peers.get(0).connectPeer(peers.get(0).getPeerID(), serverThread, peerList1);
    }
}