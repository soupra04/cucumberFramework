Feature: Add to Cart Functionality

Background: 
		  Given I am on the login page "https://tutorialsninja.com/demo/index.php?route=account/login"
		  When I enter a valid username as "soupra.cool+1234@gmail.com" and password as "12345678"
		  And I click the login button
		  Then  title should be "My Account"

Scenario: Successfully Search a product with 'e	 and add item to crat 
          Given I search a product with 'e'
		  When I click on search button
		  Then I can see the product with 'iPhone' in the product name
		  And I add first product 'iphone' to the cart
		  And I see the success message appear "Success: You have added"

       
       
		 