package com.ui.pages;

import static com.constants.Env.QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

public final class HomePage extends BrowserUtility {

	private static final By SIGNIN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());

	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());

	}

	public LoginPage goToLoginPage() {
		clickOn(SIGNIN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public static void quit() {
		if (driverLocal.get() != null) {
			driverLocal.get().quit();
		}
	}
}
