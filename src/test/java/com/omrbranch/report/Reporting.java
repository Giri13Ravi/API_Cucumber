package com.omrbranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import co.omrbranch.baseclass.Base_Class_API;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends Base_Class_API{

	public static void generateJVMReport(String jsonFile) {
		File report = new File(System.getProperty("user.dir")+"\\target");
		Configuration config = new Configuration(report,"OMR Branch Web Automation");
		
		config.addClassifications("Platform Name", "Windows");
		config.addClassifications("Platform Version", "11");
		config.addClassifications("Author", "Giri");
		config.addClassifications("Environment", "QA");
		config.addClassifications("Sprint Number", "34");
		List<String>jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		// Create Object for Report Builder Class
		ReportBuilder build = new ReportBuilder(jsonFiles, config);
		build.generateReports();

	}
}
