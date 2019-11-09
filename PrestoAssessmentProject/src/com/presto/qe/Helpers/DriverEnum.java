package com.presto.qe.Helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.presto.qe.utils.CONSTANTS;


/**
 * Enum to load the driver based on properties
 * @author Jeberson
 *
 */
public enum DriverEnum implements DriverType{
	
	
	Firefox{
		/**
		 * to get the Webdriver for FireFox
		 */
		@Override
		public WebDriver getWebDriver() {
			// TODO Auto-generated method stub
			
			System.setProperty("webdriver.gecko.driver",driverLocation+CONSTANTS.LINE_SEPERATOR+ CONSTANTS.GECKODRIVER);
			WebDriver driver = new FirefoxDriver(new FirefoxOptions());
			return driver;
			
		}
		
	},
		Chrome{
		/**
		 * to get the Webdriver for Chrome
		 */
		@Override
		public WebDriver getWebDriver() {
			// TODO Auto-generated method stub
			
			System.setProperty("webdriver.chrome.driver",driverLocation+CONSTANTS.LINE_SEPERATOR+ CONSTANTS.CHROMEDRIVER);
			
			ChromeOptions options = new ChromeOptions();
			
			WebDriver driver = new ChromeDriver(options);
			return driver;
		}
		
	};

}
