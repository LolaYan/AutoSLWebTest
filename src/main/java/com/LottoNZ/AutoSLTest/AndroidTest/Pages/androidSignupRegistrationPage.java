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
import com.LottoNZ.AutoSLTest.Utils.PropertyLoader;

public class androidSignupRegistrationPage extends _AndroidBasePage {
	protected static String emailTextBox_ContentDesc = "emailAddressFromRegistrationForm";
	protected static String firstNameTextBox_ContentDesc = "firstNameFromRegistrationForm";
	protected static String lastNameTextBox_ContentDesc = "lastNameFromRegistrationForm";
	protected static String PasswordTextBox_ContentDesc = "password";
	protected static String dateTextBox_ContentDesc = "birthDay";
	protected static String monthListButton_ContentDesc = "birthMonth";
	protected static String yearTextbox_ContentDesc = "birthYear";
	protected static String femaleRadioButton_ContentDesc = "genderFemaleCheck";
	protected static String maleRadioButton_ContentDesc = "genderMaleCheck";
	protected static String mobileCodeTexbox_ContentDesc = "mobileNetworkFromCompleteRegistrationForm";
	protected static String mobileNumberTexbox_ContentDesc = "mobileNumberFromCompleteRegistrationForm";
	protected static String regionSelectlist_ContentDesc = "regionSelect";
	protected static String regionLocationList_ContentDesc = "location";
	protected static String securitySelectlist_ContentDesc = "sequeiryQuestionSelect";
	protected static String secAnswerTextbox_ContentDesc = "sequeiryQuestionSelectText";

	protected static String showpasswordLink_ContentDesc = "Show password";
	protected static String hidepasswordLink_ContentDesc = "Hide password";

	protected static String jackpotPromoCheckbox_ContentDesc = "jackpotRemindersCheck";
	protected static String jackpotRemindersSelect_ContentDesc = "jackpotRemindersSelect";
	protected static String resultsPromoCheckbox_ContentDesc = "promotionRemindersCheck";
	protected static String IKCheckbox_ContentDesc = "instantKiwiCheck";

	protected static String signupBtn_ContentDesc = "signUp";
	protected static String loginBtn_ContentDesc = "loginFromRegisterForm";

	private androidSignupRegistrationPage() {
		emailTextBox_ContentDesc = PropertyLoader
				.loadElementContentDecsValue("emailTextBox_ContentDesc");
		firstNameTextBox_ContentDesc = PropertyLoader
				.loadElementContentDecsValue("CheckresultsButton_ContentDesc");
		lastNameTextBox_ContentDesc = PropertyLoader
				.loadElementContentDecsValue("lastNameTextBox_ContentDesc");
		PasswordTextBox_ContentDesc = PropertyLoader
				.loadElementContentDecsValue("PasswordTextBox_ContentDesc");
		dateTextBox_ContentDesc = PropertyLoader
				.loadElementContentDecsValue("dateTextBox_ContentDesc");
		monthListButton_ContentDesc = PropertyLoader
				.loadElementContentDecsValue("monthListButton_ContentDesc");
		PasswordTextBox_ContentDesc = PropertyLoader
				.loadElementContentDecsValue("PasswordTextBox_ContentDesc");
	}

	/**
	 * go to the Registration page
	 * 
	 * @throws InterruptedException
	 **/
	public static void loaded(AppiumDriver driver) throws InterruptedException {
		androidNavBarPage.navigateTologinNav(driver);
		androidNavBarPage.clickRegister(driver);

	}

	/**
	 * WebElement
	 */

