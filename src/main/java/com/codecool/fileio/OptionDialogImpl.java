package com.codecool.fileio;

import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

@Service
public class OptionDialogImpl implements OptionDialog, ActionListener{

    private JButton copyButton;
    private JButton stopButton;
    private JFrame f;
    private Container content;
    private JPanel subPanel=new JPanel();
    private List<JProgressBar> barList = new ArrayList<>();
    private boolean inputIsTrue=false;


    @Override
    public String[] getInput() {

        String[] input = new String[2];
        JTextField fromField = new JTextField();
        JTextField toField = new JTextField();
        Object[] message = {
                "From: ", fromField,
                "To: ", toField,
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            input[0] = fromField.getText();
            input[1] = toField.getText();
        }
        inputIsTrue = true;
        return input;
    }

    @Override
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

        f.setSize(1500, 500);
        f.setVisible(true);
    }

    @Override
    public JProgressBar createProgressBar() {

        if(content == null) {
            createProgressBarWindow();
        }
        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        Border border = BorderFactory.createTitledBorder("Copying...");

        progressBar.setBorder(border);

        subPanel.add(progressBar);

        content.add(subPanel, BorderLayout.NORTH);
        barList.add(progressBar);
        return progressBar;
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        if (action.equals("Stop")) {
            System.exit(0);
        }
        else {
            new Thread(new CopyController(this)).run();
        }
    }
}

