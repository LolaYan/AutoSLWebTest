/**
 * 
 */
package com.LottoNZ.AutoSLTest.WebTest.Tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

/**
 * @author MRawal
 *
 */
public class verify {

	/**
	 * verifies if element is selected
	 * 
	 * @param element
	 * @return true false
	 */

	public static boolean isElementNotSelected(WebElement element,
			String eleName) {

		if (element.isSelected()) {

			System.out.println(eleName + " is not selected");
			return false;
		} else {
			System.out.println(eleName + " is selected");
			return true;
		}
	}

	/**
	 * verifies if element is disabled
	 * 
	 * @param element
	 * @return true false
	 */

	public static boolean isElementsDisabled(WebElement element) {

		if (element.isEnabled()) {

			System.out.println("Element is disabled");
			return false;
		} else {
			System.out.println("Element is enabled");
			return true;
		}
	}

	/**
	 * verifies if element is enabled
	 * 
	 * @param element
	 * @return true false
	 */

	public static boolean isElementsEnabled(WebElement element) {

		if (element.isEnabled()) {

			System.out.println("Element is enabled");
			return true;
		} else {
			System.out.println("Element is disabled");
			return false;
		}
	}

	/**
	 * verifies if element is present
	 * 
	 * @param element
	 * @param elementName
	 * @return true false
	 */

	public static boolean isElementsInvisible(WebElement element,
			String elementName) {

		try {
			element.isDisplayed();

			System.out.println(elementName + " is invisible");
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println(elementName + " is still visible");
			return false;
		} catch (StaleElementReferenceException e) {
			e.getMessage();
			System.out.println(elementName + " is still visible");
			return false;
		}
	}

	/**
	 * verifies if element is present
	 * 
	 * @param element
	 * @param elementName
	 * @return true false
	 */

	public static boolean isElementsPresent(WebElement element,
			String elementName) {

		if (element != null) {
			System.out.println(elementName + " present");
			return true;
		} else {
			System.out.println(elementName + " absent");
			return false;
		}
	}

	/**
	 * verifies if element is present
	 * 
	 * @param element
	 * @param elementName
	 * @return true false
	 */

	public static boolean isElementsVisible(WebElement element,
			String elementName) {

		try {
			element.isDisplayed();

			System.out.println(elementName + " is visible");
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println(elementName + " is invisible");
			return false;
		} catch (StaleElementReferenceException e) {
			e.getMessage();
			System.out.println(elementName + " is invisible");
			return false;
		}
	}

	/**
	 * verifies if text is present
	 * 
	 * @param page
	 *            source text
	 * @return true false
	 */

	public static boolean isTextPresent(String text) {

		if (text.contains("Text to check")) {
			System.out.println("Text is present");
			return true;
		} else {
			System.out.println("Text is absent");
			return false;
		}
	}

	public static void verifyValue(WebElement element, String expectedVal) {
		String actualVal = element.getAttribute("value");
		if (actualVal.contains(expectedVal)) {
			System.out.println(String.format(
					"Actual value: %s is same as Expected Value:%s", actualVal,
					expectedVal));
		} else {
			System.out.println(String.format(
					"Actual value: %s is not the same as Expected Value:%s",
					actualVal, expectedVal));
		}
	}
}
