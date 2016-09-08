package com.LottoNZ.AutoSLTest.AndroidTest.Tests;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.LottoNZ.AutoSLTest.AndroidTest.Pages.androidLottoDipPage;
import com.LottoNZ.AutoSLTest.Utils.LogHelper;

/**
 * @author mrawal
 * 
 */
public class androidLottoDipsTest extends _AndroidTestBase {

	@Test(dataProvider = "AndroidAppCapabilities", description = "luckyDip12")
	public void luckyDip12(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws Exception {

		/** create webdriver session **/
		LogHelper.info(String
				.format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
						appiumVersion, deviceName, deviceType,
						deviceOrientation, platformVersion, platformName,
						browserName, app));

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		driver.context("NATIVE_APP");

		// Go to Dips
		androidLottoDipPage.bypassIntroScreens(driver);
		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectaLuckyDip(driver, "12", 20);

	}

	@Test(dataProvider = "AndroidAppCapabilities", description = "luckyDip480")
	public void luckyDip480(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws Exception {

		/** create webdriver session **/
		LogHelper.info(String
				.format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
						appiumVersion, deviceName, deviceType,
						deviceOrientation, platformVersion, platformName,
						browserName, app));

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		driver.context("NATIVE_APP");

		// Go to Dips
		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectaLuckyDip(driver, "4.8", 10);

	}

	@Test(dataProvider = "AndroidAppCapabilities", description = "luckyDip6")
	public void luckyDip6(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws Exception {

		/** create webdriver session **/
		LogHelper.info(String
				.format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
						appiumVersion, deviceName, deviceType,
						deviceOrientation, platformVersion, platformName,
						browserName, app));

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		

		// Go to Dips
		androidLottoDipPage.bypassIntroScreens(driver);
		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectaLuckyDip(driver, "6", 10);

	}

	@Test(dataProvider = "AndroidAppCapabilities", description = "luckyDip9")
	public void luckyDip9(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws Exception {

		/** create webdriver session **/
		LogHelper.info(String
				.format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
						appiumVersion, deviceName, deviceType,
						deviceOrientation, platformVersion, platformName,
						browserName, app));

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		driver.context("NATIVE_APP");

		// Go to Dips
		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectaLuckyDip(driver, "9", 15);

	}

	@Test(dataProvider = "AndroidAppCapabilities", description = "powerDip960")
	public void powerDip960(String appiumVersion, String deviceName,
			String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws Exception {

		/** create webdriver session **/
		LogHelper.info(String
				.format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
						appiumVersion, deviceName, deviceType,
						deviceOrientation, platformVersion, platformName,
						browserName, app));

		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName,
				deviceType, deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		driver.context("NATIVE_APP");

		// Go to Dips
		androidLottoDipPage.loaded(driver);
		androidLottoDipPage.selectaPowerDip(driver, "9.60", 8, 8);

	}

	// @Test(dataProvider = "AndroidAppCapabilities", description =
	// "powerDip12")
	// public void powerDip12(String appiumVersion, String deviceName,
	// String deviceType, String deviceOrientation,
	// String platformVersion, String platformName, String browserName,
	// String app, Method method) throws Exception {
	//
	// /** create webdriver session **/
	// Log.info(String
	// .format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
	// appiumVersion, deviceName, deviceType,
	// deviceOrientation, platformVersion, platformName,
	// browserName, app));
	//
	// // create webdriver session
	// AppiumDriver driver = createDriver(appiumVersion, deviceName,
	// deviceType, deviceOrientation, platformVersion, platformName,
	// browserName, app, method.getName());
	// driver.context("NATIVE_APP");
	//
	// // Go to Dips
	// LottoDipsAndroidPage.loaded(driver);
	// LottoDipsAndroidPage.selectaPowerDip(driver, "12", 10, 10);
	//
	// }
	//
	// @Test(dataProvider = "AndroidAppCapabilities", description =
	// "powerDip18")
	// public void powerDip18(String appiumVersion, String deviceName,
	// String deviceType, String deviceOrientation,
	// String platformVersion, String platformName, String browserName,
	// String app, Method method) throws Exception {
	//
	// /** create webdriver session **/
	// Log.info(String
	// .format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
	// appiumVersion, deviceName, deviceType,
	// deviceOrientation, platformVersion, platformName,
	// browserName, app));
	//
	// // create webdriver session
	// AppiumDriver driver = createDriver(appiumVersion, deviceName,
	// deviceType, deviceOrientation, platformVersion, platformName,
	// browserName, app, method.getName());
	// driver.context("NATIVE_APP");
	//
	// // Go to Dips
	// LottoDipsAndroidPage.loaded(driver);
	// LottoDipsAndroidPage.selectaPowerDip(driver, "18", 15, 15);
	//
	// }
	//
	// @Test(dataProvider = "AndroidAppCapabilities", description =
	// "powerDip24")
	// public void powerDip24(String appiumVersion, String deviceName,
	// String deviceType, String deviceOrientation,
	// String platformVersion, String platformName, String browserName,
	// String app, Method method) throws Exception {
	//
	// /** create webdriver session **/
	// Log.info(String
	// .format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
	// appiumVersion, deviceName, deviceType,
	// deviceOrientation, platformVersion, platformName,
	// browserName, app));
	//
	// // create webdriver session
	// AppiumDriver driver = createDriver(appiumVersion, deviceName,
	// deviceType, deviceOrientation, platformVersion, platformName,
	// browserName, app, method.getName());
	// driver.context("NATIVE_APP");
	//
	// // Go to Dips
	// LottoDipsAndroidPage.loaded(driver);
	// LottoDipsAndroidPage.selectaPowerDip(driver, "24", 20, 20);
	//
	// }

