package com.goibibo.properties1;


import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import com.goibibo.keyword.Keyword;


public class Properties  extends Keyword {
	@Test
	public static void launchUrl() {
		openBrowser("chrome");
		launchUrl("https://www.flipkart.com");
		implicitWait(3);
		maximize();
		closeBrowser();

		// TODO Auto-generated method stub

	}

		
	}
	
	


