/**
 * 
 */
package com.LottoNZ.AutoSLTest.WebTest.Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

import org.jfree.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author mrawal
 */
public class LottoDipsPage extends PageBase {

	public static String noOfLottoLines;

	public static String noOfPBLines;
	public static String noOfStrikeLines;
	public static WebElement luckyDipContainer(WebDriver driver, String dipVal) {

		return find(driver, String.format("luckyDip%s", dipVal));
	}

	public static WebElement powerDipContainer(WebDriver driver, String dipVal) {
		MobileElement me = (MobileElement) find(driver,
				String.format("tripleDip$14Dollars", dipVal));
		;
		me.swipe(SwipeElementDirection.LEFT, 5000);
		return find(driver, String.format("powerDip$%sDollars", dipVal));
	}

	/**
	 * Select a dip, verify its value and number of lines
	 * 
	 * @param driver
	 * @param dipVal
	 * @param numOfLines
	 */
	public static void selectaLuckyDip(WebDriver driver, String dipVal,
			int numOfLines) {

		Log.info("Select a lucky dip with amount: " + dipVal);
		luckyDipContainer(driver, dipVal).click();
		LottoEcommpage.verifyLottoLinesoneCom(driver, numOfLines);
		LottoEcommpage.verifyPBLinesoneCom(driver, 0);
		LottoEcommpage.verifyStrikeLinesoneCom(driver, 0);
		LottoEcommpage.verifyTicketTotaleCom(driver, dipVal);

	}

	/**
	 * Select a dip, verify its value and number of lines
	 * 
	 * @param driver
	 * @param dipVal
	 * @param numOfLottoLines
	 * @param numOfPBLines
	 */
	public static void selectaPowerDip(WebDriver driver, String dipVal,
			int numOfLottoLines, int numOfPBLines) {

		Log.info("Select a power dip with amount: " + dipVal);
		powerDipContainer(driver, dipVal).click();
		LottoEcommpage.verifyLottoLinesoneCom(driver, numOfLottoLines);
		LottoEcommpage.verifyPBLinesoneCom(driver, numOfPBLines);
		LottoEcommpage.verifyStrikeLinesoneCom(driver, 0);
		LottoEcommpage.verifyTicketTotaleCom(driver, dipVal);

	}

	/**
	 * Select a dip, verify its value and number of lines
	 * 
	 * @param driver
	 * @param dipVal
	 * @param numOfLottoLines
	 * @param numOfPBLines
	 * @param numOfStrikeLines
	 */
	public static void selectaTripleDip(WebDriver driver, String dipVal,
			int numOfLottoLines, int numOfPBLines, int numOfStrikeLines) {

		Log.info("Select a triple dip with amount: " + dipVal);
		tripleDipContainer(driver, dipVal).click();
		LottoEcommpage.verifyLottoLinesoneCom(driver, numOfLottoLines);
		LottoEcommpage.verifyPBLinesoneCom(driver, numOfPBLines);
		LottoEcommpage.verifyStrikeLinesoneCom(driver, numOfStrikeLines);
		LottoEcommpage.verifyTicketTotaleCom(driver, dipVal);

	}

	public static WebElement thisDipHasLottolines(WebDriver driver,
			int numOfLines) {

		return find(driver, String.format("thisDipHas%sLottolines", numOfLines));
	}

	public static WebElement tripleDipContainer(WebDriver driver, String dipVal) {

		return find(driver, String.format("tripleDip%s", dipVal));
	}

	/**
	 * verify its value and number of lines
	 * 
	 * @param driver
	 * @param dipVal
	 * @param numOfLottoLines
	 * @param numOfPBLines
	 */
	public static void verifyaPowerDip(WebDriver driver, String dipVal,
			int numOfLottoLines, int numOfPBLines) {

		LottoEcommpage.verifyLottoLinesoneCom(driver, numOfLottoLines);
		LottoEcommpage.verifyPBLinesoneCom(driver, numOfPBLines);
		LottoEcommpage.verifyStrikeLinesoneCom(driver, 0);
		LottoEcommpage.verifyTicketTotaleCom(driver, dipVal);

	}

	/**
	 * verify its value and number of lines
	 * 
	 * @param driver
	 * @param dipVal
	 * @param numOfLottoLines
	 * @param numOfPBLines
	 * @param numOfStrikeLines
	 */
	public static void verifyaTripleDip(WebDriver driver, String dipVal,
			int numOfLottoLines, int numOfPBLines, int numOfStrikeLines) {

		LottoEcommpage.verifyLottoLinesoneCom(driver, numOfLottoLines);
		LottoEcommpage.verifyPBLinesoneCom(driver, numOfPBLines);
		LottoEcommpage.verifyStrikeLinesoneCom(driver, numOfStrikeLines);
		LottoEcommpage.verifyTicketTotaleCom(driver, dipVal);

	}

	/**
	 * verify its value and number of lines
	 * 
	 * @param driver
	 * @param dipVal
	 * @param numOfLines
	 */
	public static void verifyLuckyDipinfoOneCom(WebDriver driver,
			String dipVal, int numOfLines) {

		LottoEcommpage.verifyLottoLinesoneCom(driver, numOfLines);
		LottoEcommpage.verifyPBLinesoneCom(driver, 0);
		LottoEcommpage.verifyStrikeLinesoneCom(driver, 0);
		LottoEcommpage.verifyTicketTotaleCom(driver, dipVal);

	}

	public LottoDipsPage(WebDriver driver) {
		super(driver);

	}
}
