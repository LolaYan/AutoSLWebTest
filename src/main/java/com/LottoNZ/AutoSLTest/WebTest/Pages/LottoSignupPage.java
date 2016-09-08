/**
 * 
 */
package com.LottoNZ.AutoSLTest.WebTest.Pages;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.Utils.getActivationCode;

/**
 * @author Lola
 * @email lyan@planittesting.co.nz Note: define the findelement methods here in
 *        LottoHomePage
 */
public class LottoSignupPage extends PageBase {

	/** Page object for the Registration page **/
	public abstract static class ActivationPage {
		public static WebElement activateBtn(WebDriver driver) {
			return find(driver, "activationButton");
		}

		public static WebElement activationCodeTextBox(WebDriver driver) {
			return find(driver, "activationId");
		}

		/**
		 * Happy case enter correct activation id and submit
		 * 
		 * @param email
		 * @throws Exception
		 * @throws SQLException
		 * @throws Exception
		 */
		public static void activeAccount(WebDriver driver, String email)
				throws Exception, SQLException, Exception {
			inputActivationid(driver, email);
			clickActivateBtn(driver);
		}

		public static WebElement checkforStringwithusername(WebDriver driver,
				String username) {
			return find(driver, String.format(
					"We've sent an activation email to: %s", username));
		}

		public static void clickActivateBtn(WebDriver driver) {
			LogHelper.info(" click activate..... ...");
			activateBtn(driver).click();
		}

		public static WebElement emailisReqValidation(WebDriver driver) {
			return find(driver, "Email address is required");
		}

		public static void inputActivationid(WebDriver driver, String username)
				throws IOException, Exception, SQLException {
			Thread.sleep(3000);
			String activationCode = getActivationCode
					.returnActivationId(username);
			LogHelper.info(" input activation id........" + activationCode);
			activationCodeTextBox(driver).sendKeys(activationCode);
		}
	}

	/** Page object for the complete your account page **/
	public abstract static class compYourAccountPage {
		public static WebElement bankAccountAccount(WebDriver driver) {
			return find(driver, "bankAccountAccount");
		}

		public static WebElement bankAccountBank(WebDriver driver) {
			return find(driver, "bankAccountBank");
		}

		public static WebElement bankAccountBranch(WebDriver driver) {
			return find(driver, "bankAccountBranch");
		}

		public static WebElement bankAccountSuffix(WebDriver driver) {
			return find(driver, "bankAccountSuffix");
		}

		public static void clickDoneBtn(WebDriver driver) throws Exception {
			LogHelper.info("Click done button........");
			completeRegistrationButton(driver).click();
		}

		/**
		 * Enter Male or Female
		 * 
		 * @param driver
		 * @param genderStr
		 * @throws Exception
		 */
		public static void clickGenderButton(WebDriver driver, String genderStr)
				throws Exception {
			System.out.println(" select gender........" + genderStr);
			// *[@id="femaleCheckbox"]
			driver.findElement(By.xpath("//input[@id='femaleCheckbox']"))
					.sendKeys(Keys.SPACE);
		}

		public static WebElement completeRegistrationButton(WebDriver driver) {
			return find(driver, String.format("completeRegistrationButton"));
		}

		/**
		 * Happy scenario for final stage of complete registration page
		 * 
		 * @param driver
		 * @param regionStr
		 * @param locStr
		 * @param genderStr
		 * @param bankAccountBankNum
		 * @param bankAccountBranchNum
		 * @param bankAccountAccountNum
		 * @param bankAccountSuffixNum
		 * @param mobileNetworkNum
		 * @param mobileNumberNum
		 * @param password
		 * @throws Exception
		 */
		public static void fillCompleteRegPage(WebDriver driver,
				String regionStr, String locStr, String genderStr,
				String bankAccountBankNum, String bankAccountBranchNum,
				String bankAccountAccountNum, String bankAccountSuffixNum,
				String mobileNetworkNum, String mobileNumberNum, String password)
				throws Exception {
			selectaRegion(driver, regionStr);
			selectaLoc(driver, locStr);
			clickGenderButton(driver, genderStr);
			inputBankAccNumber(driver, bankAccountBankNum,
					bankAccountBranchNum, bankAccountAccountNum,
					bankAccountSuffixNum);
			inputMobileNum(driver, mobileNetworkNum, mobileNumberNum);
			inputPassword(driver, password);

			clickDoneBtn(driver);

		}

