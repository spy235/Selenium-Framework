package report;

import com.aventstack.extentreports.ExtentTest;

/**
 * Manager class for handling ExtentTest instances using ThreadLocal.
 *
 * <p>
 * This class provides methods to set, get, and remove ExtentTest instances. It
 * ensures thread-safe handling of ExtentTest instances for parallel test
 * execution.
 * </p>
 *
 * @version 1.0
 * @since 2022
 */
public class ExtentTestManager {

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	/**
	 * Retrieves the current ExtentTest instance for the current thread.
	 *
	 * @return the ExtentTest instance for the current thread.
	 */
	public static ExtentTest getExtentTest() {
		// System.out.println("ExtentTestManager class: " + extentTest.get());
		return extentTest.get();
	}

	/**
	 * Sets the ExtentTest instance for the current thread.
	 *
	 * @param test the ExtentTest instance to be set.
	 */
	public static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	/**
	 * Removes the ExtentTest instance for the current thread.
	 */
	public static void unload() {
		extentTest.remove();
	}

}