package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListeners implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReporter; // How the HTML file will look as report created
	ExtentReports extentReports; // HeavyLifting Data that needs to be dumped on the HTML report is carried here
	ExtentTest extentTest; // To store information about the test

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "Passed");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "Passed");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "Failed");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "Failed");
		ExtentReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		
		Object testclass = result.getInstance();
		
		logger.info("Capturing Screenshot for the failed test");
		
		BrowserUtility browserUtility = ((TestBase)testclass).getInstance();
		String screenshotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
		
		logger.info("Attaching the Screenshot in HTML file");
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
		
		
		

	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "Skipped");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "Skipped");

	}

	public void onStart(ITestContext context) {
		logger.info("Test suite Started");
		ExtentReporterUtility.setupSparkReportrer("report.html");

	}

	public void onFinish(ITestContext context) {
		logger.info("Test suite Completed");
		ExtentReporterUtility.flushReport();
	}

}
