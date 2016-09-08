/**
 * 
 */
package com.LottoNZ.AutoSLTest.WebTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;

/**
 * @author Lola
 * @email lyan@planittesting.co.nz Note: define the findelement methods here in
 *        LottoHomePage
 */
public class LottoTopupPage extends PageBase {

	public static WebElement cardNumInput(WebDriver driver) {
		return driver.findElement((By.id("topup-card-number-input")));
	}

	public static void cardNumInput(WebDriver driver, String ccNum) {
		LogHelper.info("enter CC number");
		cardNumInput(driver).sendKeys(ccNum);
	}

	public static void clickSubmitBtn() {
		try {
			LogHelper.info("Click submit button");
			Thread.sleep(1000);
			submitBtn().click();
		} catch (Exception e) {
			LogHelper.error(e.getMessage());
		}

	}

	public static WebElement cvcInput(WebDriver driver) {
		return driver.findElement((By.id("topup-cvc-input")));
	}

	public static WebElement expiryMonthInput(WebDriver driver) {
		return driver.findElement((By.id("topup-expiry-month-input")));
	}

	public static WebElement expiryYearInput(WebDriver driver) {
		return driver.findElement((By.id("topup-expiry-year-input")));
	}

	public static void insertCVC(WebDriver driver, String cvc) {
		LogHelper.info("enter 3 digit CVC");
		nameOnCCInput(driver).sendKeys(cvc);
	}

	public static void insertMonth(WebDriver driver, String monthVal) {
		LogHelper.info("enter 2 digit MM value");
		expiryMonthInput(driver).sendKeys(monthVal);
	}

	public static void insertName(WebDriver driver, String name) {
		LogHelper.info("enter name on CC ");
		nameOnCCInput(driver).sendKeys(name);
	}

	public static void insertPassword(WebDriver driver, String password) {
		LogHelper.info("enter password");
		passwordInput(driver).sendKeys(password);
	}

	public static void insertYear(WebDriver driver, String yearVal) {
		LogHelper.info("enter 2 digit YY value");

		expiryYearInput(driver).sendKeys(yearVal);
	}

	public static void insterTopupAmt(WebDriver driver, String amount) {
		LogHelper.info("enter amount");
		try {
			Thread.sleep(5000);
			topUpAmtInput(driver).click();
			topUpAmtInput(driver).clear();
			topUpAmtInput(driver).sendKeys(amount);
		} catch (InterruptedException e) {
			LogHelper.error(e.getMessage());
		}

	}

	public static WebElement nameOnCCInput(WebDriver driver) {
		return driver.findElement((By.id("topup-name-on-card-input")));
	}

	public static WebElement passwordInput(WebDriver driver) {
		return driver.findElement((By.id("topup-mylotto-password-input")));
	}

	public static WebElement submitBtn() {
		return driver.findElement((By.id("topup-submit-button")));
	}

	public static WebElement topUpAmtInput(WebDriver driver) {
		return driver.findElement((By.id("topup-deposit-amount-input")));
	}

	/***
	 * Select option to top up with CC Enter form details Top up and register a
	 * new card
	 * 
	 * @param amount
	 * @param cardNum
	 * @param month
	 * @param year
	 * @param name
	 * @param cvc
	 * @param password
	 * @throws InterruptedException
	 */
	public static void topUpwithCCfortheFirstTime(WebDriver driver,
			String amount, String cardNum, String month, String year,
			String name, String cvc, String password)
			throws InterruptedException {
		NavBarPage.navigateToTopup(driver);
		NavBarPage.selecttopUpwithCC(driver);
		insterTopupAmt(driver, amount);
		cardNumInput(driver, cardNum);
		insertMonth(driver, month);
		insertYear(driver, year);
		insertName(driver, name);
		insertCVC(driver, cvc);
		insertPassword(driver, password);
		LogHelper.info("Your current Balance Amount: "
				+ yourCurrentBalAmtText(driver).getText());
		clickSubmitBtn();
		Assert.assertTrue(
				yourCurrentBalAmtText(driver).getText().contains(amount),
				"Your current Balance Amount: "
						+ yourCurrentBalAmtText(driver).getText());
		Thread.sleep(2000);
	}

	public static WebElement yourCurrentBalAmtText(WebDriver driver) {
		return driver.findElement((By.id("your-current-balance-amount")));
	}

	public LottoTopupPage(WebDriver driver) {
		super(driver);

	}
}
