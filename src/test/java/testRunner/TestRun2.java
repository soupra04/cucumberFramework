package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features/login.feature",
    glue = {"step1Definations", "myHooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber-reports.json"
    },
    monochrome = true,
    dryRun = false
)
public class TestRun2 extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel= true)
    
    public Object[][] scenarios() {
    	return super.scenarios();
    }

}
