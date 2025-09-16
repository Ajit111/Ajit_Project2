package Runner;
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/java/Features", tags="@login",glue = {"StepDefinition","base"},
//plugin = {"pretty", "html:target/HTML-reports/test.html","json:target/cucumber-report/cucumber.json"})
//
//
//public class RunnerTest {
//
//}


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"StepDefinition", "base"},
    tags = "@login",
    plugin = {
        "pretty",
        "json:target/cucumber.json",                // JSON report for maven-cucumber-reporting
        "html:target/HTML-reports/cucumber.html"    // Direct HTML output from cucumber
    },
    
    monochrome = true
)
public class RunnerTest {
    // Empty class - only used as test runner
}
