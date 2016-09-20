package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Utils.PropertyLoader;

/** Page object for the home page **/
public abstract class androidHomePage extends _AndroidBasePage {

	protected static String BuyadipButton_ContentDesc = "Buyadip";
	protected static String CheckresultsButton_ContentDesc = "Checkresults";
	protected static String PickyourownButtonn_ContentDesc = "Pickyourown";
	protected static String ScanNowButton_ContentDesc = "SCANNOW";
	
	private androidHomePage()
	{
		BuyadipButton_ContentDesc = PropertyLoader.loadElementContentDecsValue("BuyadipButton_ContentDesc");
		CheckresultsButton_ContentDesc = PropertyLoader.loadElementContentDecsValue("CheckresultsButton_ContentDesc");
		PickyourownButtonn_ContentDesc = PropertyLoader.loadElementContentDecsValue("PickyourownButtonn_ContentDesc");
		ScanNowButton_ContentDesc = PropertyLoader.loadElementContentDecsValue("ScanNowButton_ContentDesc");
	}
	
	public static void loaded(AppiumDriver driver) throws InterruptedException {
		androidNavBarPage.navigateToHomepage(driver);

	}

	/**
	 * Page Element
	 */
	// Buy a dip Button
	public static WebElement BuyadipButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, BuyadipButton_ContentDesc);
	}

	// Checkresults
	public static WebElement CheckresultsButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, CheckresultsButton_ContentDesc);
	}

	// Pickyourown
	public static WebElement PickyourownButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, PickyourownButtonn_ContentDesc);
	}

	// SCANNOW
	public static WebElement ScanNowButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver,ScanNowButton_ContentDesc);
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