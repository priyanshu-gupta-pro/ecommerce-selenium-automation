package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    private WebDriverWait wait;

    public WaitUtility(WebDriver driver) {

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    // Wait until element is visible
    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    // Wait until element is clickable
    public WebElement waitForClickability(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    // Wait until element is present
    public WebElement waitForPresence(By locator) {

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }
}