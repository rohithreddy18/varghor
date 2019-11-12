package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFile",glue="StepDefination",tags={"@tag1"}, monochrome=true)

public class Runner {

}
