package pageObjects;

import java.util.List;
import utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.DriverManager;


public class AddItemToCartPage {

	WebDriver driver;
	JavascriptExecutor js;
	WaitHelper wp;

	public AddItemToCartPage(WebDriver driver) {
		this.driver = DriverManager.getDriver();
		this.js = (JavascriptExecutor) driver;
		this.wp = new WaitHelper(this.driver);
		
	}

	private By searchbox = By.xpath("//input[@type='text']");
	private By searchicon = By.xpath("//span[@class='input-group-btn']");
	private By nameOfProduct = By.xpath("//div[@class='row']//div[@class='caption']/h4/a");
	private By sucmsg = By.xpath("//div[contains(text(),'Success: You have added')]");
	private By cartBttn = By.xpath("//button[@id='button-cart']");

	public void searchitem(String item) {
		driver.findElement(searchbox).sendKeys(item);
	}

	public void clicksearch() {
		driver.findElement(searchicon).click();
	}

	public boolean isProductPresent(String expectedProduct) {
		List<WebElement> products = driver.findElements(nameOfProduct);

		for (WebElement product : products) {
			if (product.getText().contains(expectedProduct)) {
				return true;
			}
		}
		return false;
		

	}
	
	
	public void clicktheProduct(String expectedProduct) {
		List<WebElement> products = driver.findElements(nameOfProduct);
		for (WebElement product : products) {
			
			if (product.getText().toLowerCase().contains(expectedProduct.toLowerCase())) {
				 js.executeScript("arguments[0].scrollIntoView(true);", product);
				product.click();
				wp.waitForElement(cartBttn, 10);
				driver.findElement(cartBttn).click();
	            break;
			}
		}
	}
	
	
	public String getSuccessMessage() {
	    wp.waitForElement(sucmsg, 10);
	    return driver.findElement(sucmsg).getText();
	}
}