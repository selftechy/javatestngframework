package com.automation.tngtests.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ScenarioContext {

	private String searchTerm;
	
	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	@Autowired
	private Environment properties;


	public void resetContext() {

		searchTerm = null;
	}




}
