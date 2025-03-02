package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//cucumber --> TestNg,junit(using for run the feature file)

@CucumberOptions(features="src/test/java/cucumber",glue ="SeleniumFramework.stepDefination",
monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	


}
