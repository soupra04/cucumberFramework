package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features2/login.feature",
		//features = "src/test/resources/Features/login.feature" // Path to your feature files
		glue = {"step1Definations", "myHooks"}, // Package containing step definitions
		plugin = {"pretty", "html:target/loginPage.html"}, // Reporting plugins
		//plugin = {"pretty", "json:target/cucumber-reports-json.json"}, // Reporting plugins for jSON
        // publish=true,
		monochrome = false, // Cleaner console output
		dryRun = false // Set to true to check if all steps are defined
       //tags = "@Sanity" // Tags to filter scenarios
		)

public class TestRun {

}



///////////////////////////////////////////////////
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//    features = "src/test/resources/Features",   // Path to feature files
//    glue = {"stepDefinitions", "myHooks"},      // Step defs + hooks packages
//    plugin = {
//        "pretty",
//        "html:target/cucumber-reports.html",
//        "json:target/cucumber-reports.json"
//    },
//    publish = true, 
//    tags = "@Sanity" // optional
//)
//public class TestRun {
//}
//
// instead of dry run
// mvn test -Dcucumber.options="--dry-run"
//Paths → better to use src/test/resources/Features instead of relative .//Features/