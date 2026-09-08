package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class LoginPage {

    WebDriver driver;
    WaitUtility wait;

    // Login page locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    // Error message
    By errorMessage = By.cssSelector(
            "h3[data-test='error']"
    );

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtility(driver);
    }

    // Enter username
    public void enterUsername(String usernameValue) {

        wait.waitForVisibility(username)
                .sendKeys(usernameValue);
    }

    // Enter password
    public void enterPassword(String passwordValue) {

        wait.waitForVisibility(password)
                .sendKeys(passwordValue);
    }

    // Click Login
    public void clickLogin() {

        wait.waitForClickability(loginButton)
                .click();
    }

    // Get page title
    public String getPageTitle() {

        return driver.getTitle();
    }

    // Get error message
    public String getErrorMessage() {

        return wait.waitForVisibility(errorMessage)
                .getText();
    }
}