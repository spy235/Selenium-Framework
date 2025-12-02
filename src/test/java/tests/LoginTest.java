package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;


public class LoginTest extends BaseTest {


    @Test
    public void validLoginTest() {
    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage();
        HomePage homepage = loginPage.loginToApplication("Admin", "admin123");
        AdminPage adminPage =  homepage.goToAdminPage();        
    }
}
