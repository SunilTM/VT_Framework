package com.crm.autodesk.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * This Class contains generic method to read from database
 * @author SUNIL
 *
 */
public class DataBaseUtility {
	Connection con = null;
	ResultSet result=null;
	Driver driverref;

	/**
	 * This method contains generic methods to read data from database
	 * @throws Throwable 
	 */
	public void connectToDatabase() throws Throwable {
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "admin", "root");
	}
	
	/**
	 * This method is to close the connection of database
	 * @throws Throwable
	 */
	public void closeDb() throws Throwable
	{
		con.close();
	}
	
	/**
	 * This method returns the data wrt to column index
	 * @param query
	 * @param Columnindex
	 * @return
	 * @throws Throwable
	 */
	
	public String getDataFromDB(String query,int Columnindex) throws Throwable
	{
		String value=null;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			value =result.getString(Columnindex);
		}
		return value;
	}
	
	/**
	 * Get Data from Database and Verify
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String getDataFromDB(String query,int columnName,String expData) throws SQLException
	{
		boolean flag = false;
		result= con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnName).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+"Data is verified in database");
			return expData;
		}else {
			System.out.println(expData+"Data is not verified in database");
			return expData;
		}
	}
}