/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLoginPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoDipPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoEcommPage;
import com.LottoNZ.AutoSLTest.Driver.LottoBipType;
import com.LottoNZ.AutoSLTest.Utils.Verification.Verify;

public class androidLottoDIPTest extends _AndroidTestBase {

	String actualLottoLinesNum;
	String actualPowerballLinesNum;
	String actualStrikeLinesNum;
	String actualTotalCost;
	String password = "password1";
	String usernameText = "automation@autotest.com";

	@Test(dataProvider = "AndroidAppCapabilities")
	public void LottoDIPBasicTripleTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws InvalidElementStateException,
			InterruptedException, Exception {

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());

		androidLottoDipPage.bypassIntroScreens(driver);
		Thread.sleep(1000);
		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.BasicTriple);
		androidLottoEcommPage.OpenLottoSummaryBar(driver);
		actualLottoLinesNum = androidLottoEcommPage.getLottoLines(driver);
		actualPowerballLinesNum = androidLottoEcommPage
				.getPowerballLines(driver);
		actualStrikeLinesNum = androidLottoEcommPage.getStrikeLines(driver);
		actualTotalCost = androidLottoEcommPage.getTotalCostValue(driver);
		Verify.verifyEquals("10 LINES", actualLottoLinesNum,
				"actual Lotto Lines Num is not as expected");
		Verify.verifyEquals("10 LINES", actualPowerballLinesNum,
				"actual Powerball Lines Num is not as expected");
		Verify.verifyEquals("2 LINES", actualStrikeLinesNum,
				"actual Strike Lines Num is not as expected");
		Verify.verifyEquals("$14.00", actualTotalCost,
				"actual Total Cost Value is not as expected");
		androidLottoEcommPage.CloseLottoSummaryBar(driver);

	}

	@Test(dataProvider = "AndroidAppCapabilities")
	public void LottoDIPStarterLuckyTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws InvalidElementStateException,
			InterruptedException, Exception {

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());

		androidLottoDipPage.bypassIntroScreens(driver);
		Thread.sleep(1000);
		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.StarterLucky);

		LottoDIPSummaryVerify(driver, LottoBipType.StarterLucky, "8 LINES",
				"0 LINES", "0 LINES", "$4.80");
	}

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
		androidLottoDipPage.bypassIntroScreens(driver);
		Thread.sleep(1000);

		// Go to Lotto DIP page
		androidLottoDipPage.loaded(driver);
		// Select StarterPower DIP
		androidLottoDipPage.selectDip(driver, LottoBipType.StarterPower);
		LottoDIPSummaryVerify(driver, LottoBipType.StarterPower, "8 LINES",
				"8 LINES", "0 LINES", "$9.60");
	}

	@Test(dataProvider = "AndroidAppCapabilities")
	public void LottoDIPSummaryInfoTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws InvalidElementStateException,
			InterruptedException, Exception {

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());

		androidLoginPage.bypassIntroScreens(driver);
		Thread.sleep(1000);

		/*
		 * // Login again androidLoginPage.loaded(driver);
		 * androidLoginPage.enterLoginemail(driver, usernameText);
		 * androidLoginPage.enterLoginPassword(driver, password);
		 * androidLoginPage.clickLoginBtn(driver); Thread.sleep(1000);
		 * 
		 * 
		 * // Go to menu androidNavBarPage.navigateToMenu(driver);
		 * androidNavBarPage.clickMenuGamePowerball(driver);
		 * 
		 * // Go to Lotto Buy a DIP androidLottoPage.clickBuyaDIP(driver);
		 */
		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.BasicTriple);
		LottoDIPSummaryVerify(driver, LottoBipType.BasicTriple, "10 LINES",
				"10 LINES", "2 LINES", "$14.00");

		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.StarterPower);
		LottoDIPSummaryVerify(driver, LottoBipType.StarterPower, "8 LINES",
				"8 LINES", "0 LINES", "$9.60");

		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.StarterLucky);
		LottoDIPSummaryVerify(driver, LottoBipType.StarterLucky, "8 LINES",
				"0 LINES", "0 LINES", "$4.80");

		//
		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.SuperTriple);
		LottoDIPSummaryVerify(driver, LottoBipType.SuperTriple, "10 LINES",
				"10 LINES", "4 LINES", "$16.00");

		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.BasicPower);
		LottoDIPSummaryVerify(driver, LottoBipType.BasicPower, "10 LINES",
				"10 LINES", "0 LINES", "$12.00");

		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.BasicLucky);
		LottoDIPSummaryVerify(driver, LottoBipType.BasicLucky, "10 LINES",
				"0 LINES", "0 LINES", "$6.00");

		//
		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.SuperPlusTriple);
		LottoDIPSummaryVerify(driver, LottoBipType.SuperPlusTriple, "15 LINES",
				"15 LINES", "2 LINES", "$20.00");

		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.SuperPower);
		LottoDIPSummaryVerify(driver, LottoBipType.MegaPower, "15 LINES",
				"15 LINES", "0 LINES", "$18.00");

		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.SuperLucky);
		LottoDIPSummaryVerify(driver, LottoBipType.MegaLucky, "15 LINES",
				"0 LINES", "0 LINES", "$9.00");

		//

		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.MegaTriple);
		LottoDIPSummaryVerify(driver, LottoBipType.MegaTriple, "20 LINES",
				"20 LINES", "2 LINES", "$26.00");

		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.MegaPower);
		LottoDIPSummaryVerify(driver, LottoBipType.MegaPower, "20 LINES",
				"20 LINES", "0 LINES", "$24.00");

		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectDip(driver, LottoBipType.MegaLucky);
		LottoDIPSummaryVerify(driver, LottoBipType.MegaLucky, "20 LINES",
				"0 LINES", "0 LINES", "$12.00");
	}

	public void LottoDIPSummaryVerify(AppiumDriver driver,
			LottoBipType LottoBipType, String expectLottoLinesNum,
			String expectPowerballLinesNum, String expectStrikeLinesNum,
			String expectTotalCost) throws InvalidElementStateException,
			InterruptedException, Exception {

		// androidLottoDipPage.loaded(driver);
		// androidLottoDipPage.selectDip(driver, LottoBipType);

		androidLottoEcommPage.OpenLottoSummaryBar(driver);
		String actualLottoLinesNum = androidLottoEcommPage
				.getLottoLines(driver);
		String actualPowerballLinesNum = androidLottoEcommPage
				.getPowerballLines(driver);
		String actualStrikeLinesNum = androidLottoEcommPage
				.getStrikeLines(driver);
		String actualTotalCost = androidLottoEcommPage
				.getTotalCostValue(driver);
		Verify.verifyEquals(expectLottoLinesNum, actualLottoLinesNum,
				"actual Lotto Lines Num is not as expected");
		Verify.verifyEquals(expectPowerballLinesNum, actualPowerballLinesNum,
				"actual Powerball Lines Num is not as expected");
		Verify.verifyEquals(expectStrikeLinesNum, actualStrikeLinesNum,
				"actual Strike Lines Num is not as expected");
		Verify.verifyEquals(expectTotalCost, actualTotalCost,
				"actual Total Cost Value is not as expected");
		androidLottoEcommPage.CloseLottoSummaryBar(driver);
	}
}
