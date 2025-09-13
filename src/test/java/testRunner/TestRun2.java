package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features2/login.feature",
    glue = {"step1Definations", "myHooks"},
    plugin = {
        "pretty",
        "html:target/loginPageParallelTest.html",
        "json:target/loginPageParallelTest.json"
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
