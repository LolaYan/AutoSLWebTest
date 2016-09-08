/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;

/**
 * @author MRawal
 *
 */
public class androidTicketScanPage extends _AndroidBasePage {

	public static void loaded(AppiumDriver driver) throws InterruptedException {
		androidNavBarPage.navigateToMenu(driver);
		androidNavBarPage.clickMenuScan(driver);
	}

	/**
	 * Element
	 * 
	 * @param driver
	 */
	// Favourites
	public static WebElement firstTimerStartButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "firstTimerStartButton");
	}

	// Trouble scanning?
	public static WebElement TroubleScanning(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Trouble scanning?");
	}

	// Still stuck?
	public static WebElement StillStuck(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Still stuck?");
	}

	// checkPaperTicket
	public static WebElement checkPaperTicket(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "checkPaperTicket");
	}

	// checkInstantKiwiTicket
	public static WebElement checkInstantKiwiTicket(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "checkInstantKiwiTicket");
	}

	// Check ticket manually
	public static WebElement checkPaperTicketmanually(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Check ticket manually");
	}

	// serialNumber
	public static WebElement serialNumberTextbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "serialNumber");
	} 
	
	// checkTicketButton
	public static WebElement checkTicketButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "checkTicketButton");
	}	
	// scanAnotherTicket
	public static WebElement scanAnotherTicketButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "scanAnotherTicket");
	}

	/**
	 * Method
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */

	// Before pl check if showing existing
	public static void clickfirstTimerStartButton(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click firstTimerStartButton.");
		firstTimerStartButton(driver).click();
	}

	public static void clickTroubleScanning(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click TroubleScanning.");
		TroubleScanning(driver).click();
	}

	public static void clickStillStuck(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click StillStuck.");
		StillStuck(driver).click();
	}

	public static void clickCheckPaperTicket(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click checkPaperTicket.");
		checkPaperTicket(driver).click();
	}

	public static void clickCheckInstantKiwiTicket(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click checkInstantKiwiTicket.");
		checkInstantKiwiTicket(driver).click();
	}

	public static void clickCheckPaperTicketManually(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click checkPaperTicketmanually.");
		checkPaperTicketmanually(driver).click();
	}
	
	public static void inputOnlineTicketSerialNumber(AppiumDriver driver, String serialNumber)
			throws InterruptedException {
		LogHelper.info(" input serialNumber: " + serialNumber);
		SendKeys(driver, serialNumberTextbox(driver), serialNumber);
	}
	
	public static void clickCheckTicketButton(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click checkTicketButton.");
		checkTicketButton(driver).click();
	}
	
	public static void CheckOnlineTicketManuallyWorkflow(AppiumDriver driver,
			String serialNumber) throws InterruptedException
	
	{
		androidTicketScanPage.bypassIntroScreens(driver);
		androidTicketScanPage.loaded(driver);

		androidTicketScanPage.clickfirstTimerStartButton(driver);
		androidTicketScanPage.clickTroubleScanning(driver);

		androidTicketScanPage.clickStillStuck(driver);
		androidTicketScanPage.clickCheckPaperTicket(driver);
		androidTicketScanPage.clickCheckPaperTicketManually(driver);
		androidTicketScanPage.inputOnlineTicketSerialNumber(driver,
				serialNumber);
		androidTicketScanPage.clickCheckTicketButton(driver);
	}
}
