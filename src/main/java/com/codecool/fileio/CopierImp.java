package com.codecool.fileio;

import javax.swing.*;
import java.io.*;

public class CopierImp implements Copier{

    private JProgressBar bar;

    public CopierImp(JProgressBar bar) {
        this.bar = bar;
    }

    @Override
    public void copy(String source, String destination) throws IOException {

        InputStream inStream  = null;
        OutputStream outStream = null;

        try {
            inStream = new FileInputStream(source);
            outStream = new FileOutputStream(destination);

            byte[] buffer = new byte[1024];
            int startCapacity = inStream.available();
            int len;
            while ((len = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, len);
                bar.setValue((startCapacity - inStream.available())/startCapacity * 100);
            }

        } finally {
            assert inStream != null;
            inStream.close();
            assert outStream != null;
            outStream.close();
        }
    }
    
    @Override
    public void stop() {

    }
}
