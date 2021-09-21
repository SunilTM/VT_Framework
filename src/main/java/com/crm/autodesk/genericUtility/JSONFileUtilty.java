package com.crm.autodesk.genericUtility;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
/**
 * 
 * @author SUNIL
 *
 */
public class JSONFileUtilty {
/**
 * This method is to read the data from json file
 * @throws Throwable
 */
	public String readDataFromJson(String key) throws Throwable
	{
		//Read the data from json file
		FileReader file = new FileReader("./commonData.json");
		
		//convert the json file into java object
		JSONParser jasonobj = new JSONParser();
		Object javaobj = jasonobj.parse(file);
		
		///Type cast(Down Cast) java object to hashmap
		HashMap map = (HashMap)javaobj;
		Object value = map.get(key).toString();
		
		//return the value
		return (String) value;
	}
}
