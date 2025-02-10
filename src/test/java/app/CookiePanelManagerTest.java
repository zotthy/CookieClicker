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
        inventory = new Inventory();
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
    void testIncereseCookieValueIsNegative(){
        cookiePanelManager.setCookie(-1);
        cookiePanelManager.increaseCookie();
        assertEquals(0,cookiePanelManager.getCookie());
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
        cookiePanelManager.increaseMultiplier(1.0);
        assertEquals(1.0, cookiePanelManager.getMultiplerCookie());
    }
    @Test
    void testIncreaseMultiplierWithZero() {
        cookiePanelManager.increaseMultiplier(0.0);
        assertEquals(0.0, cookiePanelManager.getMultiplerCookie());
    }
    @Test
    void testMultiplerMaxValue(){
        cookiePanelManager.setMultiplerCookie(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE,cookiePanelManager.getMultiplerCookie());
    }
    @Test
    void testIncreaseCookieWithNegativeMultiplier() {
        cookiePanelManager.increaseMultiplier(-1.0);
        cookiePanelManager.increaseCookie();
        assertEquals(1, cookiePanelManager.getCookie());
    }
    @Test
    void testSetCookieToMaxValue() {
        cookiePanelManager.setCookie(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, cookiePanelManager.getCookie());
    }
    @Test
    void testDecreaseCookieFromMaxValue() {
        cookiePanelManager.setCookie(Integer.MAX_VALUE);
        cookiePanelManager.decreaseCookie(100);
        assertEquals(Integer.MAX_VALUE - 100, cookiePanelManager.getCookie());
    }
    @Test
    void testIncreaseCookieAtMaxValue() {
        cookiePanelManager.setCookie(Integer.MAX_VALUE);
        cookiePanelManager.increaseCookie();
        assertEquals(Integer.MAX_VALUE, cookiePanelManager.getCookie());
    }
}