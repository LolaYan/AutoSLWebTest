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
#### Driver:
```
 - DeviceDataProvider
 DataProvider is to set the DesiredCapabilities data to be used. 
 It returns two dimensional array of objects with browser, version, and platform information.
 - DriverHelper
 DriverHelper defines the creation of androidDriver, iosDriver, webDriver. 
 Also define implicitlyWait and pageloadTimeout here.
 - SauceHelper
 SauceHelper will return credential data for Sauce Connect, 
 which are read from ipConfig.properties file Used by TestBase class in Test package.
```
#### Utils:
Utils package includes different test utilities which are needed by Page Object/Class or Test Object/Class.

Most Common Utils are:
```
 - DataGenerator
 DataGenerator is to generate test data like email, phone number, guid, bank account, user name, random string, random number, etc.
 - DBHelper
 DBHelper is to handle different DB operation - query, update, delete.
 Also, DBHelper should be compatible with different type DB - mysql, db2, jdbc, etc. 
 This requires jars to be imported in the project.
 - LogHelper
 During the running of test case user wants some information to be logged in the console. 
 Information could be any detail depends upon the purpose. Log4j is applied for it here.
 - PropertyLoader
 PropertyLoader is to load the prperty value from the properties file in config folder.
 - Verification
 Verification helps your test execution to continue,
 even if there are any assertion failures and throw all errors at the end.
 Code is referred from:
 https://muthutechno.wordpress.com/2015/01/26/implementing-verify-statements-for-testng-framework/.
```

#### config:
config folder includes all the project properties file, example as below:
```
! SauceConnectCmdRelayType = No, VM. Local
SauceConnectCmdRelayType=No
seleniumURI=@ondemand.saucelabs.com:80/wd/hub
vmSeleniumURI=@192.168.200.70:4445
localSeleniumURI=@localhost:4445
localAppiumRunMode=ON
localAppiumURI=http://127.0.0.1:4723/wd/hub
tunnelIdentifier = Mudra CAT PC
sauceUname = testsauceUname
sauceUkay = 4441f476-xxxx-xxxx-xxxx-437e8323d461
! app info - Android apk
sauce.LottoAPK.filename = sauce-storage:demo.apk
sauce.LottoAPK.appPackage = co.nz.demo
sauce.LottoAPK.appActivity = co.nz.demo.MainActivity
! app info - IOS ipa
sauce.LottoIPA.filename = sauce-storage:demo.zip
! time wait
timeWaitInSeconds=40
implicitlyWebWait=40
elementWait=30
! Acceptable value for log could be ON, OFF
log=ON
EnableLogin=ON
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
