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
import com.LottoNZ.AutoSLTest.WebTest.Tests.Constants;

public class androidLoginPage extends _AndroidBasePage {

	final static By closemodal = By.id("close-modal");
	final static By keepLoggedInCB = By.id("keepLoggedInCB");
	final static By login_submit_button = By.id("login-submit-button");

	public static void loaded(AppiumDriver driver) throws InterruptedException {
		androidNavBarPage.navigateTologinNav(driver);
		androidNavBarPage.clickLogin(driver);

	}

	/**
	 * Element
	 * 
	 * @param driver
	 */
	public static WebElement loginpassword(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "passwordInputFromLoginForm");
	}

	public static WebElement loginTextbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, String.format("Email"));
	}

	public static WebElement passwordTextbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, String.format("Log in password user input"));
	}

	public static WebElement signupFromLogin(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Sign up now");
	}

	public static WebElement cantAccessEmailLink(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, String.format("Can't access your email?"));
	}

	public static WebElement cantAccessEmailLinkFromLogin(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "cantAccessEmailLinkFromLogin");
	}

	public static WebElement forgotPasswordLinkFromLogin(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "forgotPasswordLinkFromLogin");
	}

	public static WebElement forgottenPasswordLink(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, String.format("Forgotten your password?"));
	}

	public static WebElement login_submit_button(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "LOG IN");
	}

	public static WebElement loginBtn(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, String.format("LOG IN"));
	}

	public static WebElement loginemail(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "emailInputFromLoginForm");
	}

	/**
	 * Method
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void clickLoginBtn(AppiumDriver driver) throws Exception {
		LogHelper.info(" Login now........");
		loginBtn(driver).click();
	}

	public static void clickSubmitBtn(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click on submit button");

		login_submit_button(driver).click();

	}

	public static void enterLoginemail(AppiumDriver driver, String email)
			throws InterruptedException {
		LogHelper.info("Enter login email address");
		SendKeys(driver, loginemail(driver), email);
		// loginemail(driver).sendKeys(email);

	}

	public static void enterLoginPassword(AppiumDriver driver, String password)
			throws InterruptedException {
		LogHelper.info("Enter login password");
		SendKeys(driver, loginpassword(driver), password);
		// loginpassword(driver).sendKeys(password);

	}

	public static void inputLoginPassword(AppiumDriver driver, String password)
			throws Exception {
		LogHelper.info(" input password........" + password);
		loginpassword(driver).sendKeys(password);
	}

	public static void inputLoginUsername(AppiumDriver driver, String username)
			throws Exception {
		LogHelper.info(" input username........" + username);
		loginTextbox(driver).sendKeys(username);
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
		signupFromLogin(driver).click();
		Thread.sleep(500);
		Assert.assertTrue(
				driver.getCurrentUrl().contains(Constants.registrationURL),
				"User not navigated to registration url");

	}

}
