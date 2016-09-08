/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Utils.DataGenerator;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;

public class androidLottoPYOPage extends _AndroidBasePage {

	public static void loaded(AppiumDriver driver) throws InterruptedException {
		androidNavBarPage.navigateToHomepage(driver);
		androidLottoPage.clickPickYourOwn(driver);

	}

	/*********************************************************
	 * Page Element
	 *******************************************************/
	public static WebElement lottoAutofill(AppiumDriver driver, int lineNumber)
			throws InterruptedException {

		lineNumber = lineNumber - 1;
		String line = Integer.toString(lineNumber);
		return find(driver, String.format("autofillLine%s1", line));
	}

	public static WebElement lottoNumber(AppiumDriver driver, int lottoNumberArr)
			throws InterruptedException {

		return find(driver, "lottoNumber" + Integer.toString(lottoNumberArr));
	}

	// lottoNumberSelector
	public static WebElement lottoNumberSelector(AppiumDriver driver)
			throws InterruptedException {

		return find(driver, "lottoNumberSelector");
	}

	public static WebElement lottoRefreshLine(AppiumDriver driver,
			int lineNumber) throws InterruptedException {
		lineNumber = lineNumber - 1;
		String line = Integer.toString(lineNumber);
		return find(driver, String.format("refreshLine%s1", line));
	}

	public static WebElement powerballNumber(AppiumDriver driver, String number)
			throws InterruptedException {
		return find(driver, "powerballNumber" + number);
	}

