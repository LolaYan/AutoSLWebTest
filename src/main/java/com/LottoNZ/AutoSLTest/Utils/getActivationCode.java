/**
 *
 */
package com.LottoNZ.AutoSLTest.Utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mrawal
 *
 */
public class getActivationCode {
	static String account1;
	static String account2;
	static String account3;
	static String account4;

	// public static String getDBString() {
	// String dbStr = null;
	// if (HelperMethods.baseURL.contains("2")) {
	// dbStr = CAT2DB;
	// } else if
	// (HelperMethods.baseURL.startsWith("https://3.cat.mylotto.co.nz/")) {
	// dbStr = CAT3DB;
	// } else if
	// (HelperMethods.baseURL.startsWith("https://1.cat.mylotto.co.nz/")) {
	// dbStr = CAT1DB;
	// }
	// System.out.println(dbStr);
	// return dbStr;
	// }

	static String CAT1DB = "jdbc:db2://192.168.101.87:50000/ESI_DB";

	static String CAT2DB = "jdbc:db2://192.168.103.74:50000/ESI_DB";

	static String CAT3DB = "jdbc:db2://192.168.101.74:50000/ESI_DB";

	private static final String FILE_PATH = "C:\\Users\\CATPC\\workspace\\Test\\NewBankAccountList.csv"; // Replace
	static String SIT1DB = "jdbc:db2://192.168.225.66:50000/ESI_DB";
	public static void main(String[] args) throws IOException {

		System.out.println("Getting random line from file: " + FILE_PATH);

		InputStream is = null;
		BufferedReader reader = null;
		try {
			is = new FileInputStream(FILE_PATH);

			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(FILE_PATH)));

			System.out.println("Reading file...");
			final List<String> list = new ArrayList<String>();
			String line = reader.readLine();
			while (line != null) {
				list.add(line);
				line = reader.readLine();
			}

			System.out.println("Generating random...");
			final SecureRandom random = new SecureRandom();
			final int row = random.nextInt(list.size());

			System.out.println("Random selection is:\n");
			System.out.println(list.get(row));

		} finally {
			if (is != null) {
				is.close();
			}
			if (reader != null) {
				reader.close();
			}
		}
	}
	public static String readRandomRow() throws IOException {
		System.out.println("Getting random line from file: " + FILE_PATH);

		InputStream is = null;
		BufferedReader reader = null;
		try {
			is = new FileInputStream(FILE_PATH);

			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(FILE_PATH)));

			System.out.println("Reading file...");
			final List<String> list = new ArrayList<String>();
			String line = reader.readLine();
			while (line != null) {
				list.add(line);
				line = reader.readLine();
			}

			System.out.println("Generating random...");
			final SecureRandom random = new SecureRandom();
			final int row = random.nextInt(list.size());

			System.out.println("Random selection is:\n");
			System.out.println(list.get(row));
			return list.get(row);
		} finally {
			if (is != null) {
				is.close();
			}
			if (reader != null) {
				reader.close();
			}
		}

	}
	public static String returnActivationId(String username)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		connection = DriverManager
				.getConnection(CAT1DB, "gtkinst1", "gtkinst1");
		System.out.println("DB2 Connection setup... " + CAT1DB);
		connection.createStatement();
		final String query = String
				.format("Select NZDEV.ES_SECURITY.ACTIVATION_ID From NZDEV.ES_SECURITY Where NZDEV.ES_SECURITY.USER_NAME = '%s'",

				username);
		System.out.println(query);
		preparedStatement = connection.prepareStatement(query);
		String activationId = null;
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			activationId = resultSet.getString("activation_id");
		}
		System.out.println(activationId);
		connection.close();
		return activationId;

	}

	public static void updateSpendingLimits(String username)
			throws ClassNotFoundException, SQLException {
		Statement smt = null;
		Connection connection = null;
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		connection = DriverManager
				.getConnection(SIT1DB, "gtkinst1", "gtkinst1");
		connection.createStatement();
		final String query = String
				.format("update NZDEV.ESI_PROFILE set NZDEV.ESI_PROFILE.MONTHLY_ACTUAL_LIMIT=9999, NZDEV.ESI_PROFILE.WEEKLY_ACTUAL_LIMIT=9999 where NZDEV.ESI_PROFILE.EMAIL_ADDR='%s'",

				username);
		System.out.println(query);
		smt = connection.createStatement();
		smt.executeUpdate(query);
		connection.close();

	}

	public static void updateWalletBalance(String username)
			throws ClassNotFoundException, SQLException {
		Statement smt = null;
		Connection connection = null;
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		connection = DriverManager
				.getConnection(SIT1DB, "gtkinst1", "gtkinst1");
		connection.createStatement();
		final String query = String
				.format("update NZDEV.ES_ACCOUNT set acct_balance = 900 where acct_userid in (select USER_ID from NZDEV.ES_SECURITY where user_name like '%s')",

				username);
		System.out.println(query);
		smt = connection.createStatement();
		smt.executeUpdate(query);
		connection.close();

	}

}
