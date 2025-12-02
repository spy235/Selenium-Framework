package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import utils.TestUtils;

public class HomePage {

	By homepageTitle = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
	WebDriver driver = DriverFactory.getDriver();
	HomePage(){
        PageFactory.initElements(driver, this);
		TestUtils.waitForElement(homepageTitle);
	}
	@FindBy(xpath = "//span[contains(@class,'oxd-main-menu-item--name')][text()='Admin']")
	WebElement adminPageNav;
	public AdminPage goToAdminPage() {
		adminPageNav.click();
		return new AdminPage();
		
	}
	
}
