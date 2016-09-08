/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;

public class androidSignupCompleteAccountPage extends _AndroidBasePage {
	public static void loaded(AppiumDriver driver) throws InterruptedException {
		isElementExists(driver, By.name("bankAccountBank"));
	}

	/**
	 * Page Element
	 */

	// bankAccountBank
	public static WebElement bankAccountBankTextbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "bankAccountBank");
	}

	// bankAccountAccount
	public static WebElement bankAccountBaseBank(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "bankAccountAccount");
	}

	// bankAccountBranch
	public static WebElement bankAccountBranchTextbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "bankAccountBranch");
	}

	// bankAccountSuffix
	public static WebElement bankAccountSuffixTextbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "bankAccountSuffix");
	}

	public static WebElement OKBtn(AppiumDriver driver)
			throws InterruptedException {
		return findByName(driver, "OK");
	}

	// Wahoo, you're good to go!
	public static WebElement OKMsgTitle(AppiumDriver driver)
			throws InterruptedException {
		return findByName(driver, "Wahoo, you're good to go!");
	}

	public static WebElement skipLabel(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Skip");
	}

	// errorModalClose
	public static WebElement closeMsg(AppiumDriver driver)
			throws InterruptedException {
		return findByName(driver, "errorModalClose");
	}

	public static WebElement doneBtn(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "DONE");
	}

	/**
	 * Page Method
	 */
	public static void clickDoneBtn(AppiumDriver driver) throws Exception {
		LogHelper.info("Click DONE button........");
		doneBtn(driver).click();
	}

	public static void clickOKBtn(AppiumDriver driver) throws Exception {
		LogHelper.info("Click OK button........");
		OKBtn(driver).click();
	}

	public static void inputBankAccountAccount(AppiumDriver driver,
			String bankAccountBase) throws Exception {
		LogHelper.info(" input bankAccountBase........" + bankAccountBase);
		// bankAccountBaseBank(driver).sendKeys(bankAccountBase);
		SendKeys(driver, bankAccountBaseBank(driver), bankAccountBase);
	}

	public static void inputBankAccountBank(AppiumDriver driver,
			String bankAccountBank) throws Exception {
		mobileSwipeHelper.swipeElementToTop(driver,
				bankAccountBankTextbox(driver));
		LogHelper.info(" input bankAccountBank........" + bankAccountBank);
		// bankAccountBankTextbox(driver).sendKeys(bankAccountBank);
		SendKeys(driver, bankAccountBankTextbox(driver), bankAccountBank);
	}

	public static void inputBankAccountBranch(AppiumDriver driver,
			String bankAccountBranch) throws Exception {
		LogHelper.info(" input bankAccountBranch........" + bankAccountBranch);
		// bankAccountBranchTextbox(driver).sendKeys(bankAccountBranch);
		SendKeys(driver, bankAccountBranchTextbox(driver), bankAccountBranch);
	}

	public static void inputBankAccountSuffix(AppiumDriver driver,
			String bankAccountSuffix) throws Exception {
		LogHelper.info(" input bankAccountSuffix........" + bankAccountSuffix);
		// bankAccountSuffixTextbox(driver).sendKeys(bankAccountSuffix);
		SendKeys(driver, bankAccountSuffixTextbox(driver), bankAccountSuffix);
	}

}
