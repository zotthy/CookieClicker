package app.Shop;

import app.CookiePanelManager;
import app.MyItemPanel.Inventory;

import javax.swing.*;
import java.awt.*;

public class ShopItem extends JPanel {
    private String name;
    private double price;
    private double multipler;
    private int countUpgrade = 0;
    private JButton button;

    public ShopItem(String name, double price, double multipler, CookiePanelManager cookiePanelManager) {
        this.name = name;
        this.price = price;
        this.multipler = multipler;
        button = new JButton();
        button.setPreferredSize(new Dimension(200, 50));
        updateButtonAfterBuyUpgrade();
        button.addActionListener(e -> buyUpgrade(cookiePanelManager)));
    }

    private void buyUpgrade(CookiePanelManager item) {
        if (item.getCookie() >= price) {
            item.decreaseCookie(price);
            price *= 1.3;
            countUpgrade++;
            System.out.println("------>" + name);
            System.out.println(countUpgrade);
            item.increaseMultiplier(multipler);
            updateButtonAfterBuyUpgrade();
        } else {
            System.out.println("Not enough cookies!");
            alert("Not enough cookies");
        }
    }

    private void updateButtonAfterBuyUpgrade() {
        button.setText(name + ": " + formatNumber(price));
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

    public JButton getButton() {
        return button;
    }

    private void alert(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    public int getCountUpgrade() {
        return countUpgrade;
    }

    public void setCountUpgrade(int countUpgrade) {
        this.countUpgrade = countUpgrade;
    }
}
