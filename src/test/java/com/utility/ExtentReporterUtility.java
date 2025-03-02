package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	private static ExtentReports extentReports; 
	private static  ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static void setupSparkReportrer(String reportName) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/report.html"); // How the HTML file will look as report created
		extentReports =  new ExtentReports(); // HeavyLifting Data that needs to be dumped on the HTML report is carried here
		extentReports.attachReporter(extentSparkReporter) ; // To store information about the test
	}

	public static void createExtentTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
	}
	
	public static ExtentTest getTest() {
		return extentTest.get();
	}
	
	public static void flushReport() {
		extentReports.flush();
	}
	
	
}
