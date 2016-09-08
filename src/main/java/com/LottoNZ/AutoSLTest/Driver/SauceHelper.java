package com.LottoNZ.AutoSLTest.Driver;

import com.LottoNZ.AutoSLTest.Utils.PropertyLoader;

/**
 * Will return credential date for Sauce Connect, which are read from
 * ipConfig.properties file Used by
 * TestBase.java/IOSTestBase.java/AndroidTestBase.java/
 * 
 * @return String formatted uri for Sauce Se commands.
 */
public class SauceHelper {

	public static String buildSauceUri() {

		String seleniumURI = "@ondemand.saucelabs.com:80";

		// load property from ./config/ipConfig.properties
		String defaultSeleniumURI = PropertyLoader
				.loadProjectProperty("seleniumURI");
		String vmSeleniumURI = PropertyLoader
				.loadProjectProperty("vmSeleniumURI");
		String localSeleniumURI = PropertyLoader
				.loadProjectProperty("localSeleniumURI");
		String SauceConnectCmdRelayType = PropertyLoader
				.loadProjectProperty("SauceConnectCmdRelayType").toUpperCase()
				.replaceAll("\\s", "");

		if (SauceConnectCmdRelayType.equals("VM") && vmSeleniumURI != null) {
			seleniumURI = vmSeleniumURI;
		} else if (SauceConnectCmdRelayType.equals("LOCAL")
				&& localSeleniumURI != null) {
			seleniumURI = localSeleniumURI;
		} else if (SauceConnectCmdRelayType == "No" && localSeleniumURI != null) {
			seleniumURI = defaultSeleniumURI;
		}
		System.out.println("**********" + seleniumURI);
		return seleniumURI;
	}

	// Get Sauce APK App Activity from ./config/ipConfig.properties
	public static String getApkActivity() {
		String AppActivity = PropertyLoader
				.loadProjectProperty("sauce.LottoAPK.appActivity");
		System.out.println("AppActivity:" + AppActivity);
		return AppActivity;
	}

	// Get Sauce APK App Name from ./config/ipConfig.properties
	public static String getApkName() {
		String AppName = PropertyLoader
				.loadProjectProperty("sauce.LottoAPK.filename");
		return AppName;
	}

	// Get Sauce APK App Package from ./config/ipConfig.properties
	public static String getApkPackage() {
		String AppPackage = PropertyLoader
				.loadProjectProperty("sauce.LottoAPK.appPackage");
		System.out.println("AppPackage:" + AppPackage);
		return AppPackage;
	}

	// Get build Tag Name from System Env
	public static String getBuildTag() {
		String buildTag = System.getenv("BUILD_TAG");
		return buildTag;
	}

	// Get Sauce IPA App Name from ./config/ipConfig.properties
	public static String getIpaName() {
		String AppName = PropertyLoader
				.loadProjectProperty("sauce.LottoIPA.filename");
		System.out.println("AppName:" + AppName);
		return AppName;
	}

	// Get Sauce User Key from ./config/ipConfig.properties
	public static String getSauceUserkey() {
		String userkey = System.getenv("SAUCE_ACCESS_KEY");
		String sauceUkeyFromConfig = PropertyLoader
				.loadProjectProperty("sauceUkay");
		if (sauceUkeyFromConfig != null) {
			userkey = sauceUkeyFromConfig;
		}
		System.out.println(userkey);
		return userkey;
	}

	// Get Sauce User name from ./config/ipConfig.properties
	public static String getSauceUsername() {
		String username = System.getenv("SAUCE_USERNAME");
		String sauceUnameFromConfig = PropertyLoader
				.loadProjectProperty("sauceUname");
		if (sauceUnameFromConfig != null) {
			username = sauceUnameFromConfig;
		}
		System.out.println(username);
		return username;
	}

	// Get Sauce User Key from ./config/ipConfig.properties
	public static String getTunnelId() {
		String tunnelid = System.getenv("tunnel-identifier");
		String tunnelIdFromConfig = PropertyLoader
				.loadProjectProperty("tunnelIdentifier");
		if (tunnelIdFromConfig != null) {
			tunnelid = tunnelIdFromConfig;
		}
		System.out.println(tunnelid);
		return tunnelid;
	}

	public static void main(String[] args) {

	}

}
