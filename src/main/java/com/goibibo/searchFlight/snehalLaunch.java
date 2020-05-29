package com.goibibo.searchFlight;

import org.testng.annotations.Test;

import com.goibibo.keyword.Keyword;

public class snehalLaunch extends Keyword {
@Test
public static void launchUrl() {
	openBrowser("chrome");
	launchUrl("https://www.goibibo.com");
	implicitWait(3);
	maximize();
	closeBrowser();

	// TODO Auto-generated method stub

}


}
