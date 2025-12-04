package report;

import driver.DriverManager;
import enums.AuthorType;
import enums.CategoryType;
import helpers.CaptureHelpers;
import utils.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FrameworkConstants;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import tech.grasshopper.reporter.ExtentPDFReporter;

import static constants.FrameworkConstants.*;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Utility class for managing Extent reports.
 *
 * <p>
 * This class provides methods to initialize, flush, and create tests in Extent
 * reports. It also includes methods for adding screenshots, authors,
 * categories, devices, and log messages to the reports.
 * </p>
 *
 * @version 1.0
 * @since 2022
 */
public class ExtentReportManager {

	private static ExtentReports extentReports;
	private static String link = "";

	/**
	 * Initializes the Extent reports. Configures the report settings and sets the
	 * system information.
	 */
	public static void initReports() {
		if (Objects.isNull(extentReports)) {
			extentReports = new ExtentReports();

			if (OVERRIDE_REPORTS.trim().equals(NO)) {
				System.out.println("OVERRIDE EXTENT REPORTS = " + OVERRIDE_REPORTS);
				link = EXTENT_REPORT_FOLDER_PATH + File.separator + DateUtils.getCurrentDateTimeCustom("_") + "_"
						+ EXTENT_REPORT_FILE_NAME;
				LogUtils.info("Link Extent Report: " + link);
			} else {
				System.out.println("OVERRIDE EXTENT REPORTS = " + OVERRIDE_REPORTS);
				link = EXTENT_REPORT_FILE_PATH;
				LogUtils.info("Link Extent Report: " + link);
			}

//            ExtentPDFReporter pdf = new ExtentPDFReporter("reports/ExtentReports/PdfReport.pdf");
//            try {
//                pdf.loadJSONConfig(new File("src/test/resources/pdf-config.json"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            extentReports.attachReporter(pdf);

			ExtentSparkReporter spark = new ExtentSparkReporter(link);
			extentReports.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle(FrameworkConstants.REPORT_TITLE);
			spark.config().setReportName(FrameworkConstants.REPORT_TITLE);
			extentReports.setSystemInfo("Framework Name", FrameworkConstants.REPORT_TITLE);
			extentReports.setSystemInfo("Author", FrameworkConstants.AUTHOR);

			System.out.println("Extent Reports is installed.");
		}
	}

	/**
	 * Flushes the Extent reports. Unloads the current test and opens the report.
	 */
	public static void flushReports() {
		if (Objects.nonNull(extentReports)) {
			extentReports.flush();
		}
		ExtentTestManager.unload();
		ReportUtils.openReports(link);
	}

	/**
	 * Creates a test with the given test case name.
	 *
	 * @param testCaseName the name of the test case.
	 */
	public static void createTest(String testCaseName) {
		// ExtentManager.setExtentTest(extent.createTest(testCaseName));
		ExtentTestManager.setExtentTest(extentReports.createTest(IconUtils.getBrowserIcon() + " : " + testCaseName));
	}

	/**
	 * Creates a test with the given test case name and description.
	 *
	 * @param testCaseName the name of the test case.
	 * @param description  the description of the test case.
	 */
	public static void createTest(String testCaseName, String description) {
		// ExtentManager.setExtentTest(extent.createTest(testCaseName));
		ExtentTestManager.setExtentTest(extentReports.createTest(testCaseName, description));
	}

	/**
	 * Removes a test with the given test case name.
	 *
	 * @param testCaseName the name of the test case.
	 */
	public static void removeTest(String testCaseName) {
		// ExtentManager.setExtentTest(extent.createTest(testCaseName));
		extentReports.removeTest(testCaseName);
	}

	/**
	 * Adds a screenshot with the given message to the current test.
	 *
	 * @param message the message to be included with the screenshot.
	 */
	public static void addScreenShot(String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

		// Base64 from Screenshot of Selenium
		// ExtentTestManager.getExtentTest().log(Status.INFO,
		// MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());

		// File Path from Screenshot of Java
		ExtentTestManager.getExtentTest().log(Status.INFO, MediaEntityBuilder
				.createScreenCaptureFromPath(String.valueOf(CaptureHelpers.getScreenshot(message))).build());

	}

	/**
	 * Adds a screenshot with the given status and message to the current test.
	 *
	 * @param status  the status of the log entry.
	 * @param message the message to be included with the screenshot.
	 */
	public static void addScreenShot(Status status, String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

		// Base64 from Screenshot of Selenium
		// ExtentTestManager.getExtentTest().log(status,
		// MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());

		// File Path from Screenshot of Java
		ExtentTestManager.getExtentTest().log(status, MediaEntityBuilder
				.createScreenCaptureFromPath(String.valueOf(CaptureHelpers.getScreenshot(message))).build());

	}

