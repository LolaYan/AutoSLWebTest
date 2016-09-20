/**
 * 
 */
package com.LottoNZ.AutoSLTest.WebTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.WebTest.Pages.LoginModal.LoginModalwithUser;
import com.LottoNZ.AutoSLTest.WebTest.Tests.Constants;

/**
 * @author mrawal
 * 
 * 
 */
public class LottoEcommpage extends PageBase {

	public static WebElement buyButton(WebDriver driver) {
		LogHelper.info("Looking for buyButton");
		return driver.findElement(By.id("buyButton"));
	}

	/**
	 * 
	 * @param driver
	 * @param email
	 * @param password
	 * @throws Exception
	 */
	public static void buyLoginOnDemand(WebDriver driver, String email,
			String password) throws Exception {
		clickBuyButton(driver);
		LoginModalwithUser.loginFromModal(driver, email, password);
		Assert.assertTrue(buyButton(driver).isDisplayed(),
				"Buy button not displayed after login");
	}

	/**
	 * 
	 * @param driver
	 * @param email
	 * @param password
	 * @throws Exception
	 */
	public static void buySignUpOnDemand(WebDriver driver) throws Exception {
		clickBuyButton(driver);
		LoginModalwithUser.selectSignUpLink(driver);

	}

	/**
	 * Click on the buy button
	 * 
	 * @param driver
	 */
	public static void clickBuyButton(WebDriver driver) {
		LogHelper.info("Clicks on buy button");
		buyButton(driver).click();
	}

	public static void clickmaximiseBar(WebDriver driver) {
		LogHelper.info("Click maximiseBar ");
		maximiseBar(driver).click();
	}

	public static void clickminimiseBar(WebDriver driver) {
		LogHelper.info("Click minimiseBar ");
		minimiseBar(driver).click();
	}

	public static WebElement lottoLineNumEcom(WebDriver driver, int lineNum) {
		LogHelper.info("Looking for Number of lotto lines in ecommerceBar");
		return driver.findElement(By.id(String.format(
				lineNum == 1 ? "youHaveSelected%sLINEOfLotto"
						: "youHaveSelected%sLINESOfLotto", lineNum)));
	}

	public static WebElement maximiseBar(WebDriver driver) {
		LogHelper.info("Looking for maximiseBar");
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try {
			Thread.sleep(500);

		} catch (InterruptedException e) {
			LogHelper.error(e.getMessage());
		}
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("maximiseBar")));
	}

	public static WebElement minimiseBar(WebDriver driver) {
		LogHelper.info("Looking for minimiseBar");
		WebDriverWait wait = new WebDriverWait(driver, 90);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("minimiseBar")));
	}

	public static WebElement powerballLineNumEcom(WebDriver driver, int lineNum) {
		LogHelper.info("Looking for Number of lotto lines in ecommerceBar");
		return driver.findElement(By.id(String.format(
				lineNum == 1 ? "youHaveSelected%sLINEOfPowerball"
						: "youHaveSelected%sLINESOfPowerball", lineNum)));
	}

	public static WebElement strikeLineNumEcom(WebDriver driver, int lineNum) {
		LogHelper.info("Looking for Number of lotto lines in ecommerceBar");
		return driver.findElement(By.id(String.format(
				lineNum == 1 ? "youHaveSelected%sLINEOfStrike"
						: "youHaveSelected%sLINESOfStrike", lineNum)));
	}

	public static WebElement ticketTotal(WebDriver driver) {
		LogHelper.info("Looking for ticketTotal");
		return driver.findElement(By.id("ticketTotal"));
	}

	/**
	 * maximise menu bar verify number of lotto lines and minimize it
	 * 
	 * @param driver
	 * @param lines
	 */
	public static void verifyLottoLinesoneCom(WebDriver driver, int lines) {
		clickmaximiseBar(driver);
		Assert.assertTrue(lottoLineNumEcom(driver, lines).isDisplayed(),
				"Number of Lotto lines on eCommerce bars: " + lines);
		clickminimiseBar(driver);
	}

	/**
	 * maximise menu bar verify number of PB lines and minimize it
	 * 
	 * @param driver
	 * @param lines
	 */
	public static void verifyPBLinesoneCom(WebDriver driver, int lines) {
		clickmaximiseBar(driver);
		Assert.assertTrue(powerballLineNumEcom(driver, lines).isDisplayed(),
				"Number of PB lines on eCommerce bars: " + lines);
		clickminimiseBar(driver);
	}

	/**
	 * maximise menu bar verify number of strike lines and minimize it
	 * 
	 * @param driver
	 * @param lines
	 */
	public static void verifyStrikeLinesoneCom(WebDriver driver, int lines) {
		clickmaximiseBar(driver);
		Assert.assertTrue(strikeLineNumEcom(driver, lines).isDisplayed(),
				"Number of strike lines on eCommerce bars: " + lines);
		clickminimiseBar(driver);
	}

	/**
	 * Verify TicketTotal values from ecommerce bar
	 * 
	 * @param driver
	 * @param amt
	 */
	public static void verifyTicketTotaleCom(WebDriver driver, String amt) {
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

	public LottoEcommpage(WebDriver driver) {
		super(driver);

		driver.get(Constants.lottoPYOURL);

	}
}
