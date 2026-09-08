package listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utilities.ExtentReportManager;

public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentReportManager.getReportInstance();

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Test starts
    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
    }


    // Log test steps
    public static void logStep(String message) {

        test.get().pass(message);

    }


    // Test passes
    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed Successfully");

    }
    // Test fails
    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        try {

            BaseTest baseTest = (BaseTest) result.getInstance();

            WebDriver driver = baseTest.getDriver();

            String screenshotPath = takeScreenshot(
                    driver,
                    result.getMethod().getMethodName()
            );

            test.get().addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {

            test.get().warning(
                    "Screenshot could not be attached: "
                    + e.getMessage()
            );
        }
    }

    // Test skipped
    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");

    }

    // All tests finished
    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

    }

    // Screenshot method
    private String takeScreenshot(
            WebDriver driver,
            String testName) throws IOException {

        TakesScreenshot screenshot =
                (TakesScreenshot) driver;

        Path source =
                screenshot.getScreenshotAs(OutputType.FILE).toPath();

        Path destination =
                Paths.get(
                        "screenshots",
                        testName + "_" + System.currentTimeMillis() + ".png"
                );

        Files.createDirectories(destination.getParent());

        Files.copy(
                source,
                destination,
                StandardCopyOption.REPLACE_EXISTING
        );

        return destination.toString();
    }
}