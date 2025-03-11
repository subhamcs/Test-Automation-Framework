package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;

	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest","isHeadless" })
	@BeforeMethod(description = "Load the homepage")
	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("true") boolean isHeadless, ITestResult result) {
		WebDriver lambdaDriver;
		this.isLambdaTest = isLambdaTest;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("Chrome", result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {
			// running the test in Local machine!
			Logger logger = LoggerUtility.getLogger(this.getClass());
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless); // Object of the homepage
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		} else {
			homePage.quit();
		}
	}
}
