package com.LottoNZ.AutoSLAndroidTest.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLWebTest.Pages.LottoHomePage;

public class AndroidLottoHomePageTest extends AndroidTestBase {

	@Test(dataProvider = "AndroidCapabilities")
	public void verifyLottoTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws MalformedURLException,
			InvalidElementStateException, UnexpectedException {

		/*
		System.out.println(String.format(
				"appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s", appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,browserName, app));
		
		*/
		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName, deviceType
				,deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		System.out.println("create over");
		driver.get("https://mylotto.co.nz/");
		// Go to Lotto Homepage
		LottoHomePage HomePage = new LottoHomePage(driver);

	}
}
