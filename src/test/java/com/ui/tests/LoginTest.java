package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListeners.class })
public class LoginTest extends TestBase{
	

	@Test(description = "Verifies with the valid user is able to do the login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProviders")
	public void loginTest(User user) {

		/*
		 * Test method!! 1. you cannot write conditional statement, loops and try catch
		 * in test method 2. Test script --> test steps 3. Reduce local variables 4.
		 * Atleast one assertion!!
		 * 
		 */
		Assert.assertEquals(
				homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Shubham Kumar");

	}

	@Test(description = "Verifies with the valid user is able to do the login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {

		/*
		 * Test method!! 1. you cannot write conditional statement, loops and try catch
		 * in test method 2. Test script --> test steps 3. Reduce local variables 4.
		 * Atleast one assertion!!
		 * 
		 */
		Assert.assertEquals(
				homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Shubham Kumar");

	}

	@Test(description = "Verifies with the valid user is able to do the login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {

		/*
		 * Test method!! 1. you cannot write conditional statement, loops and try catch
		 * in test method 2. Test script --> test steps 3. Reduce local variables 4.
		 * Atleast one assertion!!
		 * 
		 */
		Assert.assertEquals(
				homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Shubham Kumar");

	}

}
