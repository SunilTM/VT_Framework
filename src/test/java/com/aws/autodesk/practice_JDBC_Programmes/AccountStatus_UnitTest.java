package com.aws.autodesk.practice_JDBC_Programmes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class AccountStatus_UnitTest  {
	@Test
	public void testAccountType() throws SQLException {
		Connection con = null;
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");

			// Step 3:Create SQL Statement
			Statement stat = con.createStatement();
			String query = "Select * from account";

			// Step4:ExecuteStatement/Query
			ResultSet result = stat.executeQuery(query);
			while (result.next()) {
				int accNum = result.getInt("accno");
				System.out.println(accNum);
				if (accNum == 123 && result.getString("accountType").equals("gold")) {
					System.out.println("account type Gold & Verified==PASS");
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("account type is not Gold & Verified==FAIL");
		} finally {
			// Step5:Close the Connection
			con.close();
		}

	}
}
