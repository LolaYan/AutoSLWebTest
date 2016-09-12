package com.LottoNZ.AutoSLTest.AndroidTest.Pages;

import io.appium.java_client.AppiumDriver;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LottoNZ.AutoSLAndroidTest.util.mobileSwipeHelper;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.Utils.PropertyLoader;

public abstract class _AndroidBasePage {

	/**
	 * Global Settings
	 */
	private static WebDriverWait driverWait;
	public static int elementWaitInSeconds = Integer.parseInt(PropertyLoader
			.loadProjectProperty("elementWait"));
	public static String screenshotSwitch = PropertyLoader
			.loadAndroidProperty("EnableScreenshot");
	protected static int timeWaitInSeconds = Integer.parseInt(PropertyLoader
			.loadAndroidProperty("implicitlyWebWait"));

	public static int swipeTime = 1000;

	/**
	 * Press the back button *
	 */
	public static void back(AppiumDriver driver) {
		driver.navigate().back();
	}

	/**
	 * Bypass the introduction screens here
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void bypassIntroScreens(AppiumDriver driver)
			throws InterruptedException {
		driver.context("NATIVE_APP");
		WaitForElement(driver,
				By.className("android.support.v4.view.ViewPager"));
		Thread.sleep(3000);
		for (int i = 0; i < 6; i++) {
			mobileSwipeHelper.swipeLeft(driver);

		}
		find(driver, "introScreenButton").click();
	}

	public static WebElement find(AppiumDriver driver, String value)
			throws InterruptedException {
		LogHelper.info("got webelement: " + value);
		Thread.sleep(1000);
		return element(driver, by_Xpath(value));
	}

	public static WebElement findIfExisting(AppiumDriver driver, String value)
			throws InterruptedException {
		LogHelper.info("Find the element if is existing: " + value);
		Thread.sleep(1000);
		if (isElementExists(driver, by_Xpath(value)) == true) {

			return element(driver, by_Xpath(value));
		} else {

			return null;
		}
	}

	public static boolean isElementExists(AppiumDriver driver, By by) {
		boolean isExists = true;
		try {
			// WaitForElement(driver,by);
			driver.findElement(by);
		} catch (NoSuchElementException e) {
			isExists = false;
		}
		return isExists;
	}

	public static WebElement findByName(AppiumDriver driver, String Name)
			throws InterruptedException {
		LogHelper.info("got webelement by name: " + Name);
		Thread.sleep(1000);
		return element(driver, By.name(Name));
	}

	public static WebElement findByXpath(AppiumDriver driver, String Xpath)
			throws InterruptedException {
		LogHelper.info("got webelement by Xpath: " + Xpath);
		Thread.sleep(1000);
		return element(driver, By.name(Xpath));
	}

	public static By by_Xpath(String value) {
		LogHelper.info("Looking for value by Xpath: " + value);
		return By.xpath("//*[@content-desc=\"" + value
				+ "\" or @resource-id=\"" + value + "\" or @text=\"" + value
				+ "\"or @id=\"" + value + "\" or @name=\"" + value
				+ "\"] | //*[contains(translate(@content-desc,\"" + value
				+ "\",\"" + value + "\"), \"" + value
				+ "\") or contains(translate(@text,\"" + value + "\",\""
				+ value + "\"), \"" + value + "\") or @resource-id=\"" + value
				+ "\"]");
	}

	/**
	 * Return an element by locator *
	 */
	public static WebElement element(AppiumDriver driver, By locator) {
		WaitForElement(driver, locator);
		return driver.findElement(locator);
	}

	/**
	 * Return a static text element by xpath index *
	 */
	public static WebElement s_text(AppiumDriver driver, int xpathIndex) {
		return element(driver, for_text(xpathIndex));
	}

	/**
	 * Return a list of elements by tag name *
	 */
	public static List<WebElement> tags(AppiumDriver driver, String tagName) {
		return elements(driver, for_tags(tagName));
	}

	/**
	 * Return a static text element that contains text *
	 */
	public static WebElement text(AppiumDriver driver, String text) {
		return element(driver, for_text(text));
	}

	/**
	 * Return a static text element by exact text *
	 */
	public static WebElement text_exact(AppiumDriver driver, String text) {
		return element(driver, for_text_exact(text));
	}

	/**
	 * Return a list of elements by locator *
	 */
	public static List<WebElement> elements(AppiumDriver driver, By locator) {
		WaitForElement(driver, locator);
		return driver.findElements(locator);
	}

	/**
	 * Return a tag name locator *
	 */
	public static By for_tags(String tagName) {
		return By.className(tagName);
	}

	/**
	 * Return a static text locator by xpath index *
	 */
	public static By for_text(int xpathIndex) {
		return By.xpath("//android.widget.TextView[" + xpathIndex + "]");
	}

	/**
	 * Return a static text locator that contains text *
	 */
	public static By for_text(String text) {
		return By.xpath("//android.widget.TextView[contains(@text, '" + text
				+ "')]");
	}

	/**
	 * Return a static text locator by exact text *
	 */
	public static By for_text_exact(String text) {
		return By.xpath("//android.widget.TextView[@text='" + text + "']");
	}

	public static void SendKeys(AppiumDriver driver, WebElement ele, String str) {
		try {
			LogHelper.info(" Input string: " + str + " into element:" + ele);

			driver.context("NATIVE_APP");
			LogHelper.info("ele get Tag Name :" + ele.getTagName());
			ele.clear();
			ele.sendKeys(str);
			driver.hideKeyboard();
		} catch (Exception e) {
			LogHelper.error(" * Fail to input string: " + str
					+ " into element:" + ele + " ! \r\n Error Msg:"
					+ e.getMessage() + " ! ");
		}

	}

	/**
	 * Set implicit wait in seconds, which is set up in Config*
	 */
	public static void setImplicitlyWait(AppiumDriver driver) {
		driver.manage().timeouts()
				.implicitlyWait(timeWaitInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * Set implicit wait in seconds *
	 */
	public static void setImplicitlyWait(AppiumDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * Wait 30 seconds for locator to find an element *
	 */
	public static WebElement wait(By locator) {
		return driverWait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
	}

	/**
	 * Wait 60 seconds for locator to find all elements *
	 */
	public static List<WebElement> waitAll(By locator) {
		return driverWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(locator));
	}

	// wait for element to be clickable
	public static void WaitForElement(AppiumDriver driver, By by) {
		// timeoutInSeconds value should read from global contants file
		int timeoutInSeconds = elementWaitInSeconds;
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		if (timeoutInSeconds > 0) {
			wait.until(ExpectedConditions.elementToBeClickable(by));
		}
	}

	// wait x seconds for element to be clickable
	public static void WaitForElement(AppiumDriver driver, By by,
			int durationSeconds) {
		try {
			LogHelper.info(" Wait for " + durationSeconds
					+ " seconds before element " + by + " displayed");
			WebDriverWait wait = new WebDriverWait(driver, durationSeconds);
			if (durationSeconds > 0) {
				wait.until(ExpectedConditions.elementToBeClickable(by));
			}
		} catch (Exception e) {
			LogHelper.error(" * Fail to Wait for " + durationSeconds
					+ " seconds before element " + by
					+ " displayed ! \r\n Error Msg:" + e.getMessage());
		}
	}

	/**
	 * Wait 60 seconds for locator to not find a visible element *
	 */
	public static boolean waitInvisible(By locator) {
		return driverWait.until(ExpectedConditions
				.invisibilityOfElementLocated(locator));
	}

}
