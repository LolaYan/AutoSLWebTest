package com.LottoNZ.AutoSLTest.WebTest.Tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.WebTest.Pages.LoginModal.LoginModalwithUser;
import com.LottoNZ.AutoSLTest.WebTest.Pages.LottoTopupPage;

/**
 * @author Lola
 * @email lyan@planittesting.co.nz Note: define the find element methods here in
 *        LottoTopupPage
 * 
 */
public class LottoTopupPageTest extends TestBase {

	/*
	 * Work flow: Existing User Login > First Top up with no credit card
	 * registered
	 */
	@Test(dataProvider = "hardCodedBrowsers", groups = { "WebTest", "My funds" })
	public void verifyLottoTopupPageTest(String browser, String version,
			String os, Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.baseURL);

		/** Login **/
		LoginModalwithUser.loginFromModal(driver, "xtxpjxjn@automail.com",
				Constants.password);

		LottoTopupPage.topUpwithCCfortheFirstTime(driver, Constants.amount,
				Constants.cardNum, Constants.MM, Constants.YY,
				Constants.firstname, Constants.cvc, Constants.password);
	}

}
