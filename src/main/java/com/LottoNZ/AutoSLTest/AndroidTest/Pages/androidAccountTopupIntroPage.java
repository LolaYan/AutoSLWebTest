package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

public class androidAccountTopupIntroPage extends _AndroidBasePage {

	public static void loaded(AppiumDriver driver) throws InterruptedException {
		androidNavBarPage.navigateToAccountList(driver);
		androidNavBarPage.clickAccountTopup(driver);
	}

	/**
	 * Page ELEMENTS
	 * 
	 * @throws InterruptedException
	 */
	public static WebElement WalletAmount(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Wallet amount");
	}

	// Top up with internet banking
	public static WebElement topUpwithBankingLabel(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up with internet banking");
	}

	// Top with a credit/debit card
	public static WebElement topUpwithCardLabel(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top with a credit/debit card");
	}

	/**
	 * Page Method
	 */
	public static String getWalletbalance(AppiumDriver driver)
			throws InterruptedException {
		return WalletAmount(driver).getText();

	}
	
	public static void selectTopupWithCardBtn(AppiumDriver driver)
			throws InterruptedException {
		topUpwithCardLabel(driver).click();

	}

	public static void selectTopupWithBankingBtn(AppiumDriver driver)
			throws InterruptedException {
		topUpwithBankingLabel(driver).click();

	}

}
