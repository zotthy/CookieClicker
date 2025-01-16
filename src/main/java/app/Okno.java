package app;

import app.Shop.Shop;
import app.panelCookie.AnimationPanel;

import javax.swing.*;
import java.awt.*;


public class Okno extends JFrame {
    private static int x = 1000;
    private static int y = 700;

    private static final int RAINAMOUNT = 12;

    public Okno() {
        super("Okno");
        setSize(x, y);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        AnimationPanel animationPanel = new AnimationPanel(RAINAMOUNT);


        Shop shop = new Shop();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, animationPanel, shop);


        splitPane.setDividerLocation((int) (y * 0.5));
        splitPane.setDividerSize(0);

        JButton button = new JButton("Kliknij mnie!");
        button.setPreferredSize(new Dimension(80,80));
        button.setLocation(200,500);
        animationPanel.add(button);

        add(splitPane);
        setVisible(true);
    }
}
