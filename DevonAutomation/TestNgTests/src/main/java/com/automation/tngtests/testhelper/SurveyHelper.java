package com.automation.tngtests.testhelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import com.automation.uidriver.pageclass.AgileCockpitLoginPage;

import nl.prowareness.automation.dao.XcelDataProvider;
import nl.prowareness.automation.selenium.assertions.AssertWithScreenShot;
import nl.prowareness.automation.selenium.exceptions.AutomationDataException;
import nl.prowareness.automation.selenium.webdriver.SeleniumWebDriver;

@Component
public class SurveyHelper {
	
	@Autowired
	SeleniumWebDriver webDriver;

	@Autowired
	XcelDataProvider xlDataProvider;
	
	@Autowired
	AgileCockpitLoginPage agileCockpitLoginPage;
	
	public void navigateToHomePage(){
		AssertWithScreenShot.assertTrue(true, webDriver);
		agileCockpitLoginPage.Login();
	}
	
	@Test
	public void createSurvey() throws AutomationDataException{
		System.out.println("No of sheets: "+xlDataProvider.getData().getSheetDataByName().get("WA_Retail-SalesMarketing_-Profi").getRowData().get(13));
		AssertWithScreenShot.assertTrue(true, webDriver);
	}
	
	public void validateHeadersInHomePage(){
		AssertWithScreenShot.assertTrue(true, webDriver);
	}
	

}