		public static void inputBankAccNumber(WebDriver driver,
				String bankAccountBankNum, String bankAccountBranchNum,
				String bankAccountAccountNum, String bankAccountSuffixNum)
				throws Exception {
			LogHelper.info(" input bankAccountBank........");
			bankAccountBank(driver).sendKeys(bankAccountBankNum);
			LogHelper.info(" input bankAccountBranch........");
			bankAccountBranch(driver).sendKeys(bankAccountBranchNum);
			LogHelper.info(" input bankAccountAccount........");
			bankAccountAccount(driver).sendKeys(bankAccountAccountNum);
			LogHelper.info(" input bankAccountSuffix........");
			bankAccountSuffix(driver).sendKeys(bankAccountSuffixNum);
		}

		public static void inputMobileNum(WebDriver driver,
				String mobileNetworkNum, String mobileNumberNum) {
			LogHelper.info(" input mobile code........");
			mobileNetwork(driver).sendKeys(mobileNetworkNum);
			LogHelper.info(" input mobile number........");
			mobileNumber(driver).sendKeys(mobileNumberNum);
		}

		public static void inputPassword(WebDriver driver, String password)
				throws Exception {
			LogHelper.info(" input password........" + password);
			passwordFromCompleteRegistrationForm(driver).sendKeys(password);
		}

		public static WebElement locationSelect(WebDriver driver) {

			return find(driver, "locationSelect");
		}

		public static WebElement mobileNetwork(WebDriver driver) {
			return find(driver, "mobileNetwork");
		}

		public static WebElement mobileNumber(WebDriver driver) {
			return find(driver, "mobileNumber");
		}

		public static WebElement passwordFromCompleteRegistrationForm(
				WebDriver driver) {
			return find(driver, "passwordFromCompleteRegistrationForm");
		}

		public static WebElement regionSelect(WebDriver driver) {

			return find(driver, "regionSelect");
		}

		public static void selectaLoc(WebDriver driver, String locStr)
				throws Exception {
			LogHelper.info(" select loc ......" + locStr);
			Select select = new Select(locationSelect(driver));
			Thread.sleep(1000);
			select.selectByValue(locStr);
			;

		}

		public static void selectaRegion(WebDriver driver, String regionStr)
				throws Exception {

			LogHelper.info(" select a region ......" + regionStr);
			Select select = new Select(regionSelect(driver));
			Thread.sleep(3000);
			select.selectByValue(regionStr);
			;
		}

	}

	/** Page object for the complete your account page **/
	public abstract static class LoginWebPage {

		public static WebElement cantAccessEmailLink(WebDriver driver) {
			return find(driver, String.format("Can't access your email?"));
		}

		public static void clickLoginBtn(WebDriver driver) throws Exception {
			LogHelper.info(" Login now........");
			loginBtn(driver).click();
		}

		public static WebElement forgottenPasswordLink(WebDriver driver) {
			return find(driver, String.format("Forgotten your password?"));
		}

		public static void inputLoginPassword(WebDriver driver, String password)
				throws Exception {
			LogHelper.info(" input password........" + password);
			passwordTextbox(driver).sendKeys(password);
		}

		public static void inputLoginUsername(WebDriver driver, String username)
				throws Exception {
			LogHelper.info(" input username........" + username);
			loginTextbox(driver).sendKeys(username);
		}

		public static WebElement loginBtn(WebDriver driver) {
			return find(driver, String.format("login-submit-button"));
		}

		public static WebElement loginTextbox(WebDriver driver) {
			LogHelper.info(driver.getPageSource());
			return find(driver, String.format("email"));
		}

