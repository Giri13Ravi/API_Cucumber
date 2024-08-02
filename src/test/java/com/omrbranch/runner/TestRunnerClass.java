package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions (dryRun = false, tags= "@Login or @State or @City or @Address  or @ProductSearch or @ChangeProPic",glue = "com.omrbranch.stepdefination",features = "src\\test\\resources\\feature", plugin= {"pretty","json:target\\output.json"})
public class TestRunnerClass {
// @Login or @State or @City or @Address  or @ProductSearch
	@AfterClass
	public static void afterExecution() {
		Reporting.generateJVMReport(System.getProperty("user.dir")+("\\target\\output.json"));

	}
	
}
