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

    @Override
    public void showProgress() {

        JFrame f = new JFrame("Copying Progress");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = f.getContentPane();

        JProgressBar progressBar = new JProgressBar();
        JProgressBar progressBar2 = new JProgressBar();

        progressBar.setStringPainted(true);
        progressBar2.setStringPainted(true);

        Border border = BorderFactory.createTitledBorder("Copying...");

        progressBar.setBorder(border);
        progressBar2.setBorder(border);
        JPanel subPanel = new JPanel();
        JPanel subPanel2 = new JPanel();

        subPanel2.add(progressBar);
        subPanel2.add(progressBar2);
        content.add(subPanel2, BorderLayout.NORTH);

        JButton copyButton = new JButton("Copy");
        copyButton.addActionListener(this);
        subPanel.add(copyButton);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        subPanel.add(stopButton);

        content.add(subPanel, BorderLayout.SOUTH);


        f.setSize(500, 200);
        f.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            final int percent = i;
            try {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
                        progressBar.setValue(percent);
                        progressBar2.setValue(percent);
//                    }
//                });
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
}

