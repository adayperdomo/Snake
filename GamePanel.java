import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class GamePanel extends JPanel {
    private LinkedList<Point> snake; // List to store the positions of the snake segments
    private int direction; // Direction of the snake movement

    public GamePanel() {
        snake = new LinkedList<>();
        snake.add(new Point(100, 100)); // Initial position of the snake head
        snake.add(new Point(80, 100));  // Initial position of the first body segment
        direction = KeyEvent.VK_RIGHT; // Initial direction

        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.green);
        setFocusable(true); // Make the panel focusable to receive key events
        addKeyListener(new KeyAdapter() {
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

        Timer timer = new Timer(100, e -> {
            if (direction != 0) { // Only move if a direction is set
                moveSnake();
            }
        });
        timer.start(); // Start the timer to check for movement
    }

    private void moveSnake() {
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

        // Update the snake's body
        snake.addFirst(newHead); // Add the new head to the front of the list
        if (snake.size() > 3) {
            snake.removeLast(); // Keep only two segments
        }

        repaint(); // Repaint the panel to update the snake's position
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
    }
}
