package app.Shop;

import app.CookiePanelManager;
import app.MyItemPanel.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

class ShopItemTest {
    private CookiePanelManager cookiePanelManager;
    private Inventory inventory;
    private ShopItem shopItem;

    @BeforeEach
    void setUp() {
        inventory = mock(Inventory.class);
        cookiePanelManager = mock(CookiePanelManager.class);
        shopItem = new ShopItem("test", 100, 1.0, cookiePanelManager, inventory);
    }

    @Test
    public void buyUpgradeTestNotEnoughCookie() {
        when(cookiePanelManager.getCookie()).thenReturn(150.0);
        when(cookiePanelManager.getMultiplerCookie()).thenReturn(1.0);

        shopItem.buyUpgrade(cookiePanelManager);

        verify(cookiePanelManager, times(1)).decreaseCookie(100);

        assertEquals(1.0,cookiePanelManager.getMultiplerCookie());
        assertEquals(150,cookiePanelManager.getCookie());
        
    }
}