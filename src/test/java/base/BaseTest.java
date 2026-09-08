package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected Properties properties;

    @BeforeMethod
    public void setup() throws IOException {

        FileInputStream file = new FileInputStream(
                "src/test/resources/config.properties"
        );

        properties = new Properties();
        properties.load(file);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(properties.getProperty("url"));

        file.close();
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}