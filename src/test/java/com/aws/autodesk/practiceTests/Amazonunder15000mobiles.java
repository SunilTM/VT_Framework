package com.aws.autodesk.practiceTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazonunder15000mobiles {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Selinium\\All Browser Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");

		// driver.manage().window().maximize();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile under 15000", Keys.ENTER);

		driver.findElement(
				By.xpath("(//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium'])[4]//li//div[1]"))
				.click();

		String value = driver
				.findElement(By.xpath("//span[@class='a-price']/span/following-sibling::span/span[2]")).getText();
		System.out.println("Rupees of :-" + value + "/-");
		String value1=value.replace(",", "");

		int i = Integer.parseInt(value1);
	System.out.println(i<15000 ? "Price is" +i+ ":ValidationPass": "Price is"+i +":Validation Fail");	
	
	}
}
