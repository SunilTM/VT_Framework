package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and write from exel sheet
 * 
 * @author SUNIL
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet wrt to row number and cell number
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String getExceldata(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IpathConstants.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
//		Row row = sh.getRow(rownum);
//		Cell cell=row.getCell(cellnum);
//		String value= cell.getStringCellValue();
		
		DataFormatter format= new DataFormatter();
		String data=format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		return data;		
	}
	/**
	 * @throws Throwable 
	 * 
	 */
	public Object [][] getExcelData(String sheetname ) throws Throwable {
		FileInputStream fis= new FileInputStream(IpathConstants.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		//DataFormatter formatter = new DataFormatter();
		
		Object [][] data= new Object[lastrow][lastcell];
		
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++) {
				
				//data [i][j]= formatter.formatCellValue(sh.getRow(i+1).getCell(j));
				data [i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();				
			}
		}
		return data;
		
	}
}