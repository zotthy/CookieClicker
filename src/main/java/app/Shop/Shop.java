package app.Shop;

import app.CookiePanelManager;
import app.MyItemPanel.Inventory;

import javax.swing.*;

public class Shop extends JPanel {
    private CookiePanelManager cookiePanelManager;
    private Inventory inventory;
    public Shop(CookiePanelManager cookiePanelManager,Inventory inventory) {
        this.cookiePanelManager = cookiePanelManager;
        this.inventory = inventory;
        addItem("Test",1,3.00);
        addItem("test2",200,3.50);
        addItem("test3",600,3.0);
        addItem("test4",400,2.0);
    }

    public void addItem(String name, double price, double multipler) {
        ShopItem shopItem = new ShopItem(name, price, multipler, cookiePanelManager, inventory);
        add(shopItem.getButton());
    }
}
