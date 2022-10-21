import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigReader {

    static ArrayList<Peer> getPeerInfo() {

        int peerID;
        String hostName;
        int listeningPort;
        boolean hasFile;
        int fileBool;
        ArrayList<Peer> peers = new ArrayList<>();
        String filePath = "/Users/marcmiller/Documents/Code/CNT4007_Project/src/project_config_file_large/PeerInfo.cfg";

        try {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter(" ");

            while (scanner.hasNextLine()) {

                peerID = Integer.parseInt(scanner.next());
                hostName = scanner.next();
                listeningPort = Integer.parseInt(scanner.next());
                fileBool = Integer.parseInt(scanner.next());
                if (fileBool == 1) {
                    hasFile = true;
                } else {
                    hasFile = false;
                }
                Peer peer = new Peer(peerID, hostName, listeningPort, hasFile);
                peers.add(peer);
                if (scanner.hasNext()) {
                    scanner.nextLine();
                }
            }
            scanner.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return peers;
    }

    static Common getCommon() {

        int preferredNeighbors;
        int unchokingInterval;
        int optimisticUInt;
        String fileName;
        int fileSize;
        int pieceSize;
        String filePath = "project_config_file_large/Common.cfg";
        Common common = new Common();

        try {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter("\n");

            String temp = scanner.next();
            preferredNeighbors = Integer.parseInt(temp.substring(27));
            common.setPreferredNeighbors(preferredNeighbors);

            temp = scanner.next();
            unchokingInterval = Integer.parseInt(temp.substring(18));
            common.setUnchokingInterval(unchokingInterval);

            temp = scanner.next();
            optimisticUInt = Integer.parseInt(temp.substring(28));
            common.setOptimisticUInt(optimisticUInt);

            temp = scanner.next();
            fileName = temp.substring(9);
            common.setFileName(fileName);

            temp = scanner.next();
            fileSize = Integer.parseInt(temp.substring(9));
            common.setfileSize(fileSize);

            temp = scanner.next();
            pieceSize = Integer.parseInt(temp.substring(10));
            common.setPieceSize(pieceSize);
            scanner.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return common;
    }
}