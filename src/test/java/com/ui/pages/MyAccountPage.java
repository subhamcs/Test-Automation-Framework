package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]/span");
	private static final By PRODUCT_SEARCH_TEXTBOX = By
			.xpath("//input[contains(@class,\"search_query form-control ac_input\")]");
	private static final By SEARCH_BUTTON = By.xpath("//button[contains(@class,\"btn btn-default button-search\")]");

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

	public SearchResultPage SearchForProduct(String productName) {
		enterText(PRODUCT_SEARCH_TEXTBOX, productName);
		enterSepacialKey(PRODUCT_SEARCH_TEXTBOX, Keys.ENTER);
		// clickOn(SEARCH_BUTTON);
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		return searchResultPage;

	}

}
