
package com.goibibo.customUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CustomUtil {
	
	static Properties prop=new Properties();
	
	public static String getLocator(String locatorName) {
		String locator="";
		
		try {
			FileInputStream fis = new FileInputStream("F:\\classjava\\Goibibo\\src\\main\\resources\\goibiboObjectRepository.properties");
			prop.load(fis);
			locator=prop.getProperty(locatorName);
		} catch (FileNotFoundException e) {
			System.out.println("Object repository not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return locator;
	}
	public static String[] getLocatorValue(String locatorName) {
		return getLocator(locatorName).split("##");

	}
}
