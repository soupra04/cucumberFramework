package step1Definations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myHooks.Hooks;
import pageObjects.loginWithExcel;
import stepDefinations.BaseClass;
import utilities.ExcelReader;

public class loginWithExcelStep extends BaseClass {

	public loginWithExcelStep() {
		super(DriverManager.getDriver());

	}

	@Given("Open this Page {string}")
	public void open_this_page(String url) {
		le = new loginWithExcel(driver);
		driver.get(url); // ✅ use parameter from feature file }
		Hooks.getLogger().info("Login page opened");

	}

	@When("user fills form from sheetname {string} and rownumber {int}")
	public void user_fills_form_from_sheetname_and_rownumber_row_number(String sheetName, Integer rownumber)
			throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("D:\\Java_workspace\\cucumber\\loginTestFromExcel.xlsx",
				sheetName);
		String username = testData.get(rownumber).get("username");
		String password = testData.get(rownumber).get("password");
		le.loginFromExcel(username, password);

	}

	@When("I click the submit button")
	public void i_click_the_submit_button() {
		le.clickBtn();

	}

	@Then("I should see this message {string}")
	public void i_should_see_this_message(String expectedmsg) {
		String actual=  le.getSuccmsg();
		Assert.assertEquals(actual, expectedmsg);
	}

}
