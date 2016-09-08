/**
 * 
 */
package com.LottoNZ.AutoSLTest.WebTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;

/**
 * @author CATPC
 *
 */
public class NavBarPage extends PageBase {

	public static WebElement accTopUpBtn(WebDriver driver) {
		return driver.findElement((By.id("top-up-button")));
	}

	public static WebElement loginModal(WebDriver driver) {
		return driver.findElement((By.id("nav-item-login-link")));
	}

	public static void navigateTologinModal(WebDriver driver) {
		LogHelper.info("Navigate to Login link");

		try {
			loginModal(driver).click();
		} catch (Exception e) {
			LogHelper.error(e.getMessage());
		}

	}

	/**
	 * Click on user Account from nav bar Click on Top up button from account
	 * Nav bar
	 */
	public static void navigateToTopup(WebDriver driver) {
		LogHelper.info("Click on user Account from nav bar");
		navMenuAccountList(driver).click();
		LogHelper.info("Click on Top up button from account");
		accTopUpBtn(driver).click();
	}

	public static WebElement navMenuAccountList(WebDriver driver) {
		WebElement ele = null;
		try {
			Thread.sleep(5000);
			ele = driver.findElement((By
					.xpath("//*[@id='nav-menu-account-link']/span[1]")));
		} catch (InterruptedException e) {
			LogHelper.error(e.getCause().toString());
			e.printStackTrace();
		}
		return ele;
	}

	public static void selecttopUpwithCC(WebDriver driver) {
		LogHelper.info("Top up: debit or credit card");

		try {
			Thread.sleep(5000);
			topUpwithCCBtn(driver).click();
		} catch (InterruptedException e) {
			LogHelper.error(e.getMessage());
		}

	}

	public static WebElement signUpMenu(WebDriver driver) {
		return driver.findElement((By.id("nav-item-signup-link")));
	}

	// ////////////////////////////////////////////////////////////

	public static WebElement topUpWithBankignBtn(WebDriver driver) {
		return driver.findElement((By
				.id("top-up-with-a-internet-banking-button")));
	}

	public static WebElement topUpwithCCBtn(WebDriver driver) {
		return driver.findElement((By.id("top-up-with-a-credit-card-text")));
	}

	public NavBarPage(WebDriver driver) {
		super(driver);

	}

	// //////////////////////////////////////////////////////

}
