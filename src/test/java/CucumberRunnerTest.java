package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features= {"src/test/resources/features"})
public class CucumberRunnerTest {

}

/* In the tutorial from https://qaautomation.expert, the @CucumberOptions was like this:
* (features= {"src/test/resources"}, glue= {"com.example.apidemo"})
* but the test only worked when I deleted the [ glue= {"com.example.apidemo"} ] part.
*/