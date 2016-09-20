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
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import com.LottoNZ.AutoSLTest.Utils.DBHelper;
import com.LottoNZ.AutoSLTest.Utils.DataGenerator;
import com.LottoNZ.AutoSLTest.Utils.BankAccountHelper.BankAccountGenerator;

/**
 * @author mrawal
 *
 */
public class CoreGameEndpointCall extends CoreGameEndponitDataBuffer {

	protected static String endpoint = "http://192.168.100.196/api/core/v1/";
	protected static List<Entry<String, String>> headerList = new ArrayList<>();

	protected static String USER_ID;
	protected static String ESI_SID;
	protected static int playerCode;
	protected static String playerDescription;
	protected static String transactionId;
	protected static String returnUrl = "http://test.com";
	protected static int walletBalance;
	protected static String truncatedCardNumber;
	protected static String expirationDate;
	protected static int walletStatus;
	protected static int weeklyTransferredAmount;
	protected static int weeklyTransferredCount;
	protected static String creditCardNumber = "4111111111111111";
	protected static String ExpiryMonth = "12";
	protected static String ExpiryYear = "22";
	protected static String Cvc2 = "123";
	protected static String CardHolderName = "test";

	public static void main(String[] args) throws Exception {
		//Generate a new user
		String emailAddress = DataGenerator.generateEmail(10);
		//emailAddress = "changepassword@autotest.com";
		int amount = 50;
		int cvc = 123;
		
		/*	Sign up work flow	*/
		signupNewAccountPost(emailAddress, password);
		LoginAccountPost(emailAddress, password);
		activateEmail(emailAddress);
		String acctNumber = BankAccountGenerator.getBankAccount();
		int weeklyActualLimit = 150;
		int monthlyActualLimit = 300;
		signupSpendinglimitsPost(acctNumber, weeklyActualLimit,
				monthlyActualLimit);

		/*
		 * Top up workflow
		 */
		LoginAccountPost(emailAddress, password);
		WalletValidationPost(password, returnUrl);
		DPSCreditRegisterPost(transactionId);
		CreditCardRegisterPost(transactionId);		
		CreditCardTopupPut(amount, cvc, password);

		/*
		 * Top up again workflow
		 */
		ExpiryMonth = "04";
		ExpiryYear = "28";
		LoginAccountPost(emailAddress, password);
		WalletValidationPost(password, returnUrl);
		DPSCreditRegisterPost(transactionId);
		CreditCardRegisterPost(transactionId);
		CreditCardTopupPut(amount, cvc, password);
		
		/*
		 *  Lotto Wager
		 */
		getWalletBalanceInfo(); getUserProfileInfo(); 
		LottoPYOWagerPost(); 
		
	}

	public static void signupNewAccountPost(String emailAddress, String password)
			throws Exception {

		// String emailAddress = DataGenerator.generateEmail(10);
		String postBody = postSignupRequestBody(emailAddress, password);

		String url = endpoint + "accounts";
		String method = "POST";

		// Header Setting
		headerList.clear();
		headerList.add(new SimpleEntry<String, String>("Content-Type",
				"application/json"));

		// Call request
		sendHTTPRequest(method, url, headerList, postBody);

		// parse json response
		JSONObject playerStatusObject = jsonResponseBody
				.getJSONObject("playerStatus");
		int playerCodeRet = playerStatusObject.getInt("playerCode");
		playerCode = playerCodeRet;
		System.out.println(playerCode);
		String playerDescriptionRet = playerStatusObject
				.getString("playerDescription");
		playerDescription = playerDescriptionRet;
		System.out.println(playerDescription);
		String userId = jsonResponseBody.getString("userId");
		System.out.println(userId);

	}

	public static void LoginAccountPost(String emailAddress, String password)
			throws Exception {

		String postBody = postLoginRequestBody(emailAddress, password);

		String url = endpoint + "sessions";
		String method = "POST";

		// Header Setting
		headerList.clear();
		headerList.add(new SimpleEntry<String, String>("Content-Type",
				"application/json"));

		// Call request
		sendHTTPRequest(method, url, headerList, postBody);

		// parse json response
		String userId = jsonResponseBody.getString("userId");
		USER_ID = userId;
		System.out.println(userId);
		String sessionId = jsonResponseBody.getString("sessionId");
		ESI_SID = sessionId;
		System.out.println(sessionId);
	}

