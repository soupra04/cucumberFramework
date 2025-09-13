package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginWithExcel {
	WebDriver driver;

	
	public loginWithExcel(WebDriver driver) {
	   this.driver = driver;
	}  
	  private  By username = By.id("username");
	  private  By password = By.id("password");
	  private  By submit = By.id("submit");
	  private By sucmsg = By.xpath("//h1[contains(text(),'Successfully')]");

	  
	  public void loginFromExcel(String uname, String pwd) {
		  driver.findElement(username).sendKeys(uname);
		  driver.findElement(password).sendKeys(pwd);
		  
	  }
	  
	  public void clickBtn() {
		  driver.findElement(submit).click();
	  }
	  
	  public String getSuccmsg() {
		  return driver.findElement(sucmsg).getText();
	  }
	  

}