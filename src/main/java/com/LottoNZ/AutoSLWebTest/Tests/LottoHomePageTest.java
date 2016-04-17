package com.LottoNZ.AutoSLWebTest.Tests;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.LottoNZ.AutoSLWebTest.Pages.LottoHomePage;

public class LottoHomePageTest extends TestBase {

	@Test(dataProvider = "hardCodedBrowsers")
	public void verifyLottoHomepageTest(String browser,
			String version, String os, Method method)
			throws MalformedURLException, InvalidElementStateException,
			UnexpectedException {

		// create webdriver session
		System.out.println("creating driver ......");
		WebDriver driver = createDriver(browser, version, os, method.getName());
		System.out.println("creating successfully ......");
		driver.get("https://mylotto.co.nz/");
		// Go to Lotto Homepage
		LottoHomePage HomePage = new LottoHomePage(driver);

	}
}
