package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.TestUtils;

public class AdminPage {
	WebDriver driver = DriverFactory.getDriver();
	By adminTitle = By.cssSelector(".oxd-table-filter-title");
	AdminPage(){
		TestUtils.waitForElement(adminTitle);
	}
}
