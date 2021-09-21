package com.crm.autodesk.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author SUNIL
 *
 */
public class BaseClass {
	public DataBaseUtility dbLib = new DataBaseUtility();
	public JSONFileUtilty jsonLib = new JSONFileUtilty();
	public WebDriverUtility wLib = new WebDriverUtility();
	public javaUtility jLib = new javaUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public WebDriver driver;
	public static WebDriver staticdriver;

	@BeforeSuite(groups = { "SmokeSuite", "RegressionSuite" })
	public void connectDB() throws Throwable {
		// dbLib.connectToDatabase();
		System.out.println("====Connect to DataBase====");
	}

	//@Parameters("Browser")
	@BeforeClass(groups = { "SmokeSuite", "RegressionSuite" })
	public void launchBrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		String BROWSER = jsonLib.readDataFromJson("browser");
		String URL = jsonLib.readDataFromJson("url");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser Name");
		}

		wLib.waitForPageLoad(driver);
		wLib.maximizebrowser(driver);
		driver.get(URL);
		staticdriver=driver;
		System.out.println("====Launch Browser====");
	}

	@BeforeMethod(groups = { "SmokeSuite", "RegressionSuite" })
	public void loginToApp() throws Throwable {
		String USERNAME = jsonLib.readDataFromJson("username");
		String PASSWORD = jsonLib.readDataFromJson("password");

		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("====Login to Application====");
	}

	@AfterMethod(groups = { "SmokeSuite", "RegressionSuite" })
	public void logoutofApp() {
		HomePage hp = new HomePage(driver);
		hp.clickonSignout(driver);
		System.out.println("====Logout From Application====");
	}

	@AfterClass(groups = { "SmokeSuite", "RegressionSuite" })
	public void closeBrowser() {
		driver.close();
		System.out.println("====CloseBrowser====");
	}

	@AfterSuite(groups = { "SmokeSuite", "RegressionSuite" })
	public void closeDB() throws Throwable {
		// dbLib.closeDb();
		System.out.println("====CloseDB====");
	}
	public String getscreenshot(String name) throws IOException
	{
		File srcfile =((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile =System.getProperty("user.dir")+"/Screenshot/" +name+".png";
		File finalDest =new File(destfile);
		FileUtils.copyFile(srcfile, finalDest);
		
		return destfile;
	}
}
