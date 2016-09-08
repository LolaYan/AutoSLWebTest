package com.LottoNZ.AutoSLTest.Driver;

public class DeviceDataProvider {

	public static Object[][] localAndroidAppDataProvider() {
		return new Object[][] { new Object[] { null, "d5b296cd", "23", "Android",
				"mylotto-cat1.apk", "co.nz.mylotto.cat1",
				"co.nz.mylotto.MainActivity" } };
	}

	//LG Nexus 4 Emulator
	//Samsung Galaxy Nexus Emulator
	public static Object[][] sauceAndroidAppDataProvider() {
		return new Object[][] { new Object[] { "1.5.3",
				"Samsung Galaxy Nexus Emulator", null, "portrait", "4.3",
				"Android", "", "sauce-storage:mylotto-cat1.apk" } };
	}

	public static Object[][] sauceAndroidBrowserDataProvider() {
		return new Object[][] { new Object[] { "1.5.0",
				"Samsung Galaxy Nexus Emulator", "phone", "portrait", "5.3",
				"Android", "Browser", null } };
	}

	public static Object[][] sauceIOSAppDataProvider() {
		return new Object[][] { new Object[] { "1.5.2", "iPhone 6", "phone",
				"portrait", "9.2", "iOS", "",
				"sauce-storage:LottoNZ-SIT-ios.zip" } };
	}

	public static Object[][] sauceIOSBrowserDataProvider() {
		return new Object[][] { new Object[] { "1.5.0", "iPhone 6", "phone",
				"portrait", "8.4", "iOS", "Safari", null } };
	}

	/**
	 * DataProvider that explicitly sets the browser combinations to be used.
	 * 
	 * @param
	 * @return Two dimensional array of objects with browser, version, and
	 *         platform information
	 */
	public static Object[][] sauceWebBrowserDataProvider() {
		return new Object[][] {
		// new Object[] { "internet explorer", "11", "Windows 8.1" },
		// new Object[] { "chrome", "41", "Windows XP" },
		// new Object[] { "safari", "7", "OS X 10.9" },
		// new Object[] { "firefox", "35", "Windows 7" },
		// new Object[] { "opera", "12.12", "Windows 7" },
		new Object[] { "safari", "9.0", "OS X 10.11" } };
	}
}
