/**
 * 
 */
package com.LottoNZ.AutoSLTest.WebTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.WebTest.Tests.Constants;

/**
 * @author mrawal
 * 
 * 
 */
public class LottoPYOpage extends PageBase {

	/**
	 * Add lotto numbers manually
	 * 
	 * @param driver
	 * @param LottoNumber1
	 * @param LottoNumber2
	 * @param LottoNumber3
	 * @param LottoNumber4
	 * @param LottoNumber5
	 * @param LottoNumber6
	 */
	public static void addLottoNumberLineWithoutPowerball(WebDriver driver,
			int LottoNumber1, int LottoNumber2, int LottoNumber3,
			int LottoNumber4, int LottoNumber5, int LottoNumber6) {
		// 1-40
		pickLottoNumber(driver, LottoNumber1);
		pickLottoNumber(driver, LottoNumber2);
		pickLottoNumber(driver, LottoNumber3);
		pickLottoNumber(driver, LottoNumber4);
		pickLottoNumber(driver, LottoNumber5);
		pickLottoNumber(driver, LottoNumber6);
	}

	public static void addLottoNumberLineWithPowerball(WebDriver driver,
			int LottoNumber1, int LottoNumber2, int LottoNumber3,
			int LottoNumber4, int LottoNumber5, int LottoNumber6,
			int PowerballNumber) {
		// 1-40
		addLottoNumberLineWithoutPowerball(driver, LottoNumber1, LottoNumber2,
				LottoNumber3, LottoNumber4, LottoNumber5, LottoNumber6);
		pickPowerballNumber(driver, PowerballNumber);
	}

	/**
	 * Add 4 strike numbers
	 * 
	 * @param LottoNumber1
	 * @param LottoNumber2
	 * @param LottoNumber3
	 * @param LottoNumber4
	 */
	public static void addStrikeNumberLine(WebDriver driver, int LottoNumber1,
			int LottoNumber2, int LottoNumber3, int LottoNumber4) {
		try {
			Thread.sleep(100);
			pickStrikeNumber(driver, LottoNumber1);
			pickStrikeNumber(driver, LottoNumber2);
			pickStrikeNumber(driver, LottoNumber3);
			pickStrikeNumber(driver, LottoNumber4);
		} catch (InterruptedException e) {
			LogHelper.error(e.getMessage());
		}

	}

	/**
	 * Add all lotto only lines
	 * 
	 * @param driver
	 */
	public static void autofillAllLottoOnlyLines(WebDriver driver, int lineNum) {

		clickmaximiseBar(driver);
		for (int i = 1; i <= lineNum; i++) {
			LogHelper.info("Add lotto line: " + i);
			clickAutoFillLPBLine(driver, i);
			Assert.assertTrue(lottoLineNumEcom(driver, i).isDisplayed(),
					"Number of Lotto lines on eCommerce bars: " + i);
			Assert.assertTrue(powerballLineNumEcom(driver, 0).isDisplayed(),
					"Number of Lotto Powerball on eCommerce bars: " + i);
		}
		clickminimiseBar(driver);
	}

	/**
	 * Add all lotto PB lines
	 * 
	 * @param driver
	 */
	public static void autofillAllLottoPBLines(WebDriver driver, int lineNum) {
		clickmaximiseBar(driver);
		for (int i = 1; i <= lineNum; i++) {
			LogHelper.info("Add lotto line: " + i);
			clickAutoFillLPBLine(driver, i);
			Assert.assertTrue(lottoLineNumEcom(driver, i).isDisplayed(),
					"Number of Lotto lines on eCommerce bars: " + i);
			Assert.assertTrue(powerballLineNumEcom(driver, i).isDisplayed(),
					"Number of Lotto Powerball on eCommerce bars: " + i);
		}
		clickminimiseBar(driver);
	}

	/**
	 * Add all strike lines
	 * 
	 * @param driver
	 */
	public static void autofillAllStrikeLines(WebDriver driver, int lineNum) {
		clickmaximiseBar(driver);
		for (int i = 1; i <= lineNum; i++) {
			LogHelper.info("Add lotto line: " + i);
			clickStrikeAutoFillLine(driver, i);

			Assert.assertTrue(strikeLineNumEcom(driver, i).isDisplayed(),
					"Number of Strike lines on eCommerce bars: " + i);
		}
		clickminimiseBar(driver);
	}

