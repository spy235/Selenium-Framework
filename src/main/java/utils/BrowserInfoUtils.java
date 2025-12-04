
package utils;

import org.testng.Reporter;

import constants.FrameworkConstants;

/**
 * Utility class for retrieving browser and operating system information.
 *
 * <p>
 * This class provides methods to get browser information, operating system
 * details, and to check the type of operating system. It is designed to be used
 * in a TestNG test context.
 * </p>
 *
 * @version 1.0
 * @since 2022
 */
public final class BrowserInfoUtils {
	// Private constructor to prevent instantiation
	private BrowserInfoUtils() {
		super();
	}

	// OS name retrieved from system properties
	private static final String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * Retrieves the browser information from the TestNG context or
	 * FrameworkConstants.
	 *
	 * @return the name of the browser in uppercase.
	 */
	public static String getBrowserInfo() {
		String browser = "";
		if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER") == null) {
			browser = FrameworkConstants.BROWSER.toUpperCase();
		} else {
			browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER")
					.trim().toUpperCase();
		}
		return browser;
	}

	/**
	 * Retrieves the operating system name from system properties.
	 *
	 * @return the name of the operating system.
	 */
	public static String getOSInfo() {
		return System.getProperty("os.name");
	}

	/**
	 * Checks if the operating system is Windows.
	 *
	 * @return {@code true} if the operating system is Windows, {@code false}
	 *         otherwise.
	 */
	public static boolean isWindows() {
		return (OS.contains("win"));
	}

	/**
	 * Checks if the operating system is Mac.
	 *
	 * @return {@code true} if the operating system is Mac, {@code false} otherwise.
	 */
	public static boolean isMac() {
		return (OS.contains("mac"));
	}

	/**
	 * Checks if the operating system is Unix or Linux.
	 *
	 * @return {@code true} if the operating system is Unix or Linux, {@code false}
	 *         otherwise.
	 */
	public static boolean isUnix() {
		return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
	}

	/**
	 * Checks if the operating system is Solaris.
	 *
	 * @return {@code true} if the operating system is Solaris, {@code false}
	 *         otherwise.
	 */
	public static boolean isSolaris() {
		return (OS.contains("sunos"));
	}

}
