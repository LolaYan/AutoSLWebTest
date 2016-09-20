/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;

public class androidAccountTopupbyCardPage extends androidAccountTopupIntroPage {

	public static void loaded(AppiumDriver driver) throws InterruptedException {
		androidAccountTopupIntroPage.loaded(driver);
		androidAccountTopupIntroPage.selectTopupWithCardBtn(driver);
	}

	/**
	 * Page ELEMENTS for Top up with new credit card
	 */

	// Top up amount
	public static WebElement topupAmount(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up deposit input field");
	}

	// Top up deposit helper text
	public static WebElement topupAmountHelperLabel(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up deposit helper text");
	}

	// Top up card cvc input field
	public static WebElement topupCardCVC(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up cvc input field");
	}

	// Top up expiry month input field
	public static WebElement topupCardEMonth(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up expiry month input field");
	}

	// Top up expiry year input field
	public static WebElement topupCardEYear(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up expiry year input field");
	}

	// Top up card name input field
	public static WebElement topupCardname(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up card name input field");
	}

	// Top up card number input field
	public static WebElement topupCardNumber(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up card number input field");
	}

	// Top up password input field
	public static WebElement topupPassword(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up password input field");
	}

	// topupButton
	public static WebElement topupButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "topupButton");
	}

	// Top up policy helper text
	public static WebElement topupPolicyHelperLabel(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up policy helper text");
	}

	/**
	 * Page Error Msg ELEMENTS for Top up with new credit card
	 */
	// Top up amount
	public static WebElement topupDepositAmountError(AppiumDriver driver)
			throws InterruptedException {
		return findIfExisting(driver, "Top up deposit error message");
	}

	// Top up card cvc input field
	public static WebElement topupCardCVCError(AppiumDriver driver)
			throws InterruptedException {
		return findIfExisting(driver, "Top up cvc error message");
	}

	// Top up expiry month input field
	public static WebElement topupCardEMonthError(AppiumDriver driver)
			throws InterruptedException {
		return findIfExisting(driver, "Top up expiry month error message");
	}

	// Top up expiry year input field
	public static WebElement topupCardEYearError(AppiumDriver driver)
			throws InterruptedException {
		return findIfExisting(driver, "Top up expiry year error message");
	}

	// Top up card name input field
	public static WebElement topupCardnameError(AppiumDriver driver)
			throws InterruptedException {
		return findIfExisting(driver, "Top up card name error message");
	}

	// Top up card number input field
	public static WebElement topupCardNumberError(AppiumDriver driver)
			throws InterruptedException {
		return findIfExisting(driver, "Top up card number error message");
	}

	// Top up password input field
	public static WebElement topupPasswordError(AppiumDriver driver)
			throws InterruptedException {
		return findIfExisting(driver, "Top up password error message");
	}

	/**
	 * Page Method
	 */

	public static void inputTopupAmount(AppiumDriver driver, String topupAmount)
			throws InterruptedException {
		LogHelper.info("Input topupAmount......" + topupAmount);
		mobileSwipeHelper.swipeElementToTop(driver, topupAmount(driver));
		SendKeys(driver, topupAmount(driver), topupAmount);
	}

	public static void inputTopupCardNumber(AppiumDriver driver,
			String topupCardNumber) throws InterruptedException {
		LogHelper.info("Input topupCardNumber......" + topupCardNumber);
		mobileSwipeHelper.swipeElementToTop(driver, topupCardNumber(driver));
		SendKeys(driver, topupCardNumber(driver), topupCardNumber);
	}

	public static void inputTopupCardEMonth(AppiumDriver driver,
			String topupCardEMonth) throws InterruptedException {
		LogHelper.info("Input topupCardEMonth......" + topupCardEMonth);
		mobileSwipeHelper.swipeElementToTop(driver, topupCardEMonth(driver));
		SendKeys(driver, topupCardEMonth(driver), topupCardEMonth);
	}

	public static void inputTopupCardEYear(AppiumDriver driver,
			String topupCardEYear) throws InterruptedException {
		LogHelper.info("Input topupCardEYear......" + topupCardEYear);
		mobileSwipeHelper.swipeElementToTop(driver, topupCardEYear(driver));
		SendKeys(driver, topupCardEYear(driver), topupCardEYear);
	}

	public static void inputTopupCardname(AppiumDriver driver,
			String topupCardname) throws InterruptedException {
		LogHelper.info("Input topupCardname......" + topupCardname);
		mobileSwipeHelper.swipeElementToTop(driver, topupAmount(driver));
		SendKeys(driver, topupCardname(driver), topupCardname);
	}

	public static void inputTopupCardCVC(AppiumDriver driver,
			String topupCardCVC) throws InterruptedException {
		LogHelper.info("Input topupCardCVC......" + topupCardCVC);
		mobileSwipeHelper.swipeElementToTop(driver, topupCardCVC(driver));
		SendKeys(driver, topupCardCVC(driver), topupCardCVC);
	}

	public static void inputTopupPassword(AppiumDriver driver,
			String topupPassword) throws InterruptedException {
		LogHelper.info("Input topupPassword......" + topupPassword);
		mobileSwipeHelper.swipeElementToTop(driver, topupPassword(driver));
		SendKeys(driver, topupPassword(driver), topupPassword);
	}

	public static void clickTopupButton(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click topupButton.");
		topupButton(driver).click();
	}

	/**
	 * Page Method of Get Error Msg Text
	 */
	public static String getTopupDepositAmountError(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver,
				topupDepositAmountError(driver));
		String text = topupDepositAmountError(driver).getText();
		LogHelper.info("Get topupDepositAmountError text:" + text);
		return text;
	}

	public static String getTopupCardCVCError(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver, topupCardCVCError(driver));
		String text = topupCardCVCError(driver).getText();
		LogHelper.info("Get topupCardCVCError text:" + text);
		return text;
	}

	public static String getTopupCardEMonthError(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver,
				topupCardEMonthError(driver));
		String text = topupCardEMonthError(driver).getText();
		LogHelper.info("Get topupCardEMonthError text:" + text);
		return text;
	}

	public static String getTopupCardEYearError(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper
				.swipeElementToTop(driver, topupCardEYearError(driver));
		String text = topupCardEYearError(driver).getText();
		LogHelper.info("Get topupCardEYearError text:" + text);
		return text;
	}

	public static String getTopupCardnameError(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver, topupCardnameError(driver));
		String text = topupCardnameError(driver).getText();
		LogHelper.info("Get topupCardnameError text:" + text);
		return text;
	}

	public static String getTopupCardNumberError(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver,
				topupCardNumberError(driver));
		String text = topupCardNumberError(driver).getText();
		LogHelper.info("Get topupCardNumberError text:" + text);
		return text;
	}

	public static String getTopupPasswordError(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipetoButtom(driver);
		String text = topupPasswordError(driver).getText();
		LogHelper.info("Get topupPasswordError text:" + text);
		return text;
	}
}
