Feature: Registration

Scenario: Register a new account
        Given I open the registration Page "https://tutorialsninja.com/demo/index.php?route=account/register"
		When I provide the details on the Register Page
		And I select the privacy policy
		And I click on Continue button
		Then I can see the message as "Your Account Has Been Created!"