package com.automation.tngtests.testDriver;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

								plugin={"json:TestReports/json/jsonreport.json", "rerun:TestReports/failedTests.txt"}, 
                                glue={"com.automation.cockpit.cucumber.glue"},
                                features="src/test/resources/live",
                                tags={"@Survey"}

                                )
public class CucumberTestRunner {

	private static final Logger LOGGER = Logger.getLogger(CucumberTestRunner.class);

	public CucumberTestRunner(){
		LOGGER.info("CucumberTest execution started...");
	}
}



