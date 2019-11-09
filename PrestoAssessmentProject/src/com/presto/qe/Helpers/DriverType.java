package com.presto.qe.Helpers;

import org.openqa.selenium.WebDriver;

import com.presto.qe.utils.CONSTANTS;





public interface DriverType {
	
	public String driverLocation=CONSTANTS.DRIVER_LOCATION;
	
	public WebDriver getWebDriver();

}
