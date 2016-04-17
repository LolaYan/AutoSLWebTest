package com.LottoNZ.AutoSLWebTest.Tests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import com.LottoNZ.AutoSLWebTest.Utils.SauceHelpers;

@Listeners({ SauceOnDemandTestListener.class })
public class TestBase implements SauceOnDemandSessionIdProvider,
		SauceOnDemandAuthenticationProvider {

	// Selenium URI -- static same for everyone.
	public static String seleniumURI = null;

	// Selenium URI -- static same for everyone
	public static String buildTag = null;

	/** Sauce username **/
	// public String username = System.getenv("SAUCE_USERNAME");
	public String username = "lottotestnz";

	/** Sauce access key **/
	// public String accesskey = System.getenv("SAUCE_ACCESS_KEY");
	public String accesskey = "4441f476-39c5-419f-9b4b-437e8323d461";

	public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(
			username, accesskey);

	/***
	 * ThreadLocal variable which contains the {@link WebDriver} instance which
	 * is used to perform browser interactions with.
	 */
	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	/*** ThreadLocal variable which contains the Sauce Job Id. */
	private ThreadLocal<String> sessionId = new ThreadLocal<String>();

	/**
	 * DataProvider that explicitly sets the browser combinations to be used.
	 * 
	 * @param testMethod
	 * @return Two dimensional array of objects with browser, version, and
	 *         platform information
	 */
	@DataProvider(name = "hardCodedBrowsers", parallel = true)
	public static Object[][] sauceBrowserDataProvider(Method testMethod) {
		return new Object[][] {
				//new Object[] { "internet explorer", "11", "Windows 8.1" },
				//new Object[] { "chrome", "41", "Windows XP" },
				
				//new Object[] { "safari", "7", "OS X 10.9" },
				//new Object[] { "firefox", "35", "Windows 7" },
				//new Object[] { "opera", "12.12", "Windows 7" },
				new Object[] { "chrome", "45", "Windows 7" }
				};
	}

	/** * @return the {@link WebDriver} for the current thread */
	public WebDriver getWebDriver() {
		return webDriver.get();
	}

	/**** @return the Sauce Job id for the current thread */
	public String getSessionId() {
		return sessionId.get();
	}

	/****
	 * @return the {@link SauceOnDemandAuthentication} instance containing the
	 *         Sauce username/access key
	 */
	@Override
	public SauceOnDemandAuthentication getAuthentication() {
		return authentication;
	}

	protected WebDriver createDriver(String browser, String version, String os,
			String methodName) throws MalformedURLException,
			UnexpectedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// set desired capabilities to launch appropriate browser on Sauce
		capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
		capabilities.setCapability(CapabilityType.VERSION, version);
		capabilities.setCapability(CapabilityType.PLATFORM, os);
		capabilities.setCapability("name", methodName);

		if (buildTag != null) {
			capabilities.setCapability("build", buildTag);
		}

		URL url = new URL("http://" + authentication.getUsername() + ":"
				+ authentication.getAccessKey() + seleniumURI + "/wd/hub");
		// Launch remote browser and set it as the current thread
		webDriver.set(new RemoteWebDriver(url, capabilities));
		System.out.println(url);
		// set current sessionId
		String id = ((RemoteWebDriver) getWebDriver()).getSessionId()
				.toString();
		sessionId.set(id);

		// print out sessionId and jobname for consumption by Sauce Jenkins
		// plugin
		System.out.println(String.format(
				"SauceOnDemandSessionID=%1$s job-name=%2$s", id, methodName));

		return webDriver.get();
	}

	@AfterMethod
	public void tearDown() throws Exception {

		// Gets browser logs if available.
		webDriver.get().quit();
	}

	@BeforeSuite
	public void setupSuite() {
		// get the uri to send the commands to.
		seleniumURI = SauceHelpers.buildSauceUri();
		// If available add build tag. When running under Jenkins BUILD_TAG is
		// automatically set.
		// You can set this manually on manual runs.
		buildTag = System.getenv("BUILD_TAG");
	}

}
