package pages;

import org.openqa.selenium.By;

import common.CommonPage;
import keywords.WebUI;
import dataprovider.TestDataProvider;
import dto.User;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogInPage extends CommonPage{
	    private By usernameInput = By.xpath("//input[@placeholder='Username']");
	    private By passwordInput = By.xpath("//input[@placeholder='Password']");
	    private By loginButton = By.cssSelector(".orangehrm-login-button");
	    private By loginHeader = By.cssSelector("h5.oxd-text");
	    private By dashboardHeader = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
	    private By invlaidLoginElement = By.cssSelector(".oxd-alert-content-text");

	    public void enterCreds(String userAlias) throws Exception {
	    	String username = TestDataProvider.getUserCredential(userAlias, "Username");
			String password = TestDataProvider.getUserCredential(userAlias, "Password");
			System.out.println(username+""+password);
            WebUI.clearAndFillText(usernameInput, username);
            WebUI.clearAndFillText(passwordInput, password);
	    }
	    
	    public void login() {
            WebUI.clickElement(loginButton);
	    }

	    public void verifyLoginPage() {
	        WebUI.verifyElementPresent(loginHeader);
	        String text = WebUI.getTextElement(loginHeader);
	        if (!text.contains("Login")) {
	            throw new RuntimeException("Not on Login Page");
	        }
	    }

	    public void verifyDashboard() {
	    	WebUI.verifyElementPresent(dashboardHeader);
	        String text = WebUI.getTextElement(dashboardHeader);
	        if (!text.contains("Dashboard")) {
	            throw new RuntimeException("Login failed!");
	        }
	    }
	    public void verifyInvalidLoginMessage(String message) {
	    	WebUI.verifyElementPresent(invlaidLoginElement);
	        String text = WebUI.getTextElement(dashboardHeader);
	        if (!text.contains(message)) {
	            throw new RuntimeException("Login failed!");
	        }
	    }
}
