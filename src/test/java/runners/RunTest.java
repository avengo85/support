package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"
       , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = "src/test/resources/features/",
//        dryRun = true,
        monochrome = true,
        glue = "stepdefinitions"
)
public class RunTest {


}
