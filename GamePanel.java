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
    }    
}
