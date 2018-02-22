package com.codecool.fileio;

import java.io.IOException;

public interface Copier {

    public void copy(String source, String destination) throws IOException;
    public void stop();
}
