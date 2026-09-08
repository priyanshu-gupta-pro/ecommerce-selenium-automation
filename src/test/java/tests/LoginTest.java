package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        TestListener.logStep("Open login page");

        loginPage.enterUsername(properties.getProperty("username"));
        TestListener.logStep("Enter valid username");

        loginPage.enterPassword(properties.getProperty("password"));
        TestListener.logStep("Enter valid password");

        loginPage.clickLogin();
        TestListener.logStep("Click Login button");

        String actualTitle = loginPage.getPageTitle();

        Assert.assertEquals(actualTitle, "Swag Labs");
        TestListener.logStep("Verify page title is Swag Labs");

        System.out.println("Login test completed successfully");
    }
}