/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoEcommPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoPYOPage;

public class androidLottoPYOTest extends _AndroidTestBase {

	public static int[] lottoNumberArr;
	public static int powerball;
	public static int[] strikeNumberArr;

	@Test(dataProvider = "AndroidAppCapabilities")
	public void LottoPYOAutoFillTest(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws Exception {

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
		androidLottoPYOPage.bypassIntroScreens(driver);
		androidLottoPYOPage.loaded(driver);

		androidLottoPYOPage.clickLottoAutoFill(driver, 1);
		androidLottoPYOPage.clickLottoAutoFill(driver, 2);
		androidLottoPYOPage.clickLottoAutoFill(driver, 3);
		androidLottoPYOPage.clickLottoAutoFill(driver, 4);

		androidLottoPYOPage.swipeuptoShowStrikeEditor(driver);
		androidLottoPYOPage.clickStrikeAutoFill(driver, 1);
		androidLottoPYOPage.clickStrikeAutoFill(driver, 2);
		androidLottoPYOPage.clickStrikeAutoFill(driver, 3);
		androidLottoPYOPage.clickStrikeAutoFill(driver, 4);
		// Click BUY Button
		androidLottoEcommPage.clickBuyButton(driver);
	}

	@Test(dataProvider = "AndroidAppCapabilities")
	public void LottoPYOManualFillTest(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws Exception {

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
		androidLottoPYOPage.bypassIntroScreens(driver);
		androidLottoPYOPage.loaded(driver);

		lottoNumberArr = new int[] { 1, 6, 11, 16, 21, 26 };
		powerball = 2;
		androidLottoPYOPage.addLottoLine(driver, lottoNumberArr, powerball, 1);
		lottoNumberArr = new int[] { 1, 2, 3, 4, 5, 6 };
		powerball = 3;
		androidLottoPYOPage.addLottoLine(driver, lottoNumberArr, powerball, 2);
		lottoNumberArr = new int[] { 11, 22, 33, 14, 15, 16 };
		powerball = 4;
		androidLottoPYOPage.addLottoLine(driver, lottoNumberArr, powerball, 3);
		lottoNumberArr = new int[] { 21, 22, 23, 24, 25, 26 };
		powerball = 10;
		androidLottoPYOPage.addLottoLine(driver, lottoNumberArr, powerball, 4);
		
		androidLottoPYOPage.swipeuptoShowStrikeEditor(driver);
		strikeNumberArr= new int[] { 1, 6, 11, 16 };
		androidLottoPYOPage.addStrikeLine(driver, strikeNumberArr);
		strikeNumberArr= new int[] { 1, 2, 3, 4 };
		androidLottoPYOPage.addStrikeLine(driver, strikeNumberArr);
		strikeNumberArr= new int[] { 37, 38, 39, 40 };
		androidLottoPYOPage.addStrikeLine(driver, strikeNumberArr);
		
		androidLottoPYOPage.swipetoTopPage(driver);
		androidLottoEcommPage.clickBuyButton(driver);

	}
}
