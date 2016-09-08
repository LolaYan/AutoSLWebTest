/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Driver.LottoBipType;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;

/**
 * @author mrawal
 */
public class androidLottoDipPage extends _AndroidBasePage {

	public static String noOfLottoLines;
	public static String noOfPBLines;
	public static String noOfStrikeLines;

	public static void loaded(AppiumDriver driver) throws InterruptedException {

		androidNavBarPage.navigateToHomepage(driver);
		androidLottoPage.clickBuyaDIP(driver);

	}

	public static void loadedviaMenu(AppiumDriver driver)
			throws InterruptedException {

		androidNavBarPage.navigateToMenu(driver);
		androidNavBarPage.clickMenuGamePowerball(driver);
		androidLottoPage.clickBuyaDIP(driver);

	}

	/**
	 * Page Element
	 */
	// Power Dip Selection
	public static WebElement powerDipContainer(AppiumDriver driver,
			String dipVal) throws InterruptedException {
		/*
		 * MobileElement me = (MobileElement) find(driver,
		 * "tripleDip$14Dollars"); me.swipe(SwipeElementDirection.LEFT, 5000);
		 */
		mobileSwipeHelper.swipeLeft(driver);
		// moveHeadingtoTop(driver, "Power");
		return find(driver, String.format("powerDip$%sDollars", dipVal));
	}

