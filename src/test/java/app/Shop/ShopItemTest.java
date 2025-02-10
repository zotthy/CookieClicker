package app.Shop;

import app.CookiePanelManager;
import app.Exceptions.NotEnoughtCookieException;
import app.MyItemPanel.Inventory;
import app.MyItemPanel.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ShopItemTest {
    private CookiePanelManager cookiePanelManager;
    private Inventory inventory;
    private ShopItem shopItem;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        cookiePanelManager = new CookiePanelManager(inventory);
        shopItem = new ShopItem("test", 100, 2.0, cookiePanelManager, inventory);
    }

    @Test
    public void buyUpgradeTestSuccessfulBuy() {
        cookiePanelManager.setCookie(100.0);

        shopItem.buyUpgrade(cookiePanelManager);

        assertEquals(0.0, cookiePanelManager.getCookie());
        assertEquals(2.0, cookiePanelManager.getMultiplerCookie());
    }

    @Test
    public void buyUpgradeTestNotEnoughCookie() {
        cookiePanelManager.setMultiplerCookie(0);

        assertThrows(NotEnoughtCookieException.class, () -> shopItem.buyUpgrade(cookiePanelManager));
    }

    @Test
    public void testUpdatePriceAfterBuyUpgrade() {
        cookiePanelManager.setCookie(100.0);

        shopItem.buyUpgrade(cookiePanelManager);

        assertEquals(130, shopItem.getPrice());
    }

    @Test
    public void testCounterUpgrade() {
        cookiePanelManager.setCookie(300.0);

        shopItem.buyUpgrade(cookiePanelManager);
        shopItem.buyUpgrade(cookiePanelManager);

        assertEquals(2, shopItem.getCountUpgrade());
    }

    @Test
    public void testAddItemToInventory() {
        cookiePanelManager.setCookie(300.0);
        inventory.addItem("test", 1);

        shopItem.buyUpgrade(cookiePanelManager);
        shopItem.buyUpgrade(cookiePanelManager);

        HashMap<String, Item> itemHashMap = inventory.getItemHashMap();
        assertTrue(itemHashMap.containsKey("test"));
        assertEquals(3, itemHashMap.get("test").getCount());
    }
    @Test
    public void testAddItemToInventoryUi(){
        cookiePanelManager.setCookie(300.0);
        inventory.addItem("test", 1);

        shopItem.buyUpgrade(cookiePanelManager);

        Component components[] = inventory.getComponents();

        assertTrue(components[0] instanceof Item);
        assertEquals(1,components.length);
    }
}