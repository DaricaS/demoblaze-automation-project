package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;
import utils.DriverManager;

public class AuthTests extends BaseTest {

    @Test
    public void signupTest() {

        HomePage home = new HomePage(DriverManager.getDriver());
        home.openSignupModal();

        SignupLoginPage auth = new SignupLoginPage(DriverManager.getDriver());

        auth.signup(
                "user" + System.currentTimeMillis(),
                "password123"
        );

        auth.handleSignupAlert();
    }

    @Test
    public void loginTest() {

        HomePage home = new HomePage(DriverManager.getDriver());
        home.openLoginModal();

        SignupLoginPage auth = new SignupLoginPage(DriverManager.getDriver());

        auth.login("testuser", "testpass");
    }
}