	// triple dip heading
	public static WebElement PowerDipHeading(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "power dip heading");
	}

	public static WebElement thisDipHasLottolines(AppiumDriver driver,
			int numOfLines) throws InterruptedException {

		return find(driver, String.format("thisDipHas%sLottolines", numOfLines));
	}

	// Triple Dip Selection
	public static WebElement tripleDipContainer(AppiumDriver driver,
			String dipVal) throws InterruptedException {
		moveHeadingtoTop(driver, "Triple");
		return find(driver, String.format("tripleDip$%sDollars", dipVal));
	}

	// triple dip heading
	public static WebElement TripleDipHeading(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "triple dip heading");
	}

	// Lucky Dip Selection
	public static WebElement luckyDipContainer(AppiumDriver driver,
			String dipVal) throws InterruptedException {
		mobileSwipeHelper.swipeLeft(driver);
		mobileSwipeHelper.swipeLeft(driver);
		// moveHeadingtoTop(driver, "Lucky");
		return find(driver, String.format("luckyDip$%sDollars", dipVal));
	}

	// triple dip heading
	public static WebElement luckyDipHeading(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "lucky dip heading");
	}

	/**
	 * Page Method
	 * 
	 * @throws InterruptedException
	 */
	public static void moveHeadingtoTop(AppiumDriver driver,
			String DipHeaderType) throws InterruptedException {
		LogHelper.info(" ^ Move DIP Header up: " + DipHeaderType);
		switch (DipHeaderType) {
		case "Triple":
			mobileSwipeHelper.swipeElementToTop(driver,
					TripleDipHeading(driver));
			break;
		case "Power":
			mobileSwipeHelper
					.swipeElementToTop(driver, PowerDipHeading(driver));
			break;
		case "Lucky":
			mobileSwipeHelper
					.swipeElementToTop(driver, luckyDipHeading(driver));
			break;
		}
	}

	public static void selectaLuckyDip(AppiumDriver driver, String dipVal,
			int numOfLines) throws InterruptedException {

		LogHelper.info("Select a lucky dip with amount: " + dipVal);
		luckyDipContainer(driver, dipVal).click();
		androidLottoEcommPage.verifyLottoLinesoneCom(driver, numOfLines);
		androidLottoEcommPage.verifyPBLinesoneCom(driver, 0);
		androidLottoEcommPage.verifyStrikeLinesoneCom(driver, 0);

	}

	public static void selectaPowerDip(AppiumDriver driver, String dipVal,
			int numOfLottoLines, int numOfPBLines) throws InterruptedException {

		LogHelper.info("Select a power dip with amount: " + dipVal);
		powerDipContainer(driver, dipVal).click();
		androidLottoEcommPage.verifyLottoLinesoneCom(driver, numOfLottoLines);
		androidLottoEcommPage.verifyPBLinesoneCom(driver, numOfPBLines);
		androidLottoEcommPage.verifyStrikeLinesoneCom(driver, 0);

	}

	public static void selectaTripleDip(AppiumDriver driver, String dipVal,
			int numOfLottoLines, int numOfPBLines, int numOfStrikeLines,
			String dipCost) throws InterruptedException {

		LogHelper.info("Select a triple dip with amount: " + dipVal);
		tripleDipContainer(driver, dipVal).click();
		androidLottoEcommPage.verifyLottoLinesoneCom(driver, numOfLottoLines);
		androidLottoEcommPage.verifyPBLinesoneCom(driver, numOfPBLines);
		androidLottoEcommPage.verifyStrikeLinesoneCom(driver, numOfStrikeLines);

	}

	public static void selectDip(AppiumDriver driver, LottoBipType LottoBipType)
			throws InterruptedException {

		LogHelper.info("Select DIP: " + LottoBipType.toString());
		String dipVal = "14";
		WebElement DipElement = tripleDipContainer(driver, dipVal);
		switch (LottoBipType) {
		case BasicTriple:
			dipVal = "14";
			DipElement = tripleDipContainer(driver, dipVal);
			break;
		case SuperTriple:
			dipVal = "16";
			DipElement = tripleDipContainer(driver, dipVal);
			break;
		case SuperPlusTriple:
			dipVal = "20";
			DipElement = tripleDipContainer(driver, dipVal);
			break;
		case MegaTriple:
			dipVal = "26";
			DipElement = tripleDipContainer(driver, dipVal);
			break;
		case StarterPower:
			dipVal = "9.60";
			DipElement = powerDipContainer(driver, dipVal);
			break;
		case BasicPower:
			dipVal = "12";
			DipElement = powerDipContainer(driver, dipVal);
			break;
		case SuperPower:
			dipVal = "18";
			DipElement = powerDipContainer(driver, dipVal);
			break;
		case MegaPower:
			dipVal = "24";
			DipElement = powerDipContainer(driver, dipVal);
			break;
		case StarterLucky:
			dipVal = "4.80";
			DipElement = luckyDipContainer(driver, dipVal);
			break;
		case BasicLucky:
			dipVal = "6";
			DipElement = luckyDipContainer(driver, dipVal);
			break;
		case SuperLucky:
			dipVal = "9";
			DipElement = luckyDipContainer(driver, dipVal);
			break;
		case MegaLucky:
			dipVal = "12";
			DipElement = luckyDipContainer(driver, dipVal);
			break;
		default:
			DipElement = tripleDipContainer(driver, dipVal);
			break;

		}

		DipElement.click();

	}

	public static void verifyaPowerDip(AppiumDriver driver, String dipVal,
			int numOfLottoLines, int numOfPBLines, String dipCost)
			throws InterruptedException {

		androidLottoEcommPage.verifyLottoLinesoneCom(driver, numOfLottoLines);
		androidLottoEcommPage.verifyPBLinesoneCom(driver, numOfPBLines);
		androidLottoEcommPage.verifyStrikeLinesoneCom(driver, 0);
		androidLottoEcommPage.verifyTicketTotaleCom(driver, dipVal);

	}

	public static void verifyaTripleDip(AppiumDriver driver, String dipVal,
			int numOfLottoLines, int numOfPBLines, int numOfStrikeLines)
			throws InterruptedException {

		androidLottoEcommPage.verifyLottoLinesoneCom(driver, numOfLottoLines);
		androidLottoEcommPage.verifyPBLinesoneCom(driver, numOfPBLines);
		androidLottoEcommPage.verifyStrikeLinesoneCom(driver, numOfStrikeLines);
		androidLottoEcommPage.verifyTicketTotaleCom(driver, dipVal);

	}

	public static void verifyLuckyDipinfoOneCom(AppiumDriver driver,
			String dipVal, int numOfLines) throws InterruptedException {

		androidLottoEcommPage.verifyLottoLinesoneCom(driver, numOfLines);
		androidLottoEcommPage.verifyPBLinesoneCom(driver, 0);
		androidLottoEcommPage.verifyStrikeLinesoneCom(driver, 0);
		androidLottoEcommPage.verifyTicketTotaleCom(driver, dipVal);

	}
}
