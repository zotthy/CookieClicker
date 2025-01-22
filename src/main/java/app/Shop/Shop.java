package app.Shop;

import app.MyItemPanel.MyItem;

import javax.swing.*;

public class Shop extends JPanel {
    private MyItem myItem;
    public Shop(MyItem myItem) {
        this.myItem = myItem;
        addItem("Test",100,3.00);
        addItem("test2",200,3.50);
        addItem("test3",600,3.0);
    }

    public void addItem(String name, double price, double multipler) {
        ShopItem shopItem = new ShopItem(name, price, multipler,myItem);
        shopItem.getButton().addActionListener(e->shopItem.buyUpgrade(myItem));
        add(shopItem.getButton());
    }
}
