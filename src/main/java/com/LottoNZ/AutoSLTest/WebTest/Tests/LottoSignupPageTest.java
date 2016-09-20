package com.LottoNZ.AutoSLTest.WebTest.Tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.WebTest.Pages.LottoSignupPage.ActivationPage;
import com.LottoNZ.AutoSLTest.WebTest.Pages.LottoSignupPage.LoginWebPage;
import com.LottoNZ.AutoSLTest.WebTest.Pages.LottoSignupPage.compYourAccountPage;
import com.LottoNZ.AutoSLTest.WebTest.Pages.LottoSignupPage.lottoWebSignupPage;

/**
 * @author Lola
 * @email lyan@planittesting.co.nz Note: define the find element methods here in
 *        LottoSignupPage
 * 
 */
public class LottoSignupPageTest extends TestBase {

	/* Workflow: Sign up > active email > Login > bank register */
	@Test(dataProvider = "hardCodedBrowsers", priority = 1, groups = {
			"WebTest", "Signup" }, description = "Lotto Signup Page Positive Testing")
	public void verifyLottoSignupPageTest(String browser, String version,
			String os, Method method) throws Exception {

		Log.info("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		Log.info("creating successfully ......");

		/** Go to url directly **/
		driver.get(Constants.registrationURL);

		Log.info("Step 1: Fill signup page");
		lottoWebSignupPage.fillSignupPage(driver, Constants.email,
				Constants.firstname, Constants.lastname, Constants.password,
				Constants.day, Constants.month, Constants.year,
				Constants.jackpotAmt, Constants.securityQuestionText,
				Constants.securityAnswerText);

		Log.info("Step 2: Activation stage");
		ActivationPage.activeAccount(driver, Constants.email);

		Log.info("Step 3: Login with the new account");
		LoginWebPage.LoginWhileSignupStep(driver, Constants.email,
				Constants.password);

		Log.info("Step 4: Complete registraton process for this new user");
		compYourAccountPage.fillCompleteRegPage(driver, Constants.regionStr,
				Constants.locStr, Constants.genderStr,
				Constants.bankAccountBankNum, Constants.bankAccountBranchNum,
				Constants.bankAccountAccountNum,
				Constants.bankAccountSuffixNum, Constants.mobileNetworkNum,
				Constants.mobileNumberNum, Constants.password);

		Thread.sleep(5000);
	}
}
