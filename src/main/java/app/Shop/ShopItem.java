package app.Shop;

import app.CookiePanelManager;
import app.Exceptions.NotEnoughtCookieException;
import app.MyItemPanel.Inventory;

import javax.swing.*;
import java.awt.*;

public class ShopItem extends JPanel {
    private String name;
    private double price;
    private double multipler;
    private int countUpgrade = 0;
    private JButton button;
    private Inventory inventory;

    public ShopItem(String name, double price, double multipler, CookiePanelManager cookiePanelManager,Inventory inventory) {
        this.name = name;
        this.price = price;
        this.multipler = multipler;
        this.inventory = inventory;
        button = new JButton();
        button.setPreferredSize(new Dimension(200, 50));
        updateButtonAfterBuyUpgrade();
        button.addActionListener(e->{
        try{
            buyUpgrade(cookiePanelManager);
        }
        catch (NotEnoughtCookieException exception){
            JOptionPane.showMessageDialog(null,exception.getMessage());
        }});
    }

    public void buyUpgrade(CookiePanelManager item) {
        if (item.getCookie() >= price) {
            item.decreaseCookie(price);
            price *= 1.3;
            countUpgrade++;
            item.increaseMultiplier(multipler);
            inventory.addItem(name,1);
            updateButtonAfterBuyUpgrade();
        } else {
            throw new NotEnoughtCookieException("not enought cookie");
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

    public int getCountUpgrade() {
        return countUpgrade;
    }

    public void setCountUpgrade(int countUpgrade) {
        this.countUpgrade = countUpgrade;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMultipler() {
        return multipler;
    }

    public void setMultipler(double multipler) {
        this.multipler = multipler;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
