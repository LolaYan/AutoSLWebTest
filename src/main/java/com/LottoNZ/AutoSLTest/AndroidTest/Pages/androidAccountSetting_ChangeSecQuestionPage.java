/**
 * 
 */
package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;

/**
 * @author MRawal
 *
 */
public class androidAccountSetting_ChangeSecQuestionPage extends
		_AndroidBasePage {
	protected static String securityQuestionSelector_ContentDesc = "securityQuestionText";
	protected static String securityAnswerTextField_ContentDesc = "Form input sequrity answer";
	protected static String passwordTextField_ContentDesc = "questionPasswordInput";
	protected static String saveButton_ContentDesc = "securityQuestionSubmit";

	public static void loaded(AppiumDriver driver) throws InterruptedException {
	}

	/**
	 * Element
	 */

	// myDetails
	public static WebElement securityQuestionSelector(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, securityQuestionSelector_ContentDesc);
	}

	public static WebElement securityAnswerTextField(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, securityAnswerTextField_ContentDesc);
	}

	public static WebElement passwordTextField(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, passwordTextField_ContentDesc);
	}

	public static WebElement saveButton(AppiumDriver driver)
			throws InterruptedException {
		return find(driver, saveButton_ContentDesc);
	}

	/**
	 * Method
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void openSecurityQuestionSelector(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Open Security Question Selector");
		securityQuestionSelector(driver).click();

	}

	public static void clickSecurityQuestion(AppiumDriver driver,
			String securityQuestion) throws InterruptedException {
		LogHelper.info(" click Security Question:" + securityQuestion);
		find(driver, securityQuestion).click();
	}

	public static void inputSecurityAnswer(AppiumDriver driver,
			String securityAnswer) throws InterruptedException {
		LogHelper.info(" input securityAnswer:" + securityAnswer);
		SendKeys(driver, securityAnswerTextField(driver), securityAnswer);
	}

	public static void inputPassword(AppiumDriver driver, String password)
			throws InterruptedException {
		LogHelper.info(" input Password:" + password);
		SendKeys(driver, passwordTextField(driver), password);
	}

	public static void clickSave(AppiumDriver driver)
			throws InterruptedException {
		LogHelper.info("Click Save Button");
		saveButton(driver).click();

	}

}
