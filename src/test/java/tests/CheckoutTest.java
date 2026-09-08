package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {

        // ==========================================
        // 1. Login
        // ==========================================

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(
                properties.getProperty("username")
        );
        TestListener.logStep("Enter valid username");

        loginPage.enterPassword(
                properties.getProperty("password")
        );
        TestListener.logStep("Enter valid password");

        loginPage.clickLogin();
        TestListener.logStep("Click Login button");

        // ==========================================
        // 2. Add product to cart
        // ==========================================

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addBackpackToCart();
        TestListener.logStep("Add Sauce Labs Backpack to cart");

        // ==========================================
        // 3. Open cart
        // ==========================================

        productsPage.clickCart();
        TestListener.logStep("Open shopping cart");

        // ==========================================
        // 4. Verify product in cart
        // ==========================================

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.isBackpackDisplayed(),
                "Sauce Labs Backpack is not displayed in cart"
        );

        TestListener.logStep(
                "Verify Sauce Labs Backpack is displayed in cart"
        );

        // ==========================================
        // 5. Go to checkout
        // ==========================================

        cartPage.clickCheckout();
        TestListener.logStep("Click Checkout button");

        // ==========================================
        // 6. Enter customer information
        // ==========================================

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.enterFirstName("Priyanshu");
        TestListener.logStep("Enter first name");

        checkoutPage.enterLastName("Gupta");
        TestListener.logStep("Enter last name");

        checkoutPage.enterPostalCode("110001");
        TestListener.logStep("Enter postal code");

        // ==========================================
        // 7. Continue to order overview
        // ==========================================

        checkoutPage.clickContinue();
        TestListener.logStep("Click Continue button");

        // ==========================================
        // 8. Finish order
        // ==========================================

        checkoutPage.clickFinish();
        TestListener.logStep("Click Finish button");

        // ==========================================
        // 9. Verify order confirmation
        // ==========================================

        OrderConfirmationPage confirmationPage =
                new OrderConfirmationPage(driver);

        String actualMessage =
                confirmationPage.getConfirmationMessage();

        Assert.assertEquals(
                actualMessage,
                "Thank you for your order!"
        );

        TestListener.logStep(
                "Verify order confirmation message"
        );

        System.out.println(
                "Checkout test completed successfully"
        );
    }
}