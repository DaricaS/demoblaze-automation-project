package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class SignupLoginPage {

    private WebDriver driver;
    private WaitHelper wait;

    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
    }

    private By signupUsernameField = By.id("sign-username");
    private By signupPasswordField = By.id("sign-password");
    private By signupSubmitButton = By.cssSelector("#signInModal .btn-primary");

    private By loginUsernameField = By.id("loginusername");
    private By loginPasswordField = By.id("loginpassword");
    private By loginSubmitButton = By.cssSelector("#logInModal .btn-primary");

    public void signup(String username, String password) {
        wait.waitForElementVisible(signupUsernameField).sendKeys(username);
        wait.waitForElementVisible(signupPasswordField).sendKeys(password);
        wait.waitForElementClickable(signupSubmitButton).click();
    }

    public void login(String username, String password) {
        wait.waitForElementVisible(loginUsernameField).sendKeys(username);
        wait.waitForElementVisible(loginPasswordField).sendKeys(password);
        wait.waitForElementClickable(loginSubmitButton).click();
    }

    public void waitForModalVisible() {
        wait.waitForElementVisible(signupUsernameField);
    }

    public void handleSignupAlert() {
        wait.waitForAlert();
        driver.switchTo().alert().accept();
    }
}
