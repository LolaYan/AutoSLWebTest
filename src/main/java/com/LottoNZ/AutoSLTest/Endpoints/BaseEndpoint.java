/**
 *
 */
package com.LottoNZ.AutoSLTest.Endpoints;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
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
import java.util.Map;
import java.util.UUID;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.json.JSONException;
import org.json.JSONObject;

import com.LottoNZ.AutoSLTest.Utils.DataGenerator;

/**
 * @author mrawal
 *
 */
public class BaseEndpoint {
	protected static int responseCode;
	protected static String responseHeader;
	protected static Map<String, List<String>> responseHeaderList;
	protected static String responseBody;
	protected static JSONObject jsonResponseBody;

	public static void main(String[] args) throws Exception {
		sendHeader();
	}

	// Set Header
	public static void sendHeader() {
		// ======> List of Entries
		List<Entry<String, String>> headerList = new ArrayList<>();
		// -- Specify manually
		Entry<String, String> contentType = new SimpleEntry<String, String>(
				"Content-Type ", "application/json");
		headerList.add(contentType);
		// -- one liner:
		headerList.add(new SimpleEntry<String, String>("USER_ID", "107560051")); // Ananomous
																					// add.
		// -- Iterate over Entry array:
		for (Entry<String, String> entr : headerList) {
			System.out.println("Button: " + entr.getKey() + "    Label: "
					+ entr.getValue());
		}
	}

	public static void printHeader(Map<String, List<String>> responseHeaderList) {
		for (Map.Entry<String, List<String>> entry : responseHeaderList
				.entrySet()) {
			String key = entry.getKey();
			for (String value : entry.getValue()) {

			}
		} // add.

	}

	// Set Header
	public static void setHeader(HttpURLConnection con,
			List<Entry<String, String>> headerList) {
		// -- Iterate over Entry array:
		for (Entry<String, String> header : headerList) {
			System.out.println("Header Key: " + header.getKey()
					+ "    Header Value: " + header.getValue());
			// add request header
			con.setRequestProperty(header.getKey(), header.getValue());
		}
	}

	// HTTP POST request
	public static void sendHTTPRequest(String Method, String url,
			List<Entry<String, String>> headerList, String requestBody)
			throws Exception {
		Method = Method.toUpperCase();
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod(Method);

		// add reuqest header
		setHeader(con, headerList);

		if (Method.equals("GET")) {

		} else {
			// Set up request body
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(requestBody);
			wr.flush();
			wr.close();
		}
		System.out
				.println("\nSending '" + Method + "' request to URL : " + url);
		System.out.println(Method + " body : " + requestBody);

		responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		con.getHeaderFields();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		responseBody = response.toString();
		getJsonResponseBody();
		// print result
		System.out.println(responseBody);

	}

	public static void getJsonResponseBody() {
		jsonResponseBody = new JSONObject(responseBody);
	}

	// HTTP GET request
	public static void sendGet(String url,
			List<Entry<String, String>> headerList) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		setHeader(con, headerList);

		System.out.println("\nSending 'GET' request to URL : " + url);
		responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

	// HTTP GET request
	public static void sendDelete(String url,
			List<Entry<String, String>> headerList, String postBody)
			throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest method
		con.setRequestMethod("DELETE");

		// add reuqest header
		setHeader(con, headerList);

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postBody);
		wr.flush();
		wr.close();

		System.out.println("\nSending 'DELETE' request to URL : " + url);
		System.out.println("Post body : " + postBody);

		responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

	// HTTP POST request
	public static void sendPost(String url,
			List<Entry<String, String>> headerList, String postBody)
			throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest method
		con.setRequestMethod("POST");

		// add reuqest header
		setHeader(con, headerList);

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postBody);
		wr.flush();
		wr.close();

		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post body : " + postBody);

		responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

	// HTTP PUT request
	public static void sendPut(String url,
			List<Entry<String, String>> headerList, String postBody)
			throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest method
		con.setRequestMethod("PUT");

		// add reuqest header
		setHeader(con, headerList);

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postBody);
		wr.flush();
		wr.close();

		System.out.println("\nSending 'PUT' request to URL : " + url);
		System.out.println("Post body : " + postBody);

		responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

	public static String readFile(String filename) {
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
