/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidAccountFavPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidAccountTopupbyCardPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLoginPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoEcommPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidNavBarPage;
import com.LottoNZ.AutoSLTest.Utils.DataGenerator;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.Utils.verify;
import com.LottoNZ.AutoSLTest.Utils.Verification.Verify;

public class androidAccountTopwithCreditCardTest extends _AndroidTestBase {

	String password = "password1";
	String usernameText = "automation@autotest.com";

	String topupAmount = "10";
	String topupCardNumber = "4111111111111111";
	String topupCardname = "test";
	String topupCardEMonth = "11";
	String topupCardEYear = "22";
	String topupPassword = password;

	@Test(dataProvider = "AndroidAppCapabilities")
	public void TopupwithValidCreditCardTest(String appiumVersion,
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

		// Login
		androidLoginPage.loaded(driver);
		androidLoginPage.enterLoginemail(driver, usernameText);
		androidLoginPage.enterLoginPassword(driver, password);
		androidLoginPage.clickLoginBtn(driver);
		Thread.sleep(1000);
		LogHelper.info("Login Successfully!");

		androidAccountTopupbyCardPage.loaded(driver);
		androidAccountTopupbyCardPage.inputTopupAmount(driver, topupAmount);
		androidAccountTopupbyCardPage.inputTopupCardNumber(driver,
				topupCardNumber);
		androidAccountTopupbyCardPage.inputTopupCardEMonth(driver,
				topupCardEMonth);
		// androidAccountTopupbyCardPage.inputTopupCardEYear(driver,
		// topupCardEYear);
		// androidAccountTopupbyCardPage.inputTopupCardname(driver,
		// topupCardname);
		androidAccountTopupbyCardPage.inputTopupPassword(driver, topupPassword);
		androidAccountTopupbyCardPage.clickTopupButton(driver);

	}

	@Test(dataProvider = "AndroidAppCapabilities")
	public void TopupErrorMsgTest(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws InvalidElementStateException,
			InterruptedException, Exception {

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());

		androidLoginPage.bypassIntroScreens(driver);
		Thread.sleep(1000);

		// Login
		androidLoginPage.loaded(driver);
		androidLoginPage.enterLoginemail(driver, usernameText);
		androidLoginPage.enterLoginPassword(driver, password);
		androidLoginPage.clickLoginBtn(driver);
		Thread.sleep(1000);
		LogHelper.info("Login Successfully!");

		androidAccountTopupbyCardPage.loaded(driver);
		mobileSwipeHelper.swipetoButtom(driver);
		mobileSwipeHelper.swipetoButtom(driver);
		mobileSwipeHelper.swipetoButtom(driver);
		androidAccountTopupbyCardPage.clickTopupButton(driver);

		mobileSwipeHelper.swipetoTop(driver);
		mobileSwipeHelper.swipetoTop(driver);

		// Verification
		verify.isTextPresent(androidAccountTopupbyCardPage
				.getTopupDepositAmountError(driver));

		String actualTopupAmountError = androidAccountTopupbyCardPage
				.getTopupDepositAmountError(driver);
		String expectTopupAmountError = "The minimum deposit amount is $10.00, please check the amount entered and try again.";
		String actualTopupNumberError = androidAccountTopupbyCardPage
				.getTopupCardNumberError(driver);
		String expectTopupNumberError = "Sorry, this format is not allowed for a credit card.";
		String actualTopupPasswordError = androidAccountTopupbyCardPage
				.getTopupPasswordError(driver);
		String expectTopupPasswordError = "You need to enter your password.";

		Verify.verifyEquals(actualTopupAmountError, expectTopupAmountError);
		Verify.verifyEquals(actualTopupNumberError, expectTopupNumberError);
		Verify.verifyEquals(actualTopupPasswordError, expectTopupPasswordError);
	}
}
