package com.LottoNZ.AutoSLIOSTest.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
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
public class IOSTestBase implements SauceOnDemandSessionIdProvider,
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

	private static IOSDriver<WebElement> driver;
	
	private ThreadLocal<String> sessionId = new ThreadLocal<String>();

	@DataProvider(name = "iosCapabilities", parallel = true)
	public static Object[][] sauceBrowserDataProvider(Method testMethod) {
		return new Object[][] {
				new Object[] { "1.5.0", "iPhone 6", "phone","portrait",  "8.4", "iOS", "Safari", null } };
	}


	public static IOSDriver<WebElement> getWebDriver() {
		//return androidDriver.get();
		return driver;
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

	protected IOSDriver<WebElement> createDriver(String appiumVersion, String deviceName,
			 String deviceType,String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, String methodName) throws MalformedURLException,
			UnexpectedException {
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		DesiredCapabilities capabilities = DesiredCapabilities.iphone();


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
	
			capabilities.setCapability("app", app);

		capabilities.setCapability("name", methodName);
	
		if (buildTag != null) {
			capabilities.setCapability("build", buildTag);
		}

		URL url = new URL("http://" + authentication.getUsername() + ":"+ authentication.getAccessKey() + seleniumURI + "/wd/hub");

		this.driver = new IOSDriver<WebElement>(url, capabilities);
		System.out.println(url);
		// set current sessionId
		String id = ((RemoteWebDriver) this.driver).getSessionId()
				.toString();
		sessionId.set(id);

		System.out.println(String.format(
				"SauceOnDemandSessionID=%1$s job-name=%2$s", id, methodName));

		//return androidDriver.get();
		return driver;
	}
	
	/*
	@BeforeMethod
	public void setupMethod() throws Exception {
	}
	*/
	
	@AfterMethod
	public void tearDown() throws Exception {
		//androidDriver.get().quit();
		driver.quit();
	}

	@BeforeSuite
	public void setupSuite() {
		seleniumURI = SauceHelpers.buildSauceUri();
		buildTag = System.getenv("BUILD_TAG");
	}

}
