package com.LottoNZ.AutoSLTest.IOSTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.IOSTest.pages.iOSRegistrationPage.RegistrationPage;
import com.LottoNZ.AutoSLTest.Utils.DataGenerator;

public class ioSRegistrationTest extends IOSTestBase {

	@Test(dataProvider = "iosAppCapabilities")
	public void iOSRegistration(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws Exception {
		/**/
		System.out
				.println(String
						.format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
								appiumVersion, deviceName, deviceType,
								deviceOrientation, platformVersion,
								platformName, browserName, app));

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		driver.context("NATIVE_APP");
		String usernameText = DataGenerator.generateEmail(5);
		String fnameText = DataGenerator.generateLetters(10);
		String lnameText = DataGenerator.generateLetters(10);
		String password = "password1";
		String securityQuestionText = "What was the make of my first car?";
		String securityAnswerText = DataGenerator.generateLetters(10);
		String jackpotAmountSelect = "8.0 million";
		Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		System.out.println("Goes to check for reg now");
		RegistrationPage.loaded(driver);
		Thread.sleep(3000);
		RegistrationPage.inputEmailAddress(driver, usernameText);
		RegistrationPage.inputFirstName(driver, fnameText);
		RegistrationPage.inputLastName(driver, lnameText);
		RegistrationPage.inputPassword(driver, password);
		RegistrationPage.inputDoBDay(driver, "21");
		RegistrationPage.monthSelect(driver, "May");
		RegistrationPage.inputDoBYear(driver, "1986");
		RegistrationPage.selectaQuestion(driver, securityQuestionText);
		RegistrationPage.InputSecurityAnswer(driver, securityAnswerText);
		RegistrationPage.tickPromotionReminders(driver);
		RegistrationPage.tickJackpotReminder(driver);
		RegistrationPage.selectJackpotReminderAmount(driver,
				jackpotAmountSelect);
		RegistrationPage.tickIKReminder(driver);
		RegistrationPage.clickSignup(driver);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[contains(@name, 'MENU')]")).click();
		Thread.sleep(5000);
	}

}
