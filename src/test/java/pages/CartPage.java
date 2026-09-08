package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class CartPage {

    WebDriver driver;
    WaitUtility wait;

    // Product locator
    By backpack = By.id("item_4_title_link");

    // Checkout button
    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtility(driver);
    }

    // Verify backpack is displayed
    public boolean isBackpackDisplayed() {

        return wait.waitForVisibility(backpack)
                .isDisplayed();
    }

    // Click Checkout
    public void clickCheckout() {

        wait.waitForClickability(checkoutButton)
                .click();
    }
}