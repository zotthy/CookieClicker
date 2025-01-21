package app;

import app.MyItemPanel.MyItem;
import app.Shop.Shop;
import app.panelCookie.AnimationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Okno extends JFrame {
    private static int x = 1000;
    private static int y = 700;

    private static final int RAINAMOUNT = 12;

    public Okno() {
        super("Okno");
        setSize(x, y);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        AnimationPanel animationPanel = new AnimationPanel(RAINAMOUNT);


        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("hello"));


        Shop shop = new Shop();

        JPanel thirdPanel = new JPanel();
        MyItem myItem = new MyItem();
        thirdPanel.add(myItem);
        thirdPanel.setBackground(Color.LIGHT_GRAY);
        thirdPanel.add(new JLabel("Trzeci Panel"));

        JSplitPane leftSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, animationPanel, thirdPanel);
        leftSplitPane.setDividerLocation((int) (x * 0.33));
        leftSplitPane.setDividerSize(2);

        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSplitPane, shop);
        mainSplitPane.setDividerLocation((int) (x * 0.66));
        mainSplitPane.setDividerSize(2);

        JButton button = new JButton("Kliknij mnie!");
        button.setPreferredSize(new Dimension(80,80));
        button.setLocation(200,500);
        button.addActionListener(e -> myItem.inCrease());
        animationPanel.add(button);

        add(mainSplitPane);
        setVisible(true);
    }
}
