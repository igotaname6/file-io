package com.codecool.fileio;

import java.io.*;

public class CopierImp implements Copier{

    private int progress = 0;
    private ProgressDisplay display;

    public CopierImp(ProgressDisplay display) {
        this.display = display;
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
            display.setAllBytes(startCapacity);

            int len;
            while ((len = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, len);
                display.setBytesRemained(inStream.available());
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

    @Override
    public ProgressDisplay getProgress(){
        return display;
    }
}
