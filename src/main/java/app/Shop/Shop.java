package app.Shop;

import javax.swing.*;

public class Shop extends JPanel {
    public Shop() {
        addItem("Test",100,0.33);
        addItem("test2",200,0.90);
        addItem("test3",600,3.0);
    }

    public void addItem(String name, double price, double multipler) {
        ShopItem shopItem = new ShopItem(name, price, multipler);
        add(shopItem.getButton());
    }
}