	public static WebElement autoFillLPBLine(WebDriver driver, int lineNum) {
		LogHelper.info("Looking for autofill on line: " + lineNum);
		return driver.findElement(By.id("autofillLine" + lineNum));
	}

	public static void clickAutoFillLPBLine(WebDriver driver, int lineNum) {
		LogHelper.info("Click autofill on line: " + lineNum);
		autoFillLPBLine(driver, lineNum).click();
	}

	public static void clickdeleteLPBLine(WebDriver driver, int lineNum) {
		// using action builder here to scroll properly
		try {
			LogHelper.info("Click delete on Lotto line: " + lineNum);
			driver.manage().window().maximize();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_UP);
			Thread.sleep(500);
			action.click(deleteLPBLine(driver, lineNum)).perform();

		} catch (InterruptedException e) {
			LogHelper.error(e.getMessage());
		}
	}

	public static void clickmaximiseBar(WebDriver driver) {
		LogHelper.info("Click maximiseBar ");
		maximiseBar(driver).click();
	}

	public static void clickminimiseBar(WebDriver driver) {
		LogHelper.info("Click minimiseBar ");
		minimiseBar(driver).click();
	}

	public static void clickpowerballToggle(WebDriver driver) {
		LogHelper.info("Click powerballToggle ");
		powerballToggle(driver).click();
	}

	public static void clickStrikeAutoFillLine(WebDriver driver, int lineNum) {
		LogHelper.info("Click strike autofill on line: " + lineNum);
		strikeAutofillLine(driver, lineNum).click();
	}

	public static void clickStrikeDeleteLine(WebDriver driver, int lineNum) {
		// using action builder here to scroll properly
		try {
			LogHelper.info("Click delete on Strike line: " + lineNum);
			driver.manage().window().maximize();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_UP);
			Thread.sleep(500);
			action.click(strikeDeleteLine(driver, lineNum)).perform();

		} catch (InterruptedException e) {
			LogHelper.error(e.getMessage());
		}
	}

	/**
	 * Delete all lotto PB lines
	 * 
	 * @param driver
	 */
	public static void deleteAllLottoPBLines(WebDriver driver, int lineNum) {

		for (int i = lineNum; i >= 1; i--) {
			clickmaximiseBar(driver);
			LogHelper.info("Add lotto line: " + i);
			clickdeleteLPBLine(driver, i);
			Assert.assertTrue(lottoLineNumEcom(driver, i - 1).isDisplayed(),
					"Number of Lotto lines on eCommerce bars: " + (i - 1));
			Assert.assertTrue(
					powerballLineNumEcom(driver, i - 1).isDisplayed(),
					"Number of Lotto Powerball on eCommerce bars: " + (i - 1));
			clickminimiseBar(driver);
		}

	}

	/**
	 * Delete all strike lines
	 * 
	 * @param driver
	 */
	public static void deleteAllStrikeLines(WebDriver driver, int lineNum) {

		for (int i = lineNum; i >= 1; i--) {
			clickmaximiseBar(driver);
			LogHelper.info("Add lotto line: " + i);
			clickStrikeDeleteLine(driver, i);

			Assert.assertTrue(strikeLineNumEcom(driver, i - 1).isDisplayed(),
					"Number of Strike lines on eCommerce bars: " + (i - 1));
			clickminimiseBar(driver);
		}

	}

	public static WebElement deleteLPBLine(WebDriver driver, int lineNum) {
		LogHelper.info("Looking for delete on line: " + lineNum);
		return driver.findElement(By.id("deleteLine" + lineNum));
	}

	/**
	 * click on give line and column number, retrieve existing number and pick
	 * new number
	 * 
	 * @param driver
	 * @param line
	 * @param columnNum
	 * @param newNumber
	 */
	public static void editLottoNumberLine(WebDriver driver, String line,
			int columnNum, int newNumber) {
		try {
			Thread.sleep(100);
			LogHelper.info("Retrieve number for lotto line and column number: "
					+ line + columnNum);
			String existingLottoNum = lottoPosition(driver, line, columnNum)
					.getText();
			int oldLottoNum = Integer.parseInt(existingLottoNum);

			LogHelper.info("pick lotto poistion to edit");
			picklottoPosition(driver, line, columnNum);
			Assert.assertTrue(
					lottoNumber(driver, oldLottoNum).getAttribute("class")
							.contains("lottoNumberSelected"),
					"Verify if lotto number is selected: " + existingLottoNum);

			LogHelper.info("Unselect the lotto number: " + oldLottoNum);
			pickLottoNumber(driver, oldLottoNum);

			LogHelper.info("Select New Number: " + newNumber);

			if (oldLottoNum == newNumber) {
				pickLottoNumber(driver, newNumber);
			} else {
				pickLottoNumber(driver, newNumber);
				Assert.assertTrue(
						lottoLine(driver, line).getText().contains(
								Integer.toString(newNumber)),
						"Assert that New lotto number added: " + (newNumber));
			}
		} catch (InterruptedException e) {
			LogHelper.error(e.getMessage());
		}
	}

	/**
	 * click on give line and column number, retrieve existing number and pick
	 * new number
	 * 
	 * @param driver
	 * @param line
	 * @param columnNum
	 * @param newNumber
	 */
	public static void editPBNumberLine(WebDriver driver, String line,
			int newNumber) {
		try {
			Thread.sleep(100);
			LogHelper.info("Retrieve number for PB line: " + line);
			String existingPBNum = powerballPosition(driver, line).getText();
			int oldPBNum = Integer.parseInt(existingPBNum);

			LogHelper.info("pick PB poistion to edit");
			pickpowerballPosition(driver, line);
			Assert.assertTrue(
					powerballNumber(driver, oldPBNum).getAttribute("class")
							.contains("powerballNumberSelected"),
					"Verify if powerballNumberSelected: " + existingPBNum);

			LogHelper.info("Unselect the lotto number: " + oldPBNum);
			pickPowerballNumber(driver, oldPBNum);

			LogHelper.info("Select New Number: " + newNumber);

			if (oldPBNum == newNumber) {
				pickPowerballNumber(driver, newNumber);
			} else {
				pickPowerballNumber(driver, newNumber);
				Assert.assertTrue(Integer.parseInt(powerballPosition(driver,
						line).getText()) == newNumber,
						"Assert that New PB number added: " + (newNumber));
			}
		} catch (InterruptedException e) {
			LogHelper.error(e.getMessage());
		}
	}

	/**
	 * click on give line and column number, retrieve existing number and pick
	 * new number
	 * 
	 * @param driver
	 * @param line
	 * @param columnNum
	 * @param newNumber
	 */
	public static void editStrikeNumberLine(WebDriver driver, String line,
			int columnNum, int newNumber) {
		try {
			Thread.sleep(100);
			LogHelper.info("Retrieve number for Strike line and column number: "
					+ line + columnNum);
			String existingStrikeNum = strikePosition(driver, line, columnNum)
					.getText();
			int oldStrikeNum = Integer.parseInt(existingStrikeNum);

			LogHelper.info("pick strike poistion to edit");
			pickStrikePosition(driver, line, columnNum);
			Assert.assertTrue(
					strikeNumber(driver, oldStrikeNum).getAttribute("class")
							.contains("strikeNumberSelected"),
					"Verify if strike number is selected: " + existingStrikeNum);

			LogHelper.info("Unselect the strike number: " + oldStrikeNum);
			pickStrikeNumber(driver, oldStrikeNum);

			LogHelper.info("Select New Number: " + newNumber);

			if (oldStrikeNum == newNumber) {
				pickStrikeNumber(driver, newNumber + 1);

			} else {
				pickStrikeNumber(driver, newNumber);
				Assert.assertTrue(
						strikeLine(driver, line).getText().contains(
								Integer.toString(newNumber)),
						"Assert that New Strike number added: " + (newNumber));
			}

		} catch (InterruptedException e) {
			LogHelper.error(e.getMessage());
		}

	}

	public static WebElement lottoLine(WebDriver driver, String line) {
		LogHelper.info("Looking for strike line:" + line);
		return driver.findElement(By.xpath(String.format("//*[@id='line%s']",
				line)));
	}

	public static WebElement lottoLineNumEcom(WebDriver driver, int lineNum) {
		LogHelper.info("Looking for Number of lotto lines in ecommerceBar");
		return driver.findElement(By.id(String.format(
				lineNum == 1 ? "youHaveSelected%sLINEOfLotto"
						: "youHaveSelected%sLINESOfLotto", lineNum)));
	}

	public static WebElement lottoNumber(WebDriver driver, int num) {
		LogHelper.info("Looking for Lotto Number:" + num);

		return driver.findElement(By.xpath(String.format(
				"//*[@id='lottoNumber%s']/div/div/span", num)));
	}

	public static WebElement lottoPosition(WebDriver driver, String line,
			int num) {
		LogHelper.info("Looking for Lotto Position:" + num);
		return driver.findElement(By.id("lottoPosition" + line + num));
	}

	public static WebElement maximiseBar(WebDriver driver) {
		LogHelper.info("Looking for maximiseBar");
		return driver.findElement(By.id("maximiseBar"));
	}

	public static WebElement minimiseBar(WebDriver driver) {
		LogHelper.info("Looking for minimiseBar");
		return driver.findElement(By.id("minimiseBar"));
	}

	public static void pickLottoNumber(WebDriver driver, int num) {
		LogHelper.info("Looking for Lotto Number:" + num);
		lottoNumber(driver, num).click();
	}

	public static void picklottoPosition(WebDriver driver, String line, int num) {
		LogHelper.info("Looking for Lotto postion:" + line + num);
		lottoPosition(driver, line, num).click();
	}

	public static void pickPowerballNumber(WebDriver driver, int num) {
		LogHelper.info("Looking for PB Number:" + num);
		powerballNumber(driver, num).click();
	}

	public static void pickpowerballPosition(WebDriver driver, String line) {
		LogHelper.info("Looking for PB position:" + line);
		powerballPosition(driver, line).click();
	}

	public static void pickStrikeNumber(WebDriver driver, int num) {
		LogHelper.info("Looking for strike Number:" + num);
		strikeNumber(driver, num).click();
	}

	public static void pickStrikePosition(WebDriver driver, String line, int num) {
		LogHelper.info("Looking for strike postion:" + num);
		strikePosition(driver, line, num).click();
	}

	public static WebElement powerballLineNumEcom(WebDriver driver, int lineNum) {
		LogHelper.info("Looking for Number of lotto lines in ecommerceBar");
		return driver.findElement(By.id(String.format(
				lineNum == 1 ? "youHaveSelected%sLINEOfPowerball"
						: "youHaveSelected%sLINESOfPowerball", lineNum)));
	}

	public static WebElement powerballNumber(WebDriver driver, int num) {
		LogHelper.info("Looking for PB Number:" + num);
		return driver.findElement(By.xpath(String.format(
				"//*[@id='powerballNumber%s']/div/div/span", num)));
	}

	public static WebElement powerballPosition(WebDriver driver, String line) {
		LogHelper.info("Looking for PB Position:" + line);
		return driver.findElement(By.id("powerballPosition" + line));
	}

	public static WebElement powerballToggle(WebDriver driver) {
		LogHelper.info("Looking for powerballToggle");
		return driver.findElement(By.id("powerballToggle"));
	}

	public static WebElement strikeAutofillLine(WebDriver driver, int lineNum) {
		LogHelper.info("Looking for strikeAutofill on line: " + lineNum);
		return driver.findElement(By.id("strikeAutofillLine" + lineNum));
	}

	public static WebElement strikeBlocked(WebDriver driver) {
		LogHelper.info("Looking for strikeBlocked");
		return driver.findElement(By.id("strikeBlocked"));
	}

	public static WebElement strikeDeleteLine(WebDriver driver, int lineNum) {
		LogHelper.info("Looking for strikeDelete on line: " + lineNum);
		return driver.findElement(By.id("strikeDeleteLine" + lineNum));
	}

	public static WebElement strikeLine(WebDriver driver, String line) {
		LogHelper.info("Looking for strike line:" + line);
		return driver.findElement(By.xpath(String.format(
				"//*[@id='strikeLine%s']/div/div[1]", line)));
	}

	public static WebElement strikeLineNumEcom(WebDriver driver, int lineNum) {
		LogHelper.info("Looking for Number of lotto lines in ecommerceBar");
		return driver.findElement(By.id(String.format(
				lineNum == 1 ? "youHaveSelected%sLINEOfStrike"
						: "youHaveSelected%sLINESOfStrike", lineNum)));
	}

	public static WebElement strikeNumber(WebDriver driver, int num) {
		LogHelper.info("Looking for strike Number:" + num);
		return driver.findElement(By.xpath(String.format(
				"//*[@id='strikeNumber%s']/div/div/span", num)));
	}

	public static WebElement strikePosition(WebDriver driver, String line,
			int num) {
		LogHelper.info("Looking for strike position:" + line + num);
		return driver.findElement(By.id("strikePosition" + line + num));
	}

	/**
	 * Toggle powerball button OFF
	 * 
	 * @param driver
	 */
	public static void togglePBoff(WebDriver driver) {
		LogHelper.info("Verify if PB selection is ON by default");
		Assert.assertTrue(powerballToggle(driver).getText().contains("ON"));
		clickpowerballToggle(driver);
		LogHelper.info("Verify if PB selection is OFF now");
		Assert.assertTrue(powerballToggle(driver).getText().contains("OFF"));
	}

	/**
	 * maximise menu bar verify number of lotto lines and minimize it
	 * 
	 * @param driver
	 * @param lines
	 */
	public static void verifyLottoLinesoneCom(WebDriver driver, int lines) {
		clickmaximiseBar(driver);
		Assert.assertTrue(lottoLineNumEcom(driver, lines).isDisplayed(),
				"Number of Lotto lines on eCommerce bars: " + lines);
		clickminimiseBar(driver);
	}

	/**
	 * maximise menu bar verify number of PB lines and minimize it
	 * 
	 * @param driver
	 * @param lines
	 */
	public static void verifyPBLinesoneCom(WebDriver driver, int lines) {
		clickmaximiseBar(driver);
		Assert.assertTrue(powerballLineNumEcom(driver, lines).isDisplayed(),
				"Number of PB lines on eCommerce bars: " + lines);
		clickminimiseBar(driver);
	}

	/**
	 * Test to verify if strike is blocked for less than 4 Lotto lines
	 * 
	 * @param driver
	 */
	public static void verifyStrikeBlockedLottoOnly(WebDriver driver) {
		togglePBoff(driver);
		for (int i = 1; i < 4; i++) {
			clickAutoFillLPBLine(driver, i);
			Assert.assertTrue(strikeBlocked(driver).isDisplayed(),
					"Strike display should be blocked for " + i + "Lotto lines");
		}
		LogHelper.info("Add 4th lotto PB line");
		clickAutoFillLPBLine(driver, 4);
		Assert.assertTrue(strikeAutofillLine(driver, 1).isEnabled(),
				"Strike display should be blocked for " + 4 + "Lotto lines");

		LogHelper.info("Delete 1 lotto PB line");
		clickdeleteLPBLine(driver, 4);
		Assert.assertTrue(strikeBlocked(driver).isDisplayed(),
				"Strike display should be blocked for 3 Lotto lines");
	}

	/**
	 * Test to verify if strike is blocked for less than 4 Lotto PB lines
	 * 
	 * @param driver
	 */
	public static void verifyStrikeBlockedLottoPB(WebDriver driver) {
		for (int i = 1; i < 4; i++) {
			clickAutoFillLPBLine(driver, i);
			Assert.assertTrue(strikeBlocked(driver).isDisplayed(),
					"Strike display should be blocked for " + i
							+ "Lotto PB lines");
		}
		LogHelper.info("Add 4th lotto PB line");
		clickAutoFillLPBLine(driver, 4);
		Assert.assertTrue(strikeAutofillLine(driver, 1).isEnabled(),
				"Strike display should be blocked for " + 4 + "Lotto PB  lines");

		LogHelper.info("Delete 1 lotto PB line");
		clickdeleteLPBLine(driver, 4);
		Assert.assertTrue(strikeBlocked(driver).isDisplayed(),
				"Strike display should be blocked for 3 Lotto PB lines");
	}

	/**
	 * maximise menu bar verify number of strike lines and minimize it
	 * 
	 * @param driver
	 * @param lines
	 */
	public static void verifyStrikeLinesoneCom(WebDriver driver, int lines) {
		clickmaximiseBar(driver);
		Assert.assertTrue(strikeLineNumEcom(driver, lines).isDisplayed(),
				"Number of strike lines on eCommerce bars: " + lines);
		clickminimiseBar(driver);
	}

	public LottoPYOpage(WebDriver driver) {
		super(driver);

		driver.get(Constants.lottoPYOURL);

	}
}
