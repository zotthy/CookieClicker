package app.MyItemPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyItem extends JPanel {
    private double cookie = 10000;
    private double multiplerCookie = 1.35;
    private double cookiePer = 1.05;
    private JLabel quantitiCookieDisplay;
    private JLabel multiplerCookieDisplay;

    public MyItem() {
        quantitiCookieDisplay = new JLabel("Cookie: " + cookie);
        multiplerCookieDisplay = new JLabel("Multipler: " + multiplerCookie);
        add(quantitiCookieDisplay);
        add(multiplerCookieDisplay);

        Timer timer = new Timer(1000, e -> {
            updateDisplay();
            cookiePerSecond();
            cookie += cookiePer;
        });
        timer.start();
    }

    public void inCrease() {
        System.out.println(cookie);
        cookie = cookie + 100 ;
    }

    public void updateDisplay() {
        quantitiCookieDisplay.setText("Cookies: " + cookie);
    }

    public void increaseMultiplier(double additionalMultiplier) {
        multiplerCookie += additionalMultiplier;
    }

    private void cookiePerSecond() {
        cookiePer = multiplerCookie * cookiePer;

        System.out.println(cookie);
        System.out.println(cookiePer);
        System.out.println(multiplerCookie);
    }
}