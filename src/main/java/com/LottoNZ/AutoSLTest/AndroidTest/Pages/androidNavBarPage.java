/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;

public class androidNavBarPage extends _AndroidBasePage {

	public static void loaded(AppiumDriver driver) throws InterruptedException {

	}
	
	/**
	 * Homepage Nav Bar Elements
	 */
	/**
	 * Elements of Account Actions Only existing after account login, and click
	 * account
	 */
	public static WebElement closeAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Close account menu");
	}

	public static WebElement favofAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Favourites");
	}

	public static WebElement homePageNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Homepage");
	}


	// If not login
	public static WebElement loginNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "LOGIN");
	}

	/**
	 * Elements of Login Actions Only existing click login nav button
	 */
	public static WebElement loginSideNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "LOGIN");
	}

	// If already login
	public static WebElement accountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Open account menu");
	}


	public static WebElement logoutAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Log out");
	}

	// Navigate to Contact us
	public static WebElement menuContact(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Contact us");
	}

	// Navigate to FAQs
	public static WebElement menuFAQ(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to FAQs");
	}

	// Navigate to Full site
	public static WebElement menuFullSite(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Full site");
	}

	/**
	 * Elements of Menu lists Actions Showing after click MENU in the nav bar
	 */
	// Powerball Menu Item
	public static WebElement menuGamePowerball(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Powerball Menu Item");
	}

	// Navigate to Legal
	public static WebElement menuLegal(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Legal");
	}

	// Menu
	public static WebElement menuNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Open game menu");
	}

	// Navigate to Notification Settings
	public static WebElement menuNotifySetting(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Notification Settings");
	}

	// Navigate to Play responsibly
	public static WebElement menuPalyResponsibly(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Play responsibly");
	}

	// Navigate to Scan Ticket
	public static WebElement menuScan(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Scan Ticket");
	}

	// Navigate to Store finder
	public static WebElement menuStoreFinder(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Store finder");
	}

	public static WebElement msgsofAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Messages");
	}

	public static WebElement notifySettingSideNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "NOTIFICATION SETTINGS");
	}

	public static WebElement registerSideNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Register now");
	}

	// Results
	public static WebElement resultsNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Results button");
	}

	// If not login
	public static WebElement scanNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "SCAN");
	}

	public static WebElement settingsAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to Settings");
	}

	// If already login
	public static WebElement ticketsNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "My tickets");
	}

	public static WebElement ticktsofAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Navigate to My Tickets");
	}

	public static WebElement TopupAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Top up my account");
	}

	/*******************************************************
	 * Page Method
	 *******************************************************/

	public static void clickAccountFavs(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Go to Account Favs");
		favofAccountNav(driver).click();

	}

	public static void clickAccountMsgs(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Go to Account Messages");
		msgsofAccountNav(driver).click();

	}

	public static void clickAccountSettings(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Go to Account Setting");
		settingsAccountNav(driver).click();

	}

	public static void clickAccountTickets(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Go to Account Tickets");
		ticktsofAccountNav(driver).click();

	}

	public static void clickAccountTopup(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Go to Account Top up");
		TopupAccountNav(driver).click();

	}

	/**
	 * LOGIN Left Side Nav Bar LIST method
	 */
	public static void clickLogin(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Go to Login page");
		loginSideNav(driver).click();

	}

	public static void clickMenuContact(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Menu > Contact");
		menuContact(driver).click();
	}

	public static void clickMenuFAQ(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Menu > FAQ");
		menuFAQ(driver).click();
	}

	public static void clickMenuFullSite(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Menu > FullSite");
		menuFullSite(driver).click();
	}

	/**
	 * MENU LIST method
	 */

	public static void clickMenuGamePowerball(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Menu > GamePowerball");
		menuGamePowerball(driver).click();
	}

	public static void clickMenuLegal(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Menu > Legal");
		menuLegal(driver).click();
	}

	public static void clickMenuNotifySetting(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Menu > NotifySetting");
		menuNotifySetting(driver).click();
	}

	public static void clickMenuPalyResponsibly(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Menu > PalyResponsibly");
		menuPalyResponsibly(driver).click();
	}

	public static void clickMenuScan(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Menu > Scan");
		menuScan(driver).click();
	}

	public static void clickMenuStoreFinder(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Menu > StoreFinder");
		menuStoreFinder(driver).click();
	}

	public static void clickNotifySetting(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Go to Account Nav Bar");
		notifySettingSideNav(driver).click();

	}

	public static void clickRegister(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Close Account Right Side Nav Bar");
		registerSideNav(driver).click();

	}

	public static void closeAccountList(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Close Account Right Side Nav Bar");
		closeAccountNav(driver).click();

	}

	public static String getAccountBalanceinNavBar(AppiumDriver driver)
			throws InterruptedException {
		By locator = By
				.xpath("//*[@content-desc=\"Open account menu\"]/*[@class=\"android.widget.TextView\"]");
		WebElement ele;
		String value;
		if (mobileSwipeHelper.isElementExists(driver, locator) == true) {
			value = elements(driver, locator).get(0).getText();
		} else {
			value = null;
		}
		return value;
	}

	public static void logoutAccount(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Log out Account ");
		logoutAccountNav(driver).click();

	}

	/**
	 * ACCOUNT LIST method
	 */
	public static void navigateToAccountList(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Account Nav Bar");
		accountNav(driver).click();

	}

	public static void navigateToHomepage(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Homepage");
		homePageNav(driver).click();

	}

	public static void navigateTologinNav(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Login Nav Bar");
		loginNav(driver).click();

	}

	/**
	 * NAV BAR method
	 */
	public static void navigateToMenu(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Navigate to Menu link");
		menuNav(driver).click();

	}

}
