/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.Utils.PropertyLoader;

public class androidNavBarPage extends _AndroidBasePage {
	protected static String homePageNav_ContentDesc = "Homepage";
	protected static String menuNav_ContentDesc = "Open game menu";
	protected static String resultsNav_ContentDesc = "Results button";
	protected static String scanNav_ContentDesc = "Scan tickets";
	protected static String loginNav_ContentDesc = "loginOrSignupNavigationLink";
	protected static String accountNav_ContentDesc = "Close account menu";
	protected static String ticketsNav_ContentDesc = "My tickets";

	protected static String loginRSideNav_Login_ContentDesc = "LOGIN";
	protected static String loginRSideNav_Register_ContentDesc = "Register now";
	protected static String loginRSideNav_NotifySetting_ContentDesc = "Navigate to Notification Settings";

	protected static String menuGamePowerball_ContentDesc = "Powerball Menu Item";
	protected static String menuScan_ContentDesc = "Navigate to Scan Ticket";
	protected static String menuNotifySetting_ContentDesc = "Navigate to Notification Settings";
	protected static String menuStoreFinder_ContentDesc = "Navigate to Store finder";
	protected static String menuFAQ_ContentDesc = "Navigate to FAQs";
	protected static String menuPalyResponsibly_ContentDesc = "Navigate to Play responsibly";
	protected static String menuLegal_ContentDesc = "Navigate to Legal";
	protected static String menuContact_ContentDesc = "Navigate to Contact us";
	protected static String menuFullSite_ContentDesc = "Navigate to Full site";

	protected static String accountRSideNav_Close_ContentDesc = "Close account menu";
	protected static String accountRSideNav_Topup_ContentDesc = "Top up my account";
	protected static String accountRSideNav_Settings_ContentDesc = "Navigate to Settings";
	protected static String accountRSideNav_MyTickets_ContentDesc = "Navigate to My Tickets";
	protected static String accountRSideNav_Fav_ContentDesc = "Navigate to Favourites";
	protected static String accountRSideNav_Msg_ContentDesc = "Navigate to Messages";
	protected static String accountRSideNav_Logout_ContentDesc = "Navigate to Log out";

	private androidNavBarPage()
	{
		homePageNav_ContentDesc = PropertyLoader.loadElementContentDecsValue("homePageNav_ContentDesc");
		menuNav_ContentDesc = PropertyLoader.loadElementContentDecsValue("menuNav_ContentDesc");
		resultsNav_ContentDesc = PropertyLoader.loadElementContentDecsValue("resultsNav_ContentDesc");
		scanNav_ContentDesc = PropertyLoader.loadElementContentDecsValue("scanNav_ContentDesc");
		loginNav_ContentDesc = PropertyLoader.loadElementContentDecsValue("loginNav_ContentDesc");
		accountNav_ContentDesc = PropertyLoader.loadElementContentDecsValue("accountNav_ContentDesc");
		ticketsNav_ContentDesc = PropertyLoader.loadElementContentDecsValue("ticketsNav_ContentDesc");

		loginRSideNav_Login_ContentDesc = PropertyLoader.loadElementContentDecsValue("loginRSideNav_Login_ContentDesc");
		loginRSideNav_Register_ContentDesc = PropertyLoader.loadElementContentDecsValue("loginRSideNav_Register_ContentDesc");
		loginRSideNav_NotifySetting_ContentDesc = PropertyLoader.loadElementContentDecsValue("loginRSideNav_NotifySetting_ContentDesc");
		
		menuGamePowerball_ContentDesc = PropertyLoader.loadElementContentDecsValue("menuGamePowerball_ContentDesc");
		menuScan_ContentDesc = PropertyLoader.loadElementContentDecsValue("menuScan_ContentDesc");
		menuNotifySetting_ContentDesc = PropertyLoader.loadElementContentDecsValue("menuNotifySetting_ContentDesc");
		menuStoreFinder_ContentDesc = PropertyLoader.loadElementContentDecsValue("menuStoreFinder_ContentDesc");
		menuFAQ_ContentDesc = PropertyLoader.loadElementContentDecsValue("menuFAQ_ContentDesc");
		menuPalyResponsibly_ContentDesc = PropertyLoader.loadElementContentDecsValue("menuPalyResponsibly_ContentDesc");
		menuLegal_ContentDesc = PropertyLoader.loadElementContentDecsValue("menuLegal_ContentDesc");
		menuContact_ContentDesc = PropertyLoader.loadElementContentDecsValue("menuContact_ContentDesc");
		menuFullSite_ContentDesc = PropertyLoader.loadElementContentDecsValue("menuFullSite_ContentDesc");

		accountRSideNav_Close_ContentDesc = PropertyLoader.loadElementContentDecsValue("accountRSideNav_Close_ContentDesc");
		accountRSideNav_Topup_ContentDesc = PropertyLoader.loadElementContentDecsValue("accountRSideNav_Topup_ContentDesc");
		accountRSideNav_Settings_ContentDesc = PropertyLoader.loadElementContentDecsValue("accountRSideNav_Settings_ContentDesc");
		accountRSideNav_MyTickets_ContentDesc = PropertyLoader.loadElementContentDecsValue("accountRSideNav_MyTickets_ContentDesc");
		accountRSideNav_Fav_ContentDesc = PropertyLoader.loadElementContentDecsValue("accountRSideNav_Fav_ContentDesc");
		accountRSideNav_Msg_ContentDesc = PropertyLoader.loadElementContentDecsValue("accountRSideNav_Msg_ContentDesc");
		accountRSideNav_Logout_ContentDesc = PropertyLoader.loadElementContentDecsValue("accountRSideNav_Logout_ContentDesc");
		
	}
	
