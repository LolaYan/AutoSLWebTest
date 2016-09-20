/**
 * 
 */
package com.LottoNZ.AutoSLTest.WebTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.WebTest.Tests.Constants;

/**
 * @author MRawal
 *
 */
public class LoginModal extends PageBase {
	public abstract static class LoginModalwithUser {

		final static By closemodal = By.id("close-modal");
		final static By keepLoggedInCB = By.id("keepLoggedInCB");
		final static By login_submit_button = By.id("login-submit-button");

		public static void clickSubmitBtn(WebDriver driver)
				throws InterruptedException {
			LogHelper.info("Click on submit button");

			login_submit_button(driver).click();

		}

		public static void enterLoginemail(WebDriver driver, String email)
				throws InterruptedException {
			LogHelper.info("Enter login email address");

			loginemail(driver).sendKeys(email);

		}

		public static void enterLoginPassword(WebDriver driver, String password)
				throws InterruptedException {

			LogHelper.info("Enter login password");
			loginpassword(driver).sendKeys(password);

		}

		public static WebElement login_submit_button(WebDriver driver) {
			return driver.findElement((By.id("login-submit-button")));
		}

		public static WebElement loginemail(WebDriver driver) {
			return driver.findElement((By.id("email")));
		}

		/**
		 * method used to login
		 * 
		 * @param driver
		 * @param email
		 * @param password
		 * @throws Exception
		 */
		public static void loginFromModal(WebDriver driver, String email,
				String password) throws Exception {
			NavBarPage.navigateTologinModal(driver);
			driver.switchTo().activeElement();
			enterLoginemail(driver, email);
			enterLoginPassword(driver, password);
			clickSubmitBtn(driver);
		}

		public static WebElement loginpassword(WebDriver driver) {
			return driver.findElement((By.id("password")));
		}

		/**
		 * if the
		 * 
		 * @param driver
		 * @param password
		 * @throws InterruptedException
		 */
		public static void selectSignUpLink(WebDriver driver)
				throws InterruptedException {
			LogHelper.info("select loginModalSignupLink");
			signupFromLogin(driver).click();
			Thread.sleep(500);
			Assert.assertTrue(
					driver.getCurrentUrl().contains(Constants.registrationURL),
					"User not navigated to registration url");

		}

		public static WebElement signupFromLogin(WebDriver driver) {
			return driver.findElement((By.id("loginModalSignupLink")));
		}
	}

	public LoginModal(WebDriver driver) {
		super(driver);
	}
}
