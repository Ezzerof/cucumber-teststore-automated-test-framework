package teststore.chris;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        glue = "src/test/java/teststore/chris/stepdefinition",
        features = {"src/test/resources/features"},
        plugin = {"pretty",
                "html:target/testReport.html",
                "json:target/jsonReport.json",
                "rerun:target/rerun.txt"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
