package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.Test;

public class androidLottoHomePageTest extends _AndroidTestBase {

	@Test(dataProvider = "AndroidAppCapabilities")
	public void verifyAndroidAppTest(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws MalformedURLException,
			InvalidElementStateException, UnexpectedException {
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

	}
}
