package app.Shop;

import app.CookiePanelManager;

import javax.swing.*;

public class Shop extends JPanel {
    private CookiePanelManager cookiePanelManager;
    public Shop(CookiePanelManager cookiePanelManager) {
        this.cookiePanelManager = cookiePanelManager;
        addItem("Test",100,3.00);
        addItem("test2",200,3.50);
        addItem("test3",600,3.0);
    }

    public void addItem(String name, double price, double multipler) {
        ShopItem shopItem = new ShopItem(name, price, multipler, cookiePanelManager);
        shopItem.getButton().addActionListener(e->shopItem.buyUpgrade(cookiePanelManager));
        add(shopItem.getButton());
    }
}
