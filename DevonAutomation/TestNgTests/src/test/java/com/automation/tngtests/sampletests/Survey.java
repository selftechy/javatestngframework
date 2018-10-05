package com.automation.tngtests.sampletests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.automation.tngtests.config.SpringContextConfig;
import com.automation.tngtests.testhelper.SurveyHelper;

import nl.prowareness.automation.selenium.exceptions.AutomationDataException;

@ContextConfiguration(classes = { SpringContextConfig.class })
public class Survey extends AbstractTestNGSpringContextTests{
	
	@Autowired
	SurveyHelper surveyHelper;
	
	
	@Test
	public void createAndValidateSurvey() throws AutomationDataException {
		surveyHelper.navigateToHomePage();
		surveyHelper.validateHeadersInHomePage();
		surveyHelper.createSurvey();
	}
	

}
