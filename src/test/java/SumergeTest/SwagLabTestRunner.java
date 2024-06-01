package SumergeTest;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/SumergeTest/Login.feature",
        glue = {"SumergeTest"},
        plugin = {"pretty", "html:target/cucumber-reports/report.html"}
)

public class SwagLabTestRunner extends AbstractTestNGCucumberTests {
}
