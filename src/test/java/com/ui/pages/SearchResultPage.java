package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility{

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class=\"lighter\"]");
	private static final By PRODUCT_LIST = By.xpath("//h5[@itemprop=\"name\"]");
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean isSearchTermPresentinProductList(String searchTerm) {
		List<String> keywordList = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNameList = getAllVisibleText(PRODUCT_LIST);
		boolean result = productNameList.stream()
		.anyMatch(name -> (keywordList.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
	}

}
