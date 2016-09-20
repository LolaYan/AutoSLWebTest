/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;

/**
 * @author mrawal
 */
public class androidLottoPickDrawPage extends _AndroidBasePage {
	public static void loaded(AppiumDriver driver) throws InterruptedException {

		androidNavBarPage.navigateToMenu(driver);
		androidNavBarPage.clickMenuGamePowerball(driver);
	}

	/**
	 * Page Element
	 */
	// Upsell AddStrikeToYourTicket
	public static WebElement AddStrikeToYourTicket(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "AddStrikeToYourTicket");
	}

	//
	public static WebElement BuyTicketButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "BUY TICKET");
	}

	// Next draw
	public static WebElement NextDraw(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Next draw");
	}

	// viewTicketDetail
	public static WebElement viewTicketDetail(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "viewTicketDetail");
	}

	/**
	 * Page Method
	 */

	public static void clickAddStrikeUpsell(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver,
				AddStrikeToYourTicket(driver));
		AddStrikeToYourTicket(driver).click();
	}

	public static void clickBuyTicketButton(AppiumDriver driver)
			throws InterruptedException {
		// mobileSwipeHelper.swipeElementToTop(driver, BuyTicketButton(driver));
		BuyTicketButton(driver).click();
	}

	public static void clickNextDraw(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver, NextDraw(driver));
		NextDraw(driver).click();
	}

	public static void clickViewTicketDetail(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver, viewTicketDetail(driver));
		viewTicketDetail(driver).click();
	}

	// DIPWagerDetailsCost
	public static String GetDIPWagerDetailsCost(AppiumDriver driver)
			throws InterruptedException {
		By locator = By
				.xpath("//*[@content-desc=\"DIPWagerDetailsCost\"]/*[@class=\"android.widget.TextView\"]");
		WebElement ele;
		String value;
		if (mobileSwipeHelper.isElementExists(driver, locator) == true) {
			value = elements(driver, locator).get(2).getText();
		} else {
			value = null;
		}
		return value;
	}

	// DIPWagerDetailsNoOfDraws
	public static String GetDIPWagerDetailsNoOfDraws(AppiumDriver driver)
			throws InterruptedException {
		By locator = By
				.xpath("//*[@content-desc=\"DIPWagerDetailsNoOfDraws\"]/*[@class=\"android.widget.TextView\"]");
		WebElement ele;
		String value;
		if (mobileSwipeHelper.isElementExists(driver, locator) == true) {
			value = elements(driver, locator).get(1).getText();
		} else {
			value = null;
		}
		return value;
	}

	// TotalPurchaseCost
	public static String GetTotalPurchaseCost(AppiumDriver driver)
			throws InterruptedException {
		By locator = By
				.xpath("//*[@content-desc=\"TotalPurchaseCost\"]/*[@class=\"android.widget.TextView\"]");
		WebElement ele;
		String value;
		if (mobileSwipeHelper.isElementExists(driver, locator) == true) {
			value = elements(driver, locator).get(1).getText();
		} else {
			value = null;
		}
		return value;
	}

}
