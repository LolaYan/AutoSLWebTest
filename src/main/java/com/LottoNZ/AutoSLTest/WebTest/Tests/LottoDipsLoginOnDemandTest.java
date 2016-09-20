package com.LottoNZ.AutoSLTest.WebTest.Tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.WebTest.Pages.LottoDipsPage;
import com.LottoNZ.AutoSLTest.WebTest.Pages.LottoEcommpage;

/**
 * @author mrawal
 * 
 */
public class LottoDipsLoginOnDemandTest extends TestBase {

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "luckyDip12")
	public void luckyDip12Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaLuckyDip(driver, "12", 20);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyLuckyDipinfoOneCom(driver, "12", 20);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "luckyDip480")
	public void luckyDip480Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		Log.info("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		Log.info("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaLuckyDip(driver, "480", 8);

		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyLuckyDipinfoOneCom(driver, "480", 8);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "luckyDip6")
	public void luckyDip6Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaLuckyDip(driver, "6", 10);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyLuckyDipinfoOneCom(driver, "6", 10);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "luckyDip9")
	public void luckyDip9Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaLuckyDip(driver, "9", 15);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyLuckyDipinfoOneCom(driver, "9", 15);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "powerDip12")
	public void powerDip12Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaPowerDip(driver, "12", 10, 10);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyaPowerDip(driver, "12", 10, 10);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "powerDip18")
	public void powerDip18Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaPowerDip(driver, "18", 15, 15);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyaPowerDip(driver, "18", 15, 15);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "powerDip24")
	public void powerDip24Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaPowerDip(driver, "24", 20, 20);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyaPowerDip(driver, "24", 20, 20);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "powerDip960")
	public void powerDip960Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaPowerDip(driver, "960", 8, 8);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyaPowerDip(driver, "960", 8, 8);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "tripleDip14")
	public void tripleDip14Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaTripleDip(driver, "14", 10, 10, 2);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyaTripleDip(driver, "14", 10, 10, 2);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "tripleDip16")
	public void tripleDip16Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaTripleDip(driver, "16", 10, 10, 4);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyaTripleDip(driver, "16", 10, 10, 4);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "tripleDip20")
	public void tripleDip20Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaTripleDip(driver, "20", 15, 15, 2);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyaTripleDip(driver, "20", 15, 15, 2);
	}

	@Test(dataProvider = "hardCodedBrowsers", priority = 0, groups = {
			"WebTest", "Signup" }, description = "tripleDip26")
	public void tripleDip26Test(String browser, String version, String os,
			Method method) throws Exception {

		/** create webdriver session **/
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.lottoDipsURL);
		LottoDipsPage.selectaTripleDip(driver, "26", 20, 20, 2);
		LottoEcommpage.buyLoginOnDemand(driver, Constants.existingemail,
				Constants.password);

		LottoDipsPage.verifyaTripleDip(driver, "26", 20, 20, 2);
	}
}
