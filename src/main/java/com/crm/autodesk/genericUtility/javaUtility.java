package com.crm.autodesk.genericUtility;

import java.util.Random;

/*
 * This class contains generic methods
 * @ Sunil 
 */
public class javaUtility {
/**
 * This method generates random number
 */
	public int getRandomNum()
	{
		Random ran=new Random();
		int randomNum=ran.nextInt(1000);
		return randomNum;
		
	}
	
}
