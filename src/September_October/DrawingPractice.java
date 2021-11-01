package September_October;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;

/**
 *
 * @author etho8
 */
public class DrawingPractice extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 500;
    static final int HEIGHT = 500;

    //Title of the window
    String title = "Drawing";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));

    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    int sunYPos = 50;
    int skyR = 135;
    int skyG = 206;
    int skyB = 235;

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public DrawingPractice() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);

        // Set things up for the game at startup
        setup();

        // Start the game loop
        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        // COLORS
        Color woodBrown = new Color(98, 52, 18);
        Color skyBlue = new Color(skyR, skyG, skyB);
        Color grass = new Color(0, 100, 0);

        // COMPLETE BACKGROUND
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 500, 500);

        //SKY
        g.setColor(skyBlue);
        g.fillRect(25, 25, 450, 450);

        //SUN
        g.setColor(Color.yellow);
        g.fillOval(50, sunYPos, 75, 75);

        //SUN COVERS
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 500, 25);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 400, 500, 500);

        // TERRAIN START
        int[] xPoints = {25, 25, 475, 475};
        int[] yPoints = {400, 475, 475, 360};

        g.setColor(grass);
        g.fillPolygon(xPoints, yPoints, 4);
        // TERRAIN END

        // TREE START
        g.setColor(woodBrown);
        g.fillRect(300, 260, 30, 120);

        g.setColor(grass);
        g.fillOval(275, 220, 80, 80);
        // TREE END

        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void setup() {
        // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void loop() {

        sunYPos++;

        // When sun is in the position to start setting, make the background go darker
        if (sunYPos >= 50) {
            if (skyR > 0) {
                skyR--;
            }
            if (skyG > 0) {
                skyG--;
            }
            if (skyG == skyR) {
                if (skyB > 50) {
                    skyB--;
                }
            }
        }

        // Reset the sun to the sunrise position when sunset is done
        if (sunYPos > HEIGHT) {
            sunYPos = -400;
        }

        // When the sun is in the sunrise position make the sky brighten up
        if (sunYPos < 0) {
            if (skyR <= 135 && skyB == 236 && skyG >= 72) {
                skyR++;
            }
            if (skyG <= 206 && skyB == 236) {
                skyG++;
            }
            if (skyB <= 235) {
                skyB++;
            }
        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {

        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        loop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        DrawingPractice game = new DrawingPractice();
    }
}
