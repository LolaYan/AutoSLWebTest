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
public class androidAccountSetting_WithdrawFundsPage extends _AndroidBasePage {
	protected static String changeBankAccount_ContentDesc = "changeBankAccount";
	protected static String transferAmountField_ContentDesc = "transferAmountField";
	protected static String passwordTextField_ContentDesc = "passwordFieldFromWithdrawFunds";
	protected static String withdrawFundsButton_ContentDesc = "withdrawFunds";

	public static void loaded(AppiumDriver driver) throws InterruptedException {
	}

	/**
	 * Element
	 */

	// myDetails
	public static WebElement changeBankAccount(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, changeBankAccount_ContentDesc);
	}

	public static WebElement transferAmountField(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, transferAmountField_ContentDesc);
	}

	public static WebElement passwordTextField(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, passwordTextField_ContentDesc);
	}

	public static WebElement withdrawFundsButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, withdrawFundsButton_ContentDesc);
	}

	/**
	 * Method
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void clickChangeBankAccount(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click changeBankAccount");
		changeBankAccount(driver).click();

	}

	public static void inputWithdrawAmount(AppiumDriver driver,
			String WithdrawAmount) throws InterruptedException {
		LogHelper.info(" input WithdrawAmount:" + WithdrawAmount);
		SendKeys(driver, transferAmountField(driver), WithdrawAmount);
	}

	public static void inputPassword(AppiumDriver driver, String password)
			throws InterruptedException {
		LogHelper.info(" input Password:" + password);
		SendKeys(driver, passwordTextField(driver), password);
	}

	public static void clickSave(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click Save Button");
		withdrawFundsButton(driver).click();

	}

}
