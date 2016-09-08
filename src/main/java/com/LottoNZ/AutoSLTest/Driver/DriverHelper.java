package com.LottoNZ.AutoSLTest.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.Utils.PropertyLoader;

/**
 * @author Lola
 * @email lyan@planittesting.co.nz Note: define init driver and kill driver in
 *        WebDriverSupport. Also define implicitlyWait and pageloadTimeout here.
 */
public class DriverHelper {

	protected static AppiumDriver androidDriver;
	protected static AppiumDriver iosDriver;
	protected static AppiumDriver localDriver;
	protected static int timeWaitInSeconds;

	protected static WebDriver webDriver;

	/** Create Appium Driver for Android Testing **/
	public static AppiumDriver createAndroidDriver(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String appName, String appPackage, String appActivity, URL slUrl,
			String buildTag, String sessionId, String methodName)
			throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.android();

		// set desired capabilities to launch appropriate browser on Sauce
		if (appiumVersion != null) {
			LogHelper.info("Setting appiumVersion as " + appiumVersion);
			capabilities.setCapability("appiumVersion", appiumVersion);
		}

		if (deviceName != null) {
			LogHelper.info("Setting deviceName as " + deviceName);
			capabilities.setCapability("deviceName", deviceName);
		}

		if (deviceOrientation != null) {
			LogHelper.info("Setting deviceOrientation as " + deviceOrientation);
			capabilities.setCapability("deviceOrientation", deviceOrientation);
		}
		if (deviceType != null) {
			LogHelper.info("Setting deviceType as " + deviceType);
			capabilities.setCapability("deviceType", deviceType);
		}
		if (platformVersion != null) {
			LogHelper.info("Setting platformVersion as " + platformVersion);
			capabilities.setCapability("platformVersion", platformVersion);
		}
		if (platformName != null) {
			LogHelper.info("Setting platformName as " + platformName);
			capabilities.setCapability("platformName", platformName);
		}
		if (browserName != null) {
			LogHelper.info("Setting browserName as " + browserName);
			capabilities.setCapability("browserName", browserName);
		}
		if (appName != null) {
			LogHelper.info("Setting app as " + appName);
			capabilities.setCapability("app", appName);
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);
		}

		if (buildTag != null) {
			capabilities.setCapability("build", buildTag);
		}

		capabilities.setCapability("name", methodName);

		androidDriver = new AndroidDriver(slUrl, capabilities);
		setImplicitlyWait(androidDriver);
		// set current sessionId
		String id = ((RemoteWebDriver) androidDriver).getSessionId().toString();
		sessionId = id;
		LogHelper.info(String.format(
				"SauceOnDemandSessionID=%1$s job-name=%2$s", id, methodName));
		LogHelper.info(methodName);
		return androidDriver;
	}

	/** Create Appium Driver for IOS Testing **/
	public static AppiumDriver createIOSDriver(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, URL slUrl, String buildTag, String sessionId,
			String methodName) throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.iphone();

		// set desired capabilities to launch appropriate browser on Sauce
		if (appiumVersion != null) {
			LogHelper.info("Setting appiumVersion as " + appiumVersion);
			capabilities.setCapability("appiumVersion", appiumVersion);
		}

		if (deviceName != null) {
			LogHelper.info("Setting deviceName as " + deviceName);
			capabilities.setCapability("deviceName", deviceName);
		}

		if (deviceOrientation != null) {
			LogHelper.info("Setting deviceOrientation as " + deviceOrientation);
			capabilities.setCapability("deviceOrientation", deviceOrientation);
		}
		if (deviceType != null) {
			LogHelper.info("Setting deviceType as " + deviceType);
			capabilities.setCapability("deviceType", deviceType);
		}
		if (platformVersion != null) {
			LogHelper.info("Setting platformVersion as " + platformVersion);
			capabilities.setCapability("platformVersion", platformVersion);
		}
		if (platformName != null) {
			LogHelper.info("Setting platformName as " + platformName);
			capabilities.setCapability("platformName", platformName);
		}
		if (browserName != null) {
			LogHelper.info("Setting browserName as " + browserName);
			capabilities.setCapability("browserName", browserName);
		}
		if (app != null) {
			LogHelper.info("Setting appName as " + app);
			capabilities.setCapability("app", app);
		}

		if (buildTag != null) {
			capabilities.setCapability("build", buildTag);
		}
		capabilities.setCapability("name", methodName);
		iosDriver = new IOSDriver<WebElement>(slUrl, capabilities);
		setImplicitlyWait(iosDriver);
		// set current sessionId
		String id = ((RemoteWebDriver) iosDriver).getSessionId().toString();
		sessionId = id;

		LogHelper.info(String.format(
				"SauceOnDemandSessionID=%1$s job-name=%2$s", id, methodName));
		LogHelper.info(methodName);
		return iosDriver;
	}

	public static AppiumDriver createLocalAndroidDriver() {
		try {
			LogHelper.info(" > Creating local appium session.");

			String browserName = PropertyLoader
					.loadAndroidProperty("browserName");
			String deviceName = PropertyLoader
					.loadAndroidProperty("deviceName");
			String platformVersion = PropertyLoader
					.loadAndroidProperty("platformVersion");
			String platformName = PropertyLoader
					.loadAndroidProperty("platformName");
			String appName = PropertyLoader.loadAndroidProperty("appName");
			String appPackage = PropertyLoader
					.loadAndroidProperty("appPackage");
			String appActivity = PropertyLoader
					.loadAndroidProperty("appActivity");

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities
					.setCapability(CapabilityType.BROWSER_NAME, browserName);
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformVersion", platformVersion);
			capabilities.setCapability("platformName", platformName);
			capabilities.setCapability("app", getApp(appName));
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);

			String appiumUrl = PropertyLoader.loadAndroidProperty("appium.url");
			localDriver = new AndroidDriver(new URL(appiumUrl), capabilities);
			setImplicitlyWait(localDriver);

		} catch (Exception e) {
			LogHelper.error(" Fail to create the appium session ! Error Msg: "
					+ e.getMessage());
		}
		return localDriver;
	}

	// initiate the android driver
	public static AppiumDriver createLocalAndroidDriver(String browserName,
			String deviceName, String platformVersion, String platformName,
			String appName, String appPackage, String appActivity) {
		try {
			LogHelper.info(" > Creating local appium session.");

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities
					.setCapability(CapabilityType.BROWSER_NAME, browserName);
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformVersion", platformVersion);
			capabilities.setCapability("platformName", platformName);
			capabilities.setCapability("app", getApp(appName));
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);

			String appiumUrl = PropertyLoader.loadAndroidProperty("appium.url");
			localDriver = new AndroidDriver(new URL(appiumUrl), capabilities);
			setImplicitlyWait(localDriver);

		} catch (Exception e) {
			LogHelper.error(" Fail to create the appium session ! Error Msg: "
					+ e.getMessage());
		}
		return localDriver;
	}

	/** Create Web Driver for Web Testing **/
	public static WebDriver createWebDriver(String browser, String version,
			String os, URL slUrl, String buildTag, String sessionId,
			String methodName) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// set desired capabilities to launch appropriate browser on Sauce
		capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
		capabilities.setCapability(CapabilityType.VERSION, version);
		capabilities.setCapability(CapabilityType.PLATFORM, os);
		capabilities.setCapability("name", methodName);
		capabilities.setCapability("tunnel-identifier", "Mudra CAT PC");
		if (buildTag != null) {
			capabilities.setCapability("build", buildTag);
		}

		webDriver = new RemoteWebDriver(slUrl, capabilities);
		setImplicitlyWait(webDriver);
		// set current sessionId
		String id = ((RemoteWebDriver) webDriver).getSessionId().toString();
		sessionId = id;

		LogHelper.info(String.format(
				"SauceOnDemandSessionID=%1$s job-name=%2$s", id, methodName));
	
		return webDriver;
	}

	public static String getApp(String appName) {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/apps/");
		File app = new File(appDir, appName);
		return app.getAbsolutePath();
	}

	/**
	 * Set implicit wait in seconds *
	 */
	public static void setImplicitlyWait(AppiumDriver driver) {
		driver.manage().timeouts()
				.implicitlyWait(timeWaitInSeconds, TimeUnit.SECONDS);
	}

	private static void setImplicitlyWait(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.manage().timeouts()
				.implicitlyWait(timeWaitInSeconds, TimeUnit.SECONDS);
	}

	public DriverHelper() {
		timeWaitInSeconds = Integer.parseInt(PropertyLoader
				.loadAndroidProperty("implicitlyWebWait"));
	}
}
