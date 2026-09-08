package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class CheckoutPage {

    WebDriver driver;
    WaitUtility wait;

    // Checkout information locators
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");

    // Buttons
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtility(driver);
    }

    // Enter first name
    public void enterFirstName(String firstNameValue) {

        wait.waitForVisibility(firstName)
                .sendKeys(firstNameValue);
    }

    // Enter last name
    public void enterLastName(String lastNameValue) {

        wait.waitForVisibility(lastName)
                .sendKeys(lastNameValue);
    }

    // Enter postal code
    public void enterPostalCode(String postalCodeValue) {

        wait.waitForVisibility(postalCode)
                .sendKeys(postalCodeValue);
    }

    // Click Continue
    public void clickContinue() {

        wait.waitForClickability(continueButton).click();
    }

    // Click Finish
    public void clickFinish() {

        wait.waitForClickability(finishButton).click();
    }
}