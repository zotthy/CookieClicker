package app;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Animation extends JPanel {
    private double x = 50;
    private double y = 50;
    private double dx = 2;
    private double dy = 2;

    public Animation() {
        setPreferredSize(new Dimension(500, 500)); // Ustaw wymiary panelu
        Timer timer = new Timer(16, e -> {
            x += dx;
            y += dy;
            if (x < 0 || x + 50 > getWidth()) { // Uwzględnij szerokość prostokąta
                dx = -dx;
            }
            if (y < 0 || y + 50 > getHeight()) { // Uwzględnij wysokość prostokąta
                dy = -dy;
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE); // Ustaw kolor prostokąta
        Rectangle2D rect = new Rectangle2D.Double(x, y, 50, 50);
        g2d.fill(rect); // Wypełnij prostokąt kolorem
    }
}


