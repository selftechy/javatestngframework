package com.automation.tngtests.testDriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class RefactorRerun {

	@Test
	public void refactorFiles() throws IOException {
		refactor("Group1");
		refactor("Group2");
		refactor("Group3");
		refactor("Group4");
		refactor("GroupMerchandise");
		refactor("GroupNewShop");
		System.clearProperty("cucumber.options");
	}
	
	private void refactor(String groupName) throws IOException{

		String sourceFile="TestReports/failures/failedTests"+groupName+".txt";
		String refactorFile="TestReports/failures/reRunTests"+groupName+".txt";
		(new File(refactorFile)).delete();
		BufferedReader br = new BufferedReader(new FileReader(new File(sourceFile)));
		File newFile = new File(refactorFile);
		newFile.createNewFile();
		if(br.ready()){
			
			String[] lines =br.readLine().split(" ");
			BufferedWriter bw =  new BufferedWriter(new FileWriter(newFile.getAbsolutePath()));
			for(String line : lines){
				bw.write("src/test/resources/live/"+groupName+"/"+line + " ");
			}

			bw.close();
		}else {
			BufferedWriter bw =  new BufferedWriter(new FileWriter(newFile.getAbsolutePath()));
			bw.write("src/test/resources/live/login.feature:200");
			bw.close();
		}
		

		if(br!=null)
			br.close();
	}
	
}
