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
        addItem("Worker",8.0,0.01);
        addItem("Farm",13.50,0.09);
        addItem("Grandma",300,0.3);
        addItem("Mine",100.0,0.15);
        addItem("Factory",200.0,0.25);
        addItem("Bank",3000,0.2);
        addItem("Temple",50000.0,0.5);
        addItem("Portal",70000.0,1.0);
    }

    public void addItem(String name, double price, double multipler) {
        ShopItem shopItem = new ShopItem(name, price, multipler, cookiePanelManager, inventory);
        add(shopItem.getButton());
    }
}
