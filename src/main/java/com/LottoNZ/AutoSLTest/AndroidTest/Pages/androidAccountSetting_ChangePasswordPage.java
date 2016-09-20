/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;

/**
 * @author MRawal
 *
 */
public class androidAccountSetting_ChangePasswordPage extends _AndroidBasePage {
	protected static String oldPasswordTextField_ContentDesc = "oldPasswordFromChangePasswordForm";
	protected static String newPasswordTextField_ContentDesc = "newPasswordFromChangePasswordForm";
	protected static String changePasswordButton_ContentDesc = "SAVE CHANGES";

	public static void loaded(AppiumDriver driver) throws InterruptedException {
	}

	/**
	 * Element
	 */

	// myDetails
	public static WebElement oldPasswordTextField(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, oldPasswordTextField_ContentDesc);
	}

	public static WebElement newPasswordTextField(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, newPasswordTextField_ContentDesc);
	}

	public static WebElement changePasswordButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, changePasswordButton_ContentDesc);
	}

	/**
	 * Method
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void inputOldPassword(AppiumDriver driver, String oldPassword)
			throws InterruptedException {
		LogHelper.info(" input old Password:" + oldPassword);
		// mobileSwipeHelper.swipeElementToTop(driver,
		// oldPasswordTextField(driver));
		SendKeys(driver, oldPasswordTextField(driver), oldPassword);
	}

	public static void inputnNewPassword(AppiumDriver driver, String newPassword)
			throws InterruptedException {
		LogHelper.info(" input new Password:" + newPassword);
		// mobileSwipeHelper.swipeElementToTop(driver,
		// newPasswordTextField(driver));
		SendKeys(driver, newPasswordTextField(driver), newPassword);
	}

	public static void clickSave(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click Save Button");
		changePasswordButton(driver).click();

	}

}
