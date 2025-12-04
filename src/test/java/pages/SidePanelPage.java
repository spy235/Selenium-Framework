package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import keywords.WebUI;

public class SidePanelPage {

    private WebDriver driver;

    public SidePanelPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nav(String name) {
        By locator = By.xpath("//span[contains(@class,'oxd-main-menu-item--name') and text()='" + name + "']");
        return  WebUI.verifyElementClickable(locator)? locator:null;
       
    }

//    public Object gotoPage(String pageName) {
//    	nav(pageName);
//
//        switch (pageName) {
//            case "Admin":
//                return new AdminPage(driver);
//            case "Directory":
//                return new DirectoryPage(driver);
//            case "Recruitment":
//                return new RecruitmentPage(driver);
//            case "PIM":
//                return new PIMPage(driver);
//            default:
//                return null;
//        }
    
}
