package teststore.chris;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {"src/test/resources/features"},
        features = {"src/test/resources/features/logIn.feature"},
        plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json", "rerun:target/rerun.txt"},
        tags = "LogIn"
)
public class TestRunner {

}
