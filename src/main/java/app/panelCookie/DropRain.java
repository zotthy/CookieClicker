package app.panelCookie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.BufferOverflowException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DropRain {
    private final int width;
    private final int height;
    private int positionX;
    private int positionY;
    private final double speed;
    private Image scaledImage;

    public DropRain() {
        positionX = ThreadLocalRandom.current().nextInt(1000);
        positionY = -ThreadLocalRandom.current().nextInt(1000);
        width = Math.max(1, ThreadLocalRandom.current().nextInt(2));
        height = Math.max(1, ThreadLocalRandom.current().nextInt(10));
        double scaleFactor = 0.3;

        try {
            BufferedImage cookieImage = ImageIO.read(new File("src/main/resources/images/cookie.png"));
            int scaledWidth = (int) (cookieImage.getWidth() * scaleFactor);
            int scaledHeight = (int) (cookieImage.getHeight() * scaleFactor);
            scaledImage = cookieImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        speed = getSpeed();
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public double getSpeed() {
        return ThreadLocalRandom.current().nextDouble(1, 5);
    }

    protected void drawToScreen(Graphics g) {
        g.drawImage(scaledImage,positionX,positionY,null);
        positionY += (int) Math.ceil(speed);
    }
}
