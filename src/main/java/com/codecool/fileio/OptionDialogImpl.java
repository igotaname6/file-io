package com.codecool.fileio;

import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Service
public class OptionDialogImpl implements OptionDialog, ActionListener{

    JButton copyButton;
    JButton stopButton;
    JFrame f;
    Container content;
    JProgressBar progressBar;

    @Override
    public String getInput() {

        JTextField fromField = new JTextField();
        JTextField toField = new JTextField();
        JCheckBox overwriteOption = new JCheckBox("Overwrite?");
        Object[] message = {
                "From: ", fromField,
                "To: ", toField,
                overwriteOption
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String fromFile = fromField.getText();
            String toFile = toField.getText();
        }
        return "dupa";
    }

    public void createProgressBarWindow() {
        f = new JFrame("Copying Progress");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = f.getContentPane();
        JPanel subPanel = new JPanel();


        copyButton = new JButton("Copy");
        copyButton.addActionListener(this);
        subPanel.add(copyButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        subPanel.add(stopButton);

        content.add(subPanel, BorderLayout.SOUTH);

        f.setSize(500, 200);
        f.setVisible(true);
    }

    public void createProgressBar() {

        progressBar = new JProgressBar();

        progressBar.setStringPainted(true);

        Border border = BorderFactory.createTitledBorder("Copying...");

        progressBar.setBorder(border);
        JPanel subPanel = new JPanel();

//        subPanel.add(progressBar);
        content.add(progressBar, BorderLayout.NORTH);
    }

    @Override
    public void showProgress() {

        for (int i = 0; i <= 100; i++) {
            final int percent = i;
            try {
                        progressBar.setValue(percent);
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        if (action.equals("Stop")) {
            System.exit(0);
        }
        else {
            System.out.println("dupa");
        }
    }

    public static void main(String[] args) {
        OptionDialogImpl optionDialog = new OptionDialogImpl();
        optionDialog.createProgressBarWindow();
        optionDialog.createProgressBar();
        optionDialog.showProgress();
    }
}

