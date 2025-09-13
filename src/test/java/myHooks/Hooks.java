package myHooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import stepDefinations.BaseClass;

public class Hooks extends BaseClass {
	
	public Hooks() {
		super(DriverManager.getDriver());
	}
	
	@Before
	public void setup() throws IOException {
		//Reading config properties
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);
		
		
		logger =Logger.getLogger("Login");
		PropertyConfigurator.configure("log4j.properties");
		
		String br = configProp.getProperty("browser");
		if(br.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			DriverManager.init("chrome");
			logger.info("Launching Chrome browser");
		}
		else if(br.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			DriverManager.init("edge");
			logger.info("Launching Edge browser");
		}
		else if(br.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			DriverManager.init("firefox");
			logger.info("Launching Firefox browser");
		}

		driver = DriverManager.getDriver();
	}
	
//	@After
//	public void tearDown() {
//		DriverManager.tearDown();
//	}

}
