package com.ui.pages;

import static com.constants.Env.QA;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

public final class HomePage extends BrowserUtility {
	
	private static final By SIGNIN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	 public HomePage(Browser browserName, boolean isHeadless){
		 super(browserName, isHeadless);
		 goToWebsite(JSONUtility.readJSON(QA).getUrl());
		
	}
	 
	 public LoginPage goToLoginPage() {
		 clickOn(SIGNIN_LINK_LOCATOR);
		 LoginPage loginPage = new LoginPage(getDriver());
		 return loginPage;
	 }


}
