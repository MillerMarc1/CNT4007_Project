import java.util.ArrayList;

class Common {

    private int _preferredNeighbors;
    private int _unchokingInterval;
    private int _optimisticUInt;
    private String _fileName;
    private int _fileSize;
    private int _pieceSize;

    public Common() {
        _preferredNeighbors = 0;
        _unchokingInterval = 0;
        _optimisticUInt = 0;
        _fileName = null;
        _fileSize = 0;
        _pieceSize = 0;
    }

    public int getPreferredNeighbors() {

        return _preferredNeighbors;
    }

    public int getUnchokingInterval() {

        return _unchokingInterval;
    }

    public int getOptimisticUInt() {

        return _optimisticUInt;
    }

    public String getFileName() {

        return _fileName;
    }

    public int getFileSize() {

        return _fileSize;
    }

    public int getPieceSize() {

        return _pieceSize;
    }

    public void setPreferredNeighbors(int preferredNeighbors) {

        _preferredNeighbors = preferredNeighbors;
    }

    public void setUnchokingInterval(int unchokingInterval) {

        _unchokingInterval = unchokingInterval;
    }

    public void setOptimisticUInt(int optimisticUInt) {

        _optimisticUInt = optimisticUInt;
    }

    public void setFileName(String fileName) {

        _fileName = fileName;
    }

    public void setfileSize(int fileSize) {

        _fileSize = fileSize;
    }

    public void setPieceSize(int pieceSize) {

        _pieceSize = pieceSize;
    }
}