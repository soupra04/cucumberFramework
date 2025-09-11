package testClassesFormySelf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class TestClass1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--start-maximized");
		WebDriver driver = new EdgeDriver(edgeOptions);
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys("soupra.cool+12@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	    driver.quit();
	   
	}

}
