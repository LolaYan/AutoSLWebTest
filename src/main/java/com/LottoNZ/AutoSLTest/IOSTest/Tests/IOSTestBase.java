package com.LottoNZ.AutoSLTest.IOSTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.LottoNZ.AutoSLTest.Driver.DeviceDataProvider;
import com.LottoNZ.AutoSLTest.Driver.DriverHelper;
import com.LottoNZ.AutoSLTest.Driver.SauceHelper;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class })
public class IOSTestBase implements SauceOnDemandSessionIdProvider,
		SauceOnDemandAuthenticationProvider {

	public static String buildTag = null;
	// Sauce Labs Credential Parameters.
	public static String seleniumURI = null;
	@DataProvider(name = "iosAppCapabilities", parallel = true)
	public static Object[][] sauceIOSAppDataProvider(Method testMethod) {
		Object[][] data = DeviceDataProvider.sauceIOSAppDataProvider();
		return data;
	}
	@DataProvider(name = "iosBrowserCapabilities", parallel = true)
	public static Object[][] sauceIOSBrowserDataProvider(Method testMethod) {
		Object[][] data = DeviceDataProvider.sauceIOSBrowserDataProvider();
		return data;
	}
	public String accesskey = null;
	public String appActivity = null;
	public String appName = null;
	public String appPackage = null;
	public SauceOnDemandAuthentication authentication;

	private ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();

	// private ThreadLocal<String> sessionId = new ThreadLocal<String>();

	private String sessionId = new String();

	public URL url;

	public String username = null;

	protected AppiumDriver createDriver(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, String methodName) throws MalformedURLException,
			UnexpectedException {
		String sid = null;
		AppiumDriver iosDriver = DriverHelper.createIOSDriver(appiumVersion,
				deviceName, deviceType, deviceOrientation, platformVersion,
				platformName, browserName, app, url, buildTag, sid, methodName);
		driver.set(iosDriver);

		sessionId = getWebDriver().getSessionId().toString();
		System.out.println("sessionId: " + sessionId);

		return driver.get();
	}

	/****
	 * @return the {@link SauceOnDemandAuthentication} instance containing the
	 *         Sauce username/access key
	 */
	@Override
	public SauceOnDemandAuthentication getAuthentication() {
		return authentication;
	}

	/**** @return the Sauce Job id for the current thread */
	@Override
	public String getSessionId() {
		return sessionId;
	}

	public AppiumDriver getWebDriver() {
		return driver.get();
	}

	@BeforeSuite
	public void setupSuite() throws MalformedURLException {
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
		appName = SauceHelper.getIpaName();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.get().quit();
	}

}
