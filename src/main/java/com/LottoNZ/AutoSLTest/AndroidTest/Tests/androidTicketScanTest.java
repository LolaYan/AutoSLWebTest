/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidAccountFavPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLoginPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoEcommPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidNavBarPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidTicketScanPage;
import com.LottoNZ.AutoSLTest.Utils.DataGenerator;
import com.LottoNZ.AutoSLTest.Utils.Verification.Verify;

public class androidTicketScanTest extends _AndroidTestBase {

	String favName = "FavName";
	String password = "password1";
	String usernameText = "automation@autotest.com";
	String serialNumber = "0660051678722018";
	String validSerialNumber = "0660089034281259";
	String InvalidSerialNumber = "0660089034281259";
	String NonWinSerialNumber = "0660051678722018";
	String CashPrizeSerialNumber = "0660051678722018";
	String MajorPrizeSerialNumber = "0660051678722018";
	String BonusSerialNumber = "0660051678722018";

	@Test(dataProvider = "AndroidAppCapabilities")
	public void CheckValidOnlineTicketTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws InvalidElementStateException,
			InterruptedException, Exception {

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());

		androidTicketScanPage.bypassIntroScreens(driver);
		androidTicketScanPage.loaded(driver);

		androidTicketScanPage.clickfirstTimerStartButton(driver);
		androidTicketScanPage.clickTroubleScanning(driver);

		androidTicketScanPage.clickStillStuck(driver);
		androidTicketScanPage.clickCheckPaperTicket(driver);
		androidTicketScanPage.clickCheckPaperTicketManually(driver);
		androidTicketScanPage.inputOnlineTicketSerialNumber(driver,
				serialNumber);
		androidTicketScanPage.clickCheckTicketButton(driver);
	}

	@Test(dataProvider = "AndroidAppCapabilities")
	public void CheckInvalidOnlineTicketTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws InvalidElementStateException,
			InterruptedException, Exception {

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());

		androidTicketScanPage.CheckOnlineTicketManuallyWorkflow(driver,
				InvalidSerialNumber);
		boolean NotWinningText = androidTicketScanPage.isElementExists(driver,
				By.name("Not a winning ticket."));
		boolean BetterNextTimeText = androidTicketScanPage.isElementExists(
				driver, By.name("Better luck next time!"));
		Verify.verifyTrue(NotWinningText);
		Verify.verifyTrue(BetterNextTimeText);
	}

}
