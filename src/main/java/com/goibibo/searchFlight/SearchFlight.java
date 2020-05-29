package com.goibibo.searchFlight;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.goibibo.keyword.Keyword;

public class SearchFlight extends Keyword {
	@Test
	public static void searchFlight() throws InterruptedException {

		openBrowser("chrome");
		launchUrl("https://www.goibibo.com");
		implicitWait(3);
		maximize();
		enterText("from", "Mumbai");

		mouseHoverClick("citysource");
		enterText("to", "Dubai");
		mouseHoverClick("citydest");
		click("date");
		click("currentDate");
		click("search");
		driver.navigate().refresh();
		explicitWait(10);

		String actual = getText("message");
		Assert.assertEquals(actual, "Sorry, no flights available till 31st May due to COVID-19 lockdown.",
				"Messsage not match");
		closeBrowser();
	}

}
