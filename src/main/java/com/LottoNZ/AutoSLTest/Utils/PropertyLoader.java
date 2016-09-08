/**
 * 
 */
package com.LottoNZ.AutoSLTest.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

/**
 * 
 * Note: Load the application.prperties from config folder LoadProperty by name
 * in order to get the value of it
 */
public class PropertyLoader {

	private static final String ANDROID_PROP_FILE = "./config/androidConfig.properties";
	private static FileInputStream fs;
	private static final String PROP_FILE = "./config/projectConfig.properties";
	private static Properties props = new Properties();
	private static final String WEB_PROP_FILE = "./config/webConfig.properties";

	public static By getWebOjectLocator(String locatorName) throws IOException {

		FileInputStream stream = new FileInputStream(WEB_PROP_FILE);
		Properties propertyFile = new Properties();
		propertyFile.load(stream);
		String locatorProperty = propertyFile.getProperty(locatorName);
		System.out.println(locatorProperty.toString());
		String locatorType = locatorProperty.split(":")[0];
		String locatorValue = locatorProperty.split(":")[1];
		System.out.println(" locatorType......" + locatorType);
		By locator = null;
		switch (locatorType) {
		case "Id":
			locator = By.id(locatorValue);
			System.out.println("locator Id :" + locator.toString());
			break;
		case "Name":
			locator = By.name(locatorValue);
			break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;
		case "Xpath":
			locator = By.xpath(locatorValue);
			break;
		}
		return locator;
	}
	public static String loadAndroidProperty(String name) {
		String value = "";
		setFilePath(ANDROID_PROP_FILE);
		loadFS();
		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}
	public static void loadFS() {
		try {
			props.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String loadProjectProperty(String name) {
		String value = "";
		setFilePath(PROP_FILE);
		loadFS();
		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}
	
	public static String loadProperty(String fileName, String keyName) {
		String keyValue = "";
		setFilePath(fileName);
		loadFS();
		if (keyName != null) {
			keyValue = props.getProperty(keyName);
		}
		return keyValue;
	}

	public static String loadWebProperty(String name) {
		String value = "";
		setFilePath(WEB_PROP_FILE);
		loadFS();
		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}

	public static void setFilePath(String fileName) {
		try {
			fs = new FileInputStream(fileName);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private PropertyLoader() {

	}
}
