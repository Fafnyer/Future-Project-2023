package Code.Gui;
//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Visuals extends JPanel {
    private JTextArea mainTextBox;
    private JScrollPane mainScrollPane;

    private JButton upperButton;
    private JButton lowerButton;

    private JFrame mainFrame;

    private boolean upperPressed;
    private boolean lowerPressed;

    public Visuals() {
        //construct components
        mainTextBox = new JTextArea ("Default text, should only be seen while debugging");
        upperButton = new JButton ("Continue");
        lowerButton = new JButton ("Continue");
        mainScrollPane = new JScrollPane (mainTextBox);

        //adjust size and set layout
        setPreferredSize (new Dimension (600, 600));
        setLayout (null);

        //set component bounds (only needed by Absolute Positioning)
        mainScrollPane.setBounds (0, 0, 600, 400);
        upperButton.setBounds(0, 400, 600, 100);
        lowerButton.setBounds(0, 500, 600, 100);
        
        //adjust properties
        mainTextBox.setEditable(false);
        mainTextBox.setLineWrap(true);
        mainTextBox.setWrapStyleWord(true);

        //add components
        add (mainScrollPane);
        add (upperButton);
        add (lowerButton);

        upperPressed = false;
        lowerPressed = false;
    }


    public void initialize() {
        mainFrame = new JFrame ("Distress In the Void");
        mainFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().add (this);
        mainFrame.pack();
        mainFrame.setVisible (true);
        mainFrame.setResizable(false);
        addActionListeners();
    }

    public JTextArea getMainTextBox() {
        return mainTextBox;
    }

    public JButton getUpperButton() {
        return upperButton;
    }

    public JButton getLowerButton() {
        return lowerButton;
    }
    
    public JFrame getMainFrame() {
        return mainFrame;
    }

    public JScrollPane getMainScrollPane() {
        return mainScrollPane;
    }

    public boolean getUpperPressed() {
        return upperPressed;
    }

    public boolean getLowerPressed() {
        return lowerPressed;
    }

    public void resetInputs() {
        upperPressed = false;
        lowerPressed = false;
    }
    
    public boolean hasButtonBeenPressed() {
        if (!upperPressed && !lowerPressed) {
            return true;
        }
        return false;
    }

    private void addActionListeners() {
        upperButton.addActionListener( 
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    upperPressed = true;
                }
            }
        );
        lowerButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    lowerPressed = true;
                }
            }
        );
    }
}