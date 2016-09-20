/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLoginPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidSignupCompleteAccountPage;
import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidSignupRegistrationPage;
import com.LottoNZ.AutoSLTest.Endpoints.CoreGameEndpointCall;
import com.LottoNZ.AutoSLTest.Utils.AccountActicationHelper;
import com.LottoNZ.AutoSLTest.Utils.DataGenerator;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.Utils.BankAccountHelper.BankAccountGenerator;

public class androidAccountRegistrationTest extends _AndroidTestBase {

	protected static String DoBDay = "21";
	protected static String DoBYear = "1986";
	protected static String fnameText = "Automation";
	protected static String Gender = "Male";
	protected static String jackpotAmountSelect = "8.0 million";
	protected static String lnameText = "Test";
	protected static String LocationStr = "Auckland City";
	protected static String mobileCode = "021";
	protected static String mobileNumber = "1234567";
	protected static String monthSelectStr = "May";
	protected static String password = "password1";
	protected static String RegionStr = "Auckland";
	protected static String securityAnswerText = "SecurityAnswer";
	protected static String securityQuestionText = "What town was I born in?";
	protected static String usernameText = DataGenerator.generateEmail(10);

	@Test(dataProvider = "AndroidAppCapabilities")
	public void RegistrationTest(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws InvalidElementStateException,
			InterruptedException, Exception {
		// usernameText= "automation@autotest.com";
		LogHelper
				.info(String
						.format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
								appiumVersion, deviceName, deviceType,
								deviceOrientation, platformVersion,
								platformName, browserName, app));

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());

		jackpotAmountSelect = "All";

		androidSignupRegistrationPage.bypassIntroScreens(driver);
		Thread.sleep(1000);
		androidSignupRegistrationPage.loaded(driver);

		androidSignupRegistrationPage.inputEmailAddress(driver, usernameText);
		androidSignupRegistrationPage.inputFirstName(driver, fnameText);
		androidSignupRegistrationPage.inputLastName(driver, lnameText);
		androidSignupRegistrationPage.inputPassword(driver, password);
		androidSignupRegistrationPage.inputDoBDay(driver, DoBDay);
		androidSignupRegistrationPage.monthSelect(driver, monthSelectStr);
		androidSignupRegistrationPage.inputDoBYear(driver, DoBYear);
		androidSignupRegistrationPage.clickGenderButton(driver, Gender);
		androidSignupRegistrationPage.inputMobileCode(driver, mobileCode);
		androidSignupRegistrationPage.inputMobileNumber(driver, mobileNumber);
		androidSignupRegistrationPage.clickRegionSelector(driver);
		androidSignupRegistrationPage.selectaRegion(driver, RegionStr);
		androidSignupRegistrationPage.clickLocationSelector(driver);
		androidSignupRegistrationPage.selectaLocation(driver, LocationStr);
		// securityQuestionText is not working in SL android simulator
		// androidSignupRegistrationPage.selectaQuestion(driver);
		androidSignupRegistrationPage.selectaQuestion(driver,
				securityQuestionText);
		androidSignupRegistrationPage.InputSecurityAnswer(driver,
				securityAnswerText);
		/*
		 * androidSignupRegistrationPage.tickJackpotReminder(driver);
		 * androidSignupRegistrationPage.clickJackpotRemindersSelect(driver);
		 * androidSignupRegistrationPage
		 * .selectJackpotReminderAmount(driver,jackpotAmountSelect);
		 */
		androidSignupRegistrationPage.tickPromotionReminders(driver);
		androidSignupRegistrationPage.tickIKReminder(driver);
		androidSignupRegistrationPage.clickSignup(driver);
		Thread.sleep(2000);
		
		
		// Activate the account
		//String ActivationId = AccountActicationHelper.getActivationId(usernameText);
		//AccountActicationHelper.sendPut(ActivationId);
		CoreGameEndpointCall.activateEmail(usernameText);
		Thread.sleep(5000);

		/*
		 * androidSignupActivationPage.inputActivationid(driver, usernameText);
		 * androidSignupActivationPage.clickActivateBtn(driver);
		 * Thread.sleep(5000);
		 */

		// Login again
		androidLoginPage.loaded(driver);
		androidLoginPage.enterLoginemail(driver, usernameText);
		androidLoginPage.enterLoginPassword(driver, password);
		androidLoginPage.clickLoginBtn(driver);
		Thread.sleep(1000);

		// BankAccount
		BankAccountGenerator.getBankAccount("B");
		String bankAccountBank = BankAccountGenerator.BankIDStr;
		String bankAccountBranch = BankAccountGenerator.BankBranchStr;
		String bankAccountBase = BankAccountGenerator.BankAccountBaseStr;
		String bankAccountSuffix = BankAccountGenerator.suffixStr;
		LogHelper.info("BankAccountStr: " + BankAccountGenerator.BankIDStr
				+ "-" + BankAccountGenerator.BankBranchStr + "-"
				+ BankAccountGenerator.BankAccountBaseStr + "-"
				+ BankAccountGenerator.suffixStr);
		androidSignupCompleteAccountPage.inputBankAccountBank(driver,
				bankAccountBank);
		androidSignupCompleteAccountPage.inputBankAccountBranch(driver,
				bankAccountBranch);
		androidSignupCompleteAccountPage.inputBankAccountAccount(driver,
				bankAccountBase);
		androidSignupCompleteAccountPage.inputBankAccountSuffix(driver,
				bankAccountSuffix);
		androidSignupCompleteAccountPage.clickDoneBtn(driver);
		Thread.sleep(2000);

		// Pop up msg saying
		// "Registration is complete??You are ready to start using Lotto!"
		// Assert msg
		androidSignupCompleteAccountPage.clickOKBtn(driver);
		Thread.sleep(5000);

		//Recode Email
		LogHelper.recordEmail(usernameText);

	}
}
