package com.presto.qe.utils;

public class CONSTANTS {
	
	public static final String PROJECT_LOCATION = System.getProperty("user.dir");
	public static final String LINE_SEPERATOR = System.getProperty("file.separator");
	public static final String DRIVER_LOCATION = PROJECT_LOCATION + LINE_SEPERATOR + "utilities" + LINE_SEPERATOR;
	public static final String GECKODRIVER = "geckodriver.exe";
	public static final String CHROMEDRIVER = "chromedriver.exe";
	public static final String PROPERTIES_LOCATION = PROJECT_LOCATION + LINE_SEPERATOR + "Properties" + LINE_SEPERATOR;
	public static final String PROPERTIES_FILE = "EnvProp.properties";
	public static final int IMPLICIT_WAIT_TIME = 20;
	public static final int EXPLICIT_WAIT_TIME = 50;
}
