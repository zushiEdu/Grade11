package MainFiles;

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
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author etho8
 */
public class CItyScroller extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 400;
    static final int HEIGHT = 400;

    //Title of the window
    String title = "My Game";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));

    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    Random rand = new Random();
    int maxHeight = 7;

    int ranHeight[] = new int[36];

    int offset = 50;

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public CItyScroller() {
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
        if (offset <= 0) {
            offset = 800;
            for (int i = 0; i < ranHeight.length; i++) {
                ranHeight[i] = rand.nextInt(maxHeight);
            }
        }

        // draw building
        for (int i = 0; i < 36; i++) {
            if (i % 2 == 0) {
                // place base of building
                g.setColor(Color.black);
                g.fillRect((50 * i) - offset, 400, 50, -50);
                g.setColor(Color.white);
                g.fillRect((50 * i) - offset + 10, 400, 10, -20);
                g.fillRect((50 * i) - offset + 30, 400 - 10, 10, -10);
                g.fillRect((50 * i) - offset + 30, 400 - 30, 10, -10);
                g.fillRect((50 * i) - offset + 10, 400 - 30, 10, -10);

                for (int j = 0; j < ranHeight[i]; j++) {
                    g.setColor(Color.black);
                    g.fillRect((50 * i) - offset, 350 - 50 * j, 50, -50);
                    g.setColor(Color.white);
                    // bottom windows
                    g.fillRect((50 * i) - offset + 30, 350 - 50 * j - 10, 10, -10);
                    g.fillRect((50 * i) - offset + 10, 350 - 50 * j - 10, 10, -10);
                    // top windows
                    g.fillRect((50 * i) - offset + 30, 350 - 50 * j - 30, 10, -10);
                    g.fillRect((50 * i) - offset + 10, 350 - 50 * j - 30, 10, -10);

                }
            }
        }
        offset = offset - 5;

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
        CItyScroller game = new CItyScroller();
    }
}
