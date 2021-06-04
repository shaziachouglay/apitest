import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ="json:target/jsonReports/cucumber-report.json",
        tags = "@current",
        features = "src/test/java/features",
        glue= {"stepdefinitions"}
)
public class CucumberTestSuite {
}
