package com.aws.autodesk.practiceTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample_MavenParameterTest {
	@Test
	public void sampleTest() {
		System.out.println("Execute Test");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");

		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.close();
	}
}