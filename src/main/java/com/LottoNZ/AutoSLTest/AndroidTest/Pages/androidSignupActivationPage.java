/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.Utils.getActivationCode;

public class androidSignupActivationPage extends _AndroidBasePage {
	public static void loaded(AppiumDriver driver) throws InterruptedException {

	}

	/***********************************
	 * Page Elements
	 *********************************/
	public static WebElement activateBtn(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "ACTIVATE");
	}

	public static WebElement activationCodeTextBox(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Please enter your activation code");
	}

	public static WebElement checkforStringwithusername(AppiumDriver driver,
			String username) throws InterruptedException {
		return find(driver, String.format(
				"We've sent an activation email to: %s", username));
	}

	public static WebElement emailisReqValidation(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, "Email address is required");
	}

	/**
	 * Page Method
	 */
	public static void clickActivateBtn(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info(" click activate..... ...");
		activateBtn(driver).click();
	}

	public static void inputActivationid(AppiumDriver driver, String username)
			throws IOException, Exception, SQLException {
		Thread.sleep(3000);
		String activationCode = getActivationCode.returnActivationId(username);
		LogHelper.info(" input activation id........" + activationCode);
		activationCodeTextBox(driver).sendKeys(activationCode);
	}

}
