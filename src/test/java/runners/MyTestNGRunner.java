package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = { "src/test/resources/features/feature2.feature"},
					glue = {"stepDefinitions"},
					plugin = { "pretty", "html:target/cucumber-reports/"}//,tags= {"@nonapitest"}
					)
public class MyTestNGRunner extends AbstractTestNGCucumberTests{
	
	

}
