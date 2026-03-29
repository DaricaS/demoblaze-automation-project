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

        Thread.sleep(2000);

        product.handleAlert();

        home.goToCart();

        Thread.sleep(2000);

        CartPage cart = new CartPage(DriverManager.getDriver());
        Assert.assertTrue(cart.getCartItemsCount() > 0);
    }
}
