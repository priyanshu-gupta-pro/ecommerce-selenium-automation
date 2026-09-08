package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(properties.getProperty("username"));
        TestListener.logStep("Enter valid username");

        loginPage.enterPassword(properties.getProperty("password"));
        TestListener.logStep("Enter valid password");

        loginPage.clickLogin();
        TestListener.logStep("Click Login button");

        // Add product
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addBackpackToCart();
        TestListener.logStep("Add Sauce Labs Backpack to cart");

        productsPage.clickCart();
        TestListener.logStep("Open shopping cart");

        // Verify product
        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isBackpackDisplayed());
        TestListener.logStep("Verify Sauce Labs Backpack is displayed in cart");

        System.out.println("Product added to cart successfully");
    }
}