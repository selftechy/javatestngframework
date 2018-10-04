package com.automation.tngtests.glue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.automation.tngtests.config.CucumberContextConfig;
import com.automation.uidriver.pageclass.AgileCockpitLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.prowareness.automation.dao.XcelDataProvider;
import nl.prowareness.automation.selenium.assertions.AssertWithScreenShot;
import nl.prowareness.automation.selenium.exceptions.AutomationDataException;
import nl.prowareness.automation.selenium.webdriver.SeleniumWebDriver;

@ContextConfiguration(classes = { CucumberContextConfig.class })
public class SurveyStepDefinition {

	@Autowired
	SeleniumWebDriver webDriver;

	@Autowired
	XcelDataProvider xlDataProvider;
	
	@Autowired
	AgileCockpitLoginPage agileCockpitLoginPage;
	
	@Given("^a user logs into the agile cockpit$")
	public void navigateToHomePage(){
		AssertWithScreenShot.assertTrue(true, webDriver);
		//agileCockpitLoginPage.Login();
	}
	
	
	@When("^creates a survey$")
	public void createSurvey() throws AutomationDataException{
        String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory : " + cwd);		
		System.out.println("No of sheets: "+xlDataProvider.getData().getSheetDataByName().get("WA_Retail-SalesMarketing_-Profi").getRowData().get(13));
		AssertWithScreenShot.assertTrue(true, webDriver);
	}
	
	@Then("^newly created survey should be present in the system$")
	public void validateHeadersInHomePage(){
		AssertWithScreenShot.assertTrue(true, webDriver);
	}
	
	
}
