package com.codecool.fileio;

public interface Copier {

    public void copy(String source, String destination);
    public int getProgress();
}
