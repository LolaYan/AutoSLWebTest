package com.LottoNZ.AutoSLTest.IOSTest.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class IOSBasepage {
	public static final String CLICK_ON_DONE_KEYBOARD = "target.frontMostApp().keyboard().typeString('\n')";
	private static final String DISMISPOPUP = "target.frontMostApp().mainWindow().popover().dismiss()";
	private static WebDriverWait driverWait;
	private static final String GET_KEYBOARD_SCRIPT = "UIATarget.localTarget().frontMostApp().keyboard()";
	private static final String GET_LOG_ELEMENT_TREE = "UIATarget.localTarget().frontMostApp().logElementTree()";
	private static final String ORIENTATION_LANDSCAPE = "target.setDeviceOrientation(UIA_DEVICE_ORIENTATION_LANDSCAPERIGHT)";

	private static final String ORIENTATION_POTRAIT = "target.setDeviceOrientation(UIA_DEVICE_ORIENTATION_PORTRAIT)";
	public static URL serverAddress;
	private static final String SET_DELAY_IN_INPUT = "target.frontMostApp().keyboard().setInterKeyDelay(0.3)";
	protected static String targetMenu = "UIATarget.localTarget().frontMostApp().mainWindow().navigationBar().buttons().withName(%s).tap()";

	/**
	 * Press the back button *
	 */
	public static void back(AppiumDriver driver) {
		driver.navigate().back();
	}

	/**
	 * Return an element by locator *
	 */
	public static WebElement element(AppiumDriver driver, By locator) {
		return driver.findElement(locator);
	}

	/**
	 * Return a list of elements by locator *
	 */
	public static List<WebElement> elements(AppiumDriver driver, By locator) {
		return driver.findElements(locator);
	}

	public static WebElement find(AppiumDriver driver, String value) {
		System.out.println("got webelement: " + value);
		return element(driver, for_find(value));
	}

	public static By for_find(String value) {
		System.out.println("Looking for value: " + value);
		By byxpath = By.xpath("//*[contains(@name,'" + value
				+ "') or contains(@label,'" + value + "') ]");
		System.out.println(byxpath);
		return By.xpath("//*[contains(@name,'" + value
				+ "') or contains(@label,'" + value + "') ]");
	}

	/**
	 * Return a tag name locator *
	 */
	public static By for_tags(String tagName) {
		return By.className(tagName);
	}

	/**
	 * Initialize the webdriver. Must be called before using any helper methods.
	 * *
	 */
	public static void init(IOSDriver<WebElement> webDriver,
			URL driverServerAddress) {

		serverAddress = driverServerAddress;
		int timeoutInSeconds = 100;
		// must wait at least 60 seconds for running on Sauce.
		// waiting for 30 seconds works locally however it fails on Sauce.
		driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
	}

	public static String keyboardScript(String script) {

		return GET_KEYBOARD_SCRIPT + script;
	}

	/**
	 * Return an element that contains name or text *
	 */
	public static WebElement scroll_to(AppiumDriver driver, String value) {
		return driver.scrollTo(value);
	}

	/**
	 * Return an element that exactly matches name or text *
	 */
	public static WebElement scroll_to_exact(AppiumDriver driver, String value) {
		return driver.scrollToExact(value);
	}

	/**
	 * Clicks on the element clears the existing text sets delay of 0.1 sec
	 * between key presses inputs values from keypads
	 */
	public static void sendKeysiOS(AppiumDriver<WebElement> driver,
			WebElement element, String val) {
		// set interkey delay of 0.1 seconds. this helps in entering correct
		// keys
		element.clear();
		element.click();
		driver.executeScript(SET_DELAY_IN_INPUT);

		driver.executeScript(keyboardScript(typeScript(val)));
	}

	protected static String setValue(String text) {
		return String.format(".setValue(\"%s\");", new Object[] { text });
	}

	/**
	 * Set implicit wait in seconds *
	 */
	public static void setWait(AppiumDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * Return a list of elements by tag name *
	 */
	public static List<WebElement> tags(AppiumDriver driver, String tagName) {
		return elements(driver, for_tags(tagName));
	}

	protected static String typeScript(String text) {
		return String.format(".typeString(\"%s\");", new Object[] { text });
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

	/**
	 * Wait 60 seconds for locator to not find a visible element *
	 */
	public static boolean waitInvisible(By locator) {
		return driverWait.until(ExpectedConditions
				.invisibilityOfElementLocated(locator));
	}

	private void executeScript(String script, IOSDriver driver) {
		IOSDriver jsExecutor = driver;
		jsExecutor.executeScript(this.keyboardScript(script), new Object[0]);
	}

	public void pressKey(String key, IOSDriver<WebElement> driver) {
		this.executeScript(this.pressKeyScript(key), driver);
	}

	private String pressKeyScript(String key) {
		return String.format(".keys().firstWithName(\"%s\").tap();",
				new Object[] { key });
	}

	public void type(String text, IOSDriver<WebElement> driver) {
		this.executeScript(this.typeScript(text), driver);
	}
}
