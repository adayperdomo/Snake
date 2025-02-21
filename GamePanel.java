import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

public class GamePanel extends JPanel {
    private LinkedList<Point> snake;
    private int direction;
    private Point applePosition;
    private boolean isGameOver = false;
    private int elapsedTime = 0;
    private int score = 0;
    private Timer movementTimer;
    private Timer elapsedTimeTimer;
    private JButton restartButton;
    private JButton exitButton;
    private Set<Integer> pressedKeys = new HashSet<>();

    public GamePanel() {
        snake = new LinkedList<>();
        snake.add(new Point(100, 100));
        snake.add(new Point(80, 100));
        direction = KeyEvent.VK_RIGHT;
        generateApple();

        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.GRAY);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyCode());
                updateDirection();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                pressedKeys.remove(e.getKeyCode());
            }
        });

        movementTimer = new Timer(100, e -> {
            if (direction != 0) {
                moveSnake();
            }
        });
        movementTimer.start();

        elapsedTimeTimer = new Timer(1000, e -> {
            elapsedTime++;
        });
        elapsedTimeTimer.start();

        restartButton = new JButton("Restart");
        exitButton = new JButton("Exit");
        restartButton.addActionListener(this::restartGame);
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void updateDirection() {
        for (Integer key : pressedKeys) {
            switch (key) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (direction != KeyEvent.VK_DOWN) direction = KeyEvent.VK_UP;
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
    }

    private void moveSnake() {
        if (isGameOver) return;

        Point head = snake.getFirst();
        Point newHead = new Point(head);

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

        if (newHead.x < 0 || newHead.x >= getWidth() || newHead.y < 0 || newHead.y >= getHeight()) {
            gameOver();
            return;
        }

        for (int i = 1; i < snake.size(); i++) {
            if (newHead.equals(snake.get(i))) {
                gameOver();
                return;
            }
        }

        if (newHead.equals(applePosition)) {
            snake.addFirst(newHead);
            score++;
            generateApple();
        } else {
            snake.addFirst(newHead);
            if (snake.size() > 3) {
                snake.removeLast();
            }
        }

        repaint();
    }

    private void gameOver() {
        isGameOver = true;
        movementTimer.stop();
        elapsedTimeTimer.stop();
        repaint();
    }

    private void generateApple() {
        int maxX = getWidth() / 20 - 1;
        int maxY = getHeight() / 20 - 1;
        applePosition = new Point(
            (int)(Math.random() * maxX) * 20,
            (int)(Math.random() * maxY) * 20
        );
    }

    private void restartGame(ActionEvent e) {
        isGameOver = false;
        score = 0;
        snake.clear();
        snake.add(new Point(100, 100));
        snake.add(new Point(80, 100));
        direction = KeyEvent.VK_RIGHT;
        elapsedTime = 0;
        movementTimer.start();
        elapsedTimeTimer.start();
        remove(restartButton);
        remove(exitButton);
        setFocusable(true);
        requestFocus();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw grid lines
        g.setColor(new Color(200, 200, 200)); // Light gray color for grid
        for (int x = 0; x < getWidth(); x += 20) {
            g.drawLine(x, 0, x, getHeight());
        }
        for (int y = 0; y < getHeight(); y += 20) {
            g.drawLine(0, y, getWidth(), y);
        }
        
        g.setColor(Color.white);

        Point head = snake.getFirst();
        g.fillRect(head.x, head.y, 20, 20);

        g.setColor(Color.black);
        for (int i = 1; i < snake.size(); i++) {
            Point segment = snake.get(i);
            g.fillRect(segment.x, segment.y, 20, 20);
        }

        g.setColor(Color.white);
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Time: " + elapsedTime + "s", 10, 40);

        g.setColor(Color.RED);
        g.fillRect(applePosition.x, applePosition.y, 20, 20);

        if (isGameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            String gameOverMessage = "Game Over";
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            int x = (getWidth() - metrics.stringWidth(gameOverMessage)) / 2;
            g.drawString(gameOverMessage, x, getHeight() / 2 - 20);

            int buttonWidth = 200;
            int buttonHeight = 50;
            restartButton.setBounds(getWidth() / 2 - buttonWidth / 2, getHeight() / 2 + 20, buttonWidth, buttonHeight);
            exitButton.setBounds(getWidth() / 2 - buttonWidth / 2, getHeight() / 2 + 80, buttonWidth, buttonHeight);
            add(restartButton);
            add(exitButton);
        }
    }
}
