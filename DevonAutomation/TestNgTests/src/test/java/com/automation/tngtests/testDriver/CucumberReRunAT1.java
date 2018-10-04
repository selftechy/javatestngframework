package com.automation.tngtests.testDriver;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

                                plugin={"json:TestReports/json/jsonReRunReportGroup1.json","rerun:TestReports/failures/failedAgainTests1.txt"},
                                glue={"com.kramp.automation.webshop.cucumber.glue"},
                                features={"@TestReports/failures/reRunTestsGroup1.txt"}
                                )
public class CucumberReRunAT1{

	private static final Logger LOGGER = Logger.getLogger(CucumberReRunAT1.class);

	public CucumberReRunAT1(){
		LOGGER.info("CucumberTest execution started...");
	}

	

}


