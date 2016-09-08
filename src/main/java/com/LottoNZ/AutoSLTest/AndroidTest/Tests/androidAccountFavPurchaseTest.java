/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidAccountFavPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLoginPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoEcommPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidNavBarPage;
import com.LottoNZ.AutoSLTest.Utils.DataGenerator;

public class androidAccountFavPurchaseTest extends _AndroidTestBase {

	String favName = "FavName";
	String password = "password1";
	String usernameText = "automation@autotest.com";
	@Test(dataProvider = "AndroidAppCapabilities")
	public void LoginUsingValidCredentialTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws InvalidElementStateException,
			InterruptedException, Exception {
		favName = "FavName"+DataGenerator.generateString(5);
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
		androidNavBarPage.clickAccountFavs(driver);

		androidAccountFavPage.clickAddFav(driver);
		androidAccountFavPage.createLottoFav(driver);
		androidLottoEcommPage.clickSaveFavButton(driver);
		androidAccountFavPage.inputFavName(driver, favName);
		androidLottoEcommPage.clickSaveFavButton(driver);
		
		androidAccountFavPage.clickViewTicketDetail(driver);
		androidAccountFavPage.clickFavouriteTicketPlayNow(driver);
	}
}
