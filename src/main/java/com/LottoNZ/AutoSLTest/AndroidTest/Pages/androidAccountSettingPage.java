/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;

/**
 * @author MRawal
 *
 */
public class androidAccountSettingPage extends _AndroidBasePage {

	public static void loaded(AppiumDriver driver) throws InterruptedException {
		androidNavBarPage.navigateToAccountList(driver);
		androidNavBarPage.clickAccountSettings(driver);
	}

	/**
	 * Element
	 */

	// myDetails
	public static WebElement nameEdit(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "nameEdit");
	}

	public static WebElement emailEdit(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "emailEdit");
	}

	public static WebElement phoneNumberEdit(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "phoneNumberEdit");
	}

	public static WebElement locationEdit(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "locationEdit");
	}

	public static WebElement changePassword(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "changePassword");
	}

	public static WebElement changeSecurityQuestion(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "changeSecurityQuestion");
	}

	public static WebElement settingsNotification(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "settingsCommunicationPreferences");
	}

	public static WebElement blockGames(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "blockGames");
	}

	public static WebElement closeAccount(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "closeAccount");
	}

	// myFunds
	// Missing in app
	public static WebElement topUpDebitOrCreditCard(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "topUpDebitOrCreditCard");
	}

	// replaceCard
	public static WebElement replaceCard(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "replaceCard");
	}

	public static WebElement topUpInternetBanking(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "topUpInternetBanking");
	}

	public static WebElement withdrawFunds(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "withdrawFunds");
	}

	public static WebElement changeMyBankAccount(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "changeMyBankAccount");
	}

	public static WebElement spendingLimits(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "spendingLimits");
	}

	/**
	 * Method
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */

	public static void clickBlockGames(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click blockGames");
		blockGames(driver).click();

	}

	public static void clickChangeMyBankAccount(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click changeMyBankAccount");
		changeMyBankAccount(driver).click();

	}

	public static void clickChangePassword(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click changePassword");
		changePassword(driver).click();

	}

	public static void clickChangeSecurityQuestion(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Enter changeSecurityQuestion");
		changeSecurityQuestion(driver).click();

	}

	public static void clickCloseAccount(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Enter closeAccount");
		closeAccount(driver).click();

	}

	public static void clickEmailEdit(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Enter emailEdit");
		emailEdit(driver).click();

	}

	public static void clickLocationEdit(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click locationEdit");

		locationEdit(driver).click();

	}

	public static void clickNameEdit(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click nameEdit");
		nameEdit(driver).click();
		;

	}

	public static void clickNotificationSettings(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click NotificationSettings");
		settingsNotification(driver).click();

	}

	public static void clickPhoneNumberEdit(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click phoneNumberEdit");
		phoneNumberEdit(driver).click();
		// Assert.assertTrue(
		// driver.getCurrentUrl().contains(Constants.registrationURL),
		// "User not navigated to registration url");

	}

	public static void clickSpendingLimits(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click spendingLimits");
		spendingLimits(driver).click();

	}

	public static void clicktopUpDebitOrCreditCard(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click topUpDebitOrCreditCard");
		topUpDebitOrCreditCard(driver).click();

	}

	public static void clicktopUpInternetBanking(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click topUpInternetBanking");
		topUpInternetBanking(driver).click();

	}

	public static void clickWithdrawFunds(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click withdrawFunds");
		withdrawFunds(driver).click();

	}

}