		/**
		 * Happy case login step while signup
		 * 
		 * @param email
		 * @param password
		 * @throws Exception
		 */
		public static void LoginWhileSignupStep(WebDriver driver, String email,
				String password) throws Exception {
			inputLoginUsername(driver, email);
			inputLoginPassword(driver, password);
			clickLoginBtn(driver);
		}

		public static WebElement passwordTextbox(WebDriver driver) {
			return find(driver, String.format("password"));
		}
	}

	// static WebDriverWait wait = new WebDriverWait(driver, 300);
	public abstract static class lottoWebSignupPage {

		public static By BySearchAfulldateofbirthisrequired() {
			return By.id("dateOfBirth-Afulldateofbirthisrequired");
		}

		public static By BySearchDoBDay() {
			return By.id("dobDay");
		}

		// Select dobMonth
		public static By BySearchDoBMonth() {
			return By.id("dobMonth");
		}

		public static By BySearchDoBYear() {
			return By.id("dobYear");
		}

		public static By BySearchEmailAddress() throws IOException {
			LogHelper.info(" getWebOjectLocator......");
			// return getWebOjectLocator("lottoRegistrationUrl.emailAddress");
			return By.id("emailAddress");
		}

		/* warning info element: input required */
		public static By BySearchEmailAddressRequired() {
			return By.id("emailAddress-Emailaddressisrequired");
		}

		// *******************
		// BY ELEMENTS

		public static By BySearchFirstName() {
			return By.id("firstName");
		}

		public static By BySearchFirstnameisrequired() {
			return By.id("firstName-Firstnameisrequired");
		}

		public static By BySearchIKReminder() {
			return By.id("IKReminder");
		}

		public static By BySearchIllegalFirstname() {
			return By.id("firstName-Illegalcharactersfoundinfirstname");
		}

		public static By BySearchIllegalLastname() {
			return By.id("lastName-Illegalcharactersfoundinlastname");
		}

		public static By BySearchInvalidDateofBirth() {
			return By.id("dateOfBirth-Invaliddayforthismonth");
		}

		//
		public static By BySearchInvalidemailaddress() {
			return By.id("emailAddress-Invalidemailaddress");
		}

		public static By BySearchInvalidPassword() {
			return By
					.id("password-Passwordmustcontain8characterswithatleast1number");
		}

		public static By BySearchJackpotReminder() {
			return By.id("jackpotReminder");
		}

		// Select jackpotReminderAmount
		public static By BySearchJackpotReminderAmount() {
			return By.id("jackpotReminderAmount");
		}

		public static By BySearchLastName() {
			return By.id("lastName");
		}

		// Terms and conditions
		// id="tandc-link"

		public static By BySearchLastnameisrequired() {
			return By.id("lastName-Lastnameisrequired");
		}

		public static By BySearchPassword() {
			return By.id("password");
		}

		public static By BySearchPasswordisrequired() {
			return By.id("password-Passwordisrequired");
		}

		public static By BySearchPromotionReminders() {
			return By.id("promotionReminders");
		}

		/* id="signup-button" */
		public static By BySearchSignupButton() {
			return By.id("signupButton");
		}

		public static void clickSignup(WebDriver driver) {
			driver.findElement(BySearchSignupButton()).click();
		}

		// warning info element: invalid value
		//

		/**
		 * Happy scenario fills up all the info and submits the form
		 * 
		 * @param email
		 * @param firstname
		 * @param lastname
		 * @param password
		 * @param day
		 * @param month
		 * @param year
		 * @param jacpotAmt
		 * @param securityQuestionText
		 * @param securityAnswerText
		 * @throws Exception
		 */
		public static void fillSignupPage(WebDriver driver, String email,
				String firstname, String lastname, String password, String day,
				String month, String year, String jacpotAmt,
				String securityQuestionText, String securityAnswerText)
				throws Exception {
			LogHelper.info(email);
			inputEmailAddress(driver, email);
			LogHelper.info(firstname);
			inputFirstName(driver, firstname);
			LogHelper.info(lastname);
			inputLastName(driver, lastname);
			LogHelper.info(password);
			inputPassword(driver, password);
			LogHelper.info(day);
			inputDoBDay(driver, day);
			LogHelper.info(month);
			selectDoBMonth(driver, month);
			LogHelper.info(year);
			inputDoBYear(driver, year);
			tickPromotionReminders(driver);
			tickJackpotReminder(driver);
			selectJackpotReminderAmount(driver, jacpotAmt);
			tickIKReminder(driver);
			LogHelper.info(securityQuestionText);
			selectaQuestion(driver, securityQuestionText);
			LogHelper.info(securityAnswerText);
			InputSecurityAnswer(driver, securityAnswerText);
			clickSignup(driver);
		}

