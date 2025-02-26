import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SnakeGame extends JFrame{

    public SnakeGame(){
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeGame());
    }    
}