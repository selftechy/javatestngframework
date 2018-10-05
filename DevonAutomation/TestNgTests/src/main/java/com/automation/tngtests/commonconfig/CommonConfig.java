package com.automation.tngtests.commonconfig;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.automation.tngtests.common.TestReportCleanUp;
import com.automation.tngtests.exceptions.WebshopDataFailureException;

import nl.prowareness.automation.selenium.webdriver.SeleniumWebDriver;


	
	@Component
	public class CommonConfig {

		@Autowired
		private SeleniumWebDriver webDriver;
		

		@PostConstruct
		public void beforeRun() {
			TestReportCleanUp.clearDir();
		}

		@PreDestroy
		public void afterRun() throws WebshopDataFailureException {
				//TestReportMerger.mergeAndPublishReport();
				killdriver();
		}

		
		
		private void killdriver(){
			for(WebDriver driver : webDriver.getActiveDrivers()){
				driver.quit();
			}
		}

		

	}

