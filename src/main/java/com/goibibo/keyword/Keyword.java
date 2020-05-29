package com.goibibo.keyword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.goibibo.constant.Constant;
import com.goibibo.customUtil.CustomUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword extends Constant {

	public static void openBrowser(String browserName) {

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "HTML unit":
			driver = new HtmlUnitDriver();
			break;

		default:
			System.out.println("Unable to open browser");
		}
	}

	/**
	 * Launch URL required for the project
	 */
	public static void launchUrl(String url) {
		driver.get(url);
		System.out.println("Open URL successfully");
	}

	/**
	 * Maximize window
	 */
	public static void maximize() {
		driver.manage().window().maximize();

	}

	/**
	 * delete cookies
	 */
	public static void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	/**
	 * getWebElementMethod
	 * 
	 * @param locatorName
	 * @return
	 */
	public static WebElement getWebElement(String locatorName) {
		String locatorType = CustomUtil.getLocatorValue(locatorName)[0];
		String locatorValue = CustomUtil.getLocatorValue(locatorName)[1];

		switch (locatorType) {
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "css":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "id":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			element = driver.findElement(By.className(locatorValue));
			break;
		case "LinkText":
			element = driver.findElement(By.linkText(locatorValue));
			break;
		case "partialLinkText":
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "class":
			element=driver.findElement(By.className(locatorValue));
			break;
		default:
			System.out.println("Invalid locator found");
			break;
		}

		return element;

	}

	/**
	 * Enter Text
	 */
	public static void enterText(String locatorName, String text) {
		getWebElement(locatorName).sendKeys(text);

	}

	/**
	 * mouseMove&Click
	 * 
	 * @param locatorName
	 */

	public static void mouseHoverClick(String locatorName) {
		action = new Actions(driver);
		action.moveToElement(getWebElement(locatorName)).click().build().perform();
	}

	/**
	 * implicit wait
	 * 
	 * @param duration
	 */
	public static void implicitWait(int duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}

	/**
	 * used to click
	 * 
	 * @param locatorName
	 */
	public static void click(String locatorName) {
		getWebElement(locatorName).click();
	}

	/**
	 * explicit wait applied
	 * 
	 * @param duration
	 */
	public static void explicitWait(int duration) {
		wait = new FluentWait(driver);
		wait.withTimeout(duration, TimeUnit.SECONDS);
	}

	/**
	 * get text
	 * 
	 * @param locatorName
	 * @return
	 */
	public static String getText(String locatorName) {
		return getWebElement(locatorName).getText();
	}

	/**
	 * close method will close browser
	 */
	public static void closeBrowser() {
		driver.close();
	}
}
