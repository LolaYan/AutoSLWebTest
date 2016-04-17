package com.LottoNZ.AutoSLAndroidTest.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import com.LottoNZ.AutoSLWebTest.Utils.SauceHelpers;

@Listeners({ SauceOnDemandTestListener.class })
public class AndroidTestBase implements SauceOnDemandSessionIdProvider,
		SauceOnDemandAuthenticationProvider {

	public static String seleniumURI = null;
	public static String buildTag = null;
	// public String username = System.getenv("SAUCE_USERNAME");
	public String username = "lottotestnz";
	// public String accesskey = System.getenv("SAUCE_ACCESS_KEY");
	public String accesskey = "4441f476-39c5-419f-9b4b-437e8323d461";
	public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(
			username, accesskey);
	private ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	private ThreadLocal<String> sessionId = new ThreadLocal<String>();

	@DataProvider(name = "AndroidCapabilities", parallel = true)
	public static Object[][] sauceBrowserDataProvider(Method testMethod) {
		return new Object[][] { new Object[] { "1.5.0", "Android Emulator",
				"phone", "portrait", "4.4", "Android", "Browser", null } };
	}

	public AppiumDriver getWebDriver() {
		return driver.get();
	}

	/**** @return the Sauce Job id for the current thread */
	public String getSessionId() {
		return sessionId.get();
	}

	@Override
	public SauceOnDemandAuthentication getAuthentication() {
		return authentication;
	}

	protected AppiumDriver createDriver(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, String methodName) throws MalformedURLException,
			UnexpectedException {
		DesiredCapabilities capabilities = DesiredCapabilities.android();

		// set desired capabilities to launch appropriate browser on Sauce
		if (appiumVersion != null)
			capabilities.setCapability("appiumVersion", appiumVersion);
		if (deviceName != null)
			capabilities.setCapability("deviceName", deviceName);
		if (deviceOrientation != null)
			capabilities.setCapability("deviceOrientation", deviceOrientation);
		if (deviceType != null)
			capabilities.setCapability("deviceType", deviceType);
		if (platformVersion != null)
			capabilities.setCapability("platformVersion", platformVersion);
		if (platformName != null)
			capabilities.setCapability("platformName", platformName);
		if (browserName != null)
			capabilities.setCapability("browserName", browserName);
		if (app != null)
			capabilities.setCapability("app", app);

		capabilities.setCapability("name", methodName);

		if (buildTag != null) {
			capabilities.setCapability("build", buildTag);
		}

		URL url = new URL("http://" + authentication.getUsername() + ":"
				+ authentication.getAccessKey() + seleniumURI + "/wd/hub");
		System.out.println(url);
		System.out.println("build connection");
		this.driver.set(new AndroidDriver(url, capabilities));

		// set current sessionId
		String id = ((RemoteWebDriver) getWebDriver()).getSessionId()
				.toString();
		sessionId.set(id);
		System.out.println(String.format(
				"SauceOnDemandSessionID=%1$s job-name=%2$s", id, methodName));
		return driver.get();
	}

	/*
	 * @BeforeMethod public void setupMethod() throws Exception { }
	 */

	@AfterMethod
	public void tearDown() throws Exception {
		// androidDriver.get().quit();
		driver.get().quit();
	}

	@BeforeSuite
	public void setupSuite() {
		seleniumURI = SauceHelpers.buildSauceUri();
		buildTag = System.getenv("BUILD_TAG");
	}

}
