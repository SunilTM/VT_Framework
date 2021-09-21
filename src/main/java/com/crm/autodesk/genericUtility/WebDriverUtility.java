package com.crm.autodesk.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author SUNIL
 */
public class WebDriverUtility {

	/**
	 * This method is used to maximize the browser
	 */
	public void maximizebrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method wait for 10 sec for page loading
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * This method is to use for explicitly wait
	 */
	public void waitforelementTobeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		// wait.until(ExpectedConditions.titleContains("Text"));

	}

	/**
	 * This method will perform mouse over action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method performs right click operation
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * Accept alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * Capture Alert Text
	 * 
	 * @param driver
	 */
	public void getAlertText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	/**
	 * Cancel Alert
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method wait for the element to be visible
	 * 
	 * @param driver
	 * @param element
	 * 
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this methods enables user to handle dropdown using visible text
	 * 
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}

	/**
	 * this methods enables user to handle dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method helps to switch from one window to another
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindows(WebDriver driver, String partialWinTitle) {

		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext()) {
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if (title.contains(partialWinTitle)) {
				break;
			}

		}

	}

	/**
	 * This method helps to switch from one window to another
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchwindow(WebDriver driver, String partialWinTitle) {
		String mainID = driver.getWindowHandle();
		Set<String> allID = driver.getWindowHandles();

		for (String id : allID) {
			if (!mainID.equals(allID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
	}

	/**
	 * This method used for scrolling action in a webpage
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
	}

	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void scrollByKeyboard() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	/**
	 * pass enter Key appertain in to Browser
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * To Handle Calender
	 * 
	 * @param driver
	 */
	public String calenderHandling(WebDriver driver) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrowsDate = cal.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy /MM/dd");
		String modifiedDate = sdf.format(tomorrowsDate);
		return modifiedDate;
	}

	public void closeBrowser(WebDriver driver) {
		driver.close();
	}

}
