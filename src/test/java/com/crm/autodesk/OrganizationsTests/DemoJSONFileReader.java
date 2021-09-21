package com.crm.autodesk.OrganizationsTests;

import com.crm.autodesk.genericUtility.JSONFileUtilty;

public class DemoJSONFileReader {
	public static void main(String[] args) throws Throwable {

		JSONFileUtilty jsonLib = new JSONFileUtilty();

		String value = jsonLib.readDataFromJson("password");

		System.out.println(value);
	}
}
