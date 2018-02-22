package com.codecool.fileio;

import java.io.IOException;

public class CopyController implements Runnable {

    private Copier copier;
    private OptionDialog optionDialog;

    public CopyController(OptionDialog optionDialog) {
        this.optionDialog = optionDialog;
        this.copier = new CopierImp(optionDialog.createProgressBar());
    }

    public void run() {

        String[] paths = optionDialog.getInput();
        try {
            copier.copy(paths[0], paths[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
