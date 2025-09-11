package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverManager;

public class SearchOrder  {
	
	 WebDriver driver;
	
	public SearchOrder(WebDriver driver) {
		this.driver = DriverManager.getDriver();
	}

	
	private By searchbox = By.xpath("//input[@type='text']");
	private By searchicon = By.xpath("//span[@class='input-group-btn']");

	public void searchitem(String item) {
		driver.findElement(searchbox).sendKeys(item);
	}

	public void clicksearch() {
		driver.findElement(searchicon).click();
	}
}