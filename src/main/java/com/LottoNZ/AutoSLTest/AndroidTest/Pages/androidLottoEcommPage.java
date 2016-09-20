/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.WebTest.Pages.LoginModal.LoginModalwithUser;

public class androidLottoEcommPage extends _AndroidBasePage {

	/**
	 * Page Element
	 */
	public static WebElement buyButton(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Looking for buyButton");
		return find(driver, "buyButton");
	}

	public static void OpenLottoSummaryBar(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Open Lotto Lines Summary Bar ");
		if (isElementExists(
				driver,
				By.xpath("//*[@content-desc=\"ticketTotal\"]/*[@text=\"TOTAL\"]")) == false) {

			totalCost(driver).click();
		}
	}

	public static WebElement lottoLineNumEcom(AppiumDriver driver, int lineNum) {
		LogHelper.info("Looking for Number of lotto lines in ecommerceBar");
		return driver.findElement(By.id(String.format(
				lineNum == 1 ? "youHaveSelected%sLINEOfLotto"
						: "youHaveSelected%sLINESOfLotto", lineNum)));
	}

	public static WebElement maximiseBar(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Looking for maximiseBar");
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try {
			Thread.sleep(500);

		} catch (InterruptedException e) {
			LogHelper.error(e.getMessage());
		}
		return wait.until(ExpectedConditions.visibilityOf(ticketTotal(driver)));
	}

	public static WebElement minimiseBar(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Looking for minimiseBar");
		WebDriverWait wait = new WebDriverWait(driver, 90);
		return wait.until(ExpectedConditions.visibilityOf(ticketTotal(driver)));
	}

	public static WebElement powerballLineNumEcom(AppiumDriver driver,
			int lineNum) {
		LogHelper.info("Looking for Number of PB lines in ecommerceBar");
		return driver.findElement(By.id(String.format(
				lineNum == 1 ? "youHaveSelected%sLINEOfPowerball"
						: "youHaveSelected%sLINESOfPowerball", lineNum)));
	}

	// SAVE only for fav creation page
	public static WebElement saveFavButton(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Looking for SAVE Button");
		return find(driver, "SAVE");
	}

	public static WebElement strikeLineNumEcom(AppiumDriver driver, int lineNum) {
		LogHelper.info("Looking for Number of Strike lines in ecommerceBar");
		return driver.findElement(By.id(String.format(
				lineNum == 1 ? "youHaveSelected%sLINEOfStrike"
						: "youHaveSelected%sLINESOfStrike", lineNum)));
	}

	// summaryOfLotto
	public static WebElement summaryOfLotto(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Looking for summaryOfLotto");
		// WebElement ele=
		// findByXpath(driver,"//*[@content-desc=\"summaryOfLotto\"]/*[@class=\"android.widget.TextView\"]");
		return find(driver, "LINESOfLotto");
	}

	// summaryOfPowerball
	public static WebElement summaryOfPowerball(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Looking for summaryOfPowerball");
		// WebElement ele= findByXpath( driver,
		// "//*[@content-desc=\"summaryOfPowerball\"]/*[@class=\"android.widget.TextView\"]");
		return find(driver, "LINESOfPowerball");
	}

	// summaryOfStrike
	public static WebElement summaryOfStrike(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Looking for summaryOfStrike");
		// WebElement ele= findByXpath(driver,
		// "//*[@content-desc=\"summaryOfStrike\"]/*[@class=\"android.widget.TextView\"]");
		return find(driver, "LINESOfStrike");
	}

	public static WebElement ticketTotal(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Looking for totalCost");
		return find(driver, "ticketTotal");
	}

	public static WebElement totalCost(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Looking for totalCost");
		return find(driver, "totalCost");
	}

	public static WebElement totalCostValue(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Looking for totalCost value");
		// WebElement ele=findByXpath(driver,
		// "//*[@content-desc=\"totalCost\"]/*[@class=\"android.widget.TextView\"]");
		return find(driver, "Dollars");
	}

