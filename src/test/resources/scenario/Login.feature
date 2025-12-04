Feature: Login Functionality

  Scenario: User logs in successfully
    Given the user launches the application
    When the user enters valid credentials for "app_User_valid"
    And the user clicks the login button
    Then the user should see the dashboard

  Scenario: User not logs in successfully
    Given the user launches the application
    When the user enters invalid credentials for "app_User_invalid"
    And the user clicks the login button
    Then the user error message "Invalid credentials"