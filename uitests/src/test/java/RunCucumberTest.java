
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue= {"com/qa/web/uitests/pages"},
        plugin = { "pretty", "html:reports" }
)


public class RunCucumberTest {
}

