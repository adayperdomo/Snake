import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    
    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.green);
    }    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        
        // Draw the snake as a series of rectangles
        g.fillRect(100, 100, 20, 20); // Head of the snake
        g.fillRect(80, 100, 20, 20);  // Body segment 1
        g.fillRect(60, 100, 20, 20);  // Body segment 2
        g.fillRect(40, 100, 20, 20);  // Body segment 3
    }    

}
