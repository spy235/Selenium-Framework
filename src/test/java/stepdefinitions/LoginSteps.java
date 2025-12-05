package stepdefinitions;

import dataprovider.TestDataRepository;

import org.testng.Assert;

import common.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.WebUI;

public class LoginSteps extends CommonPage {

    @Given("the user launches the application")
    public void the_user_launches_the_application()throws Exception {
        // Gets the driver from ThreadLocal
		WebUI.openWebsite(TestDataRepository.getAppUrl());
    }

    @When("the user enters valid credentials for {string}")
    public void the_user_enters_valid_credentials(String userAlias) throws Exception {
    	getLogInPage().enterCreds(userAlias);
    }
    
    @When("the user enters invalid credentials for {string}")
    public void the_user_enters_invalid_credentials(String userAlias) throws Exception {
    	getLogInPage().enterCreds(userAlias);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button(){
     	getLogInPage().login();
    }

    @Then("the user should see the dashboard")
    public void the_user_should_see_the_dashboard() {
    	getLogInPage().verifyDashboard();
    }
    @Then("the user error message {string}")
     public void the_user_error_message_Invalid_credentials(String message) {
    	getLogInPage().verifyInvalidLoginMessage(message);
    }
    
// hello this is to check branching
}
