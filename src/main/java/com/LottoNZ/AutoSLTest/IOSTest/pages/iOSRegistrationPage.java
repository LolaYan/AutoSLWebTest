/**
 * 
 */
package com.LottoNZ.AutoSLTest.IOSTest.pages;

/**
 * @author MRawal
 *
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLTest.Utils.DBHelper;

public class iOSRegistrationPage extends IOSBasepage {

	/** Page object for the Registration page **/
	public abstract static class ActivationPage {
		public static WebElement activateBtn(AppiumDriver<WebElement> driver) {
			return find(driver, "ACTIVATE");
		}

		public static WebElement activationCodeTextBox(
				AppiumDriver<WebElement> driver) {
			return find(driver, "Please enter your activation code");
		}

		public static WebElement checkforStringwithusername(
				AppiumDriver<WebElement> driver, String username) {
			return find(driver, String.format(
					"We've sent an activation email to: %s", username));
		}

		public static void clickActivateBtn(AppiumDriver<WebElement> driver) {
			System.out.println(" click activate..... ...");
			activateBtn(driver).click();
		}

		public static WebElement emailisReqValidation(
				AppiumDriver<WebElement> driver) {
			return find(driver, "Email address is required");
		}

		public static void inputActivationid(AppiumDriver<WebElement> driver,
				String username) throws IOException, Exception, SQLException {
			Thread.sleep(3000);
			String activationCode = DBHelper.getActivationId(username);
			System.out.println(" input activation id........" + activationCode);
			activationCodeTextBox(driver).sendKeys(activationCode);
		}
	}

	/** Page object for the Registration page **/
	public abstract static class RegistrationPage {

		public static void clickSignup(AppiumDriver<WebElement> driver) {
			signupBtn(driver).click();
		}

		public static WebElement dateTextBox(AppiumDriver<WebElement> driver) {

			return find(driver, "DD");
		}

		public static WebElement dOBTextBox(AppiumDriver<WebElement> driver) {
			return find(driver, "Date of birth");
		}

		public static WebElement emailisReqValidation(
				AppiumDriver<WebElement> driver) {
			return find(driver, "Email address is required");
		}

		public static WebElement emailTextBox(AppiumDriver driver) {
			System.out.println(driver.getPageSource());
			return driver.findElement(MobileBy
					.xpath("//UIAElement[contains(@name,'Email')]"));

		}

		public static WebElement firstNameisRequired(
				AppiumDriver<WebElement> driver) {
			return find(driver, "First name is required");
		}

		public static WebElement firstNameTextBox(
				AppiumDriver<WebElement> driver) {
			return find(driver, "First name");
		}

		public static WebElement hidepasswordLink(
				AppiumDriver<WebElement> driver) {
			return find(driver, "Hide password");
		}

		public static WebElement IKCheckbox(AppiumDriver<WebElement> driver) {
			return find(driver, "Instant Kiwi news and reminders");
		}

		/* Date of birth */
		public static void inputDoBDay(AppiumDriver<WebElement> driver,
				String day) throws InterruptedException {
			System.out.println(" input DD  ......" + day);
			dOBTextBox(driver).sendKeys(day);
			Thread.sleep(500);
			System.out.println("-----------------------"
					+ driver.getPageSource());
			System.out.println("picker wheel: "
					+ driver.findElement(By.className("UIAPickerWheel"))
							.getAttribute("values"));
			System.out.println("uiapicker value: "
					+ driver.findElement(By.className("UIAPickerWheel"))
							.getText());
			WebElement month = driver.findElement(By
					.xpath("//UIAPickerWheel[1]"));
			WebElement date = driver.findElement(By
					.xpath("//UIAPickerWheel[2]"));
			WebElement year = driver.findElement(By
					.xpath("//UIAPickerWheel[3]"));
			System.out.println(month.getText());
			month.sendKeys("December");
			System.out.println(date.getText());
			date.sendKeys("25");
			System.out.println(year.getText());
			year.sendKeys("2016");
		}

		public static void inputDoBYear(AppiumDriver<WebElement> driver,
				String year) {
			System.out.println(" input year ......" + year);
			yearTextbox(driver).sendKeys(year);
			;
		}

		public static void inputEmailAddress(AppiumDriver<WebElement> driver,
				String email) throws IOException, InterruptedException {
			System.out.println(" inputEmailAddress......" + email);
			sendKeysiOS(driver, emailTextBox(driver), email);
		}

		/* User Name */
		public static void inputFirstName(AppiumDriver<WebElement> driver,
				String firstName) {
			System.out.println(" input Frist name ......" + firstName);
			sendKeysiOS(driver, firstNameTextBox(driver), firstName);
		}

		public static void inputLastName(AppiumDriver<WebElement> driver,
				String lastName) {
			System.out.println(" input last name ......" + lastName);
			sendKeysiOS(driver, lastNameTextBox(driver), lastName);
		}

		/* User password */
		public static void inputPassword(AppiumDriver<WebElement> driver,
				String password) {
			System.out.println(" input password ......" + password);
			sendKeysiOS(driver, PasswordTextBox(driver), password);
		}

		public static void InputSecurityAnswer(AppiumDriver<WebElement> driver,
				String answer) {
			System.out.println(" input security answer ......" + answer);
			secAnswerTextbox(driver).sendKeys(answer);
			;
		}

		public static WebElement jackpotPromoCheckbox(
				AppiumDriver<WebElement> driver) {
			return find(driver, "Jackpots reminders + Promotions");
		}

		public static WebElement lastNameisReqValidation(
				AppiumDriver<WebElement> driver) {
			return find(driver, "Last name is required");
		}

		public static WebElement lastNameTextBox(AppiumDriver<WebElement> driver) {
			return find(driver, "Last name");
		}

		/**
		 * go to the Registration page
		 * 
		 * @throws InterruptedException
		 **/
		public static void loaded(AppiumDriver driver)
				throws InterruptedException {
			System.out.println("in loaded ");
			if (find(driver, "Ignore").isDisplayed()) {
				find(driver, "Ignore").click();
			}

			find(driver, "nav-item-log-in-sign-up-link").click();
			Thread.sleep(1000);

			System.out.println("Loaded Registration");
			find(driver, "SignupFromLogin").click();
		}

		public static WebElement loginLink(AppiumDriver<WebElement> driver) {
			return find(driver, "Log in");
		}

		public static WebElement monthClick(AppiumDriver<WebElement> driver) {
			return find(driver, "Month");
		}

		/**
		 * Please Select month name like January, February, March, April, May,
		 * June, July, August, September, October, November, December
		 * 
		 * @param driver
		 * @param monthName
		 * @return
		 * @throws Exception
		 */
		public static void monthSelect(AppiumDriver<WebElement> driver,
				String monthName) throws Exception {
			System.out.println(" select month ......" + monthName);
			monthClick(driver).click();
			Thread.sleep(1000);
			find(driver, monthName).click();
			;
		}

		public static WebElement passwordisReqValidation(
				AppiumDriver<WebElement> driver) {
			return find(driver, "Password is required");
		}

		public static WebElement PasswordTextBox(AppiumDriver<WebElement> driver) {
			return find(driver, "Password");
		}

		public static WebElement resultsPRomoCheckbox(
				AppiumDriver<WebElement> driver) {
			return find(driver, "Results + Promotions");
		}

		public static WebElement secAnswerisRequired(
				AppiumDriver<WebElement> driver) {
			return find(driver, "A security question and an answer is required");
		}

		public static WebElement secAnswerTextbox(
				AppiumDriver<WebElement> driver) {
			return find(driver, "Form input sequrity answer");
		}

		public static void selectaQuestion(AppiumDriver<WebElement> driver,
				String questionStr) throws Exception {
			System.out
					.println(" select security question ......" + questionStr);
			selectSecurityClick(driver).click();
			Thread.sleep(3000);
			find(driver, questionStr).click();
			;
		}

		public static WebElement selectJackpotAmount(
				AppiumDriver<WebElement> driver) {
			return find(driver, "4.0 million");
		}

		/**
		 * 4.0 million
		 * 
		 * @param driver
		 * @param amount
		 */
		public static void selectJackpotReminderAmount(
				AppiumDriver<WebElement> driver, String amount) {
			System.out.println("select a jackpot amount.... " + amount);
			selectJackpotAmount(driver).click();
			;
			find(driver, amount).click();
		}

		public static WebElement selectSecurityClick(
				AppiumDriver<WebElement> driver) {
			driver.scrollTo("Select one");
			return find(driver, "Select one");
		}

		public static WebElement showpasswordLink(
				AppiumDriver<WebElement> driver) {
			return find(driver, "Show password");
		}

		public static WebElement signupBtn(AppiumDriver<WebElement> driver) {
			return find(driver, "clickToSignUp");
		}

		public static void tickIKReminder(AppiumDriver<WebElement> driver) {
			// this.driver.findElement(BySearchIKReminder()).click();
			IKCheckbox(driver).click();
		}

		public static void tickJackpotReminder(AppiumDriver<WebElement> driver) {
			// this.driver.findElement(BySearchJackpotReminder()).click();
			jackpotPromoCheckbox(driver).click();
		}

		/* Email preferences */
		public static void tickPromotionReminders(
				AppiumDriver<WebElement> driver) {
			// this.driver.findElement(BySearchPromotionReminders()).click();
			resultsPRomoCheckbox(driver).click();
		}

		public static WebElement tncLink(AppiumDriver<WebElement> driver) {
			return find(driver, "terms and conditions");
		}

		public static WebElement yearTextbox(AppiumDriver<WebElement> driver) {
			return find(driver, "YYYY");
		}

		public void clickLoginLink(AppiumDriver<WebElement> driver) {
			loginLink(driver).click();
		}

		public void clickTnCs(AppiumDriver<WebElement> driver) {
			tncLink(driver).click();
		}

	}

}
