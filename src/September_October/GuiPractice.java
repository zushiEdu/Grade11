package September_October;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author etho8
 */
public class GuiPractice implements Runnable, ActionListener {

    // Class Variables  
    JPanel mainPanel = new JPanel();
    JTextField textField = new JTextField();
    JButton button = new JButton("Press");
    JLabel outputField = new JLabel();
    JTextField numberField = new JTextField();

    // Method to assemble our GUI
    @Override
    public void run() {
        // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
        JFrame frame = new JFrame("Java Window");
        // Makes the X button close the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // makes the windows 800 pixel wide by 600 pixels tall
        frame.setSize(800, 600);
        // shows the window
        frame.setVisible(true);

        // put panel in frame
        frame.add(mainPanel);

        // disable the layout manager
        mainPanel.setLayout(null);

        // set size and location of text box within panel
        // x location top left, y location top left, width, height
        textField.setBounds(375, 275, 100, 50);
        outputField.setBounds(350, 350, 150, 50);
        // add the textField to the panel
        mainPanel.add(textField);
        mainPanel.add(outputField);

        //outputField.setEnabled(false);
        // add button
        button.setBounds(325, 200, 200, 50);
        mainPanel.add(button);

        // add listener to button
        button.addActionListener(this);
        // give id to button
        button.setActionCommand("button");

        numberField.setBounds(375, 125, 100, 50);
        mainPanel.add(numberField);

        // set component colors
        mainPanel.setBackground(Color.DARK_GRAY);
        button.setBackground(Color.LIGHT_GRAY);
        outputField.setForeground(Color.BLACK);
    }

    // method called when a button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        // get the command from the action
        String command = e.getActionCommand();

        // identify what command is getting heard
        if (command.equals("button")) {
            // get text and apply it to name string
            String name = textField.getText();
            // say hello to output to name
            outputField.setText("Hello " + name);

            String numberWord = numberField.getText();
            int number = Integer.parseInt(numberWord);
            int product = number * 5;
            outputField.setText(outputField.getText() + " " + product);
        }
    }

    // Main method to start our program
    public static void main(String[] args) {
        // Creates an instance of our program
        GuiPractice gui = new GuiPractice();
        // Lets the computer know to start it in the event thread
        SwingUtilities.invokeLater(gui);
    }
}