	// @Test(dataProvider = "AndroidAppCapabilities", description =
	// "tripleDip14")
	// public void tripleDip14(String appiumVersion, String deviceName,
	// String deviceType, String deviceOrientation,
	// String platformVersion, String platformName, String browserName,
	// String app, Method method) throws Exception {
	//
	// /** create webdriver session **/
	// Log.info(String
	// .format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
	// appiumVersion, deviceName, deviceType,
	// deviceOrientation, platformVersion, platformName,
	// browserName, app));
	//
	// // create webdriver session
	// AppiumDriver driver = createDriver(appiumVersion, deviceName,
	// deviceType, deviceOrientation, platformVersion, platformName,
	// browserName, app, method.getName());
	// driver.context("NATIVE_APP");
	//
	// // Go to Dips
	// LottoDipsAndroidPage.loaded(driver);
	// LottoDipsAndroidPage
	// .selectaTripleDip(driver, "14", 10, 10, 2, "$14.00");
	//
	// }
	//
	// @Test(dataProvider = "AndroidAppCapabilities", description =
	// "tripleDip16")
	// public void tripleDip16(String appiumVersion, String deviceName,
	// String deviceType, String deviceOrientation,
	// String platformVersion, String platformName, String browserName,
	// String app, Method method) throws Exception {
	//
	// /** create webdriver session **/
	// Log.info(String
	// .format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
	// appiumVersion, deviceName, deviceType,
	// deviceOrientation, platformVersion, platformName,
	// browserName, app));
	//
	// // create webdriver session
	// AppiumDriver driver = createDriver(appiumVersion, deviceName,
	// deviceType, deviceOrientation, platformVersion, platformName,
	// browserName, app, method.getName());
	// driver.context("NATIVE_APP");
	//
	// // Go to Dips
	// LottoDipsAndroidPage.loaded(driver);
	// LottoDipsAndroidPage
	// .selectaTripleDip(driver, "16", 10, 10, 4, "$16.00");
	//
	// }

	// @Test(dataProvider = "AndroidAppCapabilities", description =
	// "tripleDip20")
	// public void tripleDip20(String appiumVersion, String deviceName,
	// String deviceType, String deviceOrientation,
	// String platformVersion, String platformName, String browserName,
	// String app, Method method) throws Exception {
	//
	// /** create webdriver session **/
	// Log.info(String
	// .format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
	// appiumVersion, deviceName, deviceType,
	// deviceOrientation, platformVersion, platformName,
	// browserName, app));
	//
	// // create webdriver session
	// AppiumDriver driver = createDriver(appiumVersion, deviceName,
	// deviceType, deviceOrientation, platformVersion, platformName,
	// browserName, app, method.getName());
	// driver.context("NATIVE_APP");
	//
	// // Go to Dips
	// LottoDipsAndroidPage.loaded(driver);
	// LottoDipsAndroidPage
	// .selectaTripleDip(driver, "20", 15, 15, 2, "$20.00");
	//
	// }

	// @Test(dataProvider = "AndroidAppCapabilities", description =
	// "tripleDip14")
	// public void tripleDip26(String appiumVersion, String deviceName,
	// String deviceType, String deviceOrientation,
	// String platformVersion, String platformName, String browserName,
	// String app, Method method) throws Exception {
	//
	// /** create webdriver session **/
	// Log.info(String
	// .format("appiumVersion=%1$s deviceName=%2$s deviceType=%3$s deviceOrientation=%4$s platformVersion=%5$s platformName=%6$s ,browserName=%7$s app=%8$s",
	// appiumVersion, deviceName, deviceType,
	// deviceOrientation, platformVersion, platformName,
	// browserName, app));
	//
	// // create webdriver session
	// AppiumDriver driver = createDriver(appiumVersion, deviceName,
	// deviceType, deviceOrientation, platformVersion, platformName,
	// browserName, app, method.getName());
	// driver.context("NATIVE_APP");
	//
	// // Go to Dips
	// LottoDipsAndroidPage.loaded(driver);
	// LottoDipsAndroidPage
	// .selectaTripleDip(driver, "26", 20, 20, 2, "$26.00");
	//
	// }
}
