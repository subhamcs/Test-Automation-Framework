package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility{

	
	private static final By EMAIL_TEXTBOX_LOCATOR =  By.xpath("//input[@id='email']");
	private static final By PASSWORD_TEXTBOX_LOCATOR =  By.xpath("//input[@id='passwd']");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]/i[1]");
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAIL_TEXTBOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage =  new MyAccountPage(getDriver());
		return myAccountPage;
	}

	
	

}
