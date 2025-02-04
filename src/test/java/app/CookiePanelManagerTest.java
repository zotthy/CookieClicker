package app;

import app.MyItemPanel.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CookiePanelManagerTest {

    private CookiePanelManager cookiePanelManager;
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory(); // Assuming Inventory has a default constructor
        cookiePanelManager = new CookiePanelManager(inventory);
    }

    @Test
    void testInitialCookieCount() {
        assertEquals(0, cookiePanelManager.getCookie());
    }

    @Test
    void testIncreaseCookie() {
        cookiePanelManager.increaseCookie();
        assertEquals(1, cookiePanelManager.getCookie());
    }

    @Test
    void testDecreaseCookie() {
        cookiePanelManager.setCookie(10);
        cookiePanelManager.decreaseCookie(5);
        assertEquals(5, cookiePanelManager.getCookie());
    }

    @Test
    void testDecreaseCookieNotEnoughCookies() {
        cookiePanelManager.setCookie(3);
        cookiePanelManager.decreaseCookie(5);
        assertEquals(3, cookiePanelManager.getCookie());
    }

    @Test
    void testIncreaseMultiplier() {
        cookiePanelManager.increaseMultiplier(0.5);
        assertEquals(1.5, cookiePanelManager.getMultiplerCookie());
        assertEquals(1.575, cookiePanelManager.getCookiePer());
    }

}