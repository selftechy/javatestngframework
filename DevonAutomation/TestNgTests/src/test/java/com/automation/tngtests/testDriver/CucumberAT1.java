package com.automation.tngtests.testDriver;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

                                plugin={"json:TestReports/json/jsonreportGroup1.json", "rerun:TestReports/failures/failedTestsGroup1.txt"},
                                glue={"com.kramp.automation.webshop.cucumber.glue"},
                                features="src/test/resources/live/group1"
                                
                                )
public class CucumberAT1 {

	private static final Logger LOGGER = Logger.getLogger(CucumberAT1.class);
	
	public CucumberAT1(){
		LOGGER.info("CucumberTest execution started...");
	}
	
}


