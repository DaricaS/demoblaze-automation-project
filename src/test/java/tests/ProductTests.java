package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverManager;

public class ProductTests extends BaseTest {

    @Test
    public void verifyProductDetails() throws InterruptedException {

        HomePage home = new HomePage(DriverManager.getDriver());
        home.clickCategory("Phones");
        Thread.sleep(2000);
        home.clickProduct("Samsung galaxy s6");

        ProductPage product = new ProductPage(DriverManager.getDriver());

        String title = product.getProductTitle();
        String price = product.getProductPrice();

        Assert.assertTrue(title.contains("Samsung"));
        Assert.assertTrue(price.contains("$"));
    }

    @Test
    public void addProductToCart() {

        HomePage home = new HomePage(DriverManager.getDriver());
        home.clickCategory("Phones");
        home.clickProduct("Samsung galaxy s6");

        ProductPage product = new ProductPage(DriverManager.getDriver());
        product.clickAddToCart();
        product.handleAlert();
    }
}
