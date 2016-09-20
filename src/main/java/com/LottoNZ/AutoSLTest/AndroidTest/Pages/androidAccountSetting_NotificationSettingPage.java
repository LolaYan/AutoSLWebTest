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
public class androidAccountSetting_NotificationSettingPage extends
		_AndroidBasePage {
	protected static String push_JackpotRemindersRatio_ContentDesc = "Jackpot reminders";
	protected static String push_OffersAndPromotionsRatio_ContentDesc = "Offers and promotions";
	protected static String push_InstantKiwiRemindersRatio_ContentDesc = "Instant Kiwi reminders";

	protected static String email_JackpotRemindersRatio_ContentDesc = "Jackpot reminders & promotions";
	protected static String email_ResultsAndPromotionsRatio_ContentDesc = "Results & promotions";
	protected static String email_InstantKiwiRemindersRatio_ContentDesc = "Instant Kiwi news & promotions";

	protected static String UnsubscribeRatio_ContentDesc = "Unsubscribe from all";
	protected static String passwordTextField_ContentDesc = "Top up password input field";
	protected static String saveButton_ContentDesc = "submitButton";

	public static void loaded(AppiumDriver driver) throws InterruptedException {
	}

	/**
	 * Element
	 */

	// myDetails
	public static WebElement push_JackpotRemindersRatio(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, push_JackpotRemindersRatio_ContentDesc);
	}

	public static WebElement push_OffersAndPromotionsRatio(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, push_OffersAndPromotionsRatio_ContentDesc);
	}

	public static WebElement push_InstantKiwiRemindersRatio(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, push_InstantKiwiRemindersRatio_ContentDesc);
	}

	public static WebElement email_JackpotRemindersRatio(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, email_JackpotRemindersRatio_ContentDesc);
	}

	public static WebElement email_ResultsAndPromotionsRatio(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, email_ResultsAndPromotionsRatio_ContentDesc);
	}

	public static WebElement email_InstantKiwiRemindersRatio(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, email_InstantKiwiRemindersRatio_ContentDesc);
	}

	public static WebElement UnsubscribeRatio(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, UnsubscribeRatio_ContentDesc);
	}

	public static WebElement passwordTextField(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, passwordTextField_ContentDesc);
	}

	public static WebElement saveButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, saveButton_ContentDesc);
	}

	/**
	 * Method
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void clickPush_JackpotRemindersRatio(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click push_JackpotRemindersRatio");
		push_JackpotRemindersRatio(driver).click();

	}

	public static void clickPush_OffersAndPromotionsRatio(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click push_OffersAndPromotionsRatio");
		push_OffersAndPromotionsRatio(driver).click();

	}

	public static void clickPush_InstantKiwiRemindersRatio(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click push_InstantKiwiRemindersRatio");
		push_InstantKiwiRemindersRatio(driver).click();

	}

	public static void clickEmail_JackpotRemindersRatio(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click email_JackpotRemindersRatio");
		email_JackpotRemindersRatio(driver).click();

	}

	public static void clickEmail_ResultsAndPromotionsRatio(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click email_ResultsAndPromotionsRatio");
		email_ResultsAndPromotionsRatio(driver).click();

	}

	public static void clickEmail_InstantKiwiRemindersRatio(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click email_InstantKiwiRemindersRatio");
		email_InstantKiwiRemindersRatio(driver).click();

	}

	public static void clickUnsubscribeAllRatio(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click UnsubscribeRatio");
		UnsubscribeRatio(driver).click();

	}

	public static void inputPassword(AppiumDriver driver, String password)
			throws InterruptedException {
		LogHelper.info(" input Password:" + password);
		SendKeys(driver, passwordTextField(driver), password);
	}

	public static void clickSave(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click Save Button");
		saveButton(driver).click();

	}

}
