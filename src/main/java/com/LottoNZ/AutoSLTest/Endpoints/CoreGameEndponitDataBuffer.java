/**
 *
 */
package com.LottoNZ.AutoSLTest.Endpoints;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import com.LottoNZ.AutoSLTest.Utils.DataGenerator;

/**
 * @author mrawal
 *
 */
public class CoreGameEndponitDataBuffer extends BaseEndpoint {

	public static String password = "password1";

	public static void main(String[] args) throws Exception {
	}

	public static String postSignupRequestBody(String emailAddress,
			String password) throws JSONException {
		JSONObject obj = new JSONObject();
		UUID uuid = UUID.randomUUID();
		String deviceId = uuid.toString();
		obj.put("deviceId", deviceId);
		obj.put("emailAddress", emailAddress);
		obj.put("password", password);
		obj.put("firstName", "Automation");
		obj.put("lastName", "Lola");
		obj.put("gender", "F");
		obj.put("dateOfBirth", "1981-04-23");
		obj.put("tlaArea", "Auckland");
		obj.put("tlaLocation", "Auckland City");
		obj.put("phone", "0213334444");
		obj.put("optInLottoResults", false);
		obj.put("securityQuestionId", 1);
		obj.put("securityAnswer", "I don not know");
		obj.put("userAgreed", true);
		obj.put("optInLottoJackpotThreshold", 0);
		obj.put("optInLottoJackpot", false);
		obj.put("optInMarketing", false);
		obj.put("optInInstantKiwi", false);
		obj.put("pushLottoJackpotThreshold", 0);
		obj.put("pushLottoJackpot", false);
		obj.put("pushInstantKiwi", false);
		obj.put("pushMarketing", false);

		JSONObject obj2 = new JSONObject();
		obj2.put("language", "en-GB,en-US;q=0.8,en;q=0.6");
		obj2.put("encoding", "gzip,deflate,sdch");
		obj2.put("charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
		obj2.put("clientIP", "202.160.48.160");
		obj2.put(
				"browser",
				"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36");

		obj.put("geofilterInfo", obj2);

		String res = obj.toString();

		System.out.print(res);
		return res;
	}

	public static String postLoginRequestBody(String userName, String password)
			throws JSONException {
		JSONObject obj = new JSONObject();
		UUID uuid = UUID.randomUUID();
		String deviceId = uuid.toString();
		obj.put("userName", userName);
		obj.put("password", password);

		JSONObject obj2 = new JSONObject();
		obj2.put("language", "en-GB,en-US;q=0.8,en;q=0.6");
		obj2.put("encoding", "gzip,deflate,sdch");
		obj2.put("charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
		obj2.put("clientIP", "202.160.48.160");
		obj2.put(
				"browser",
				"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36");

		obj.put("geofilterInfo", obj2);
		String res = obj.toString();
		System.out.print(res);
		return res;
	}

	public static String getEmailActivationRequestBody(String activationId)
			throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("activationId", activationId);

		JSONObject obj2 = new JSONObject();
		obj2.put("language", "en-GB,en-US;q=0.8,en;q=0.6");
		obj2.put("encoding", "gzip,deflate,sdch");
		obj2.put("charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
		obj2.put("clientIP", "202.160.48.160");
		obj2.put(
				"browser",
				"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36");

		obj.put("geofilterInfo", obj2);
		String res = obj.toString();

		System.out.print(res);
		return res;
	}

	public static String postSpendingLimitRequestBody(String acctNumber,
			int weeklyActualLimit, int monthlyActualLimit) throws JSONException {
		JSONObject obj = new JSONObject();
		UUID uuid = UUID.randomUUID();
		String deviceId = uuid.toString();
		obj.put("acctNumber", acctNumber);
		obj.put("weeklyActualLimit", weeklyActualLimit);
		obj.put("monthlyActualLimit", monthlyActualLimit);
		String res = obj.toString();

		System.out.print(res);
		return res;
	}

	public static String postWalletValidationRequestBody(String password,
			String returnUrl) throws JSONException {
		JSONObject obj = new JSONObject();
		UUID uuid = UUID.randomUUID();
		String deviceId = uuid.toString();
		obj.put("password", password);
		obj.put("returnUrl", returnUrl);
		String res = obj.toString();

		System.out.print(res);
		return res;
	}
	
	public static String CreditCardRegisterRequestBody(String transactionId) throws JSONException {
		JSONObject obj = new JSONObject();
		UUID uuid = UUID.randomUUID();
		String deviceId = uuid.toString();
		obj.put("transactionId", transactionId);
		String res = obj.toString();

		System.out.print(res);
		return res;
	}
	
	public static String CreditCardTopupRequestBody(int amount, int cvc, String password) throws JSONException {
		JSONObject obj = new JSONObject();
		UUID uuid = UUID.randomUUID();
		String deviceId = uuid.toString();
		obj.put("amount", amount);
		obj.put("cvc", cvc);
		obj.put("password", password);
		String res = obj.toString();

		System.out.print(res);
		return res;
	}
}
