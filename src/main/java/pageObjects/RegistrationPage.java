package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverManager;

public class RegistrationPage  {
	 WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		this.driver = DriverManager.getDriver();;
	}

	private By fname = By.id("input-firstname");
	private By lname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By phn = By.id("input-telephone");
	private By password = By.id("input-password");
	private By cPassword = By.id("input-confirm");
	private By cbox = By.xpath("//input[@type='checkbox']");
	private By continueBtn = By.xpath("//input[@type='submit']");
	
	
	public void setFname(String firstName) {
		driver.findElement(fname).sendKeys(firstName);
	}
	 public void setLname(String lastName) {
		 driver.findElement(lname).sendKeys(lastName);
	 }
	 
	 public void setEmail(String emailId) {
		 driver.findElement(email).sendKeys(emailId);
	 }
	
	 public void setPhn(String phone) {
		 driver.findElement(phn).sendKeys(phone);
	 }
	 
	 public String setPassword(String pwd) {
		 driver.findElement(password).sendKeys(pwd);
		 return pwd;
	 }
	 	public void setConfPassword(String cpwd) {
		 driver.findElement(cPassword).sendKeys(cpwd);
	 }
	 	public void clickOncbox() {
		 driver.findElement(cbox).click();
	 }
	 	public void clickOncontinueBtn() {
		 driver.findElement(continueBtn).click();
	 }
	
}
