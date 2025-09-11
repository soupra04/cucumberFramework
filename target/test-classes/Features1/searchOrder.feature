Feature:Search order
Scenario: : Search a product with 'e'

		  Given I am on the login page "https://tutorialsninja.com/demo/index.php?route=account/login"
		  When I enter a valid username as "soupra.cool+12@gmail.com" and password as "12345678"
		  And I click the login button
		  Then  title should be "My Account"
		  When I search a product with 'e'
		  And I click on search button
		  Then I can see the product with 'e' in the product name