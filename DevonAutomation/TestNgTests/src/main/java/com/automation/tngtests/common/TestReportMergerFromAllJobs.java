package com.automation.tngtests.common;
/*package com.automation.cockpit.cucumber.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@Component
public class TestReportMergerFromAllJobs {

	private static final Logger LOGGER = Logger.getLogger(Utilities.class);

	public void reportMerger() throws WebshopDataFailureException {
		try {
			List<String> reports = addFiles(Arrays.asList("JobReport1/Cucumber/TestReports/json/jsonreportGroup1.json",
					"JobReport2/Cucumber/TestReports/json/jsonreportGroup2.json",
					"JobReport3/Cucumber/TestReports/json/jsonreportGroup3.json",
					"JobReport4/Cucumber/TestReports/json/jsonreportGroup4.json",
					"JobReport5/Cucumber/TestReports/json/jsonreportGroupMerchandise.json"));
			List<String> reRunReports = addFiles(checkReRun());
			if (!reports.isEmpty()) {
				generateReportsFromCucumberJson(reports, "TestReports/CucumberReports1/FirstRun");
			}
			if (!reRunReports.isEmpty()) {
				generateReportsFromCucumberJson(reRunReports, "TestReports/CucumberReports1/ReRun");
			}
			generateTestExecutionStatus();
			TestSvnLog.generateLastDateSVNLog();

		} catch (IOException exception) {
			throw new WebshopDataFailureException("Failed to Generate Cucumber Reports", exception);
		} finally{
			clearDir();
		}
		
	}

	public static void clearDir() {
		FileUtils.deleteQuietly(new File("JobReport1"));
		FileUtils.deleteQuietly(new File("JobReport2"));
		FileUtils.deleteQuietly(new File("JobReport3"));
		FileUtils.deleteQuietly(new File("JobReport4"));
		FileUtils.deleteQuietly(new File("JobReport5"));
	}

	private static List<String> checkReRun() throws IOException {
		List<String> list = new ArrayList<>();
		File file1 = new File("JobReport1/Cucumber/TestReports/json/jsonReRunreportGroup1.json");
		File file2 = new File("JobReport2/Cucumber/TestReports/json/jsonReRunreportGroup2.json");
		File file3 = new File("JobReport3/Cucumber/TestReports/json/jsonReRunreportGroup3.json");
		File file4 = new File("JobReport4/Cucumber/TestReports/json/jsonReRunreportGroup4.json");
		File file5 = new File("JobReport5/Cucumber/TestReports/json/jsonReRunReportGroupMerchandise.json");
		if (file1.exists() && !"[]".equals((new BufferedReader(new FileReader(file1))).readLine())) {
			list.add("JobReport1/Cucumber/TestReports/json/jsonReRunreportGroup1.json");
		}
		if (file2.exists() && !"[]".equals((new BufferedReader(new FileReader(file2))).readLine())) {
			list.add("JobReport2/Cucumber/TestReports/json/jsonReRunreportGroup2.json");
		}
		if (file3.exists() && !"[]".equals((new BufferedReader(new FileReader(file3))).readLine())) {
			list.add("JobReport3/Cucumber/TestReports/json/jsonReRunreportGroup3.json");
		}
		if (file4.exists() && !"[]".equals((new BufferedReader(new FileReader(file4))).readLine())) {
			list.add("JobReport4/Cucumber/TestReports/json/jsonReRunreportGroup4.json");
		}
		if (file5.exists() && !"[]".equals((new BufferedReader(new FileReader(file5))).readLine())) {
			list.add("JobReport5/Cucumber/TestReports/json/jsonReRunReportGroupMerchandise.json");
		}
		return list;

	}

	private static List<String> addFiles(List<String> fileList) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < fileList.size(); i++) {
			if (new File(fileList.get(i)).exists()) {
				list.add(fileList.get(i));
			}
		}
		return list;
	}
	
	private static void generateTestExecutionStatus() throws IOException {
		File testStatus = new File("TestReports/testStatusInPercentage.txt");
		testStatus.delete();
		testStatus.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(testStatus));

		try {

			Document docFirstRun = Jsoup.parse(new File("TestReports/CucumberReports1/FirstRun/feature-overview.html"),
					"UTF-8");
			double total = Integer.parseInt(docFirstRun.getElementById("stats-total-scenarios").text());
			double passed = Integer.parseInt(docFirstRun.getElementById("stats-total-scenarios-passed").text());
			if (passed != total && (new File("TestReports/CucumberReports1/ReRun/feature-overview.html")).exists()) {
				Document docReRun = Jsoup.parse(new File("TestReports/CucumberReports1/ReRun/feature-overview.html"),
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
			PopulateDataInGoogleSheet.updatePassingPercentageInSheet(passPercentage);
		} catch (ArithmeticException e) {
			LOGGER.error(e);

		} finally {
			if (bw != null)
				bw.close();
		}

	}

	private static void generateReportsFromCucumberJson(List<String> fileNames, String reportFolder)
			throws IOException {

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
*/