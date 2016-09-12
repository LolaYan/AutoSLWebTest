/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.Utils.PropertyLoader;
import com.LottoNZ.AutoSLTest.WebTest.Tests.Constants;

public class androidLoginPage extends _AndroidBasePage {

	protected static String loginpasswordTextField_ContentDesc = "passwordInputFromLoginForm";
	protected static String loginemailTextField_ContentDesc = "emailInputFromLoginForm";
	protected static String needHelpText_ContentDesc = "Need help?";
	protected static String forgetPasswordText_ContentDesc = "Forgotten your password?";
	protected static String loginButton_ContentDesc = "loginFormLogin";
	protected static String signupNowButton_ContentDesc = "signupNow";
	
	androidLoginPage()
	{
		loginpasswordTextField_ContentDesc = PropertyLoader.loadElementContentDecsValue("loginpasswordTextField_ContentDesc");
		loginemailTextField_ContentDesc = PropertyLoader.loadElementContentDecsValue("loginemailTextField_ContentDesc");
		needHelpText_ContentDesc = PropertyLoader.loadElementContentDecsValue("needHelpText_ContentDesc");
		forgetPasswordText_ContentDesc = PropertyLoader.loadElementContentDecsValue("forgetPasswordText_ContentDesc");
		loginButton_ContentDesc = PropertyLoader.loadElementContentDecsValue("loginButton_ContentDesc");
		signupNowButton_ContentDesc = PropertyLoader.loadElementContentDecsValue("signupNowButton_ContentDesc");
	}
	
	public static void loaded(AppiumDriver driver) throws InterruptedException {
		androidNavBarPage.navigateTologinNav(driver);
		androidNavBarPage.clickLogin(driver);

	}

	/**
	 * Element
	 * 
	 * @param driver
	 */
	public static WebElement loginEmailTextbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, loginemailTextField_ContentDesc);
	}

	public static WebElement loginPasswordTextbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, loginpasswordTextField_ContentDesc);
	}

	public static WebElement forgotPasswordLink(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, forgetPasswordText_ContentDesc);
	}

	public static WebElement loginButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, loginButton_ContentDesc);
	}

	public static WebElement registerbutton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, signupNowButton_ContentDesc);
	}

	/**
	 * Method
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void clickLoginBtn(AppiumDriver driver) throws Exception {
		LogHelper.info(" Login now........");
		loginButton(driver).click();
	}

	public static void clickSubmitBtn(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click on submit button");

		loginButton(driver).click();

	}

	public static void enterLoginemail(AppiumDriver driver, String email)
			throws InterruptedException {
		LogHelper.info("Enter login email address");
		SendKeys(driver, loginEmailTextbox(driver), email);
		// loginemail(driver).sendKeys(email);

	}

	public static void enterLoginPassword(AppiumDriver driver, String password)
			throws InterruptedException {
		LogHelper.info("Enter login password");
		SendKeys(driver, loginPasswordTextbox(driver), password);
		// loginpassword(driver).sendKeys(password);

	}

	public static void inputLoginPassword(AppiumDriver driver, String password)
			throws Exception {
		LogHelper.info(" input password........" + password);
		loginPasswordTextbox(driver).sendKeys(password);
	}

	public static void inputLoginUsername(AppiumDriver driver, String username)
			throws Exception {
		LogHelper.info(" input username........" + username);
		loginEmailTextbox(driver).sendKeys(username);
	}

	public static void loginFromModal(AppiumDriver driver, String email,
			String password) throws Exception {
		androidNavBarPage.navigateTologinNav(driver);
		enterLoginemail(driver, email);
		enterLoginPassword(driver, password);
		clickSubmitBtn(driver);
	}

	public static void selectSignUpLink(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("select loginModalSignupLink");
		registerbutton(driver).click();
		Thread.sleep(500);
		Assert.assertTrue(
				driver.getCurrentUrl().contains(Constants.registrationURL),
				"User not navigated to registration url");

	}

}
