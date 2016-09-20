/**
 * 
 */
package com.LottoNZ.AutoSLTest.Utils;

/**
 * @author CATPC
 *
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogHelper {
	private static Logger Log = Logger.getLogger(LogHelper.class.getName());
	private static String LogFlag = PropertyLoader.loadProjectProperty("log")
			.toUpperCase().replaceAll("\\s", "");

	public static void debug(String message) {
		Log.debug(message);
	}

	public static void main(String[] args) {
	}

	// This is to print log for the ending of the test case
	public static void recordEmail(String email) {
		try {
			String str = "SomeMoreTextIsHere";
			File newTextFile = new File("./email.txt");

			FileWriter fw = new FileWriter(newTextFile);
			fw.append(email + "\r\n");
			fw.close();

		} catch (IOException iox) {
			// do stuff with exception
			iox.printStackTrace();
		}
	}

	// This is to print log for the ending of the test case
	public static void endTest(String sTestName) {
		Log.info(" - END Test Case: " + sTestName + " - ");
	}

	// This is to print log for the ending of the test case
	public static void endTestClass(String sTestClassName) {
		Log.info(" - END Test Class: " + sTestClassName + " - ");
	}

	// This is to print log for the ending of the test case
	public static void endTestGroup(String sTestGroupName) {
		Log.info(" - END Test Group: " + sTestGroupName + " - ");
	}

	// This is to print log for the ending of the test case
	public static void endTestMethod(String sTestCaseName) {
		Log.info(" - END Test Method: " + sTestCaseName + " - ");
	}

	// This is to print log for the ending of the test case
	public static void endTestSuite(String sTestSuite) {
		Log.info(" * END Test Suite:" + sTestSuite + " * ");

	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	// Need to create these methods, so that they can be called
	public static void info(String message) {
		System.out.println(message);
		Log.info(message);
	}

	public static void startTest(String sTestName) {
		Log.info(" - START Test Case: " + sTestName + " - ");

	}

	public static void startTestClass(String sTestClassName) {
		Log.info(" - START Test Class: " + sTestClassName + " - ");
	}

	public static void startTestGroup(String sTestGroupName) {
		Log.info(" - START Test Group: " + sTestGroupName + " - ");
	}

	public static void startTestMethod(String sTestCaseName) {
		Log.info(" - START Test Method: " + sTestCaseName + " - ");
	}

	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite
	public static void startTestSuite(String sTestSuite) {
		Log.info(" * START Test Suite:" + sTestSuite + " * ");

	}

	public static void warn(String message) {
		Log.warn(message);
	}

	// Read Log config from application.properties file
	LogHelper() {
		System.out.println("Should we start log? Answer:" + LogFlag);
		if (LogFlag.equalsIgnoreCase("ON")) {
			DOMConfigurator.configure("log4j.xml");
		}
	}

}
