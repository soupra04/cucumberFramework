package step1Definations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddItemToCartPage;
import stepDefinations.BaseClass;

public class AddToCartSteps extends BaseClass {

	public AddToCartSteps() {
		super(DriverManager.getDriver());
		// TODO Auto-generated constructor stub
	}

	@Given("I search a product with {string}")
	public void i_search_a_product_with(String name) {
		so = new AddItemToCartPage(driver);
		so.searchitem(name);
	}

	@When("I click on search button")
	public void i_click_on_search_button() {
		so.clicksearch();

	}

	@Then("I can see the product with {string} in the product name")
	public void i_can_see_the_product_with_in_the_product_name(String name) {
		boolean isPresent=so.isProductPresent(name);
		Assert.assertTrue(isPresent);
		 System.out.println("Product is found: " + name);
		 
	}

	@Then("I add first product {string} to the cart")
	public void i_add_first_product_to_the_cart(String name) {
		so.clicktheProduct(name);
		
		System.out.println("product is selected and added to cart");
		
	}
	
	@Then("I see the success message appear {string}")
	public void i_see_the_success_message_appear(String expectedMessage) {
		String actualMessage = so.getSuccessMessage();  // extract text
	    
	    //Assert.assertEquals("Success message did not match!", expectedMessage, actualMessage);
	    Assert.assertTrue(
	            "Expected success message to contain: " + expectedMessage + " but got: " + actualMessage,
	            actualMessage.contains(expectedMessage)
	        );
	}


	

}
