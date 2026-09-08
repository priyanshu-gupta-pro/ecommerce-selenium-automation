package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test(dataProvider = "invalidLoginData")
    public void invalidLoginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        // Enter username
        loginPage.enterUsername(username);
        TestListener.logStep("Enter username: " + username);

        // Enter password
        loginPage.enterPassword(password);
        TestListener.logStep("Enter password");

        // Click Login
        loginPage.clickLogin();
        TestListener.logStep("Click Login button");

        // Get error message
        String actualErrorMessage = loginPage.getErrorMessage();
        TestListener.logStep("Get error message");

        // Expected error message
        String expectedErrorMessage =
                "Epic sadface: Username and password do not match any user in this service";

        // Verify error message
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        TestListener.logStep("Verify invalid login error message");

        System.out.println(
                "Invalid login test passed for: " + username
        );
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {

        return new Object[][] {
            {"wrong_user", "wrong_password"},
            {"standard_user", "wrong_password"},
            {"wrong_user", "secret_sauce"}
        };
    }
}