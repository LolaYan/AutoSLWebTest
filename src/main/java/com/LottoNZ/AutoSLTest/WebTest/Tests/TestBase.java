package com.LottoNZ.AutoSLTest.WebTest.Tests;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.LottoNZ.AutoSLTest.Driver.DeviceDataProvider;
import com.LottoNZ.AutoSLTest.Driver.DriverHelper;
import com.LottoNZ.AutoSLTest.Driver.SauceHelper;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;
import com.LottoNZ.AutoSLTest.Utils.Verification.TestMethodListener;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class, TestMethodListener.class })
public class TestBase implements SauceOnDemandSessionIdProvider,
		SauceOnDemandAuthenticationProvider {
	public static String buildTag = null;
	public static DeviceDataProvider deviceDataProvider = new DeviceDataProvider();
	public static Logger Log = Logger.getLogger(TestBase.class);
	// Sauce Labs Credential Parameters.
	public static String seleniumURI = null;
	@DataProvider(name = "hardCodedBrowsers", parallel = false)
	public static Object[][] sauceBrowserDataProvider(Method testMethod) {
		Object[][] data = DeviceDataProvider.sauceWebBrowserDataProvider();
		return data;
	}
	public String accesskey = null;
	public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication();
	protected ByteArrayOutputStream outputCapture;

	protected ThreadLocal<String> sessionId = new ThreadLocal<String>();
	protected PrintStream stdoutStream;
	public URL url;
	public String username = null;

	// Provide Log4j configuration settings

	protected ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	protected WebDriver createDriver(String browser, String version, String os,
			String methodName) throws MalformedURLException,
			UnexpectedException {
		String sid = null;
		WebDriver driver = DriverHelper.createWebDriver(browser, version, os,
				url, buildTag, sid, methodName);

		long timeWaitInSeconds = 30;
		// global time wait setting
		driver.manage().timeouts()
				.pageLoadTimeout(timeWaitInSeconds, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(timeWaitInSeconds, TimeUnit.SECONDS);

		webDriver.set(driver);
		sessionId.set(((RemoteWebDriver) getWebDriver()).getSessionId()
				.toString());

		return webDriver.get();

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
		return sessionId.get();
	}

	/** * @return the {@link WebDriver} for the current thread */
	public WebDriver getWebDriver() {
		return webDriver.get();
	}

	@BeforeMethod
	public void SetupMethod() throws Exception {

	}

	@BeforeSuite
	public void setupSuite() throws MalformedURLException {
		Log.info("setting sauce connect credentials ......");
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
		// Provide Log4j configuration settings
		String log4jConfigFile = System.getProperty("user.dir")
				+ File.separator + "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);

		/** create webdriver session **/
		BasicConfigurator.configure();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		LogHelper.endTest(this.getClass().getName());
		webDriver.get().close();

	}

}
