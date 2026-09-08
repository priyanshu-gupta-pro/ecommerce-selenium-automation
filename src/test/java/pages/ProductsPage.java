package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class ProductsPage {

    WebDriver driver;
    WaitUtility wait;

    // Product locator
    By backpack = By.id("add-to-cart-sauce-labs-backpack");

    // Cart locator
    By cartButton = By.className("shopping_cart_link");

    // Menu locator
    By menuButton = By.id("react-burger-menu-btn");

    // Logout locator
    By logoutButton = By.id("logout_sidebar_link");

    public ProductsPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtility(driver);
    }

    // Add backpack to cart
    public void addBackpackToCart() {

        wait.waitForClickability(backpack).click();
    }

    // Open cart
    public void clickCart() {

        wait.waitForClickability(cartButton).click();
    }

    // Open menu
    public void clickMenu() {

        wait.waitForClickability(menuButton).click();
    }

    // Logout
    public void clickLogout() {

        wait.waitForVisibility(logoutButton);

        wait.waitForClickability(logoutButton).click();
    }
}