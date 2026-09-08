package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Project Name", "E-Commerce Automation");
            extent.setSystemInfo("Tester", "Priyanshu");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}