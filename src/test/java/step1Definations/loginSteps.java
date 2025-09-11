package step1Definations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import stepDefinations.BaseClass;

public class loginSteps extends BaseClass {

	public loginSteps() {
		super(DriverManager.getDriver());

	}

	@Given("I am on the login page {string}")
	public void i_am_on_the_login_page(String url) {
		loginPage = new LoginPage(driver);
		driver.get(url); // ✅ use parameter from feature file }
		logger.info("Login page opened");
	}

	@When("I enter a valid username as {string} and password as {string}")
	public void i_enter_a_valid_username_as_and_password_as(String username, String password) {
		loginPage.setUsername(username);
		logger.info("Entered username");
		loginPage.setPassword(password);
		logger.info("Entered password");
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.clickLoginButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Clicked on login button");

	}

	@Then("title should be {string}")
	public void i_should_see_a_welcome_message(String expectedTitle) {
		String actualTitle = driver.getTitle();
		logger.info("Expected title: " + expectedTitle);
		logger.info("Actual title: " + actualTitle);
		Assert.assertEquals("Title did not match!", expectedTitle, actualTitle);
	}

	@Then("User should receive this error on screen {string}")
	public String user_should_receive_this_error_on_screen(String string) {
		return loginPage.getWarningText();
	}

	@When("I enter blank username and password")
	public void i_enter_blank_username_and_password() {
		loginPage.clickLoginButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Clicked on login button");

		
	}

}
