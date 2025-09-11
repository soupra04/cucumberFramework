package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverManager;


public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
	this.driver = DriverManager.getDriver();

	}

	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By submitBtn = By.xpath("//input[@type='submit']");
	private By text = By.xpath("//a[contains(text(),'Edit your account information')]");
	private By warningText = By.xpath("//div[contains(text(),'Warning')]");
	

	public void setUsername(String eml ) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(eml);
	
	}
	
	public void setPassword(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		driver.findElement(submitBtn).click();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public String getText() {
		return driver.findElement(text).getText();
	}
	public WebElement getTextElement() {
		return driver.findElement(text);
	}
	
	public String getWarningText() {
		return driver.findElement(warningText).getText();
	}
	
	
}