		/* Date of birth */
		public static void inputDoBDay(WebDriver driver, String day) {
			driver.findElement(BySearchDoBDay()).sendKeys(day);
			;
		}

		public static void inputDoBYear(WebDriver driver, String year) {
			driver.findElement(BySearchDoBYear()).sendKeys(year);
			;
		}

		// *******************
		// METHODS
		/* Email */
		public static void inputEmailAddress(WebDriver driver, String email)
				throws IOException {
			LogHelper.info(" inputEmailAddress......");
			driver.findElement(BySearchEmailAddress()).sendKeys(email);
			;
		}

		/* User Name */
		public static void inputFirstName(WebDriver driver, String firstName) {
			driver.findElement(BySearchFirstName()).sendKeys(firstName);
			;
		}

		public static void inputLastName(WebDriver driver, String lastName) {
			driver.findElement(BySearchLastName()).sendKeys(lastName);
			;
		}

		/* User password */
		public static void inputPassword(WebDriver driver, String password) {
			driver.findElement(BySearchPassword()).sendKeys(password);
			;
		}

		public static void InputSecurityAnswer(WebDriver driver, String answer) {
			LogHelper.info(" input security answer ......" + answer);
			secAnswerTextbox(driver).sendKeys(answer);
			;
		}

		public static WebElement secAnswerisRequired(WebDriver driver) {
			return driver
					.findElement(By
							.id("securityAnswer-Asecurityquestionandananswerisrequired"));
		}

		public static WebElement secAnswerTextbox(WebDriver driver) {
			return driver.findElement(By.id("securityAnswer"));
		}

		public static void selectaQuestion(WebDriver driver, String questionStr)
				throws Exception {
			LogHelper.info(" select security question ......" + questionStr);
			Select select = new Select(selectSecurityClick(driver));
			Thread.sleep(3000);
			select.selectByVisibleText(questionStr);
		}

		public static void selectDoBMonth(WebDriver driver, String month) {
			WebElement dobMonth = driver.findElement(BySearchDoBMonth());
			Select monthSelect = new Select(dobMonth);
			monthSelect.selectByVisibleText(month);
		}

		public static void selectJackpotReminderAmount(WebDriver driver,
				String amount) {
			WebElement JackpotReminderAmount = driver
					.findElement(BySearchJackpotReminderAmount());
			Select JackpotReminderAmountSelect = new Select(
					JackpotReminderAmount);
			JackpotReminderAmountSelect.selectByVisibleText(amount);
		}

		public static WebElement selectSecurityClick(WebDriver driver) {

			return driver.findElement((By
					.id("securityQuestionFromRegistration")));

		}

		public static void tickIKReminder(WebDriver driver) {
			// this.driver.findElement(BySearchIKReminder()).click();
			driver.findElement(BySearchIKReminder()).sendKeys(Keys.SPACE);
		}

		public static void tickJackpotReminder(WebDriver driver) {
			// this.driver.findElement(BySearchJackpotReminder()).click();
			driver.findElement(BySearchJackpotReminder()).sendKeys(Keys.SPACE);
		}

		/* Email preferences */
		public static void tickPromotionReminders(WebDriver driver) {
			// this.driver.findElement(BySearchPromotionReminders()).click();
			driver.findElement(BySearchPromotionReminders()).sendKeys(
					Keys.SPACE);
		}

	}

	public LottoSignupPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}
