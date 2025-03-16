package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({com.ui.listeners.TestListeners.class})


public class SearchProductTest extends TestBase {
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";
	
	
	@BeforeMethod(description = "Valid user logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("jememi4024@intady.com","password");
		
	}
	
	@Test(description = "Verify the logged in user is able to search the product and correct products are displayed",
			groups = {"e2e","smoke","snaity"})
	public void  verifyProductSearchTest() {
		boolean actualResult =  myAccountPage.SearchForProduct(SEARCH_TERM).isSearchTermPresentinProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}

}
