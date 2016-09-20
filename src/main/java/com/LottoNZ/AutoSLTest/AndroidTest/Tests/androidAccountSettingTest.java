/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidAccountFavPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidAccountSettingPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidAccountSetting_ChangePasswordPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLoginPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoEcommPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidNavBarPage;
import com.LottoNZ.AutoSLTest.Utils.DataGenerator;

public class androidAccountSettingTest extends _AndroidTestBase {

	@Test(dataProvider = "AndroidAppCapabilities")
	public void AccountSetting_PasswordChangeTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws InvalidElementStateException,
			InterruptedException, Exception {

		String password = "password1";
		String newPassword = "password2";
		String usernameText = "changepassword@autotest.com";

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

		androidNavBarPage.navigateToAccountList(driver);
		androidNavBarPage.clickAccountSettings(driver);

		androidAccountSettingPage.clickChangePassword(driver);

		androidAccountSetting_ChangePasswordPage.inputOldPassword(driver,
				password);
		androidAccountSetting_ChangePasswordPage.inputnNewPassword(driver,
				newPassword);
		androidAccountSetting_ChangePasswordPage.clickSave(driver);

		androidLoginPage.loaded(driver);
		androidLoginPage.enterLoginemail(driver, usernameText);
		androidLoginPage.enterLoginPassword(driver, newPassword);
		androidLoginPage.clickLoginBtn(driver);
	}
}
