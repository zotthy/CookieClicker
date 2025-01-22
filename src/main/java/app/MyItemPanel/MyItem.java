package app.MyItemPanel;

import javax.swing.*;
import java.awt.*;

public class MyItem extends JPanel {

    private double cookie = 0;
    private double multiplerCookie = 1.00;
    private double cookiePer = 1.05;
    private JLabel quantitiCookieDisplay;
    private JLabel multiplerCookieDisplay;

    public MyItem() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        quantitiCookieDisplay = new JLabel("Cookies: " + formatNumber(cookie));
        quantitiCookieDisplay.setPreferredSize(new Dimension(200, 50));
        quantitiCookieDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);

        multiplerCookieDisplay = new JLabel("Multiplier: " + formatNumber(multiplerCookie));
        multiplerCookieDisplay.setPreferredSize(new Dimension(200, 50));
        multiplerCookieDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(quantitiCookieDisplay);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(multiplerCookieDisplay);

        Timer timer = new Timer(1000, e -> {
            cookie += cookiePer;
            updateDisplay();
        });
        timer.start();
    }

    public double getCookie() {
        return cookie;
    }

    public void setCookie(double cookie) {
        this.cookie = cookie;
    }

    public double getCookiePer() {
        return cookiePer;
    }

    public void setCookiePer(double cookiePer) {
        this.cookiePer = cookiePer;
    }

    public double getMultiplerCookie() {
        return multiplerCookie;
    }

    public void setMultiplerCookie(double multiplerCookie) {
        this.multiplerCookie = multiplerCookie;
    }

    public void increaseCookie() {
        cookie = cookie + 1000;
        updateDisplay();
    }
    public void decreaseCookie(double amount) {
        if (cookie >= amount) {
            cookie -= amount;
            updateDisplay();
        }
    }

    public void increaseMultiplier(double additionalMultiplier) {
        multiplerCookie += additionalMultiplier;
        cookiePer = multiplerCookie * 1.05;
        updateDisplay();
    }

    private void updateDisplay() {
        quantitiCookieDisplay.setText("Cookies: " + formatNumber(cookie));
        multiplerCookieDisplay.setText("Multiplier: " + formatNumber(multiplerCookie));
    }

    private String formatNumber(double number) {
        if (number >= 1_000_000) {
            return String.format("%.2fM", number / 1_000_000);
        } else if (number >= 1_000) {
            return String.format("%.2fk", number / 1_000);
        } else {
            return String.format("%.2f", number);
        }
    }
}
