package com.automation.tngtests.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import nl.prowareness.automation.selenium.config.UIDriverContextConfiguration;


@Configuration
@Import(UIDriverContextConfiguration.class)
@PropertySource({"classpath:${TestEnvironment}_environment.properties", 
	"classpath:browser/browser__${TestBrowser}.properties", "classpath:application.properties"})
@ComponentScan(basePackages={"com.automation.uidriver.pageclass", 
		"com.automation.tngtests.common", 
		"com.automation.tngtests.commonconfig",
		"com.automation.tngtests.testhelper"})

public class SpringContextConfig {

	@Configuration
	static class PropertyConfig {
	    @Bean
	    public static PropertySourcesPlaceholderConfigurer  propertiesProcessor() {
	        return new PropertySourcesPlaceholderConfigurer ();
	    }
	}	
	
}




