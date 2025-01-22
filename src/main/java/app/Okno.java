package app;

import app.MyItemPanel.MyItem;
import app.Shop.Shop;
import app.panelCookie.AnimationPanel;

import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 700;
    private static final int RAIN_AMOUNT = 12;

    public Okno() {
        super("Cookie Clicker");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        AnimationPanel animationPanel = new AnimationPanel(RAIN_AMOUNT);

        MyItem myItem = new MyItem();
        JPanel myItemPanel = new JPanel(new BorderLayout());
        myItemPanel.add(myItem, BorderLayout.CENTER);
        myItemPanel.setBackground(Color.LIGHT_GRAY);

        Shop shop = new Shop(myItem);

        JSplitPane leftSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, animationPanel, myItemPanel);
        leftSplitPane.setDividerLocation((int) (WINDOW_WIDTH * 0.33));
        leftSplitPane.setDividerSize(2);

        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSplitPane, shop);
        mainSplitPane.setDividerLocation((int) (WINDOW_WIDTH * 0.66));
        mainSplitPane.setDividerSize(2);

        JButton cookieButton = new JButton("Click Me!");
        cookieButton.setPreferredSize(new Dimension(100, 100));
        cookieButton.addActionListener(e -> myItem.increaseCookie());

        animationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        animationPanel.add(cookieButton);

        add(mainSplitPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Okno::new);
    }
}
