package com.presto.qe.Helpers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.presto.qe.utils.CONSTANTS;



public class LoadProperties {
	
	private String fileLocation = CONSTANTS.PROPERTIES_LOCATION;
	private FileReader reader;
	private String sPropFileName = CONSTANTS.PROPERTIES_FILE;
	private Properties prop;
	
	/**
	 * Constructor to load the properties
	 */
	public LoadProperties() {
		try {
		reader=new FileReader(fileLocation+sPropFileName);
		prop=new Properties();
		prop.load(reader);
		}
		catch(IOException e) {
			
				e.printStackTrace();
			
		}
	}
	
	public String getURL() {
		return prop.getProperty("Login_Url");
	}
	
	public String getBrowserType() {
		return prop.getProperty("Browser");
	}

}
