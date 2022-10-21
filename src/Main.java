import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Peer> peers = ConfigReader.getPeerInfo();

        // Loop through number of peers and create a peer for each one
        peers.forEach((peer -> {
            System.out.println(peer.getPeerID() + "   " + peer.getHostName() + "   " + peer.getlisteningPort() + "   " + peer.getHasFile());
        }));

//        Common common = ConfigReader.getCommon();
//
//        System.out.println(common.getPreferredNeighbors());
//        System.out.println(common.getUnchokingInterval());
//        System.out.println(common.getOptimisticUInt());
//        System.out.println(common.getFileName());
//        System.out.println(common.getFileSize());
//        System.out.println(common.getPieceSize());

        System.out.println("done");
    }
}