package com.LottoNZ.AutoSLWebTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by mehmetgerceker on 12/7/15.
 */
public class PageBase {

	protected WebDriver driver;

	// initiate driver
	public PageBase(WebDriver driver) {
		this.driver = driver;
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

	public void NavURL(String url) {
		try {
			this.driver.get(url);
		} catch (Exception e) {
		}

	}
	

	public void Click(By by) {
		try {
			this.driver.findElement(by).click();
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

	protected static void setTextInputValue(WebElement textInput, String value)
			throws InvalidElementStateException {
		setTextElementText(textInput, "text", "input", value);

	}

	protected static void setTextAreaInputValue(WebElement textArea,
			String value) throws InvalidElementStateException {
		setTextElementText(textArea, "textarea", "textarea", value);
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
}
