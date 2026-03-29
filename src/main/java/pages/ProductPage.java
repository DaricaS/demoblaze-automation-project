package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class ProductPage {

    private WebDriver driver;
    private WaitHelper wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
    }

    private By productTitle = By.cssSelector(".name");
    private By productPrice = By.cssSelector(".price-container");
    private By addToCartButton = By.cssSelector(".btn-success");

    public String getProductTitle() {
        return wait.waitForElementVisible(productTitle).getText();
    }

    public String getProductPrice() {
        return wait.waitForElementVisible(productPrice).getText();
    }

    public void clickAddToCart() {
        wait.waitForElementClickable(addToCartButton).click();
    }

    public void handleAlert() {
        wait.waitForAlert();
        driver.switchTo().alert().accept();
    }
}

