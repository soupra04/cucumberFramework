package step1Definations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import driver.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pageObjects.EditAccountInformation;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import stepDefinations.BaseClass;

public class steps1 extends BaseClass {
	public steps1() {
		super(DriverManager.getDriver());
	}

//	@Before
//	public void setup() throws IOException {
//		//Reading config properties
//		configProp = new Properties();
//		FileInputStream configPropfile = new FileInputStream("config.properties");
//		configProp.load(configPropfile);
//		
//		
//		logger =Logger.getLogger("Login");
//		PropertyConfigurator.configure("log4j.properties");
//		
//		String br = configProp.getProperty("browser");
//		if(br.equals("chrome")) {
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--start-maximized");
//			DriverManager.init("chrome");
//			logger.info("Launching Chrome browser");
//		}
//		else if(br.equals("edge")) {
//			EdgeOptions options = new EdgeOptions();
//			options.addArguments("--start-maximized");
//			DriverManager.init("edge");
//			logger.info("Launching Edge browser");
//		}
//		else if(br.equals("firefox")) {
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--start-maximized");
//			DriverManager.init("firefox");
//			logger.info("Launching Firefox browser");
//		}
//
//		driver = DriverManager.getDriver();
//	}
//	
//	//@After
//	public void tearDown() {
//		DriverManager.tearDown();
//	}



	@Given("I open the registration Page {string}")
	public void i_open_the_registration_page(String url) {
		// Write code here that turns the phrase above into concrete actions
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		DriverManager.init("chrome");
		driver = DriverManager.getDriver();
		rpage = new RegistrationPage(driver);
		driver.get(url);

	}

	@When("I provide the details on the Register Page")
	public void i_provide_the_details_on_the_register_page() {
		rpage.setFname(randomString());
		rpage.setLname(randomString());
		rpage.setEmail(randomString() + "@gmail.com");
		rpage.setPhn(randomNumber());
		String pwd = rpage.setPassword(randomAlphaNumeric());
		rpage.setConfPassword(pwd);
		rpage.clickOncbox();
		rpage.clickOncontinueBtn();

	}

	@When("I select the privacy policy")
	public void i_select_the_privacy_policy() {
		rpage.clickOncbox();

	}

	@When("I click on Continue button")
	public void i_click_on_continue_button() {
		rpage.clickOncontinueBtn();

	}

	@Then("I can see the message as {string}")
	public void i_can_see_the_message_as(String string) {

	}

	
	@Given("I click on the Edit Account button")
	public void i_have_clicked_on_the_edit_account_button() {
		ed = new EditAccountInformation(driver);
		ed.clickEbutton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("I provide the edited information")
	public void i_provide_the_edited_information() {
		ed.setfname(randomString());
		ed.setfname(randomString());
		ed.setEmail("abc+009@gmail.com");
		ed.settphn(randomNumber());

	}

	@When("I click on the Save Information button")
	public void i_click_on_the_save_information_button() {
		ed.clickSave();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("I should see the success message {string}")
	public void i_should_see_the_success_message(String txt) {
		Assert.assertEquals(txt, ed.getmsg());
	}

	@When("I enter following user detials")
	public void i_enter_following_user_detials(DataTable dataTable) {

		 List<List<String>> userLists = dataTable.asLists(String.class);

		    for (List<String> user : userLists) {
			String username = user.get(0);
			String password = user.get(1);
			
			loginPage.setUsername(username);
			System.out.println("Username" + username);
			loginPage.setPassword(password);
			System.out.println("password" + password);
			
		}

	}

}
