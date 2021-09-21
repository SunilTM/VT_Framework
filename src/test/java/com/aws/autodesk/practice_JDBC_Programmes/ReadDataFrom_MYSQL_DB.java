package com.aws.autodesk.practice_JDBC_Programmes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_DB {
	public static void main(String[] args) throws SQLException {
		// Step 1:Register/Load the MySQL Database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);

		// Step 2:get connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");

		// Step 3:Create SQL Statement
		Statement stat = con.createStatement();
		String query = "select * from students_info";

		// Step4:ExecuteStatement/Query
		ResultSet result = stat.executeQuery(query);

		while (result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4));
		}

		// Step5:Close the Connection
		con.close();
	}
}