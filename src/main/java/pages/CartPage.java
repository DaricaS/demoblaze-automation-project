package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class CartPage {

    private WebDriver driver;
    private WaitHelper wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
    }

    private By cartItems = By.cssSelector("#tbodyid tr");
    private By totalPrice = By.id("totalp");
    private By placeOrderButton = By.cssSelector(".btn-success");
    private By deleteButtons = By.linkText("Delete");

    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }

    public String getTotalPrice() {
        return wait.waitForElementVisible(totalPrice).getText();
    }

    public void clickPlaceOrder() {
        wait.waitForElementClickable(placeOrderButton).click();
    }

    public void deleteItem(int index) {
        driver.findElements(deleteButtons).get(index).click();
    }
}

