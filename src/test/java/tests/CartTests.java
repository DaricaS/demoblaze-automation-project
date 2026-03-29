package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverManager;

public class CartTests extends BaseTest {

    @Test
    public void verifyAddToCart() throws InterruptedException {

        HomePage home = new HomePage(DriverManager.getDriver());
        home.clickCategory("Phones");
        Thread.sleep(2000);
        home.clickProduct("Samsung galaxy s6");

        ProductPage product = new ProductPage(DriverManager.getDriver());
        product.clickAddToCart();
        product.handleAlert();

        home.goToCart();

        CartPage cart = new CartPage(DriverManager.getDriver());
        Assert.assertTrue(cart.getCartItemsCount() > 0);
    }
}
