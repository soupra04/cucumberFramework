package stepDefinations;

import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;
import pageObjects.EditAccountInformation;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import pageObjects.SearchOrder;
import utilities.WaitHelper;



public class BaseClass {
	public LoginPage loginPage;
	public WebDriver driver;
	public RegistrationPage rpage;
	public SearchOrder so;
	public static Logger logger;
	public Properties configProp;
	public WaitHelper wait;
	public EditAccountInformation ed;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
		this.loginPage = new LoginPage(driver);
		this.rpage = new RegistrationPage(driver);
		this.so = new SearchOrder(driver);
		this.wait = new WaitHelper(driver);
		this.ed = new EditAccountInformation(driver);
	}

	public String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}

	public String randomAlphaNumeric() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		String generateNumber = RandomStringUtils.randomNumeric(8);
		return (generateString + "@" + generateNumber);
	}

	public String randomNumber() {
		String generateNumber = RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}

	
}
