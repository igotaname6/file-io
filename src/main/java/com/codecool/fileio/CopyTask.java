package com.codecool.fileio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class CopyTask implements Runnable{

    private OptionDialog dialog;

    public CopyTask(OptionDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void run() {

    }
}
