package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class OrderConfirmationPage {

    WebDriver driver;
    WaitUtility wait;

    // Order confirmation message
    By confirmationMessage = By.className("complete-header");

    public OrderConfirmationPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtility(driver);
    }

    // Get confirmation message
    public String getConfirmationMessage() {

        return wait.waitForVisibility(
                confirmationMessage
        ).getText();
    }

    // Verify order confirmation
    public boolean isOrderConfirmed() {

        return wait.waitForVisibility(
                confirmationMessage
        ).isDisplayed();
    }
}