	public static void activateEmail(String emailAddress) throws Exception {
		Thread.sleep(1000);
		String activationId = DBHelper.getActivationId(emailAddress);
		String postBody = getEmailActivationRequestBody(activationId);

		String url = endpoint + "accounts/status";
		String method = "PUT";

		// Header Setting
		headerList.clear();
		headerList.add(new SimpleEntry<String, String>("Content-Type",
				"application/json"));

		// Call request
		sendHTTPRequest(method, url, headerList, postBody);

		// parse json response

		JSONObject playerStatusObject = jsonResponseBody
				.getJSONObject("playerStatus");
		int playerCodeRet = playerStatusObject.getInt("playerCode");
		playerCode = playerCodeRet;
		System.out.println(playerCode);
		String playerDescriptionRet = playerStatusObject
				.getString("playerDescription");
		playerDescription = playerDescriptionRet;
		System.out.println(playerDescription);

		String userId = jsonResponseBody.getString("userId");
		System.out.println(userId);
		String emailAddressRet = jsonResponseBody.getString("emailAddress");
		System.out.println(emailAddressRet);
		boolean activationIdExpired = jsonResponseBody
				.getBoolean("activationIdExpired");
		System.out.println(activationIdExpired);
	}

	public static void signupSpendinglimitsPost(String acctNumber,
			int weeklyActualLimit, int monthlyActualLimit) throws Exception {
		String postBody = postSpendingLimitRequestBody(acctNumber,
				weeklyActualLimit, monthlyActualLimit);

		String url = endpoint + "accounts/" + USER_ID + "/spendinglimits";
		String method = "POST";

		// Header Setting
		headerList.clear();
		headerList.add(new SimpleEntry<String, String>("Content-Type",
				"application/json"));
		headerList.add(new SimpleEntry<String, String>("USER_ID", USER_ID));
		headerList.add(new SimpleEntry<String, String>("ESI_SID", ESI_SID));

		// Call request
		sendHTTPRequest(method, url, headerList, postBody);

		// parse json response

		JSONObject playerStatusObject = jsonResponseBody
				.getJSONObject("playerStatus");
		int playerCodeRet = playerStatusObject.getInt("playerCode");
		playerCode = playerCodeRet;
		System.out.println(playerCode);
		String playerDescriptionRet = playerStatusObject
				.getString("playerDescription");
		playerDescription = playerDescriptionRet;
		System.out.println(playerDescription);

	}

	public static void WalletValidationPost(String password, String returnUrl)
			throws Exception {
		String postBody = postWalletValidationRequestBody(password, returnUrl);

		String url = endpoint + "wallets/" + USER_ID + "/topups/validations";
		String method = "POST";

		// Header Setting
		headerList.clear();
		headerList.add(new SimpleEntry<String, String>("Content-Type",
				"application/json"));
		headerList.add(new SimpleEntry<String, String>("USER_ID", USER_ID));
		headerList.add(new SimpleEntry<String, String>("ESI_SID", ESI_SID));

		// Call request
		sendHTTPRequest(method, url, headerList, postBody);

		// parse json response
		String transactionIdRet = jsonResponseBody.getString("transactionId");
		transactionId = transactionIdRet;
		System.out.println(transactionId);

	}

	public static int DPSCreditRegisterPost(String transactionId)
			throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType
				.parse("multipart/form-data; boundary=---011000010111000001101001");
		RequestBody body = RequestBody
				.create(mediaType,
						"-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"CardNumber\"\r\n\r\n"
								+ creditCardNumber
								+ "\r\n-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"ExpiryMonth\"\r\n\r\n"
								+ ExpiryMonth
								+ "\r\n-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"ExpiryYear\"\r\n\r\n"
								+ ExpiryYear
								+ "\r\n-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"SessionId\"\r\n\r\n"
								+ transactionId
								+ "\r\n-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"Cvc2\"\r\n\r\n"
								+ Cvc2
								+ "\r\n-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"CardHolderName\"\r\n\r\n"
								+ CardHolderName
								+ "\r\n-----011000010111000001101001--");
		Request request = new Request.Builder()
				.url("https://sec.paymentexpress.com/pxmi3/pxfusionauth")
				.post(body)
				.addHeader("content-type",
						"multipart/form-data; boundary=---011000010111000001101001")
				.addHeader("cache-control", "no-cache")
				.addHeader("postman-token",
						"56fa25ad-bf20-7bf3-0803-cd6c6dea4812").build();

