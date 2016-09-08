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
public class androidAccountFavPage extends androidLottoPYOPage {

	public static void loaded(AppiumDriver driver) throws InterruptedException {
		androidNavBarPage.navigateToAccountList(driver);
		androidNavBarPage.clickAccountFavs(driver);
	}

	/**
	 * Element
	 * 
	 * @param driver
	 */
	// Favourites
	public static WebElement CreateFavButton(AppiumDriver driver)
			throws InterruptedException {
		// return find(driver, "Create favourite");
		return find(driver, "addYourFavourite");
	}

	// closeNotification
	public static WebElement closeNotification(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "closeNotification");
	}

	// Favourites
	public static WebElement FavouritesTab(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Favourites");
	}

	// favouriteTicketPlayNow Only showing in preview tickets
	public static WebElement favouriteTicketPlayNow(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "favouriteTicketPlayNow");
	}

	// nameYourFavourite
	public static WebElement nameYourFavouriteText(AppiumDriver driver)
			throws InterruptedException {
		// return find(driver, "Create favourite");
		return find(driver, "nameYourFavourite");
	}

	// viewTicketDetail
	public static WebElement viewTicketDetail(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "viewTicketDetail");
	}

	// favouriteName list
	/**
	 * Method
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void inputFavName(AppiumDriver driver, String favName)
			throws IOException, InterruptedException {
		LogHelper.info(" input Fav Name......" + favName);
		SendKeys(driver, nameYourFavouriteText(driver), favName);
	}

	public static boolean isExistingFav(AppiumDriver driver)
			throws InterruptedException {
		return mobileSwipeHelper.isElementExists(driver,
				By.name("favouriteName"));

	}

	public static void swipetoAddFav(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Check if fav existing.");

		do {
			mobileSwipeHelper.swipeLeft(driver);
		} while (isExistingFav(driver) == true);

	}

	// Before pl check if showing existing
	public static void clickAddFav(AppiumDriver driver)
			throws InterruptedException {
		swipetoAddFav(driver);
		LogHelper.info("Click to add FAV.");
		CreateFavButton(driver).click();
	}

	public static void clickFavouriteTicketPlayNow(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click to FavouriteTicketPlayNow in Fav Preview Page.");
		favouriteTicketPlayNow(driver).click();
	}

	public static void clickViewTicketDetail(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click to view Ticket Detail.");
		if (isExistingFav(driver) == true) {
			viewTicketDetail(driver).click();
			mobileSwipeHelper.swipetoButtom(driver);
			mobileSwipeHelper.swipetoButtom(driver);
			mobileSwipeHelper.swipetoTop(driver);
			mobileSwipeHelper.swipetoTop(driver);

		}
	}

	public static void closeNotify(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Close the notification.");
		closeNotification(driver).click();

	}

	public static void createLottoFav(AppiumDriver driver) throws Exception {
		LogHelper.info("Create Lotto FAV.");
		int[] lottoNumberArr = new int[] { 1, 6, 11, 16, 21, 26 };
		int powerball = 2;
		addLottoLine(driver, lottoNumberArr, powerball, 1);
		lottoNumberArr = new int[] { 1, 2, 3, 4, 5, 6 };
		powerball = 3;
		addLottoLine(driver, lottoNumberArr, powerball, 2);
		lottoNumberArr = new int[] { 11, 22, 33, 14, 15, 16 };
		powerball = 4;
		addLottoLine(driver, lottoNumberArr, powerball, 3);
		lottoNumberArr = new int[] { 21, 22, 23, 24, 25, 26 };
		powerball = 10;
		addLottoLine(driver, lottoNumberArr, powerball, 4);

	}

	public static void createLottoStrikeFav(AppiumDriver driver)
			throws Exception {
		LogHelper.info("Create Lotto FAV.");
		int[] lottoNumberArr = new int[] { 1, 6, 11, 16, 21, 26 };
		int powerball = 2;
		addLottoLine(driver, lottoNumberArr, powerball, 1);
		lottoNumberArr = new int[] { 1, 2, 3, 4, 5, 6 };
		powerball = 3;
		addLottoLine(driver, lottoNumberArr, powerball, 2);
		lottoNumberArr = new int[] { 11, 22, 33, 14, 15, 16 };
		powerball = 4;
		addLottoLine(driver, lottoNumberArr, powerball, 3);
		lottoNumberArr = new int[] { 21, 22, 23, 24, 25, 26 };
		powerball = 10;
		addLottoLine(driver, lottoNumberArr, powerball, 4);

		swipeuptoShowStrikeEditor(driver);
		int[] strikeNumberArr = new int[] { 1, 6, 11, 16 };
		addStrikeLine(driver, strikeNumberArr);
		strikeNumberArr = new int[] { 1, 2, 3, 4 };
		addStrikeLine(driver, strikeNumberArr);
		strikeNumberArr = new int[] { 37, 38, 39, 40 };
		addStrikeLine(driver, strikeNumberArr);

	}

}
