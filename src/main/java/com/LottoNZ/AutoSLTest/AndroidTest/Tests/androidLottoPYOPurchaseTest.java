/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoPYOPage;

public class androidLottoPYOPurchaseTest extends _AndroidTestBase {

	String actualLottoLinesNum;
	String actualPowerballLinesNum;
	String actualStrikeLinesNum;
	String actualTotalCost;
	String password = "password1";
	String usernameText = "automation@autotest.com";

	@Test(dataProvider = "AndroidAppCapabilities")
	public void LottoDIPStarterPowerTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws InvalidElementStateException,
			InterruptedException, Exception {

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());

		// Pass Introduction Page
		androidLottoPYOPage.bypassIntroScreens(driver);
		Thread.sleep(1000);

		// Go to Lotto DIP page
		androidLottoPYOPage.loaded(driver);
		
		/*
		// Select StarterPower DIP
		androidLottoDipPage.selectDip(driver, LottoBipType.StarterPower);
		// Click BUY Button
		androidLottoEcommPage.clickBuyButton(driver);

		
		androidLoginPage.enterLoginemail(driver, usernameText);
		androidLoginPage.enterLoginPassword(driver, password);
		androidLoginPage.clickLoginBtn(driver);
		Thread.sleep(1000);

		// Click BUY Button
		androidLottoEcommPage.clickBuyButton(driver);
		
		androidLottoPickDrawPage.clickNextDraw(driver);
		androidLottoPickDrawPage.clickBuyTicketButton(driver);
		*/
	}

}