		Response response = client.newCall(request).execute();
		System.out.println(response.message());
		System.out.println(response.body());
		return response.code();
	}

	public static void CreditCardRegisterPost(String transactionId)
			throws Exception {
		String postBody = CreditCardRegisterRequestBody(transactionId);

		String url = endpoint + "wallets/" + USER_ID + "/topups";
		String method = "POST";

		// Header Setting
		headerList.clear();
		headerList.add(new SimpleEntry<String, String>("Content-Type",
				"application/json"));
		headerList.add(new SimpleEntry<String, String>("USER_ID", USER_ID));
		headerList.add(new SimpleEntry<String, String>("ESI_SID", ESI_SID));

		// Call request
		sendHTTPRequest(method, url, headerList, postBody);

		// parse json response
		String messageRet = jsonResponseBody.getString("message");
		System.out.println(messageRet);

	}

	public static void CreditCardTopupPut(int amount, int cvc, String password)
			throws Exception {
		String postBody = CreditCardTopupRequestBody(amount, cvc, password);

		String url = endpoint + "wallets/" + USER_ID + "/topups";
		String method = "PUT";

		// Header Setting
		headerList.clear();
		headerList.add(new SimpleEntry<String, String>("Content-Type",
				"application/json"));
		headerList.add(new SimpleEntry<String, String>("USER_ID", USER_ID));
		headerList.add(new SimpleEntry<String, String>("ESI_SID", ESI_SID));

		// Call request
		sendHTTPRequest(method, url, headerList, postBody);

		if (responseCode == 200) {

			// parse json response
			int walletBalanceRet = jsonResponseBody.getInt("walletBalance");
			walletBalance = walletBalanceRet;
			System.out.println(walletBalance);
		} else {
			System.out.println(responseBody);

		}

	}

	public static void getWalletBalanceInfo() throws Exception {

		String url = endpoint + "wallets/" + USER_ID;
		String method = "GET";

		// Header Setting
		headerList.clear();
		headerList.add(new SimpleEntry<String, String>("USER_ID", USER_ID));
		headerList.add(new SimpleEntry<String, String>("ESI_SID", ESI_SID));

		// Call request
		sendHTTPRequest(method, url, headerList, null);

		// parse json response
		String truncatedCardNumber = jsonResponseBody
				.getString("truncatedCardNumber");
		System.out.println(truncatedCardNumber);

		String expirationDate = jsonResponseBody.getString("expirationDate");
		System.out.println(expirationDate);

		int walletStatus = jsonResponseBody.getInt("walletStatus");
		System.out.println(walletStatus);
		int weeklyTransferredAmount = jsonResponseBody
				.getInt("weeklyTransferredAmount");
		System.out.println(weeklyTransferredAmount);
		int weeklyTransferredCount = jsonResponseBody
				.getInt("weeklyTransferredCount");
		System.out.println(weeklyTransferredCount);

	}

	public static void getUserProfileInfo() throws Exception {

		String url = endpoint + "accounts/" + USER_ID;
		String method = "GET";

		// Header Setting
		headerList.clear();
		headerList.add(new SimpleEntry<String, String>("USER_ID", USER_ID));
		headerList.add(new SimpleEntry<String, String>("ESI_SID", ESI_SID));

		// Call request
		sendHTTPRequest(method, url, headerList, null);

		// parse json response

		int accountStatus = jsonResponseBody.getInt("accountStatus");
		System.out.println(accountStatus);

		String acctNumber = jsonResponseBody.getString("acctNumber");
		System.out.println(acctNumber);

		int ageConfirmStatus = jsonResponseBody.getInt("ageConfirmStatus");
		System.out.println(ageConfirmStatus);

		boolean bankAccountConfirmed = jsonResponseBody
				.getBoolean("bankAccountConfirmed");
		System.out.println(bankAccountConfirmed);

		String bankAccountNumber = jsonResponseBody
				.getString("bankAccountNumber");
		System.out.println(bankAccountNumber);

		int cashBalance = jsonResponseBody.getInt("cashBalance");
		System.out.println(cashBalance);

		int claimTypeNotificationsCount = jsonResponseBody
				.getInt("claimTypeNotificationsCount");
		System.out.println(claimTypeNotificationsCount);

		String phone = jsonResponseBody.getString("phone");
		System.out.println(phone);

		String dateOfBirth = jsonResponseBody.getString("dateOfBirth");
		System.out.println(dateOfBirth);

		String emailAddress = jsonResponseBody.getString("emailAddress");
		System.out.println(emailAddress);

		String firstName = jsonResponseBody.getString("firstName");
		System.out.println(firstName);

		String gender = jsonResponseBody.getString("gender");
		System.out.println(gender);

		boolean helpFlagEnabled = jsonResponseBody
				.getBoolean("helpFlagEnabled");
		System.out.println(helpFlagEnabled);

		String lastName = jsonResponseBody.getString("lastName");
		System.out.println(lastName);

		int loginStatus = jsonResponseBody.getInt("loginStatus");
		System.out.println(loginStatus);

		String loginTime = jsonResponseBody.getString("loginTime");
		System.out.println(loginTime);

		int monthlySpendingLimit = jsonResponseBody
				.getInt("monthlySpendingLimit");
		System.out.println(monthlySpendingLimit);

		boolean newPasswordRequired = jsonResponseBody
				.getBoolean("newPasswordRequired");
		System.out.println(newPasswordRequired);

		boolean optInEmailResultsNotify = jsonResponseBody
				.getBoolean("optInEmailResultsNotify");
		System.out.println(optInEmailResultsNotify);

		String playerGreeting = jsonResponseBody.getString("playerGreeting");
		System.out.println(playerGreeting);

		int playerStatus = jsonResponseBody.getInt("playerStatus");
		System.out.println(playerStatus);

		boolean sessionActive = jsonResponseBody.getBoolean("sessionActive");
		System.out.println(sessionActive);

		int spentToDateMonth = jsonResponseBody.getInt("spentToDateMonth");
		System.out.println(spentToDateMonth);

		int spentToDateWeek = jsonResponseBody.getInt("spentToDateWeek");
		System.out.println(spentToDateWeek);

		String tcVersion = jsonResponseBody.getString("tcVersion");
		System.out.println(tcVersion);

		String tlaArea = jsonResponseBody.getString("tlaArea");
		System.out.println(tlaArea);

		String tlaLocation = jsonResponseBody.getString("tlaLocation");
		System.out.println(tlaLocation);

		int totalNotifications = jsonResponseBody.getInt("totalNotifications");
		System.out.println(totalNotifications);

		int userType = jsonResponseBody.getInt("userType");
		System.out.println(userType);

		int walletStatus = jsonResponseBody.getInt("walletStatus");
		System.out.println(walletStatus);

		int weeklySpendingLimit = jsonResponseBody
				.getInt("weeklySpendingLimit");
		System.out.println(weeklySpendingLimit);

		int weeklyTransferCount = jsonResponseBody
				.getInt("weeklyTransferCount");
		System.out.println(weeklyTransferCount);

		int weeklyXferAmt = jsonResponseBody.getInt("weeklyXferAmt");
		System.out.println(weeklyXferAmt);

		int winningTypeNotificationsCount = jsonResponseBody
				.getInt("winningTypeNotificationsCount");
		System.out.println(winningTypeNotificationsCount);
	}

	public static void LottoPYOWagerPost() throws Exception {
		String postBody = LottoPYORequestBody();

		String url = endpoint + "wagers/" + USER_ID;
		String method = "POST";

		// Header Setting
		headerList.clear();
		headerList.add(new SimpleEntry<String, String>("Content-Type",
				"application/json"));
		headerList.add(new SimpleEntry<String, String>("USER_ID", USER_ID));
		headerList.add(new SimpleEntry<String, String>("ESI_SID", ESI_SID));

		// Call request
		sendHTTPRequest(method, url, headerList, postBody);

		// parse json response
		// String messageRet = jsonResponseBody.getString("message");
		// System.out.println(messageRet);

	}
}
