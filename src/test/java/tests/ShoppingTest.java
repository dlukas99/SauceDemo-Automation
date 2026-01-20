package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class ShoppingTest extends BaseTest {

    @BeforeMethod
    public void loginBeforeTest() {
        // Svaki test ovdje zahtijeva prijavu, pa to radimo prije testa
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testAddToCart() {
        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertEquals(inventory.getCartItemCount(), 0);
        inventory.addBackpackToCart();
        Assert.assertEquals(inventory.getCartItemCount(), 1, "Cart count is wrong!");
    }

    @Test
    public void testPageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs", "Page title is incorrect");
    }

    @Test
    public void testLogout() {
        InventoryPage inventory = new InventoryPage(driver);
        inventory.logout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/", "Logout failed!");
    }
}