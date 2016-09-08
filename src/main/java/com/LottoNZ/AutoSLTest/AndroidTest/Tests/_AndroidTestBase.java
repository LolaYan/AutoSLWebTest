package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.LottoNZ.AutoSLTest.Driver.DeviceDataProvider;
import com.LottoNZ.AutoSLTest.Driver.DriverHelper;
import com.LottoNZ.AutoSLTest.Driver.SauceHelper;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.Utils.PropertyLoader;
import com.LottoNZ.AutoSLTest.Utils.Verification.TestMethodListener;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class, TestMethodListener.class })
public class _AndroidTestBase implements SauceOnDemandSessionIdProvider,
		SauceOnDemandAuthenticationProvider {
	protected static AppiumDriver androidDriver;
	public static String buildTag = null;
	protected static String localAppiumRunMode = PropertyLoader
			.loadProjectProperty("localAppiumRunMode");
	protected static String LogFlag = PropertyLoader.loadProjectProperty("log")
			.toUpperCase().replaceAll("\\s", "");
	public static String seleniumURI = null;
	@DataProvider(name = "AndroidAppCapabilities", parallel = true)
	public static Object[][] sauceAndroidAppDataProvider(Method testMethod) {
		Object[][] data = com.LottoNZ.AutoSLTest.Driver.DeviceDataProvider
				.sauceAndroidAppDataProvider();
		return data;
	}
	@DataProvider(name = "AndroidBrowserCapabilities", parallel = true)
	public static Object[][] sauceAndroidBrowserDataProvider(Method testMethod) {
		Object[][] data = com.LottoNZ.AutoSLTest.Driver.DeviceDataProvider
				.sauceAndroidBrowserDataProvider();
		return data;
	}
	@DataProvider(name = "hardCodedBrowsers", parallel = false)
	public static Object[][] sauceBrowserDataProvider(Method testMethod) {
		Object[][] data = DeviceDataProvider.sauceWebBrowserDataProvider();
		return data;
	}
	public String accesskey = null;
	public String appActivity = null;
	public String appName = null;
	public String appPackage = null;
	/**
	 * Authenticate to Sauce with environment variables SAUCE_USER_NAME and
	 * SAUCE_API_KEY
	 **/
	private SauceOnDemandAuthentication auth = new SauceOnDemandAuthentication();
	public SauceOnDemandAuthentication authentication;
	private ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();

	private ThreadLocal<String> sessionId = new ThreadLocal<String>();

	public URL url;

	public String username = null;

	// constructor
	_AndroidTestBase() {
		// Read Log config from application.properties file

		if (LogFlag.equalsIgnoreCase("ON")) {
			DOMConfigurator.configure("log4j.xml");
		}
	}

	protected AppiumDriver createDriver(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, String methodName) throws MalformedURLException,
			UnexpectedException {
		String sid = null;
		if (localAppiumRunMode.equals("ON")) {
			androidDriver = DriverHelper.createLocalAndroidDriver();
			return androidDriver;
		} else {
			AppiumDriver androidDriver = DriverHelper.createAndroidDriver(
					appiumVersion, deviceName, deviceType, deviceOrientation,
					platformVersion, platformName, browserName, app,
					appPackage, appActivity, url, buildTag, sid, methodName);
			driver.set(androidDriver);
			sessionId.set(getWebDriver().getSessionId().toString());
			System.out.println("Sessionid: " + sessionId);
			return driver.get();
		}

	}

	@Override
	public SauceOnDemandAuthentication getAuthentication() {
		return authentication;
	}

	/**** @return the Sauce Job id for the current thread */
	@Override
	public String getSessionId() {
		return sessionId.get();
	}

	public AppiumDriver getWebDriver() {
		return driver.get();
	}

	public void setupSauceLabsCredentials() throws MalformedURLException {
		System.out.println("setting sauce connect credentials ......");
		// get the sauce connect setting from ipConfig property file.
		seleniumURI = SauceHelper.buildSauceUri();
		username = SauceHelper.getSauceUsername();
		accesskey = SauceHelper.getSauceUserkey();
		authentication = new SauceOnDemandAuthentication(username, accesskey);
		buildTag = SauceHelper.getBuildTag(); // If available add build tag.
												// When running under Jenkins
												// BUILD_TAG is automatically
												// set.
		url = new URL("http://" + authentication.getUsername() + ":"
				+ authentication.getAccessKey() + seleniumURI + "/wd/hub");
		appName = SauceHelper.getApkName();
		appPackage = SauceHelper.getApkPackage();
		appActivity = SauceHelper.getApkActivity();

	}

	@BeforeSuite
	public void setupSuite(final ITestContext testContext)
			throws MalformedURLException {
		LogHelper.startTestSuite(testContext.getSuite().getName());
		setupSauceLabsCredentials();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		LogHelper.endTestMethod(this.getClass().getName());
		Thread.sleep(3000);
		if (localAppiumRunMode.equals("ON")) {
			androidDriver.quit();
		} else {
			driver.get().quit();

		}
	}
}
