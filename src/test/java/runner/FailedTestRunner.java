package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "@target/failed_scenarios.txt",
        glue = {"stepDefinitions", "hooks"},
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumberReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {

    }

