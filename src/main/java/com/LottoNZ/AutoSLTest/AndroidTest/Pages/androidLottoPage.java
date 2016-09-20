/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;

/**
 * @author mrawal
 */
public class androidLottoPage extends _AndroidBasePage {

	public static void loaded(AppiumDriver driver) throws InterruptedException {

		androidNavBarPage.navigateToMenu(driver);
		androidNavBarPage.clickMenuGamePowerball(driver);
	}

	/**
	 * Page Element
	 */
	// Buy a dip Button
	public static WebElement BuyadipButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Buyadip");
	}

	// Checkresults
	public static WebElement CheckresultsButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Checkresults");
	}

	// Pickyourown
	public static WebElement PickyourownButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "PICK YOUR OWN");
	}

	// SCANNOW
	public static WebElement ScanNowButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "SCANNOW");
	}

	/**
	 * Page Method
	 */

	public static void clickBuyaDIP(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver, BuyadipButton(driver));
		BuyadipButton(driver).click();
	}

	public static void clickCheckResults(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver, BuyadipButton(driver));
		mobileSwipeHelper.swipeElementToTop(driver, CheckresultsButton(driver));
		CheckresultsButton(driver).click();
	}

	public static void clickPickYourOwn(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver, BuyadipButton(driver));
		PickyourownButton(driver).click();
	}

	// READ MORE

	public static void clickScanNow(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver, BuyadipButton(driver));
		mobileSwipeHelper.swipeElementToTop(driver, CheckresultsButton(driver));
		ScanNowButton(driver).click();
	}

}
