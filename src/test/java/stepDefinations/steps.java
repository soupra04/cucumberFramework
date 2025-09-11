//package stepDefinations;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import driver.DriverManager;
//import io.cucumber.java.en.*;
//import pageObjects.LoginPage;
//import pageObjects.RegistrationPage;
//import pageObjects.SearchOrder;
//
//public class steps extends BaseClass {
//	public steps() {
//		super(DriverManager.getDriver());
//	}
//	
//	
//
//	@Given("I am on the login page {string}")
//	public void i_am_on_the_login_page(String url) {
//		logger =Logger.getLogger("Login");
//		PropertyConfigurator.configure("log4j.properties");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--start-maximized");
//		DriverManager.init("chrome");
//		driver = DriverManager.getDriver();
//		loginPage = new LoginPage(driver);
//		driver.get(url); // ✅ use parameter from feature file }
//		logger.info("Login page opened");
//	}
//
//	@When("I enter a valid username as {string} and password as {string}")
//	public void i_enter_a_valid_username_as_and_password_as(String username, String password) {
//		loginPage.setUsername(username);
//		logger.info("Entered username");
//		loginPage.setPassword(password);
//		logger.info("Entered password");
//	}
//
//	@When("I click the login button")
//	public void i_click_the_login_button() {
//		// Write code here that turns the phrase above into concrete actions
//		loginPage.clickLoginButton();
//		logger.info("Clicked on login button");
//
//	}
//
//	@Then("I should be redirected to the dashboard page")
//	public String i_should_be_redirected_to_the_dashboard_page() {
//		// Write code here that turns the phrase above into concrete actions
//		logger.info("Login successful");
//		return loginPage.getText();
//		
//	}
//
//	@And("title should be {string}")
//	public void i_should_see_a_welcome_message(String title) {
//		// Write code here that turns the phrase above into concrete actions
//		if (driver.getPageSource().contains("Error: Please check your username and password")) {
//			driver.close();
//			Assert.assertTrue(false);
//		} else {
//			Assert.assertEquals(title, loginPage.getText());
//		}
//		logger.info("Title matched");
//	}
//
//	@Given("I open the registration Page {string}")
//	public void i_open_the_registration_page(String url) {
//		// Write code here that turns the phrase above into concrete actions
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--start-maximized");
//		DriverManager.init("chrome");
//		driver = DriverManager.getDriver();
//		rpage = new RegistrationPage(driver);
//		driver.get(url);
//
//	}
//
//	@When("I provide the details on the Register Page")
//	public void i_provide_the_details_on_the_register_page() {
//		rpage.setFname(randomString());
//		rpage.setLname(randomString());
//		rpage.setEmail(randomString() + "@gmail.com");
//		rpage.setPhn(randomNumber());
//		String pwd = rpage.setPassword(randomAlphaNumeric());
//		rpage.setConfPassword(pwd);
//		rpage.clickOncbox();
//		rpage.clickOncontinueBtn();
//
//	}
//
//	@When("I select the privacy policy")
//	public void i_select_the_privacy_policy() {
//		rpage.clickOncbox();
//
//	}
//
//	@When("I click on Continue button")
//	public void i_click_on_continue_button() {
//		rpage.clickOncontinueBtn();
//
//	}
//
//	@Then("I can see the message as {string}")
//	public void i_can_see_the_message_as(String string) {
//		
//
//	}
//
//	@When("I search a product with {string}")
//	public void i_search_a_product_with(String string) {
//		so = new SearchOrder(driver);
//		so.searchitem("e");
//	}
//
//	@When("I click on search button")
//	public void i_click_on_search_button() {
//		so.clicksearch();
//
//	}
//
//	@Then("I can see the product with {string} in the product name")
//	public void i_can_see_the_product_with_in_the_product_name(String string) {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//}
