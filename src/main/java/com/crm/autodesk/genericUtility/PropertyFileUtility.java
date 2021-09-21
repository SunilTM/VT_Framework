package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author SUNIL
 *
 */

public class PropertyFileUtility {
/**
 * its used to read the data from commonData.properties File based on Key which you pass as an argument
 * @throws IOException  
 * 
 */
	
	public void getPropertyFilData() throws IOException
	{
		FileInputStream fis= new FileInputStream(IpathConstants.PropertyFilePath);
		Properties p= new Properties();
		p.load(fis);
		
	}
}
