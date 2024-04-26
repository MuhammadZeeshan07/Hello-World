package org.youCater.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	public static void getEventDetailsInDatabase() throws ClassNotFoundException, SQLException {
		
		String dbUrl = "jdbc:mysql://development.cwmovwytuqms.me-south-1.rds.amazonaws.com:3306/business";
		String username = "master";
		String password = "Tx3b1E9RGiOyCQ8BdqGv";
		String query = "select * from event order by created_at desc limit 1;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		if (rs.next()) {
			int numColumns = rs.getMetaData().getColumnCount();

			for (int i = 1; i <= numColumns; i++) {
				String columnName = rs.getMetaData().getColumnName(i);
				String columnValue = rs.getString(i);
				System.out.println(columnName + ": " + columnValue);
			}
		} else {
			System.out.println("No rows found in the table.");
		}

		con.close();
	}
}
