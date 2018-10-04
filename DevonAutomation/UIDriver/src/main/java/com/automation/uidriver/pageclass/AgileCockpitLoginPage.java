package com.automation.uidriver.pageclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.automation.uidriver.utilities.Utils;

import nl.prowareness.automation.selenium.exceptions.AutomationDriverException;
import nl.prowareness.automation.selenium.fields.Button;
import nl.prowareness.automation.selenium.fields.TextBox;
import nl.prowareness.automation.selenium.pageinitializers.BasePage;
import nl.prowareness.automation.selenium.utilities.FindElement;
import nl.prowareness.automation.selenium.webdriver.SeleniumWebDriver;

@Component
public class AgileCockpitLoginPage extends BasePage{
	
	

	@Autowired
	private Environment properties;
	
	@Autowired
	SeleniumWebDriver webdriver;
	
	private String strUrl;
	private String strUsername;
	private String strPassword;
	
	@Autowired
	public AgileCockpitLoginPage(SeleniumWebDriver webdriver) throws AutomationDriverException {
		super(webdriver);
	}
	
	@FindElement(page = "LoginPage", field = "username")
	private TextBox username; 

	@FindElement(page = "LoginPage", field = "password")
	private TextBox password;
	
	@FindElement(page = "LoginPage", field = "submitButton")
	private Button submitButton;
	



		
	
	public void Login(){
		strUrl = properties.getProperty("agilecockpit.url");
		strUsername = properties.getProperty("agilecockpit.username");
		strPassword = properties.getProperty("agilecockpit.password");
		webdriver.navigateToURL(strUrl);
		waitJQueryAngular(60);
		waitUntilElementIsVisible(username, 20);
		username.typeText(strUsername);
		password.typeText(strPassword);
		submitButton.click();
	}
	
	
		
}

