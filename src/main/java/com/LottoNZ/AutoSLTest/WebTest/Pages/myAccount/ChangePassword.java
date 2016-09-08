package com.LottoNZ.AutoSLTest.WebTest.Pages.myAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.LottoNZ.AutoSLTest.WebTest.Pages.PageBase;

public class ChangePassword extends PageBase {
	public static WebElement changePasswordOld(WebDriver driver) {

		return find(driver, "change-password-old");
	}

	public static WebElement closeModal(WebDriver driver) {

		return find(driver, "close-modal");
	}

	public static WebElement newpassword(WebDriver driver) {

		return find(driver, "newpassword");
	}

	public static WebElement newPasswordisrequired(WebDriver driver) {

		return find(driver, "newpassword-Passwordisrequired");
	}

	public static WebElement oldPasswordisrequired(WebDriver driver) {

		return find(driver, "oldpassword-Passwordisrequired");
	}

	public static WebElement submitBtn(WebDriver driver) {

		return find(driver, "change-password-submit-button");
	}

	public static WebElement toggleShowHidePassword(WebDriver driver) {

		return find(driver, "toggleShowHidePassword");
	}

	public ChangePassword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}
