package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverManager;

public class EditAccountInformation {
	
	WebDriver driver;
	
	public EditAccountInformation(WebDriver driver) {
		this.driver = DriverManager.getDriver();
	}
	
	private By editbttn = By.xpath("//a[contains(text(),'Edit Account')]");
	private By fname= By.xpath("//input[@name='firstname']");
	private By lname= By.xpath("//input[@name='lastname']");
	private By email= By.xpath("//input[@name='email']");
	private By tphn= By.xpath("//input[@name='telephone']");
	private By cbutton= By.xpath("//input[@type='submit']");
	private By successMsg = By.xpath("//div[contains(text(),'Success: Your account')]");	
	
	public void clickEbutton() {
		driver.findElement(editbttn).click();
	}
	
	public void setfname(String firstname) {
		driver.findElement(fname).clear();
		driver.findElement(fname).sendKeys(firstname);
	}
	
	public void setlname(String lastname) {
		driver.findElement(lname).clear();
		driver.findElement(lname).sendKeys(lastname);
	}
	
	public void setEmail(String eml) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(eml);
	}
	
	public void settphn(String phn) {
		driver.findElement(tphn).clear();
		driver.findElement(tphn).sendKeys(phn);
	}
	
	public void clickSave() {
		driver.findElement(cbutton).click();
	}
	
	public String getmsg() {
		return driver.findElement(successMsg).getText();
	}

}
