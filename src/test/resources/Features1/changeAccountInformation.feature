Feature: Change my account information

  Background:
    Given I am on the login page "https://tutorialsninja.com/demo/index.php?route=account/login"
    When I enter a valid username as "soupra.cool+12@gmail.com" and password as "12345678"
    And I click the login button
    Then title should be "My Account"

  Scenario: Change Account info with correct details
    Given I click on the Edit Account button
    When I provide the edited information
    And I click on the Save Information button
    Then I should see the success message "Success: Your account has been successfully updated."
