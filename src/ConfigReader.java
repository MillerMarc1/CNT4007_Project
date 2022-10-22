/*
 * ConfigReader.java
 * 
 * Class that parses the PeerInfo.cfg file and pulls out relevant information:
 * peerID, hostname, listeningPort, hasFile, fileBool
 * 
 */

//import dependencies
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ConfigReader {

    static ArrayList<Peer> getPeerInfo() {
        //this function retrieves the various elements of the PeerInfo.cfg file and returns them as an arraylist of Peers
        
        //declare variables for the respective fields of a PeerInfo.cfg entry
        int peerID;
        String hostName;
        int listeningPort;
        boolean hasFile;
        int fileBool;
        //declare arraylist of peers to be returned at end of function
        ArrayList<Peer> peers = new ArrayList<>();
        
        //initialize proper file path
        String filePath = "project_config_file_large/PeerInfo.cfg";

        try {
            //initialize scanner to read PeerInfo.cfg
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter(" ");

            while (scanner.hasNextLine()) {
                //for each entry in PeerInfo.cfg, parse the peerID, host name, listening port, and hasfile fields
                peerID = Integer.parseInt(scanner.next());
                hostName = scanner.next();
                listeningPort = Integer.parseInt(scanner.next());
                fileBool = Integer.parseInt(scanner.next());
                if (fileBool == 1) {
                    hasFile = true;
                } else {
                    hasFile = false;
                }
                //once the respective fields have been parsed, place the data into a new Peer instance and add it to the arraylist of Peers
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
        
        //return the arraylist of Peers
        return peers;
    }

    static Common getCommon() {
        //this function retrieves the various properties of the Common.cfg file and returns a Common instance containing the properties
        
        //declare properties of Common.cfg file
        int preferredNeighbors;
        int unchokingInterval;
        int optimisticUInt;
        String fileName;
        int fileSize;
        int pieceSize;
        
        //initialize proper file path
        String filePath = "project_config_file_large/Common.cfg";
        //declare common instance to be returned at end of function
        Common common = new Common();

        try {
            //initialize scanner to read Common.cfg
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter("\n");
            
            //parse the preferredNeighbors property and place it in the common instance to be returned
            String temp = scanner.next();
            preferredNeighbors = Integer.parseInt(temp.substring(27));
            common.setPreferredNeighbors(preferredNeighbors);
            
            //parse the unchokingInterval property and place it in the common instance to be returned
            temp = scanner.next();
            unchokingInterval = Integer.parseInt(temp.substring(18));
            common.setUnchokingInterval(unchokingInterval);
            
            //parse the optimistic unchoking interval property and place it in the common instance to be returned
            temp = scanner.next();
            optimisticUInt = Integer.parseInt(temp.substring(28));
            common.setOptimisticUInt(optimisticUInt);
            
            //parse the fileName property and place it in the common instance to be returned
            temp = scanner.next();
            fileName = temp.substring(9);
            common.setFileName(fileName);

            //parse the fileSize property and place it in the common instance to be returned
            temp = scanner.next();
            fileSize = Integer.parseInt(temp.substring(9));
            common.setfileSize(fileSize);

            //parse the pieceSize property and place it in the common instance to be returned
            temp = scanner.next();
            pieceSize = Integer.parseInt(temp.substring(10));
            common.setPieceSize(pieceSize);
            scanner.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //return the common instance containing the properties of Common.cfg
        return common;
    }
}