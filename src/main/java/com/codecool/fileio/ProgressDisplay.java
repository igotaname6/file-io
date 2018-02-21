package com.codecool.fileio;

public class ProgressDisplay {

    private int bytesRemained;
    private int allBytes;

    public void setBytesRemained(int bytesRemained) {
        this.bytesRemained = bytesRemained;
    }

    public void setAllBytes(int allBytes) {
        this.allBytes = allBytes;
    }

    public int getProgress(){
        return (allBytes - bytesRemained)/allBytes * 100;
    }
}
