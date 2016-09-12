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

	static String CAT1DB = "jdbc:db2://192.168.101.87:50000/ESI_DB";
	static String CAT2DB = "jdbc:db2://192.168.103.74:50000/ESI_DB";
	static String CAT3DB = "jdbc:db2://192.168.101.74:50000/ESI_DB";
	static String SIT1DB = "jdbc:db2://192.168.225.66:50000/ESI_DB";

	public static void main(String[] args) throws IOException {
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
