package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions (
        features = {"src/test/java/Cucumber_Frameworks/resources"},
        glue = {"stepDefinitions"},
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/rerun.txt"
        }
)

public class RunnerGeneral extends AbstractTestNGCucumberTests {

}

