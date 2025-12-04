/*
 * Copyright (c) 2022.
 * Automation Framework Selenium - Anh Tester
 */

package driver;

import enums.Target;
import exceptions.TargetNotValidException;
import utils.LogUtils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.FrameworkConstants;

import java.net.URL;

/**
 * Factory class to create WebDriver instances based on the target environment.
 * 
 * <p>
 * This class supports both local and remote WebDriver instances. The target
 * environment is specified by the {@code FrameworkConstants.TARGET} property.
 * </p>
 */

public class TargetFactory {

	/**
	 * Creates a WebDriver instance based on the configured target environment and
	 * browser.
	 * 
	 * @return A WebDriver instance.
	 * @throws TargetNotValidException if the specified target is not valid.
	 */

	public WebDriver createInstance() {
		Target target = Target.valueOf(FrameworkConstants.TARGET.toUpperCase());
		WebDriver webdriver;

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: FrameworkConstants.BROWSER;

		switch (target) {
		case LOCAL:
			// Create new driver from Enum setup in BrowserFactory class
			webdriver = BrowserFactory.valueOf(browserName.toUpperCase()).createDriver();
			break;
		case REMOTE:
			// Create new driver on Cloud (Selenium Grid, Docker) from method below
			webdriver = createRemoteInstance(BrowserFactory.valueOf(browserName.toUpperCase()).getOptions());
			break;
		default:
			throw new TargetNotValidException(target.toString());
		}
		return webdriver;
	}

	/**
	 * Creates a WebDriver instance based on the specified browser and configured
	 * target environment.
	 * 
	 * @param browser The browser name to be used for the WebDriver instance.
	 * @return A WebDriver instance.
	 * @throws TargetNotValidException if the specified target is not valid.
	 */

	public WebDriver createInstance(String browser) {
		Target target = Target.valueOf(FrameworkConstants.TARGET.toUpperCase());
		WebDriver webdriver;

		switch (target) {
		case LOCAL:
			// Create new driver from Enum setup in BrowserFactory class
			webdriver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
			break;
		case REMOTE:
			// Create new driver on Cloud (Selenium Grid, Docker) from method below
			webdriver = createRemoteInstance(BrowserFactory.valueOf(browser.toUpperCase()).getOptions());
			break;
		default:
			throw new TargetNotValidException(target.toString());
		}
		return webdriver;
	}

	/**
	 * Creates a RemoteWebDriver instance for remote execution (e.g., Selenium Grid,
	 * Docker).
	 * 
	 * @param capability The capabilities for the remote WebDriver instance.
	 * @return A RemoteWebDriver instance.
	 */
	private RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
		RemoteWebDriver remoteWebDriver = null;
		try {
			String gridURL = String.format("http://%s:%s", FrameworkConstants.REMOTE_URL,
					FrameworkConstants.REMOTE_PORT);

			remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
		} catch (java.net.MalformedURLException e) {
			LogUtils.error("Grid URL is invalid or Grid Port is not available");
			LogUtils.error(String.format("Browser: %s", capability.getBrowserName()), e);
		} catch (IllegalArgumentException e) {
			LogUtils.error(String.format("Browser %s is not valid or recognized", capability.getBrowserName()), e);
		}

		return remoteWebDriver;
	}

}