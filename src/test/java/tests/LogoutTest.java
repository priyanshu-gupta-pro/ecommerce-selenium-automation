package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.LoginPage;
import pages.ProductsPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(properties.getProperty("username"));
        TestListener.logStep("Enter valid username");

        loginPage.enterPassword(properties.getProperty("password"));
        TestListener.logStep("Enter valid password");

        loginPage.clickLogin();
        TestListener.logStep("Click Login button");

        // Open menu
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.clickMenu();
        TestListener.logStep("Open navigation menu");

        // Logout
        productsPage.clickLogout();
        TestListener.logStep("Click Logout");

        // Verify login page
        Assert.assertTrue(
            driver.findElement(By.id("login-button")).isDisplayed()
        );

        TestListener.logStep("Verify user is redirected to login page");

        System.out.println("Logout test passed successfully");
    }
}