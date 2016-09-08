/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLoginPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidNavBarPage;
import com.LottoNZ.AutoSLTest.WebTest.Tests.verify;

public class androidAccountLoginTest extends _AndroidTestBase {

	String usernameText = "automation@autotest.com";
	String password = "password1";

	String invalidUsernameText = "automation@111.com";
	String invalidPassword = "password2";

	@Test(dataProvider = "AndroidAppCapabilities")
	public void LoginUsingValidCredentialTest(String appiumVersion,
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
		androidLoginPage.loaded(driver);

		// Login again
		androidLoginPage.enterLoginemail(driver, usernameText);
		androidLoginPage.enterLoginPassword(driver, password);
		androidLoginPage.clickLoginBtn(driver);
		Thread.sleep(1000);

		// Verify Account Balance is showing
		String actualAccountBalance = androidNavBarPage
				.getAccountBalanceinNavBar(driver);
		verify.isTextPresent(actualAccountBalance);

	}
}
