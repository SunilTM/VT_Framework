package com.aws.autodesk.practiceTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lenskartAutoSuggestion_HandlingTests {

	public static void main (String [] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selinium\\All Browser Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.lenskart.com/");

		driver.findElement(By.name("q")).click();
		
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='trending_block']"));
		
		for(WebElement e:suggestions)
		{
			
			System.out.println("Auto Sugggestion for lenskart search text is : = "+e.getText());
		}
		driver.close();
	}
}
