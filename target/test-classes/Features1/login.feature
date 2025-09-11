Feature: Login functionality

@Sanity
Scenario: Successful login with valid credentials
  Given I am on the login page "https://tutorialsninja.com/demo/index.php?route=account/login"
  When I enter a valid username as "soupra.cool+123@gmail.com" and password as "12345678"
  And I click the login button
  Then  title should be "My Account"

@Regression
Scenario Outline: login data Driver
  Given I am on the login page "https://tutorialsninja.com/demo/index.php?route=account/login"
  When I enter a valid username as "<email>" and password as "<password>"
  And I click the login button
 Then title should be "My Account"

  Examples:
    | email                                       | password   |
    |soupra.cool+123@gmail.com                       | 12345678 |
    | soupra.cool+1234@gmail.com                     | 12345678 |
