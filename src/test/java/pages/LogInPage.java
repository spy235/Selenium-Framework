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
	
//	public  By logo = By.xpath("//img[@src=\"/static/images/myeden_logo_dark_small.svg\"]");
//	public  By exiusernametextfield= By.xpath("//div[text()='Email']/parent::div//input[@placeholder='Email']");
//	public  By exipasswordtextfield = By.xpath("//span[@class='password-icon icon-eye-close']/../../../input[@placeholder='Password']");
//	public  By newusernametextfield = By.xpath("//div[text()='Create an account']/parent::div/..//label/div[text()='Email Address']/parent::label/parent::div//input[@placeholder='Email']");
//	public  By newpasswordtextfield = By.xpath("//div[text()='Set a Password']/../..//span[@class='password-icon icon-eye-close']/../../../input[@placeholder='Password']");
//	public  By loginbutton = By.xpath("//button[text()='Log In']");
//	public  By agreebutton = By.xpath("//button[text()='I agree']");
//	public  By signupbutton = By.xpath("//div[text()=\"Don't have an account?\"]/span[text()='Sign up']");
//	public By welcometext1=By.xpath("//div[text()=\"Welcome Back\"]");
//	public By welcometext2=By.xpath("//div[text()=\"It's lovely to see you again.\"]");
//
//	
//	public void enterEmailAndPassword(String userAlias) throws Exception
//	{
//		 String email = TestDataProvider.getUserCredential(userAlias, "Email Address");
// 	    String password = TestDataProvider.getUserCredential(userAlias, "Password");
// 	    
// 	    switch (userAlias) {
// 	        case "myeden_ExistingUser":
// 	        	WebUI.verifyElementVisible(logo);
// 	        	WebUI.verifyElementVisible(welcometext1);
// 	       	    WebUI.verifyElementVisible(welcometext2);
// 	            WebUI.clearAndFillText(exiusernametextfield , email);
// 	            WebUI.clearAndFillText(exipasswordtextfield, password);
// 	            break;
// 	        
// 	        case "myeden_NewUser":
// 	            WebUI.clearAndFillText(newusernametextfield, email);
// 	            WebUI.clearAndFillText(newpasswordtextfield, password);
// 	            break;
// 	  
// 	        
// 	        default:
// 	            throw new IllegalArgumentException("Invalid User: " + userAlias);
// 	    }
//	}
	


	    private By usernameInput = By.xpath("//input[@placeholder='Username']");
	    private By passwordInput = By.xpath("//input[@placeholder='Password']");
	    private By loginButton = By.cssSelector(".orangehrm-login-button");
	    private By loginHeader = By.cssSelector("h5.oxd-text");
	    private By dashboardHeader = By.cssSelector(".oxd-topbar-header-breadcrumb-module");

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
}
