package com.LottoNZ.AutoSLTest.WebTest.Pages;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LottoNZ.AutoSLTest.Utils.PropertyLoader;

/**
 *
 */
public class PageBase {

	protected static WebDriver driver;
	private static WebDriverWait driverWait;

	public static URL serverAddress;

	/**
	 * Press the back button *
	 */
	public static void back(WebDriver driver) {
		driver.navigate().back();
	}

	protected static void clickButton(WebElement button)
			throws InvalidElementStateException {
		if (!button.getAttribute("type").contentEquals("submit")
				|| !button.getTagName().toLowerCase().contentEquals("input")) {
			throw new InvalidElementStateException(
					"This web element is not a button input!");
		}
		// we may wanna check if it is displayed and enabled, when performing
		// actions.
		if (button.isDisplayed() && button.isEnabled()) {
			button.click();
		} else {
			throw new InvalidElementStateException("Button by "
					+ button.getAttribute("id")
					+ " is disabled or not displayed!");
		}
	}

	/**
	 * Return an element by locator *
	 */
	public static WebElement element(WebDriver driver, By locator) {
		return driver.findElement(locator);
	}

	/**
	 * Return a list of elements by locator *
	 */
	public static List<WebElement> elements(WebDriver driver, By locator) {
		return driver.findElements(locator);
	}

	public static WebElement find(WebDriver driver, String value) {
		System.out.println("got webelement: " + value);
		return element(driver, for_find(value));
	}

	public static By for_find(String value) {
		System.out.println("Looking for value: " + value);
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

	/**
	 * Initialize the webdriver. Must be called before using any helper methods.
	 * *
	 */
	public static void init(WebDriver webDriver, URL driverServerAddress) {

		serverAddress = driverServerAddress;
		int timeoutInSeconds = 60;
		// must wait at least 60 seconds for running on Sauce.
		// waiting for 30 seconds works locally however it fails on Sauce.
		driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
	}

	/**
	 * Return a static text element by xpath index *
	 */
	public static WebElement s_text(WebDriver driver, int xpathIndex) {
		return element(driver, for_text(xpathIndex));
	}

	protected static void setCheckCheckBoxState(WebElement checkBox,
			boolean checked) throws InvalidElementStateException {
		if (!checkBox.getAttribute("type").contentEquals("checkbox")
				|| !checkBox.getTagName().toLowerCase().contentEquals("input")) {
			throw new InvalidElementStateException(
					"This web element is not a checkbox!");
		}
		// we may wanna check if it is displayed and enabled, when performing
		// actions.
		if (checkBox.isDisplayed() && checkBox.isEnabled()) {
			if (checkBox.isSelected() != checked) {
				checkBox.click();
			}
		} else {
			throw new InvalidElementStateException("Checkbox by "
					+ checkBox.getAttribute("id") + " is disabled!");
		}

	}

	protected static void setTextAreaInputValue(WebElement textArea,
			String value) throws InvalidElementStateException {
		setTextElementText(textArea, "textarea", "textarea", value);
	}
	private static void setTextElementText(WebElement textElement,
			String textInputType, String tag, String value)
			throws InvalidElementStateException {
		if (!textElement.getAttribute("type").contentEquals(textInputType)
				|| !textElement.getTagName().toLowerCase().contentEquals(tag)) {
			throw new InvalidElementStateException(
					"This web element is not a text input!");
		}
		// we may wanna check if it is displayed and enabled, when performing
		// actions.
		if (textElement.isDisplayed() && textElement.isEnabled()) {
			textElement.click();
			textElement.clear();
			textElement.sendKeys(value);
		} else {
			throw new InvalidElementStateException("Text input by "
					+ textElement.getAttribute("id")
					+ " is disabled or not displayed!");
		}
	}

	protected static void setTextInputValue(WebElement textInput, String value)
			throws InvalidElementStateException {
		setTextElementText(textInput, "text", "input", value);

	}

	/**
	 * Set implicit wait in seconds *
	 */
	public static void setWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * Return a list of elements by tag name *
	 */
	public static List<WebElement> tags(WebDriver driver, String tagName) {
		return elements(driver, for_tags(tagName));
	}

	/**
	 * Return a static text element that contains text *
	 */
	public static WebElement text(WebDriver driver, String text) {
		return element(driver, for_text(text));
	}

	/**
	 * Return a static text element by exact text *
	 */
	public static WebElement text_exact(WebDriver driver, String text) {
		return element(driver, for_text_exact(text));
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

	protected PropertyLoader propertyLoader;

	// initiate driver
	public PageBase(WebDriver driver) {
		this.driver = driver;
	}

	public void Click(By by) {
		try {
			this.driver.findElement(by).click();
		} catch (Exception e) {
		}
	}

	public String GetCurrentURL() {
		String url = null;
		try {
			url = this.driver.getCurrentUrl();
		} catch (Exception e) {
		}
		return url;
	}

	public String GetText(By by) {
		String text = null;
		try {
			text = this.driver.findElement(by).getText();
		} catch (Exception e) {
		}
		return text;
	}

	public By getWebOjectLocator(String locatorName) throws IOException {
		System.out.println(" PageBase getWebOjectLocator......" + locatorName);
		return propertyLoader.getWebOjectLocator(locatorName);
	}

	public void NavURL(String url) {
		try {
			this.driver.get(url);
		} catch (Exception e) {
		}

	}

	public void SendKeys(By by, String str) {
		try {
			this.driver.findElement(by).sendKeys(str);
			;
		} catch (Exception e) {
		}

	}

	public void Submit(By by) {
		try {
			this.driver.findElement(by).submit();
		} catch (Exception e) {
		}
	}

	// wait x seconds for element to be clickable
	public void WaitForElement(By by, int durationSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(this.driver, durationSeconds);
			if (durationSeconds > 0) {
				wait.until(ExpectedConditions.elementToBeClickable(by));
			}
		} catch (Exception e) {

		}
	}

}
