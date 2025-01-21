package app.Shop;

import javax.swing.*;
import java.awt.*;

public class ShopItem extends JPanel {
    private String name;
    private double price;
    private double multipler;
    JButton button;


    public ShopItem(String name, double price, double multipler) {
        this.name = name;
        this.price = price;
        this.multipler = multipler;
        button = new JButton();
        button.setPreferredSize(new Dimension(200,50));
        button.setLocation(400,400);
        button.setText(name);
    }

    public String getName() {
        return name;
    }

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

    public void buyUpgrade(){

    }

    public JButton getButton() {
        return button;
    }

}
