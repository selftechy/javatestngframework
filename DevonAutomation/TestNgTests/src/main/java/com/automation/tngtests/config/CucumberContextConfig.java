package com.automation.tngtests.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import nl.prowareness.automation.selenium.config.UIDriverContextConfiguration;


@Configuration
@Import(UIDriverContextConfiguration.class)
@PropertySource({"classpath:${TestEnvironment}_environment.properties", 
	"classpath:browser/browser_${TestBrowser}.properties", "classpath:application.properties"})
@ComponentScan(basePackages={"com.automation.cockpit.webdriver.pageclass", "com.automation.cockpit.cucumber.common", "com.automation.cockpit.cucumber.commonconfig"
		})

public interface CucumberContextConfig {
}

