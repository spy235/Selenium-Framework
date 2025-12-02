package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReports.html");
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Selenium POM Framework Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Yashas J");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