	/**
	 * Page Method
	 */
	public static void buyLoginOnDemand(AppiumDriver driver, String email,
			String password) throws Exception {
		clickBuyButton(driver);
		LoginModalwithUser.loginFromModal(driver, email, password);
		Assert.assertTrue(buyButton(driver).isDisplayed(),
				"Buy button not displayed after login");
	}

	public static void buySignUpOnDemand(AppiumDriver driver) throws Exception {
		clickBuyButton(driver);
		LoginModalwithUser.selectSignUpLink(driver);

	}

	public static void clickBuyButton(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Clicks on buy button");
		buyButton(driver).click();
	}

	public static void clickmaximiseBar(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click maximiseBar ");
		maximiseBar(driver).click();
	}

	public static void clickminimiseBar(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click minimiseBar ");
		minimiseBar(driver).click();
	}

	// saveFavButton
	public static void clickSaveFavButton(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Clicks on Save Fav button");
		saveFavButton(driver).click();
	}

	public static void CloseLottoSummaryBar(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Close Lotto Lines Summary Bar ");
		if (isElementExists(
				driver,
				By.xpath("//*[@content-desc=\"ticketTotal\"]/*[@text=\"TOTAL\"]")) == true) {

			totalCost(driver).click();
		}
	}

	public static String getLottoLines(AppiumDriver driver)
			throws InterruptedException {
		String actualLottoLinesNum = summaryOfLotto(driver).getText()
				.toString();
		LogHelper.info("getLottoLines:" + actualLottoLinesNum);
		return actualLottoLinesNum;
	}

	public static String getPowerballLines(AppiumDriver driver)
			throws InterruptedException {
		String actualPowerballLinesNum = summaryOfPowerball(driver).getText()
				.toString();
		LogHelper.info("getPowerballLines:" + actualPowerballLinesNum);
		return actualPowerballLinesNum;
	}

	public static String getStrikeLines(AppiumDriver driver)
			throws InterruptedException {
		String actualStrikeLinesNum = summaryOfStrike(driver).getText()
				.toString();
		LogHelper.info("getStrikeLines:" + actualStrikeLinesNum);
		return actualStrikeLinesNum;
	}

	public static String getTotalCostValue(AppiumDriver driver)
			throws InterruptedException {
		String actualTotalCost = totalCostValue(driver).getText().toString();
		LogHelper.info("getTotalCost:" + actualTotalCost);
		return actualTotalCost;
	}

	public static void verifyLottoLinesoneCom(AppiumDriver driver, int lines)
			throws InterruptedException {
		clickmaximiseBar(driver);
		Assert.assertTrue(lottoLineNumEcom(driver, lines).isDisplayed(),
				"Number of Lotto lines on eCommerce bars: " + lines);
		clickminimiseBar(driver);
	}

	public static void verifyPBLinesoneCom(AppiumDriver driver, int lines)
			throws InterruptedException {
		clickmaximiseBar(driver);
		Assert.assertTrue(powerballLineNumEcom(driver, lines).isDisplayed(),
				"Number of PB lines on eCommerce bars: " + lines);
		clickminimiseBar(driver);
	}

	public static void verifyStrikeLinesoneCom(AppiumDriver driver, int lines)
			throws InterruptedException {
		clickmaximiseBar(driver);
		Assert.assertTrue(strikeLineNumEcom(driver, lines).isDisplayed(),
				"Number of strike lines on eCommerce bars: " + lines);
		clickminimiseBar(driver);
	}

	public static void verifyTicketTotaleCom(AppiumDriver driver, String amt)
			throws InterruptedException {
		clickmaximiseBar(driver);
		String ticketTotal = ticketTotal(driver).getText().replace("$", "");
		if (ticketTotal.contains(".00")) {
			LogHelper.info("Trimming .00 from " + ticketTotal);
			ticketTotal = ticketTotal.replace(".00", "");
		} else if (ticketTotal.contains(".")) {
			LogHelper.info("Trimming . from " + ticketTotal);
			ticketTotal = ticketTotal.replace(".", "");

		}
		Assert.assertTrue(ticketTotal.contains(amt), String.format(
				"Verifies total ticket amount. Expected: %s Actual: %s", amt,
				ticketTotal));
		clickminimiseBar(driver);
	}
}
