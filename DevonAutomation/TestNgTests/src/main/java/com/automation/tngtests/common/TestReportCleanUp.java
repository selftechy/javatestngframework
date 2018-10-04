package com.automation.tngtests.common;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class TestReportCleanUp {

	private TestReportCleanUp(){
		
	}
	public static void main(String[] args)  {
		
			clearDir();
		
		
	}

	public static void clearDir() {
		FileUtils.deleteQuietly(new File ("TestReports"));
	}
	
	
	
}
