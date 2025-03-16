package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListeners.class })
public class InvalidCredLoginTest extends TestBase {

	private static final String INVALID_EMAIL_ADDRESS = "shubhamofficial2014@gmail.com";
	private static final String INAVLID_PASSWORD = "dbffvkvnu";
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Verifies if the proper error message is shown for invalid cred", groups = { "e2e", "sanity" })
	public void loginTest() {

		/*
		 * Test method!! 1. you cannot write conditional statement, loops and try catch
		 * in test method 2. Test script --> test steps 3. Reduce local variables 4.
		 * Atleast one assertion!!
		 * 
		 */
		Assert.assertEquals(homePage.goToLoginPage()
				.doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INAVLID_PASSWORD).getErrorMessage(),
				"Authentication failed.");

	}

}
