Feature: Login functionality


Scenario: Successful login with valid credentials
		  Given I am on the login page "https://tutorialsninja.com/demo/index.php?route=account/login"
		  When I enter a valid username as "soupra.cool+1234@gmail.com" and password as "12345678"
		  And I click the login button
		  Then  title should be "My Account"

Scenario: login with wrong email

		Given I am on the login page "https://tutorialsninja.com/demo/index.php?route=account/login"
  		When I enter a valid username as "soupra.cool+143@gmail.com" and password as "12345678"
  		And I click the login button
  		Then  title should be "Account Login"
  		And User should receive this error on screen "Warning: No match for E-Mail Address and/or Password."
  		
Scenario: login with blank email and password

        Given I am on the login page "https://tutorialsninja.com/demo/index.php?route=account/login"
  		When I enter blank username and password
  		And I click the login button
  		Then  title should be "Account Login"
  		And User should receive this error on screen "Warning: No match for E-Mail Address and/or Password."
  		
  		
 		
  		