	public static WebElement PowerballOFF(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "OFF");
	}

	public static WebElement PowerballON(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "ON");
	}

	public static WebElement strikeAutofill(AppiumDriver driver, int lineNumber)
			throws InterruptedException {

		lineNumber = lineNumber - 1;
		String line = Integer.toString(lineNumber);
		return find(driver, String.format("strikeAutoFillLine%s1", line));
	}

	public static WebElement strikeNumber(AppiumDriver driver,
			int lottoNumberArr) throws InterruptedException {

		return find(driver, "strikeNumber" + Integer.toString(lottoNumberArr));
	}

	// strikeNumberSelector
	public static WebElement strikeNumberSelector(AppiumDriver driver)
			throws InterruptedException {

		return find(driver, "strikeNumberSelector");
	}

	public static WebElement strikeRefreshLine(AppiumDriver driver,
			int lineNumber) throws InterruptedException {
		lineNumber = lineNumber - 1;
		String line = Integer.toString(lineNumber);
		return find(driver, String.format("refreshLine%s1", line));
	}

	/*******************************************************
	 * Page Method
	 *******************************************************/
	public static void addLottoLine(AppiumDriver driver, int[] lottoNumberArr,
			int powerball, int lineNumber) throws Exception {
		int length = lottoNumberArr.length;
		// Before Adding lotto line
		swipeupLottoNumberSelector(driver);
		// moveLottoLineup(driver, lottoAutofill(driver, lineNumber));
		// Adding lotto line
		if (DataGenerator.duplicates(lottoNumberArr) == false && length == 6
				&& DataGenerator.biggerThanMaxNum(lottoNumberArr, 40) == false) {
			LogHelper.info(" Adding Lotto Line " + lineNumber + "---------- ");
			for (int i = 0; i < length; i++) {
				int lottoNum = lottoNumberArr[i];
				LogHelper.info(" Click " + i + " > Lotto " + lottoNum
						+ " Element Text:"
						+ lottoNumber(driver, lottoNum).getText());
				clickLottoNumber(driver, lottoNum);
				// Thread.sleep(1000);
			}

		} else {

			LogHelper
					.info("LottoNumber Array have duplicates number, or the length is not 6, or The biggest number is over 40");
		}

		// Adding powerball
		if (powerball < 1 && powerball > 10)
			powerball = 10;
		clickPowerballNumber(driver, Integer.toString(powerball));
		Thread.sleep(1000);

		// Post Action
	}

	public static void addStrikeLine(AppiumDriver driver, int[] strikeNumberArr)
			throws Exception {

		swipeupStrikeNumberSelector(driver);
		int length = strikeNumberArr.length;
		if (DataGenerator.duplicates(strikeNumberArr) == false && length == 4
				&& DataGenerator.biggerThanMaxNum(strikeNumberArr, 40) == false) {
			for (int i = 0; i < length; i++) {
				clickStrikeNumber(driver, strikeNumberArr[i]);
				Thread.sleep(1000);
			}

		} else {

			LogHelper
					.info("strikeNumber Array have duplicates number, or the length is not 6, or The biggest number is over 40");
		}
		Thread.sleep(1000);
	}

	public static void clickLottoAutoFill(AppiumDriver driver, int lineNumber)
			throws Exception {
		if (lineNumber >= 1) {
			mobileSwipeHelper.swipeElementToTop(driver,
					lottoAutofill(driver, lineNumber));
			LogHelper.info(" Click Lotto Auto Fill");
			lottoAutofill(driver, lineNumber).click();
		}
	}

	public static void clickLottoNumber(AppiumDriver driver, int lottoNumber)
			throws Exception {
		LogHelper.info(" Click Lotto Number: " + lottoNumber);
		if (isElementExists(driver,
				By.name("lottoNumber" + Integer.toString(lottoNumber))) == true) {
			lottoNumber(driver, lottoNumber).click();

		}

	}

	public static void clickPowerballNumber(AppiumDriver driver, String number)
			throws Exception {

		LogHelper.info(" Click powerball Number: " + number);
		powerballNumber(driver, number).click();
		Thread.sleep(2000);
	}

	public static void clickPowerballNumber(AppiumDriver driver, String number,
			int lineNumber) throws Exception {

		clickPowerballNumber(driver, number);
		lottoRefreshLine(driver, lineNumber);
		mobileSwipeHelper.swipeElementToTop(driver,
				lottoAutofill(driver, lineNumber));
		// Call find element to refresh the position of page elements
		lottoNumber(driver, 1);

	}

	public static void clickStrikeAutoFill(AppiumDriver driver, int lineNumber)
			throws Exception {
		if (lineNumber >= 1) {
			mobileSwipeHelper.swipeElementToTop(driver,
					strikeAutofill(driver, lineNumber));
			LogHelper.info(" Click Strike Auto Fill");
			strikeAutofill(driver, lineNumber).click();
		}
	}

	public static void clickStrikeNumber(AppiumDriver driver, int strikeNumber)
			throws Exception {
		LogHelper.info(" Click Strike Number: " + strikeNumber);
		strikeNumber(driver, strikeNumber).click();

	}

	public static void moveLottoLineup(AppiumDriver driver, WebElement ele1)
			throws InterruptedException {
		Dimension size = driver.manage().window().getSize();
		Point location1 = ele1.getLocation();
		int startx = location1.getX();
		int starty = location1.getY();

		int endx = startx;
		int endy = starty - 120;
		driver.swipe(startx, starty, endx, endy, 3000);
	}

	public static void swipetoTopPage(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipetoTop(driver);
		mobileSwipeHelper.swipetoTop(driver);
	}

	// lottoNumberSelector
	public static void swipeupLottoNumberSelector(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper
				.swipeElementToTop(driver, lottoNumberSelector(driver));
	}

	public static void swipeupStrikeNumberSelector(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver,
				strikeNumberSelector(driver));
	}

	public static void swipeuptoShowStrikeEditor(AppiumDriver driver)
			throws InterruptedException {
		mobileSwipeHelper.swipeElementToTop(driver, lottoNumber(driver, 40));
	}

	public static void switchPowerballNumber(AppiumDriver driver, String Flag)
			throws Exception {
		LogHelper.info(" Switch Powerball Number - " + Flag);
		if (Flag.equals("ON")) {
			if (isElementExists(driver, By.name("ON")) == false) {
				PowerballOFF(driver).click();
			}

		} else {
			if (isElementExists(driver, By.name("OFF")) == false) {
				PowerballON(driver).click();
			}
		}

	}
}
