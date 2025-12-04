Feature: Login Functionality

  Scenario: User logs in successfully
    Given the user launches the application
    When the user enters valid credentials for "app_User"
    And the user clicks the login button
    Then the user should see the dashboard
