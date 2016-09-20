package com.LottoNZ.AutoSLTest.IOSTest.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.Test;

public class IOSLottoHomePageTest extends IOSTestBase {

	/**
	 * This is a ios test demo using app from
	 * http://appium.s3.amazonaws.com/TestApp6.0.app.zip
	 * **/
	@Test
	public void IOSAppTestDemo(Method method) throws UnexpectedException,
			MalformedURLException {
		String appiumVersion = "1.5.1";
		String deviceName = "iPhone Simulator";
		String deviceType = null;
		String deviceOrientation = "portrait";
		String platformVersion = "9.2";
		String platformName = "iOS";
		String browserName = "";
		String app = "http://appium.s3.amazonaws.com/TestApp6.0.app.zip";
		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		System.out.println("driver creation over");
		// populate text fields with values
		MobileElement fieldOne = (MobileElement) driver
				.findElementByAccessibilityId("TextField1");
		fieldOne.sendKeys("12");

		MobileElement fieldTwo = (MobileElement) driver
				.findElementsByClassName("UIATextField").get(1);
		fieldTwo.sendKeys("8");

		// they should be the same size, and the first should be above the
		// second
		// assertTrue(fieldOne.getLocation().getY() <
		// fieldTwo.getLocation().getY());
		// assertEquals(fieldOne.getSize(), fieldTwo.getSize());

		// trigger computation by using the button
		driver.findElementByAccessibilityId("ComputeSumButton").click();

		// is sum equal?
		// String sum =
		// driver.findElementsByClassName("UIAStaticText").get(0).getText();
		// TestCase.assertEquals(Integer.parseInt(sum), 20);

	}

	@Test(dataProvider = "iosAppCapabilities")
	public void verifyIOSAppTest(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws MalformedURLException,
			InvalidElementStateException, UnexpectedException {
		/**/
		System.out
				.println(String
						.format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
								appiumVersion, deviceName, deviceType,
								deviceOrientation, platformVersion,
								platformName, browserName, app));

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		System.out.println("create over");

		// Start Testing

	}

	@Test(dataProvider = "iosBrowserCapabilities")
	public void verifyIOSLottoHomepageTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws MalformedURLException,
			InvalidElementStateException, UnexpectedException {

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		System.out.println("create over");

		// Start Testing
		driver.get("https://m.mylotto.co.nz/");

	}

}
