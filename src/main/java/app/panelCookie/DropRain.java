package app.panelCookie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class DropRain {
    private int width;
    private int height;
    private int positionX;
    private int positionY;
    private final double speed;
    private final double rotationAngle;
    private Image scaledImage;

    public DropRain() {
        positionX = ThreadLocalRandom.current().nextInt(1000);
        positionY = -ThreadLocalRandom.current().nextInt(1000);

        width = Math.max(1, ThreadLocalRandom.current().nextInt(2));
        height = Math.max(1, ThreadLocalRandom.current().nextInt(10));

        double scaleFactor = 0.3;
        rotationAngle = ThreadLocalRandom.current().nextDouble(0, 2 * Math.PI);

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getRotationAngle() {
        return rotationAngle;
    }

    public Image getScaledImage() {
        return scaledImage;
    }

    public void setScaledImage(Image scaledImage) {
        this.scaledImage = scaledImage;
    }

    protected void drawToScreen(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform at = new AffineTransform();
        at.translate(positionX, positionY);
        at.rotate(rotationAngle, scaledImage.getWidth(null) / 2.0, scaledImage.getHeight(null) / 2.0);
        g2d.drawImage(scaledImage, at, null);
        positionY += (int) Math.ceil(speed);
    }
}