	public static void loaded(AppiumDriver driver) throws InterruptedException {

	}

	/**
	 * Homepage Nav Bar Elements
	 */
	// Homepage Tab
	public static WebElement homePageNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, homePageNav_ContentDesc);
	}

	// Menu Tab
	public static WebElement menuNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, menuNav_ContentDesc);
	}

	// Results Tab
	public static WebElement resultsNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, resultsNav_ContentDesc);
	}

	// Scan tab, If not login
	public static WebElement scanNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, scanNav_ContentDesc);
	}

	// login tab, If not login
	public static WebElement loginNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, loginNav_ContentDesc);
	}

	// Account Tab, If already login
	public static WebElement accountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, accountNav_ContentDesc);
	}

	// Tickets tab, If already login
	public static WebElement ticketsNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, ticketsNav_ContentDesc);
	}

	/**
	 * Elements of Login Actions, Only existing click login nav button
	 */
	public static WebElement loginRSideNav_Login(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, loginRSideNav_Login_ContentDesc);
	}

	public static WebElement loginRSideNav_Register(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, loginRSideNav_Register_ContentDesc);
	}

	public static WebElement loginRSideNav_NotifySetting(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, loginRSideNav_NotifySetting_ContentDesc);
	}

	/**
	 * Elements of Menu lists Actions Showing after click MENU in the nav bar
	 */
	// Powerball Menu Item
	public static WebElement menuGamePowerball(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, menuGamePowerball_ContentDesc);
	}

	// Navigate to Scan Ticket
	public static WebElement menuScan(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, menuScan_ContentDesc);
	}

	// Navigate to Notification Settings
	public static WebElement menuNotifySetting(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, menuNotifySetting_ContentDesc);
	}

	// Navigate to Store finder
	public static WebElement menuStoreFinder(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, menuStoreFinder_ContentDesc);
	}

	// Navigate to FAQs
	public static WebElement menuFAQ(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, menuFAQ_ContentDesc);
	}

	// Navigate to Play responsibly
	public static WebElement menuPalyResponsibly(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, menuPalyResponsibly_ContentDesc);
	}

	// Navigate to Legal
	public static WebElement menuLegal(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, menuLegal_ContentDesc);
	}

	// Navigate to Contact us
	public static WebElement menuContact(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, menuContact_ContentDesc);
	}

	// Navigate to Full site
	public static WebElement menuFullSite(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, menuFullSite_ContentDesc);
	}

	/**
	 * Elements of Account Actions Only existing after account login, and click
	 * account
	 */

	public static WebElement closeAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, accountRSideNav_Close_ContentDesc);
	}

	public static WebElement TopupAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, accountRSideNav_Topup_ContentDesc);
	}

	public static WebElement settingsAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, accountRSideNav_Settings_ContentDesc);
	}

	public static WebElement ticktsofAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, accountRSideNav_MyTickets_ContentDesc);
	}

	public static WebElement favofAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, accountRSideNav_Fav_ContentDesc);
	}

	public static WebElement msgsofAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, accountRSideNav_Msg_ContentDesc);
	}

	public static WebElement logoutAccountNav(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, accountRSideNav_Logout_ContentDesc);
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
		loginRSideNav_Login(driver).click();

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
		loginRSideNav_NotifySetting(driver).click();

	}

	public static void clickRegister(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Close Account Right Side Nav Bar");
		loginRSideNav_Register(driver).click();

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
