import java.util.ArrayList;

class Common {
    //declare common properties
    private int _preferredNeighbors;
    private int _unchokingInterval;
    private int _optimisticUInt;
    private String _fileName;
    private int _fileSize;
    private int _pieceSize;

    public Common() {
        //constructor for common properties
        
        //initializes properties to 0/null
        _preferredNeighbors = 0;
        _unchokingInterval = 0;
        _optimisticUInt = 0;
        _fileName = null;
        _fileSize = 0;
        _pieceSize = 0;
    }

    public int getPreferredNeighbors() {
        //utility function to allow retrieval of preferred neighbors property
        
        return _preferredNeighbors;
    }

    public int getUnchokingInterval() {
        //utility function to allow retrieval of unchoking interval property

        return _unchokingInterval;
    }

    public int getOptimisticUInt() {
        //utility function to allow retrieval of optomistic unchoking interval property

        return _optimisticUInt;
    }

    public String getFileName() {
        //utility function to allow retrieval of file name property

        return _fileName;
    }

    public int getFileSize() {
        //utility function to allow retrieval of file size property

        return _fileSize;
    }

    public int getPieceSize() {
        //utility function to allow retrieval of piece size property

        return _pieceSize;
    }

    public void setPreferredNeighbors(int preferredNeighbors) {
        //utility function to allow setting of preferred neighbors property

        _preferredNeighbors = preferredNeighbors;
    }

    public void setUnchokingInterval(int unchokingInterval) {
        //utility function to allow setting of unchoking interval property

        _unchokingInterval = unchokingInterval;
    }

    public void setOptimisticUInt(int optimisticUInt) {
        //utility function to allow setting of optimistic unchoking interval property

        _optimisticUInt = optimisticUInt;
    }

    public void setFileName(String fileName) {
        //utility function to allow setting off file name property

        _fileName = fileName;
    }

    public void setfileSize(int fileSize) {
        //utility function to allow setting of file size property

        _fileSize = fileSize;
    }

    public void setPieceSize(int pieceSize) {
        //utility function to allow setting of piece size property

        _pieceSize = pieceSize;
    }
}