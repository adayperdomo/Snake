 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class GamePanel extends JPanel {
    private LinkedList<Point> snake; // List to store the positions of the snake segments
    private int direction; // Direction of the snake movement
    private Point applePosition; // Position of the apple

    private boolean isGameOver = false; // Game Over state
    private int elapsedTime = 0; // Timer variable
    private Timer movementTimer; // Timer for snake movement
    private Timer elapsedTimeTimer; // Timer for elapsed time
    private JButton restartButton; // Button to restart the game
    private JButton exitButton; // Button to exit the game

    public GamePanel() {
        snake = new LinkedList<>();
        snake.add(new Point(100, 100)); // Initial position of the snake head
        snake.add(new Point(80, 100));  // Initial position of the first body segment
        direction = KeyEvent.VK_RIGHT; // Initial direction
        generateApple(); // Generate initial apple position


        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.GRAY);
        setFocusable(true); // Make the panel focusable to receive key events
        addKeyListener(new KeyAdapter() { // Add key listener in the constructor
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        if (direction != KeyEvent.VK_DOWN) direction = KeyEvent.VK_UP; // Prevent moving in the opposite direction
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        if (direction != KeyEvent.VK_UP) direction = KeyEvent.VK_DOWN;
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        if (direction != KeyEvent.VK_RIGHT) direction = KeyEvent.VK_LEFT;
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        if (direction != KeyEvent.VK_LEFT) direction = KeyEvent.VK_RIGHT;
                        break;
                }
            }
        });

        // Movement timer for the snake
        movementTimer = new Timer(100, e -> {
            if (direction != 0) { // Only move if a direction is set
                moveSnake();
            }
        });
        movementTimer.start(); // Start the movement timer

        // Elapsed time timer
        elapsedTimeTimer = new Timer(1000, e -> {
            elapsedTime++; // Increment elapsed time every second
        });
        elapsedTimeTimer.start(); // Start the elapsed time timer

        // Initialize buttons
        restartButton = new JButton("Restart");
        exitButton = new JButton("Exit");
        restartButton.addActionListener(this::restartGame);
        exitButton.addActionListener(e -> System.exit(0)); // Exit action
    }

    private void moveSnake() {
        if (isGameOver) return; // Prevent movement if the game is over

        Point head = snake.getFirst(); // Get the current head position
        Point newHead = new Point(head); // Create a new head based on the current head

        // Update the head position based on the direction
        switch (direction) {
            case KeyEvent.VK_UP:
                newHead.translate(0, -20);
                break;
            case KeyEvent.VK_DOWN:
                newHead.translate(0, 20);
                break;
            case KeyEvent.VK_LEFT:
                newHead.translate(-20, 0);
                break;
            case KeyEvent.VK_RIGHT:
                newHead.translate(20, 0);
                break;
        }

        // Check for collisions with walls
        if (newHead.x < 0 || newHead.x >= getWidth() || newHead.y < 0 || newHead.y >= getHeight()) {
            gameOver(); // Trigger Game Over if the snake hits the wall
            return;
        }

        // Check for collisions with itself
        for (int i = 1; i < snake.size(); i++) {
            if (newHead.equals(snake.get(i))) {
                gameOver(); // Trigger Game Over if the snake collides with itself
                return;
            }
        }

        // Check for apple collision
        if (newHead.equals(applePosition)) {
            snake.addFirst(newHead); // Grow the snake
            generateApple(); // Generate new apple position
        } else {
            // Update the snake's body
            snake.addFirst(newHead); // Add the new head to the front of the list
            if (snake.size() > 3) {
                snake.removeLast(); // Keep only two segments
            }
        }


        repaint(); // Repaint the panel to update the snake's position
    }

    private void gameOver() {
        isGameOver = true; // Set the game state to over
        movementTimer.stop(); // Stop the movement timer
        elapsedTimeTimer.stop(); // Stop the elapsed time timer
        repaint(); // Repaint to show the game over message
    }

    private void generateApple() {
        // Generate random position within panel bounds, aligned with grid
        int maxX = getWidth() / 20 - 1;
        int maxY = getHeight() / 20 - 1;
        applePosition = new Point(
            (int)(Math.random() * maxX) * 20,
            (int)(Math.random() * maxY) * 20
        );
    }


    private void restartGame(ActionEvent e) {
        isGameOver = false; // Reset the game state
        snake.clear(); // Clear the snake
        snake.add(new Point(100, 100)); // Reset initial position
        snake.add(new Point(80, 100)); // Reset first body segment
        direction = KeyEvent.VK_RIGHT; // Reset direction
        elapsedTime = 0; // Reset elapsed time
        movementTimer.start(); // Restart the movement timer
        elapsedTimeTimer.start(); // Restart the elapsed time timer
        remove(restartButton); // Remove the restart button
        remove(exitButton); // Remove the exit button
        setFocusable(true); // Ensure panel can receive key events
        requestFocus(); // Request focus for key input
        repaint(); // Repaint to update the game state
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white); // Set color for the snake head
        Point head = snake.getFirst();
        g.fillRect(head.x, head.y, 20, 20); // Draw the head

        g.setColor(Color.black); // Set color for the body
        // Draw the body segments
        for (int i = 1; i < snake.size(); i++) {
            Point segment = snake.get(i);
            g.fillRect(segment.x, segment.y, 20, 20); // Draw the body segments
        }

        // Draw the timer in the upper left corner
        g.setColor(Color.white); // Set color for the timer text
        g.drawString("Time: " + elapsedTime + "s", 10, 20); // Draw the timer

        // Draw the apple
        g.setColor(Color.RED);
        g.fillRect(applePosition.x, applePosition.y, 20, 20);

        // Draw Game Over message if the game is over
        if (isGameOver) {

            g.setColor(Color.RED); // Set color for Game Over message
            g.setFont(new Font("Arial", Font.BOLD, 48)); // Set font size
            String gameOverMessage = "Game Over";
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            int x = (getWidth() - metrics.stringWidth(gameOverMessage)) / 2; // Center the message
            g.drawString(gameOverMessage, x, getHeight() / 2 - 20); // Draw message

            // Draw buttons
            int buttonWidth = 200;
            int buttonHeight = 50;
            restartButton.setBounds(getWidth() / 2 - buttonWidth / 2, getHeight() / 2 + 20, buttonWidth, buttonHeight);
            exitButton.setBounds(getWidth() / 2 - buttonWidth / 2, getHeight() / 2 + 80, buttonWidth, buttonHeight);
            add(restartButton);
            add(exitButton);
        }
    }
}
