package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class HomePage {

    private WebDriver driver;
    private WaitHelper wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
    }

    private By categoriesLinks = By.cssSelector(".list-group-item");
    private By productsContainer = By.id("tbodyid");
    private By signupButton = By.id("signin2");
    private By loginButton = By.id("login2");
    private By cartLink = By.id("cartur");

    public void openSignupModal() {
        wait.waitForElementClickable(signupButton).click();
    }

    public void openLoginModal() {
        wait.waitForElementClickable(loginButton).click();
    }

    public void goToCart() {
        wait.waitForElementClickable(cartLink).click();
    }

    public void clickCategory(String category) {
        driver.findElements(categoriesLinks)
                .stream()
                .filter(el -> el.getText().equalsIgnoreCase(category))
                .findFirst()
                .ifPresent(el -> el.click());
    }

    public void clickProduct(String productName) {
        wait.waitForElementVisible(productsContainer);
        driver.findElements(By.cssSelector(".hrefch"))
                .stream()
                .filter(el -> el.getText().equalsIgnoreCase(productName))
                .findFirst()
                .ifPresent(el -> el.click());
    }
}

