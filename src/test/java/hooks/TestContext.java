package hooks;

import utils.LogUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

import driver.DriverManager;
import driver.TargetFactory;

public class TestContext {

    private WebDriver driver;

    public TestContext() {
        driver = ThreadGuard.protect(new TargetFactory().createInstance());
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }
    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

}