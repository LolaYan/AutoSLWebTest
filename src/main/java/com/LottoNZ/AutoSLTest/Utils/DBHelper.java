package com.LottoNZ.AutoSLTest.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

	public static final String url_CoreGame = "jdbc:db2://192.168.101.87:50000/ESI_DB";
	public static final String jdbcClassName_CoreGame = "com.ibm.db2.jcc.DB2Driver";
	public static final String user_CoreGame = "gtkinst1";
	public static final String password_CoreGame = "gtkinst1";

	public static final String url_CoreGame_rps = "jdbc:mysql://192.168.101.100:3306/rps_db";
	public static final String jdbcClassName_rps = "com.mysql.jdbc.Driver";
	public static final String user_CoreGame_rps = "resultrelay";
	public static final String password_CoreGame_rps = "resultrelay";

	public static void main(String[] args) {
		getActivationId("ningjinlu@gmail.com");

	}

	public static String getActivationId(String email) {

		/* data info parameters */
		Statement stmt = null;
		String query = "Select * From NZDEV.ES_SECURITY where NZDEV.ES_SECURITY.USER_NAME = '"
				+ email + "'";
		Connection connection = null;
		String activationId = "";
		try {
			// Load class into memory
			Class.forName(jdbcClassName_CoreGame);
			// Establish connection
			connection = DriverManager.getConnection(url_CoreGame,
					user_CoreGame, password_CoreGame);

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Extract data from result set
			while (rs.next()) {
				activationId = rs.getString("ACTIVATION_ID");
				System.out.println("Activation_ID: " + activationId + "\t");
			}

			// Clean-up environment
			rs.close();
			stmt.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				System.out.println("Connected successfully.");
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return activationId;

	}

	public static int countRows(Connection conn, String tableName)
			throws SQLException {
		// select the number of rows in the table
		Statement stmt = null;
		ResultSet rs = null;
		int rowCount = -1;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tableName);
			// get the number of rows from the result set
			rs.next();
			rowCount = rs.getInt(1);
		} finally {
			rs.close();
			stmt.close();
		}
		return rowCount;
	}

	public static void db2Demo() {
		Statement stmt = null;
		String email = "ningjinlu@gmail.com";
		// String query =
		// "Select NZDEV.ES_SECURITY.ACTIVATION_ID From NZDEV.ES_SECURITY where NZDEV.ES_SECURITY.USER_NAME = '"+email+"'";
		String query = "Select *  From NZDEV.ES_SECURITY where NZDEV.ES_SECURITY.USER_NAME = '"
				+ email + "'";
		Connection connection = null;
		try {
			// Load class into memory
			Class.forName(jdbcClassName_CoreGame);
			// Establish connection
			connection = DriverManager.getConnection(url_CoreGame,
					user_CoreGame, password_CoreGame);

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Get all the column name
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			String name = "";
			// The column count starts from 1
			for (int i = 1; i <= columnCount; i++) {
				name = rsmd.getColumnName(i);
				System.out.println(i + ":" + name + "\t");
			}
			// System.out.print("size: "+ countRows(connection,
			// "NZDEV.ES_SECURITY") + "\t");

			// Extract data from result set
			/**
			 * If you don't call rs.next(), the cursor doesn't point to any row.
			 **/
			while (rs.next()) {
				System.out.println("Activation_ID: "
						+ rs.getInt("ACTIVATION_ID") + "\t");
			}

			// Clean-up environment
			rs.close();
			stmt.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				System.out.println("Connected successfully.");
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void mysqlDemo() {
		Statement stmt = null;
		String query = "Select rps_db.results.draw_number From rps_db.results where rps_db.results.game_type = 'BULLSEYE' ORDER BY rps_db.results.draw_number DESC LIMIT 2";
		Connection connection = null;
		try {
			// Load class into memory
			Class.forName(jdbcClassName_rps);
			// Establish connection
			connection = DriverManager.getConnection(url_CoreGame_rps,
					user_CoreGame_rps, password_CoreGame_rps);

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("draw_number");
				System.out.print("ID: " + id);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				System.out.println("Connected successfully.");
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
