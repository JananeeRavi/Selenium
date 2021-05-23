package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
					dryRun=true,
					features={"src/test/java/features/DeleteLead.feature"},
					glue={"stepdef1"},
					monochrome=true
		
		
		)

public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