	public static WebElement emailTextBox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, emailTextBox_ContentDesc);
	}

	public static WebElement firstNameTextBox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, firstNameTextBox_ContentDesc);
	}

	public static WebElement lastNameTextBox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, lastNameTextBox_ContentDesc);
	}

	public static WebElement PasswordTextBox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, PasswordTextBox_ContentDesc);
	}

	public static WebElement showpasswordLink(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, showpasswordLink_ContentDesc);
	}

	public static WebElement dateTextBox(AppiumDriver driver)
			throws InterruptedException {

		return find(driver, dateTextBox_ContentDesc);
	}

	public static WebElement monthListButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, monthListButton_ContentDesc);
	}

	public static void monthSelect(AppiumDriver driver, String monthName)
			throws Exception {
		LogHelper.info(" select month ......" + monthName);
		monthListButton(driver).click();
		Thread.sleep(1000);
		find(driver, monthName).click();

	}

	public static WebElement yearTextbox(AppiumDriver driver)
			throws InterruptedException {

		return find(driver, yearTextbox_ContentDesc);
	}

	public static WebElement femaleRadioButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, femaleRadioButton_ContentDesc);
	}

	public static WebElement maleRadioButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, maleRadioButton_ContentDesc);
	}

	public static WebElement mobileCodeTexbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, mobileCodeTexbox_ContentDesc);
	}

	public static WebElement mobileNumberTexbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, mobileNumberTexbox_ContentDesc);
	}

	public static WebElement regionSelectlist(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, regionSelectlist_ContentDesc);
	}

	public static WebElement regionSelect(AppiumDriver driver, String regionStr)
			throws InterruptedException {
		return find(driver, regionStr);
	}

	public static WebElement regionLocationList(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, regionLocationList_ContentDesc);
	}

	public static WebElement regionLocation(AppiumDriver driver,
			String locationStr) throws InterruptedException {
		return find(driver, locationStr);
	}

	public static WebElement securitySelectlist(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, securitySelectlist_ContentDesc);
	}

	public static WebElement securityQuestion(AppiumDriver driver,
			String questionStr) throws InterruptedException {
		return find(driver, questionStr);
	}

	public static WebElement secAnswerTextbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, secAnswerTextbox_ContentDesc);
	}

	public static WebElement jackpotPromoCheckbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, jackpotPromoCheckbox_ContentDesc);
	}

	public static WebElement jackpotRemindersSelect(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, jackpotRemindersSelect_ContentDesc);
	}

	public static WebElement resultsPromoCheckbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, resultsPromoCheckbox_ContentDesc);
	}

	public static WebElement IKCheckbox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, IKCheckbox_ContentDesc);
	}

	public static WebElement signupBtn(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, signupBtn_ContentDesc);
	}

	public static WebElement loginLink(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, loginBtn_ContentDesc);
	}

	public static WebElement tncLink(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "terms and conditions");
	}

	/**
	 * Warning Msg
	 */
	public static WebElement emailisReqValidation(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Email address is required");
	}

	public static WebElement firstNameisRequired(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "First name is required");
	}

	public static WebElement hidepasswordLink(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Hide password");
	}

	public static WebElement lastNameisReqValidation(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Last name is required");
	}

	public static WebElement passwordisReqValidation(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Password is required");
	}

	public static WebElement secAnswerisRequired(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "A security question and an answer is required");
	}

	/**
	 * Method
	 */

	public static void clickGenderButton(AppiumDriver driver, String genderStr)
			throws Exception {
		LogHelper.info(" select gender........" + genderStr);
		if (genderStr.equals("F")) {
			femaleRadioButton(driver).click();
		} else {
			maleRadioButton(driver).click();

		}
	}

	public static void clickJackpotRemindersSelect(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("click JackpotRemindersSelectOR TO OPEN THE LIST");
		jackpotRemindersSelect(driver).click();
	}

	public static void clickLocationSelector(AppiumDriver driver)
			throws Exception {
		regionLocationList(driver).click();
		Thread.sleep(2000);
		if (mobileSwipeHelper.isElementExists(driver, by_Xpath("location")) == true) {
			driver.tap(1, regionLocationList(driver), 2);
		}

	}

	public static void clickLoginLink(AppiumDriver driver)
			throws InterruptedException {
		loginLink(driver).click();
	}

	public static void clickRegionSelector(AppiumDriver driver)
			throws Exception {

		LogHelper.info(" Open Region Selector");
		regionSelectlist(driver).click();
		Thread.sleep(2000);
		if (mobileSwipeHelper.isElementExists(driver, by_Xpath("regionSelect")) == true) {
			driver.tap(1, regionSelectlist(driver), 2);
		}
	}

	public static void clickSignup(AppiumDriver driver)
			throws InterruptedException {
		signupBtn(driver).click();
	}

	public static void clickTnCs(AppiumDriver driver)
			throws InterruptedException {
		tncLink(driver).click();
	}

	/* Date of birth */
	public static void inputDoBDay(AppiumDriver driver, String day)
			throws InterruptedException {
		LogHelper.info(" input DD  ......" + day);
		mobileSwipeHelper.swipeElementToTop(driver, dateTextBox(driver));
		SendKeys(driver, dateTextBox(driver), day);
	}

	public static void inputDoBYear(AppiumDriver driver, String year)
			throws InterruptedException {
		LogHelper.info(" input year ......" + year);
		// yearTextbox(driver).sendKeys(year);
		SendKeys(driver, yearTextbox(driver), year);
	}

	public static void inputEmailAddress(AppiumDriver driver, String email)
			throws IOException, InterruptedException {
		LogHelper.info(" inputEmailAddress......" + email);
		SendKeys(driver, emailTextBox(driver), email);
	}

	public static void inputFirstName(AppiumDriver driver, String firstName)
			throws InterruptedException {
		LogHelper.info(" input Frist name ......" + firstName);
		SendKeys(driver, firstNameTextBox(driver), firstName);
	}

	public static void inputLastName(AppiumDriver driver, String lastName)
			throws InterruptedException {
		LogHelper.info(" input last name ......" + lastName);
		mobileSwipeHelper.swipeElementToTop(driver, lastNameTextBox(driver));
		SendKeys(driver, lastNameTextBox(driver), lastName);

	}

	public static void inputMobileCode(AppiumDriver driver, String mobileCode)
			throws InterruptedException {
		LogHelper.info(" input mobile code........" + mobileCode);
		mobileSwipeHelper.swipeElementToTop(driver, mobileCodeTexbox(driver));
		SendKeys(driver, mobileCodeTexbox(driver), mobileCode);
	}

	public static void inputMobileNumber(AppiumDriver driver,
			String mobileNumber) throws InterruptedException {
		LogHelper.info(" input mobile code........" + mobileNumber);
		SendKeys(driver, mobileNumberTexbox(driver), mobileNumber);
	}

	/* User password */
	public static void inputPassword(AppiumDriver driver, String password)
			throws InterruptedException {
		LogHelper.info(" input password ......" + password);
		SendKeys(driver, PasswordTextBox(driver), password);

	}

	public static void InputSecurityAnswer(AppiumDriver driver, String answer)
			throws InterruptedException {
		LogHelper.info(" input security answer ......" + answer);
		// secAnswerTextbox(driver).sendKeys(answer);
		mobileSwipeHelper.swipeElementToTop(driver, secAnswerTextbox(driver));
		SendKeys(driver, secAnswerTextbox(driver), answer);
	}

	public static void selectaLocation(AppiumDriver driver, String locStr)
			throws Exception {

		LogHelper.info(" select location in locationList > " + locStr);
		regionLocation(driver, locStr).click();

	}

	public static void selectaQuestion(AppiumDriver driver) throws Exception {
		String questionStr = "What town was I born in?";
		LogHelper.info(" Input security question ......" + questionStr);
		By locator = By
				.xpath("//*[@content-desc=\"sequeiryQuestionSelect\"]/*[@class=\"android.widget.TextView\"]");

		if (mobileSwipeHelper.isElementExists(driver, locator) == true) {
			element(driver, locator).sendKeys(questionStr);
		}
	}

	public static void selectaQuestion(AppiumDriver driver, String questionStr)
			throws Exception {
		LogHelper.info(" Click security question list......" + questionStr);
		securitySelectlist(driver).click();
		Thread.sleep(1000);
		LogHelper.info(" Click security question ......" + questionStr);
		securityQuestion(driver, questionStr).click();
	}

	public static void selectaRegion(AppiumDriver driver, String regionStr)
			throws Exception {

		LogHelper.info(" select region in regionlist > " + regionStr);
		regionSelect(driver, regionStr).click();

	}

	public static void selectJackpotReminderAmount(AppiumDriver driver,
			String amount) throws InterruptedException {
		LogHelper.info("select a jackpot amount.... " + amount);
		find(driver, amount).click();
	}

	public static void tickIKReminder(AppiumDriver driver)
			throws InterruptedException {
		IKCheckbox(driver).click();
	}

	public static void tickJackpotReminder(AppiumDriver driver)
			throws InterruptedException {
		jackpotPromoCheckbox(driver).click();
	}

	/* Email preferences */
	public static void tickPromotionReminders(AppiumDriver driver)
			throws InterruptedException {
		resultsPromoCheckbox(driver).click();
	}

}
