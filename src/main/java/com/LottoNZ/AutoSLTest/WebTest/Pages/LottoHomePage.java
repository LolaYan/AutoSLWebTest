/**
 * 
 */
package com.LottoNZ.AutoSLTest.WebTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Lola
 * @email lyan@planittesting.co.nz Note: define the findelement methods here in
 *        LottoHomePage
 */
public class LottoHomePage extends PageBase {

	public static By BySearchPowerball() {
		return By.cssSelector("*[title='Go to Lotto']");
	}

	public LottoHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

		this.driver.switchTo().defaultContent();
		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.presenceOfElementLocated((By
						.cssSelector("#outerBodyWrapper"))));

	}

	public By BySearch2ndChance() {
		return By.cssSelector("*[title='Go to Second Chance']");
	}

	public By BySearchBullseye() {
		return By.cssSelector("*[title='Go to Bullseye']");
	}

	public By BySearchBW() {
		return By.cssSelector("*[title='Go to Big Wednesday']");
	}

	public By BySearchForgetPwd() {
		return By.id("requestForgotPasswordLink");
	}

	public By BySearchIK() {
		return By.cssSelector("*[title='Go to Instant Kiwi']");
	}

	public By BySearchKeno() {
		return By.cssSelector("*[title='Go to Keno']");
	}

	public By BySearchLogin() {
		return By.id("loginLink");
	}

	public By BySearchPlay3() {
		return By.cssSelector("*[title='Go to Play 3']");
	}

	// *******************
	// BYELEMENTS
	// **** Search
	public By BySearchSignUp() {
		return By.id("signupLink");
	}

	// *******************
	// METHODS

	public void GoTo2ndChance() {
		// this.driver.findElement(BySearch2ndChance()).click();
		Click(BySearch2ndChance());
	}

	public void GoToBullseye() {
		// this.driver.findElement(BySearchBullseye()).click();
		Click(BySearchBullseye());
	}

	public void GoToBW() {
		// this.driver.findElement(BySearchBW()).click();
		Click(BySearchBW());
	}

	public void GoToIK() {
		// this.driver.findElement(BySearchIK()).click();
		Click(BySearchIK());
	}

	public void GoToKeno() {
		// this.driver.findElement(BySearchKeno()).click();
		Click(BySearchKeno());
	}

	public void GoToLogin() {
		// this.driver.findElement(BySearchLogin()).click();
		Click(BySearchLogin());
	}

	public void GoToPlay3() {
		// this.driver.findElement(BySearchPlay3()).click();
		Click(BySearchPlay3());
	}

	public void GoToPowerball() {
		// this.driver.findElement(BySearchPowerball()).click();
		Click(BySearchPowerball());
	}

	public void GoToSignUp() {
		// this.driver.findElement(BySearchSignUp()).click();
		Click(BySearchSignUp());
	}
}
