## Instructions to compile

For testing purposes, ports were changes in PeerInfo.cfg. The ports can be changed to what the original file included.

Additionally, Peer.java line 81, includes the use of "localhost", remove this item when compiling.

In order to actually compile the program:
- cd into the src folder
- javac *.java
- java PeerProcess peerID (example: java PeerProcess 1001)
- Begin communication with peer