	/**
	 * Adds authors to the current test.
	 *
	 * @param authors an array of {@link AuthorType} representing the authors.
	 */
	synchronized public static void addAuthors(AuthorType[] authors) {
		if (authors == null) {
			ExtentTestManager.getExtentTest().assignAuthor("ANHTESTER");
		} else {
			for (AuthorType author : authors) {
				ExtentTestManager.getExtentTest().assignAuthor(author.toString());
			}
		}
	}

	/**
	 * Adds categories to the current test.
	 *
	 * @param categories an array of {@link CategoryType} representing the
	 *                   categories.
	 */
	// public static void addCategories(String[] categories) {
	synchronized public static void addCategories(CategoryType[] categories) {
		if (categories == null) {
			ExtentTestManager.getExtentTest().assignCategory("REGRESSION");
		} else {
			// for (String category : categories) {
			for (CategoryType category : categories) {
				ExtentTestManager.getExtentTest().assignCategory(category.toString());
			}
		}
	}

	/**
	 * Adds the current device information to the current test.
	 */
	synchronized public static void addDevices() {
		ExtentTestManager.getExtentTest().assignDevice(BrowserInfoUtils.getBrowserInfo());
//		ExtentReportManager.getExtentTest()
//				.assignDevice(BrowserIconUtils.getBrowserIcon() + " : " + BrowserInfoUtils.getBrowserInfo());
	}

	/**
	 * Logs a message with INFO status to the current test.
	 *
	 * @param message the message to be logged.
	 */
	public static void logMessage(String message) {
		ExtentTestManager.getExtentTest().log(Status.INFO, message);
	}

	/**
	 * Logs a message with the given status to the current test.
	 *
	 * @param status  the status of the log entry.
	 * @param message the message to be logged.
	 */
	public static void logMessage(Status status, String message) {
		ExtentTestManager.getExtentTest().log(status, message);
	}

	/**
	 * Logs a message with the given status and message object to the current test.
	 *
	 * @param status  the status of the log entry.
	 * @param message the message object to be logged.
	 */
	public static void logMessage(Status status, Object message) {
		ExtentTestManager.getExtentTest().log(status, (Throwable) message);
	}

	/**
	 * Logs a pass message to the current test.
	 *
	 * @param message the message to be logged.
	 */
	public static void pass(String message) {
		// System.out.println("ExtentReportManager class: " +
		// ExtentTestManager.getExtentTest());
		ExtentTestManager.getExtentTest().pass(message);
	}

	/**
	 * Logs a pass message with a {@link Markup} to the current test.
	 *
	 * @param message the markup message to be logged.
	 */
	public static void pass(Markup message) {
		ExtentTestManager.getExtentTest().pass(message);
	}

	/**
	 * Logs a fail message to the current test.
	 *
	 * @param message the message to be logged.
	 */
	public static void fail(String message) {
		ExtentTestManager.getExtentTest().fail(message);
	}

	/**
	 * Logs a fail message with an object to the current test.
	 *
	 * @param message the message object to be logged.
	 */
	public static void fail(Object message) {
		ExtentTestManager.getExtentTest().fail((String) message);
	}

	/**
	 * Logs a fail message with a {@link Markup} to the current test.
	 *
	 * @param message the markup message to be logged.
	 */
	public static void fail(Markup message) {
		ExtentTestManager.getExtentTest().fail(message);
	}

	/**
	 * Logs a skip message to the current test.
	 *
	 * @param message the message to be logged.
	 */
	public static void skip(String message) {
		ExtentTestManager.getExtentTest().skip(message);
	}

	/**
	 * Logs a skip message with a {@link Markup} to the current test.
	 *
	 * @param message the markup message to be logged.
	 */
	public static void skip(Markup message) {
		ExtentTestManager.getExtentTest().skip(message);
	}

	/**
	 * Logs an info message with a {@link Markup} to the current test.
	 *
	 * @param message the markup message to be logged.
	 */
	public static void info(Markup message) {
		ExtentTestManager.getExtentTest().info(message);
	}

	/**
	 * Logs an info message to the current test.
	 *
	 * @param message the message to be logged.
	 */
	public static void info(String message) {
		ExtentTestManager.getExtentTest().info(message);
	}

	/**
	 * Logs a warning message to the current test.
	 *
	 * @param message the message to be logged.
	 */
	public static void warning(String message) {
		ExtentTestManager.getExtentTest().log(Status.WARNING, message);
	}

}
