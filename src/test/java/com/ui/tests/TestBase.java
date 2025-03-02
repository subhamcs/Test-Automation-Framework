package com.ui.tests;

//import static com.constants.Browser.EDGE;
import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	@BeforeMethod(description = "Load the homepage")
	public void setup() {
		homePage = new HomePage(CHROME, true);  //Object of the homepage
	}
	
	public BrowserUtility getInstance(){
		return homePage;
	}
}
