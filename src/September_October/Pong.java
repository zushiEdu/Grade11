package September_October;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
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
public class Pong extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    //Title of the window
    String title = "Pong Game";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));

    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    int ballX = 375;
    int ballY = 275;

    int directionY = -1;
    int directionX = 1;

    String direction = "tr";

    boolean p1Up = false;
    boolean p1Down = false;

    boolean p2Up = false;
    boolean p2Down = false;

    int paddleOneY = 50;
    int paddleTwoY = 300;

    int p1Score = 0;
    int p2Score = 0;

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public Pong() {
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
        g.setColor(Color.BLACK);
        g.fillRect(50, paddleOneY, 50, 250);
        g.fillRect(700, paddleTwoY, 50, 250);

        g.fillOval(ballX, ballY, 50, 50);

        String p1String = "" + p1Score;
        String p2String = "" + p2Score;

        g.setFont(g.getFont().deriveFont(30f));
        g.drawString(p1String, 350, 50);
        g.drawString(p2String, 435, 50);
        
        g.fillRect(398, 10, 4, 50);

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
        //ballY = ballY + 2 * directionY;
        //ballX = ballX + 2 * directionX;

        ballY = ballY + 10 * directionY;
        ballX = ballX + 10 * directionX;

        // If it hit the top of the screen
        if (ballY <= 0) {
            if (direction == "tr") {
                direction = "br";
            } else if (direction == "bl") {
                direction = "br";
            } else if (direction == "tl") {
                direction = "bl";
            }
        }

        // If it hit the right of the screen
        if (ballX >= 750) {
            if (direction == "tr") {
                direction = "tl";
            } else if (direction == "br") {
                direction = "bl";
            }
            p1Score++;
        }

        // If it hit the bottom of the screen
        if (ballY >= 550) {
            if (direction == "br") {
                direction = "tr";
            } else if (direction == "bl") {
                direction = "tl";
            }
        }

        // If it hit the left side of the screen
        if (ballX <= 0) {
            if (direction == "bl") {
                direction = "br";
            } else if (direction == "tl") {
                direction = "tr";
            }
            p2Score++;
        }

        if (ballX >= 650 && ballX <= 700 && ballY >= paddleTwoY && ballY <= paddleTwoY + 250) {
            if (direction == "br") {
                direction = "bl";
            } else if (direction == "tr") {
                direction = "tl";
            }
        }

        if (ballX >= 50 && ballX <= 100 && ballY >= paddleOneY && ballY <= paddleOneY + 250) {
            if (direction == "tl") {
                direction = "tr";
            } else if (direction == "bl") {
                direction = "br";
            }
        }

        // Direction changing
        if (direction == "tr") {
            directionY = -1;
            directionX = 1;
        }
        if (direction == "br") {
            directionY = 1;
            directionX = 1;
        }
        if (direction == "bl") {
            directionX = -1;
            directionY = 1;
        }
        if (direction == "tl") {
            directionX = -1;
            directionY = -1;
        }

        if (paddleOneY >= 0) {
            if (p1Up) {
                paddleOneY = paddleOneY - 5;
            }
        }
        if (paddleOneY <= 350) {
            if (p1Down) {
                paddleOneY = paddleOneY + 5;
            }
        }

        if (paddleTwoY >= 0) {
            if (p2Up) {
                paddleTwoY = paddleTwoY - 5;
            }
        }
        if (paddleTwoY <= 350) {
            if (p2Down) {
                paddleTwoY = paddleTwoY + 5;
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
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_W) {
                p1Up = true;
            } else if (key == KeyEvent.VK_S) {
                p1Down = true;
            }

            if (key == KeyEvent.VK_K) {
                p2Up = true;
            } else if (key == KeyEvent.VK_M) {
                p2Down = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_W) {
                p1Up = false;
            } else if (key == KeyEvent.VK_S) {
                p1Down = false;
            }

            if (key == KeyEvent.VK_K) {
                p2Up = false;
            } else if (key == KeyEvent.VK_M) {
                p2Down = false;
            }
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
        Pong game = new Pong();
    }
}
