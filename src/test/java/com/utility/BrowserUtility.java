package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // instance variable
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		if (driver == null) {
			throw new IllegalStateException("WebDriver is null. Ensure it is initialized before calling getDriver().");
		}
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		(this.driver).set(driver);
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		}

		else {
			System.err.println("Invalid Browser name! Please select chrome or edge browser");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new"); // ✅ Use modern headless mode
				options.addArguments("--disable-gpu"); // ✅ Required for macOS
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new"); // Use modern headless mode
				options.addArguments("--disable-gpu"); // Required for macOS
				options.addArguments("--window-size=1920,1080");
				driver.set(new EdgeDriver(options));
			} else {

				driver.set(new EdgeDriver());
			}
		}

		else {
			System.err.println("Invalid Browser name! Please select chrome or edge browser");
		}
	}

	public void goToWebsite(String url) {
		driver.get().get(url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		WebElement element = driver.get().findElement(locator);
		element.click();
	}

	public void enterText(By locator, String texttoEnter) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(texttoEnter);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		String path = System.getProperty("user.dir") + "/screenshot/" + name + "-" + timestamp + ".png";
		File screenshotFile = new File(path);

		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}
}
