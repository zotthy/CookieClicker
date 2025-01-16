package app.panelCookie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AnimationPanel extends JPanel implements ActionListener {
    private final DropRain[] rain;

    public AnimationPanel(int rainAmount) {
        rain = new DropRain[rainAmount];
        setPreferredSize(new Dimension(800, 600));
        createRain();
        new Timer(15, this).start();
    }

    private void createRain() {
        for (int i = 0; i < rain.length; i++) {
            rain[i] = new DropRain();
        }
    }

    @Override
    protected void paintComponent(Graphics gfx) {
        super.paintComponent(gfx);
        gfx.setColor(Color.BLACK);
        gfx.fillRect(0, 0, getWidth(), getHeight());

        for (DropRain rainDrop : rain) {
            if (rainDrop.getPositionY() > getHeight()) {
                rainDrop.setPositionX((new Random().nextInt(getWidth())));
                rainDrop.setPositionY(0);
            }
            rainDrop.drawToScreen(gfx);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
