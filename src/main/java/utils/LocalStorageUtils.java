/**
 * Copyright (c) [2024], Cannatrek Automation Framework
 * @author SaiKumar
 */

package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import driver.DriverManager;

public class LocalStorageUtils {

    private LocalStorageUtils() {
        super();
    }

    private static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    public static String getItem(String key) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return (String) js.executeScript("return window.localStorage.getItem(arguments[0]);", key);
    }

    public static void setItem(String key, String value) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.localStorage.setItem(arguments[0], arguments[1]);", key, value);
    }

    public static void removeItem(String key) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.localStorage.removeItem(arguments[0]);", key);
    }

    public static void clear() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.localStorage.clear();");
    }

    public static int size() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return ((Long) js.executeScript("return window.localStorage.length;")).intValue();
    }
}
