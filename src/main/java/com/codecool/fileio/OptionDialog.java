package com.codecool.fileio;

import javax.swing.*;

public interface OptionDialog {

    String[] getInput();
    void createProgressBarWindow();
    JProgressBar createProgressBar();
}
