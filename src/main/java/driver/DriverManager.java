package driver;

import org.openqa.selenium.WebDriver;

/**
 * Manages the WebDriver instances for the Cannatrek framework.
 * 
 * <p>
 * This class uses a {@code ThreadLocal} to ensure that each thread has its own
 * instance of WebDriver.
 * </p>
 */
public class DriverManager {
	// Each thread gets its own separate WebDriver instance
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	// Private constructor to prevent instantiation
	private DriverManager() {
		super();
	}

	/**
	 * Retrieves the WebDriver instance for the current thread.
	 * 
	 * @return The WebDriver instance for the current thread.
	 */

	public static WebDriver getDriver() {
		return driver.get();
	}

	/**
	 * Sets the WebDriver instance for the current thread.
	 * 
	 * @param driver The WebDriver instance to be set.
	 */
	public static void setDriver(WebDriver driver) {
		DriverManager.driver.set(driver);
	}

	/**
	 * Quits the WebDriver instance for the current thread.
	 * 
	 * <p>
	 * If a WebDriver instance exists for the current thread, this method will quit
	 * the instance.
	 * </p>
	 */
	public static void quit() {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
		}
	}

	// Uncomment the method below if you want to get browser and platform
	// information
//    public static String getInfo() {
//        Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
//        String browserName = cap.getBrowserName();
//        String platform = cap.getPlatformName().toString();
//        String version = cap.getBrowserVersion();
//        return String.format("browser: %s v: %s platform: %s", browserName, version, platform);
//    }
}
