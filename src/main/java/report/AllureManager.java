
package report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.Browser;
import io.qameta.allure.Attachment;
import utils.BrowserInfoUtils;

import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.OutputType.BYTES;

/**
 * Utility class for managing Allure reports.
 * 
 * <p>This class provides methods to configure Allure environment information, attach screenshots, 
 * browser information, text logs, and HTML content to Allure reports. It uses the Allure 
 * annotations and methods to facilitate these functionalities.</p>
 * 
 * @version 1.0
 * @since 2022
 */
public class AllureManager {
	/**
     * Private constructor to prevent instantiation.
     */
    private AllureManager() {
    }
    /**
     * Sets the environment information for Allure reports using the {@link AllureEnvironmentWriter}.
     * The environment information includes test URL, target execution, timeouts, headless mode,
     * local browser, remote URL, and remote port.
     */
    public static void setAllureEnvironmentInformation() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder().
                      //  put("Test URL", FrameworkConstants.URL_CRM).
                        put("Target Execution", FrameworkConstants.TARGET).
                        put("Global Timeout", String.valueOf(FrameworkConstants.WAIT_DEFAULT)).
                        put("Page Load Timeout", String.valueOf(FrameworkConstants.WAIT_PAGE_LOADED)).
                        put("Headless Mode", FrameworkConstants.HEADLESS).
                        put("Local Browser", String.valueOf(Browser.CHROME)).
                        put("Remote URL", FrameworkConstants.REMOTE_URL).
                        put("Remote Port", FrameworkConstants.REMOTE_PORT).
                        build());

        System.out.println("Allure Reports is installed.");

    }
    /**
     * Takes a screenshot of the current browser state and attaches it to the Allure report.
     * 
     * @return a byte array representing the screenshot, or an empty byte array if an exception occurs.
     */
    @Attachment(value = "Failed test screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport() {
        try {
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new byte[0];
    }
    /**
     * Takes a step-by-step screenshot of the current browser state and attaches it to the Allure report.
     * 
     * @return a byte array representing the screenshot, or an empty byte array if an exception occurs.
     */
    @Attachment(value = "Take step screenshot", type = "image/png")
    public static byte[] takeScreenshotStep() {
        try {
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new byte[0];
    }
    /**
     * Adds browser information to the Allure report.
     * 
     * @return a string containing the browser information.
     */
    @Attachment(value = "Browser Information", type = "text/plain")
    public static String addBrowserInformationOnAllureReport() {
        return BrowserInfoUtils.getOSInfo();
    }

    /**
     * Attaches a text log to the Allure report.
     * 
     * @param message the text message to be attached.
     * @return the same text message.
     */
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    /**
     * Attaches an HTML content to the Allure report.
     * 
     * @param html the HTML content to be attached.
     * @return the same HTML content.
     */
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

}
