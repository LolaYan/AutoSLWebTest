package com.LottoNZ.AutoSLTest.WebTest.Tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.WebTest.Pages.LottoPYOpage;

/**
 * @author mrawal
 * 
 */
public class LottoPYOTest extends TestBase {

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "Test if all the lines can be added for Lotto, Lotto-PB, Strike, and editted ")
	public void editNumbersTest(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.baseURL);

		// /** Login **/
		// LoginModalwithUser.loginFromModal(driver, "xtxpjxjn@automail.com",
		// Constants.password);

		/** Go to url directly **/
		driver.get(Constants.lottoPYOURL);
		Log.info("Step 1: autofill all the Lotto PB lines");
		LottoPYOpage.autofillAllLottoPBLines(driver, 4);

		Log.info("Step 2: edit the Lotto PB lines");
		LottoPYOpage.editLottoNumberLine(driver, "A", 1, 39);
		LottoPYOpage.editLottoNumberLine(driver, "B", 4, 10);
		LottoPYOpage.editLottoNumberLine(driver, "C", 2, 15);
		LottoPYOpage.editPBNumberLine(driver, "D", 5);

		Log.info("Step 3: Add some Lotto PB numbers manually");
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 37, 38, 39, 40,
				35, 36, 5);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 37, 38, 39, 40,
				35, 36, 5);

		Log.info("Step 4: edit the Lotto PB lines");
		LottoPYOpage.editPBNumberLine(driver, "E", 9);
		LottoPYOpage.editLottoNumberLine(driver, "F", 5, 8);

		Log.info("Step 5: autofill some Strike lines");
		LottoPYOpage.autofillAllStrikeLines(driver, 2);

		Log.info("Step 6: Edit some Strike lines");
		LottoPYOpage.editStrikeNumberLine(driver, "A", 4, 30);
		LottoPYOpage.editStrikeNumberLine(driver, "B", 2, 3);

		Log.info("Step 7: Select a few strike lines");
		LottoPYOpage.addStrikeNumberLine(driver, 1, 2, 3, 4);
		LottoPYOpage.addStrikeNumberLine(driver, 5, 6, 7, 8);

		Log.info("Step 8: Edit some Strike lines");
		LottoPYOpage.editStrikeNumberLine(driver, "C", 1, 10);
		LottoPYOpage.editStrikeNumberLine(driver, "D", 3, 22);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "Verify if strike is blocked for less than 4 lotto lines")
	public void LottoOnlyStrikeBlockedTest(String browser, String version,
			String os, Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.baseURL);

		// /** Login **/
		// LoginModalwithUser.loginFromModal(driver, "xtxpjxjn@automail.com",
		// Constants.password);

		/** Go to url directly **/
		driver.get(Constants.lottoPYOURL);
		LottoPYOpage.verifyStrikeBlockedLottoOnly(driver);

	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "Verify if strike is blocked for less than 4 lotto PB lines")
	public void LottoPBStrikeBlockedTest(String browser, String version,
			String os, Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.baseURL);

		// /** Login **/
		// LoginModalwithUser.loginFromModal(driver, "xtxpjxjn@automail.com",
		// Constants.password);

		/** Go to url directly **/
		driver.get(Constants.lottoPYOURL);
		LottoPYOpage.verifyStrikeBlockedLottoPB(driver);

	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "Test if all the lines can be added for Lotto, Lotto-PB, Strike, they match ecom bar and delete is working for all of the rows ")
	public void numberOfLinesTest(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.baseURL);

		// /** Login **/
		// LoginModalwithUser.loginFromModal(driver, "xtxpjxjn@automail.com",
		// Constants.password);

		/** Go to url directly **/
		driver.get(Constants.lottoPYOURL);
		Log.info("Step 1: autofill all the Lotto PB lines");
		LottoPYOpage.autofillAllLottoPBLines(driver, 20);
		Log.info("Step 2: delete all the Lotto PB lines");
		LottoPYOpage.deleteAllLottoPBLines(driver, 20);
		Log.info("Step 3: Toggle PB button off");
		LottoPYOpage.togglePBoff(driver);
		Log.info("Step 4: autofill all the Lotto only lines");
		LottoPYOpage.autofillAllLottoOnlyLines(driver, 20);
		Log.info("Step 5: autofill all the Strike lines");
		LottoPYOpage.autofillAllStrikeLines(driver, 20);
		Log.info("Step 6: Delete all the strike lines");
		LottoPYOpage.deleteAllStrikeLines(driver, 20);

	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "Test if we can manually pick lotto, PB and strike numbers and edit them")
	public void PYOTest(String browser, String version, String os, Method method)
			throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.baseURL);

		// /** Login **/
		// LoginModalwithUser.loginFromModal(driver, "xtxpjxjn@automail.com",
		// Constants.password);

		/** Go to url directly **/
		driver.get(Constants.lottoPYOURL);
		Log.info("Step 1: Add a few Lotto PB lines manually");
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 1, 2, 3, 4, 5, 6,
				1);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 11, 12, 13, 14,
				15, 16, 2);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 21, 22, 23, 24,
				25, 26, 3);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 31, 32, 33, 34,
				35, 36, 4);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 37, 38, 39, 40, 5,
				6, 5);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 1, 2, 3, 4, 5, 6,
				1);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 11, 12, 13, 14,
				15, 16, 2);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 21, 22, 23, 24,
				25, 26, 3);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 31, 32, 33, 34,
				35, 36, 4);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 37, 38, 39, 40,
				35, 36, 5);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 1, 2, 3, 4, 5, 6,
				1);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 11, 12, 13, 14,
				15, 16, 2);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 21, 22, 23, 24,
				25, 26, 3);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 31, 32, 33, 34,
				35, 36, 4);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 37, 38, 39, 40,
				35, 36, 5);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 1, 2, 3, 4, 5, 6,
				1);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 11, 12, 13, 14,
				15, 16, 2);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 21, 22, 23, 24,
				25, 26, 3);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 31, 32, 33, 34,
				35, 36, 4);
		LottoPYOpage.addLottoNumberLineWithPowerball(driver, 37, 38, 39, 40,
				35, 36, 5);
		LottoPYOpage.verifyLottoLinesoneCom(driver, 20);
		// LottoPYOpage.verifyPBLinesoneCom(driver, 20);

		Log.info("Step 2: Select a few strike lines");
		LottoPYOpage.addStrikeNumberLine(driver, 1, 2, 3, 4);
		LottoPYOpage.addStrikeNumberLine(driver, 5, 6, 7, 8);
		LottoPYOpage.addStrikeNumberLine(driver, 9, 10, 11, 12);
		LottoPYOpage.addStrikeNumberLine(driver, 15, 16, 17, 18);

		LottoPYOpage.addStrikeNumberLine(driver, 11, 12, 13, 14);
		LottoPYOpage.addStrikeNumberLine(driver, 25, 26, 27, 28);
		LottoPYOpage.addStrikeNumberLine(driver, 21, 22, 23, 24);
		LottoPYOpage.addStrikeNumberLine(driver, 35, 36, 37, 38);
		LottoPYOpage.addStrikeNumberLine(driver, 11, 22, 33, 4);
		LottoPYOpage.addStrikeNumberLine(driver, 35, 26, 17, 8);
		LottoPYOpage.addStrikeNumberLine(driver, 1, 12, 23, 34);
		LottoPYOpage.addStrikeNumberLine(driver, 15, 6, 37, 28);
		LottoPYOpage.addStrikeNumberLine(driver, 1, 2, 3, 4);
		LottoPYOpage.addStrikeNumberLine(driver, 5, 6, 7, 8);
		LottoPYOpage.addStrikeNumberLine(driver, 9, 10, 11, 12);
		LottoPYOpage.addStrikeNumberLine(driver, 15, 16, 17, 18);

		LottoPYOpage.addStrikeNumberLine(driver, 11, 12, 13, 14);
		LottoPYOpage.addStrikeNumberLine(driver, 25, 26, 27, 28);
		LottoPYOpage.addStrikeNumberLine(driver, 21, 22, 23, 24);
		LottoPYOpage.addStrikeNumberLine(driver, 35, 36, 37, 38);
		LottoPYOpage.addStrikeNumberLine(driver, 11, 22, 33, 4);
		LottoPYOpage.addStrikeNumberLine(driver, 35, 26, 17, 8);
		LottoPYOpage.addStrikeNumberLine(driver, 1, 12, 23, 34);
		LottoPYOpage.addStrikeNumberLine(driver, 15, 6, 37, 28);
		LottoPYOpage.verifyStrikeLinesoneCom(driver, 20);

		Log.info("Step 3: Delete two Lotto PB lines. Toggle PB button off");
		LottoPYOpage.clickdeleteLPBLine(driver, 4);
		LottoPYOpage.clickdeleteLPBLine(driver, 14);
		LottoPYOpage.togglePBoff(driver);

		Log.info("Step 4: Add 2 more Lotto only lines");
		LottoPYOpage.addLottoNumberLineWithoutPowerball(driver, 7, 8, 9, 10,
				17, 18);
		LottoPYOpage.addLottoNumberLineWithoutPowerball(driver, 19, 20, 27, 28,
				29, 30);
		LottoPYOpage.verifyLottoLinesoneCom(driver, 20);
		LottoPYOpage.verifyPBLinesoneCom(driver, 18);

		Log.info("Step 5: Add a few lotto lines");
		LottoPYOpage.addLottoNumberLineWithoutPowerball(driver, 7, 8, 9, 10,
				17, 18);
		LottoPYOpage.addLottoNumberLineWithoutPowerball(driver, 19, 20, 27, 28,
				29, 30);
		LottoPYOpage.verifyLottoLinesoneCom(driver, 20);
		LottoPYOpage.verifyPBLinesoneCom(driver, 18);
	}
}
