# AutoSLWebTest

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Framework Conposition:
```
Automation Frameowrk Type: Page Object Framework
Automation Test Framework: TestNG
Automation Tools: Appium, Sauce Labs Cloud.
```
```
1. Web Test Automation.
2. Mobile Android Test Automation
3. Mobile IOS Test Automation
```

### Project Structure:
```
 - AutoSLTest.Driver
 - AutoSLTest.Utils
 - AutoSLTest.WebTest.Pages
 - AutoSLTest.WebTest.Tests
 - AutoSLTest.WebTest.Utils
 - AutoSLTest.AndoidTest.Pages
 - AutoSLTest.AndoidTest.Tests
 - AutoSLTest.AndoidTest.Utils
 - AutoSLTest.IOSTest.Pages
 - AutoSLTest.IOSTest.Tests
 - AutoSLTest.IOSTest.Utils
 - config
 - log
 - apps
 - libs
 - pom.xml
 - log4j.xml
```

### Prerequisities

What things you need to install the software and how to install them

```
1. JDK+Eclipse
2. SDK+AVD
3. Appium
4. Sauce Labs Account
5. Genymotion simulator (optional)
```

### Installing


```
1. Download the whole project, place it in your JAVA workspace folder.
2. Open Eclipse, import project, choosing existing maven project.
3. rebuild the project.
```


## Running the tests

Before running, please prepare the test objects first. 
And, check all the config settings in ./config/ folder.

### Running the tests in Remote Cloud Platform - Sauce labs

For local appium running, place the latest test app(apk/ipa) in app folder. 

Then, localAppiumRunMode=OFF in ./config/androidConfig.properties.

Find test file: /src/main/java/com/LottoNZ/AutoSLAndroidTest/Tests/AndroidLottoHomePageTest.java. Right Click it, run as TestNG.


### Running the tests via Local Appium Driver

For cloud sauce labs running, upload the test app into sauce labs cloud storage.
Reference link: https://wiki.saucelabs.com/display/DOCS/Uploading+Mobile+Applications+to+Sauce+Storage+for+Testing

Then, localAppiumRunMode=ON in ./config/androidConfig.properties.

Find test file: /src/main/java/com/LottoNZ/AutoSLAndroidTest/Tests/AndroidLottoHomePageTest.java. Right Click it, run as TestNG.

```
@Test(dataProvider = "AndroidCapabilities")
	public void verifyLottoTest(String appiumVersion,
			String deviceName, String deviceType, String deviceOrientation,
			String platformVersion, String platformName, String browserName,
			String app, Method method) throws MalformedURLException,
			InvalidElementStateException, UnexpectedException {
		// create webdriver session
		AppiumDriver driver = createDriver(appiumVersion, deviceName, deviceType
				,deviceOrientation, platformVersion, platformName,
				browserName, app, method.getName());
		System.out.println("create over");
		driver.get("https://mylotto.co.nz/");
		// Go to Lotto Homepage
		LottoHomePage HomePage = new LottoHomePage(driver);

}
```

## Built With

* TestNG - Introduction
* Maven - Introduction


## Authors

* **Lola Yan** - *Initial work* - [LolaYan](https://github.com/LolaYan)

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
