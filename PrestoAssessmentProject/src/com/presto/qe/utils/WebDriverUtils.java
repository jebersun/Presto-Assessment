package com.presto.qe.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.presto.qe.Helpers.DriverEnum;
import com.presto.qe.Helpers.LoadProperties;


public class WebDriverUtils {
	protected  WebDriver driver;
	protected LoadProperties loadProperties;
	private String browser;
	protected WebDriverWait explicitWait;
	protected JavascriptExecutor jse;
	
	/**
	 * get Webdriver object 
	 * @return WebDriver
	 */
	public WebDriver getWebDriver() {
		if(driver==null) {
			loadProperties = new LoadProperties();
			browser = loadProperties.getBrowserType();
			if(browser.equals("Firefox")) {
				driver = DriverEnum.Firefox.getWebDriver();
			}
			else {
				driver = DriverEnum.Chrome.getWebDriver();
			}
			maximize();
		}
		return driver;
	}

	/**
	 * load the URL from properties
	 * @param url 
	 */
	public void loadURL(String url) {
		driver.get(url);
	}
	
	/**
	 * to maximize the window
	 */
	public void maximize() {
		driver.manage().window().maximize();
	}
	
	/**
	 * to click an element
	 * @param element
	 */
	public void clickElement(WebElement element) {
		scrollIntoView(element);
		element.click();
		waitForPageLoad();
	}
	
	/**
	 * to click element by xpath
	 * @param xpath
	 */
	public void clickElementByXpath(String xpath) {
		clickElement(findElementByXpath(xpath));
	}
	
	/**
	 * to find Element by Xpath
	 * @param xpath
	 * @return
	 */
	public WebElement findElementByXpath(String xpath) { 
		return driver.findElement(By.xpath(xpath));
	}
	
	/**
	 * to enter text using sendkeys
	 * @param element
	 * @param text
	 */
	public void sendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	/**
	 * implicitly wait for an element
	 */
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(CONSTANTS.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);		
	}
	
	/**
	 * wait for an element using explicit wait
	 * @param element
	 */
	public void waitForElement(WebElement element) {
		explicitWait = new WebDriverWait(driver, CONSTANTS.EXPLICIT_WAIT_TIME);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * to click on browser back button
	 */
	public void clickBackButton() {
		driver.navigate().back();
		waitForPageLoad();
	}
	
	/**
	 * wait for page to load
	 */
	public void waitForPageLoad() {
		new WebDriverWait(driver, CONSTANTS.EXPLICIT_WAIT_TIME).until(
			      webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
	/**
	 * to scroll into view for clicking an element
	 * @param element
	 */
	public void scrollIntoView(WebElement element) {
		jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].scrollIntoView()", element); 
	}
	
	/**
	 * to check an element exists by ID
	 * @param elementIdentifier
	 * @return
	 */
	public boolean isElementExistsByID(String elementIdentifier) {
		try {
			driver.findElement(By.id(elementIdentifier));
			return true;
		}
		catch(NoSuchElementException nse) {
			return false;
		}
	}
	
	/**
	 * to check an element exists by Xpath
	 * @param elementIdentifier
	 * @return
	 */
	public boolean isElementExistsByXpath(String elementIdentifier) {
		try{
			driver.findElement(By.xpath(elementIdentifier));
			return true;
		}
		catch(NoSuchElementException nse) {
			return false;
		}
	}
	
	/**
	 * to quit the driver instance
	 */
	public void quitDriver() {
		driver.quit();
	}
}
