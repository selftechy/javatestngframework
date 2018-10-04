package com.automation.tngtests.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.util.StringUtils;

import com.automation.tngtests.exceptions.WebshopDataFailureException;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class TestReportMerger {
	
	
	private TestReportMerger(){
		
	}

	public static void main(String[] args) throws WebshopDataFailureException {
		mergeAndPublishReport();
	}
	
	public static void mergeAndPublishReport() throws WebshopDataFailureException {
		try{
			List<String> reports = addFiles(Arrays.asList("TestReports/json/jsonreport.json"));
			List<String> reRunReports = addFiles(checkReRun());
			if(!reports.isEmpty()){
				generateReportsFromCucumberJson(reports,"TestReports/CucumberReports/FirstRun" );
			}
			if(!reRunReports.isEmpty()){
				generateReportsFromCucumberJson(reRunReports,"TestReports/CucumberReports/ReRun" );
			}
			//generateTestExecutionStatus();
			
		}catch(IOException exception){
			throw new WebshopDataFailureException("Failed to Generate Cucumber Reports",exception);
		}
	}
	
	private static List<String> checkReRun() throws IOException{
		
		List<String> list = new ArrayList<>();
		File file1 = new File("TestReports/json/jsonReRunreportGroup1.json");
		File file2 = new File("TestReports/json/jsonReRunreportGroup2.json");
		File file3 = new File("TestReports/json/jsonReRunreportGroup3.json");
		File file4 = new File("TestReports/json/jsonReRunreportGroup4.json");
		File file5 = new File("TestReports/json/jsonReRunReportGroupMerchandise.json");
		File file6 = new File("TestReports/json/jsonReRunReportGroupNewShop.json");
		if(file1.exists() && !"[]".equals((new BufferedReader(new FileReader(file1))).readLine())){
			list.add("TestReports/json/jsonReRunreportGroup1.json");
		}
		if(file2.exists() && !"[]".equals((new BufferedReader(new FileReader(file2))).readLine())){
			list.add("TestReports/json/jsonReRunreportGroup2.json");
		}
		if(file3.exists() && !"[]".equals((new BufferedReader(new FileReader(file3))).readLine())){
			list.add("TestReports/json/jsonReRunreportGroup3.json");
		}
		if(file4.exists() && !"[]".equals((new BufferedReader(new FileReader(file4))).readLine())){
			list.add("TestReports/json/jsonReRunreportGroup4.json");
		}
		checkForMerchandiseFile(list, file5);
		checkForNewShopFile(list, file6);
		return list;
		
	}

	private static void checkForMerchandiseFile(List<String> list, File file5)
			throws IOException, FileNotFoundException {
		if(file5.exists() && !"[]".equals((new BufferedReader(new FileReader(file5))).readLine())){
			list.add("TestReports/json/jsonReRunReportGroupMerchandise.json");
		}
	}
	
	private static void checkForNewShopFile(List<String> list, File file5)
			throws IOException, FileNotFoundException {
		if(file5.exists() && !"[]".equals((new BufferedReader(new FileReader(file5))).readLine())){
			list.add("TestReports/json/jsonReRunReportGroupNewShop.json");
		}
	}

	private static List<String> addFiles(List<String> fileList) {
		List<String> list = new ArrayList<>();
		for (int i=0; i<fileList.size(); i++) {
			if(new File(fileList.get(i)).exists()){
				list.add(fileList.get(i));
			}
		}
		return list;
	}

	public static void generateTestExecutionStatus() throws IOException {
		File testStatus = new File("TestReports/testStatus.txt");
		testStatus.delete();
		testStatus.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(testStatus));

		try {

			Document docFirstRun = Jsoup.parse(new File("TestReports/CucumberReports/FirstRun/feature-overview.html"),
					"UTF-8");
			double total = Integer.parseInt(docFirstRun.getElementById("stats-total-scenarios").text());
			double passed = Integer.parseInt(docFirstRun.getElementById("stats-total-scenarios-passed").text());
			if (passed != total && (new File("TestReports/CucumberReports/ReRun/feature-overview.html")).exists()) {
				Document docReRun = Jsoup.parse(new File("TestReports/CucumberReports/ReRun/feature-overview.html"),
						"UTF-8");
				passed = passed + Integer.parseInt(docReRun.getElementById("stats-total-scenarios-passed").text());
			}

			double passPercentage = Math.round(passed / total * 100);
			double expectedCutoff = Double.parseDouble(
					!StringUtils.isEmpty(System.getProperty("PassPercent")) ? System.getProperty("PassPercent") : "85");

			if (expectedCutoff <= passPercentage) {
				bw.write("PASS BUILD as PASS PERCENT IS " + passPercentage + "%");

			} else {
				bw.write("FAIL BUILD as PASS PERCENT IS " + passPercentage + "%");
			}

		} catch (ArithmeticException e) {

		} finally {
			if (bw != null)
				bw.close();
		}

	}
	
	private static void generateReportsFromCucumberJson(List<String> fileNames, String reportFolder) throws  IOException{

		File reportOutputDirectory = new File(reportFolder);
		
		boolean skippedFails = true;
		boolean pendingFails = true;
		boolean undefinedFails = true;
		boolean missingFails = true;
		
		Configuration configuration = new Configuration(reportOutputDirectory, "WebShop Automation");
		configuration.setStatusFlags(skippedFails, pendingFails, undefinedFails, missingFails);
		ReportBuilder reportBuilder = new ReportBuilder(fileNames, configuration);
		reportBuilder.generateReports();
	}
	
}
