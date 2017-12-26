package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by plexinvise on 12/23/17.
 */
public class UIWorker extends JFrame {

    JFrame mainFrame = new JFrame("TestExercises");
    JPanel panel = new JPanel();
    JTextArea inputText;
    JTextArea outputText;
    WebDriverWorker webDriverWorker = new WebDriverWorker();

    public void startUI () {
        initUI();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    private void configureMainFrame () {
        mainFrame.setLocation(10,20);
        mainFrame.setVisible(true);
        mainFrame.add(panel);
    }

    private void initUI () {
        configureMainFrame();

        //Setting layout for JPanel
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Added inputTextArea
        inputText = new JTextArea(2,40);
        inputText.setLineWrap(true);
        panel.add(inputText, 0);

        //Added button for reverse feature
        JButton reverse = new JButton("Reverse");
        panel.add(reverse,1);
        reverse.setHorizontalAlignment(SwingConstants.CENTER);

        //Button action
        reverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputText.setText("");
                outputText.append(Reverse.reverseEverything(inputText.getText()));
            }
        });

        //Added button for html page
        JButton show3rdand5th = new JButton("Show 3rd and 5th values");
        panel.add(show3rdand5th,2);
        show3rdand5th.setHorizontalAlignment(SwingConstants.CENTER);

        //Button action
        show3rdand5th.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputText.setText("");
                outputText.append(webDriverWorker.show3rdand5th());
            }
        });

        //Added button for fetching all values from html page
        JButton printAllValues = new JButton("PrintAllValues");
        panel.add(printAllValues,3);
        printAllValues.setHorizontalAlignment(SwingConstants.CENTER);

        //Button action
        printAllValues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputText.setText("");
                outputText.append(webDriverWorker.allValues().toString());
            }
        });

        //Added outputTextArea
        outputText = new JTextArea(2,40);
        outputText.setLineWrap(true);
        panel.add(outputText, 4);

        mainFrame.setMinimumSize(getPreferredSize());

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                webDriverWorker.driver.close();
                e.getWindow().dispose();
                System.exit(0);
            }
        });


    }
}
