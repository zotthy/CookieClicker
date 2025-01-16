package app.Shop;

import javax.swing.*;

public class Shop extends JPanel {
    public Shop() {
        addItem("Test",1.33,0.33);
    }

    public void addItem(String name, double price, double multipler) {
        ShopItem shopItem = new ShopItem(name, price, multipler);
        add(shopItem.getButton());
    }
}
