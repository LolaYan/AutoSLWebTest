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
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoPickDrawPage;
import com.LottoNZ.AutoSLTest.Driver.LottoBipType;
import com.LottoNZ.AutoSLTest.Utils.Verification.Verify;

public class androidLottoDIPPurchaseTest extends _AndroidTestBase {

	String actualLottoLinesNum;
	String actualPowerballLinesNum;
	String actualStrikeLinesNum;
	String actualTotalCost;
	String password = "password1";
	String usernameText = "automation@autotest.com";

	@Test(dataProvider = "AndroidAppCapabilities")
	public void LottoDIP_StarterLucky_Test(String appiumVersion,
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
	public void LottoDIP_StarterPower_Test(String appiumVersion,
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
		// Click BUY Button
		androidLottoEcommPage.clickBuyButton(driver);

		/* Login Page Action */
		androidLoginPage.enterLoginemail(driver, usernameText);
		androidLoginPage.enterLoginPassword(driver, password);
		androidLoginPage.clickLoginBtn(driver);
		Thread.sleep(1000);

		// Click BUY Button
		androidLottoEcommPage.clickBuyButton(driver);
		
		androidLottoPickDrawPage.clickNextDraw(driver);
		androidLottoPickDrawPage.clickBuyTicketButton(driver);
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
