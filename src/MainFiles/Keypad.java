package MainFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

/**
 *
 * @author etho8
 */
public class Keypad implements Runnable, ActionListener {

    // Class Variables  
    JPanel mainPanel = new JPanel();

    JButton oneKey = new JButton("1");
    JButton twoKey = new JButton("2");
    JButton threeKey = new JButton("3");
    JButton fourKey = new JButton("4");
    JButton fiveKey = new JButton("5");
    JButton sixKey = new JButton("6");
    JButton sevenKey = new JButton("7");
    JButton eightKey = new JButton("8");
    JButton nineKey = new JButton("9");
    JButton zeroKey = new JButton("0");
    JButton clearKey = new JButton("CLEAR");
    JButton enterKey = new JButton("Enter");

    JTextField textInput = new JTextField();

    String attempt = "";
    int code;

    // Method to assemble our GUI
    public void run() {
        // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
        JFrame frame = new JFrame("Security");
        // Makes the X button close the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // makes the windows 900 pixel wide by 500 pixels tall
        frame.setSize(600, 500);
        // shows the window
        frame.setVisible(true);

        // setup frame
        frame.add(mainPanel);
        mainPanel.setLayout(null);

        // add pad components to screen
        textInput.setBounds(0, 0, 600, 100);
        mainPanel.add(textInput);

        oneKey.addActionListener(this);
        oneKey.setActionCommand("1");
        oneKey.setBounds(0, 100, 200, 100);
        mainPanel.add(oneKey);

        twoKey.addActionListener(this);
        twoKey.setActionCommand("2");
        twoKey.setBounds(200, 100, 200, 100);
        mainPanel.add(twoKey);

        threeKey.addActionListener(this);
        threeKey.setActionCommand("3");
        threeKey.setBounds(400, 100, 200, 100);
        mainPanel.add(threeKey);

        fourKey.addActionListener(this);
        fourKey.setActionCommand("4");
        fourKey.setBounds(0, 200, 200, 100);
        mainPanel.add(fourKey);

        fiveKey.addActionListener(this);
        fiveKey.setActionCommand("5");
        fiveKey.setBounds(200, 200, 200, 100);
        mainPanel.add(fiveKey);

        sixKey.addActionListener(this);
        sixKey.setActionCommand("6");
        sixKey.setBounds(400, 200, 200, 100);
        mainPanel.add(sixKey);

        sevenKey.addActionListener(this);
        sevenKey.setActionCommand("7");
        sevenKey.setBounds(0, 300, 200, 100);
        mainPanel.add(sevenKey);

        eightKey.addActionListener(this);
        eightKey.setActionCommand("8");
        eightKey.setBounds(200, 300, 200, 100);
        mainPanel.add(eightKey);

        nineKey.addActionListener(this);
        nineKey.setActionCommand("9");
        nineKey.setBounds(400, 300, 200, 100);
        mainPanel.add(nineKey);

        clearKey.addActionListener(this);
        clearKey.setActionCommand("clear");
        clearKey.setBounds(0, 400, 200, 100);
        mainPanel.add(clearKey);
           
        zeroKey.addActionListener(this);
        zeroKey.setActionCommand("0");
        zeroKey.setBounds(200, 400, 200, 100);
        mainPanel.add(zeroKey);
        
        enterKey.addActionListener(this);
        enterKey.setActionCommand("enter");
        enterKey.setBounds(400, 400, 200, 100);
        mainPanel.add(enterKey);
        
        
    }

    // method called when a button is pressed
    public void actionPerformed(ActionEvent e) {
        // get the command from the action
        String command = e.getActionCommand();
        
        attempt = attempt + command;
        System.out.println(attempt);
    }

    // Main method to start our program
    public static void main(String[] args) {
        // Creates an instance of our program
        Keypad gui = new Keypad();
        // Lets the computer know to start it in the event thread
        SwingUtilities.invokeLater(gui);
    }
}
