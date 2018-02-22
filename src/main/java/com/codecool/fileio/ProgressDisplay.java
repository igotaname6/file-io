package com.codecool.fileio;

public class ProgressDisplay {

    private volatile int bytesRemained;
    private volatile int allBytes;

    public void setBytesRemained(int bytesRemained) {
        this.bytesRemained = bytesRemained;
    }

    public void setAllBytes(int allBytes) {
        synchronized (this) {
            this.allBytes = allBytes;
        }
    }

    public int getProgress(){
        synchronized (this) {
            return (allBytes - bytesRemained) / allBytes * 100;
        }
    }
}
