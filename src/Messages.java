import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

public class Messages {

    static byte [] handshakeMessage(int peerID) throws IOException {
        String header = "P2PFILESHARINGPROJ";
        byte[] zero = new byte[10];
        byte[] peerIDBytes = ByteBuffer.allocate(4).putInt(peerID).array();

        ByteArrayOutputStream handshake = new ByteArrayOutputStream();
        handshake.write(header.getBytes());
        handshake.write(zero);
        handshake.write(peerIDBytes);
        handshake.close();

        return handshake.toByteArray();
    }

    private static byte[] setNoPayloadMsg(int value) throws IOException {
        byte[] messageType = {(byte) value};
        byte[] messageLength = ByteBuffer.allocate(4).putInt(messageType.length).array();

        ByteArrayOutputStream message = new ByteArrayOutputStream();
        message.write(messageLength);
        message.write(messageType);
        message.close();

        return message.toByteArray();
    }

    private static byte[] getMsgLengthArray(byte[] messageType, byte[] payload) {
        return ByteBuffer.allocate(4).putInt(messageType.length + payload.length).array();
    }

    private static byte[] setPieceIndexMsg(int pieceIndex, int value) throws IOException {
        byte[] messageType = {(byte) value};
        byte[] payload = ByteBuffer.allocate(4).putInt(pieceIndex).array();
        byte[] messageLength = getMsgLengthArray(messageType, payload);

        ByteArrayOutputStream message = new ByteArrayOutputStream();
        message.write(messageLength);
        message.write(messageType);
        message.write(payload);
        message.close();

        return message.toByteArray();
    }

    static byte[] getChokeMessage() throws IOException {
        return setNoPayloadMsg(0);
    }

    static byte[] getUnchokeMessage() throws IOException {
        return setNoPayloadMsg(1);
    }

    static byte[] getInterestedMessage() throws IOException {
        return setNoPayloadMsg(2);
    }

    static byte[] getNotInterestedMessage() throws IOException {
        return setNoPayloadMsg(3);
    }

    static byte[] getHaveMessage(int pieceIndex) throws IOException {
        return setPieceIndexMsg(pieceIndex, 4);
    }

    static byte[] getBitfieldMessage(BitSet bitfield) throws IOException {
        byte[] messageType = {(byte) 5};
        byte[] payload = bitfield.toByteArray();
        byte[] messageLength = getMsgLengthArray(messageType, payload);

        ByteArrayOutputStream message = new ByteArrayOutputStream();
        message.write(messageLength);
        message.write(messageType);
        message.write(payload);
        message.close();

        return message.toByteArray();
    }

    static byte[] getRequestMessage(int pieceIndex) throws IOException {
        return setPieceIndexMsg(pieceIndex, 6);
    }

    static byte[] getPieceMessage(int pieceIndex, byte[] content) throws IOException {
        byte[] messageType = {(byte) 7};
        byte[] pieceIndexByte = ByteBuffer.allocate(4).putInt(pieceIndex).array();
        int fullLength = messageType.length + pieceIndexByte.length + content.length;
        byte[] messageLength = ByteBuffer.allocate(4).putInt(fullLength).array();

        ByteArrayOutputStream message = new ByteArrayOutputStream();
        message.write(messageLength);
        message.write(messageType);
        message.write(pieceIndexByte);
        message.write(content);
        message.close();

        return message.toByteArray();
    }
}
