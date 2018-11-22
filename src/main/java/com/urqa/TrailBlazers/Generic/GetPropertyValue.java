package com.urqa.TrailBlazers.Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyValue {
	public static String configFilePath=".\\config.properties";
	public static  String value;
	public static String getValue(String key){
	Properties prop=new Properties();
	try {
		prop.load(new FileInputStream(new File(configFilePath)));
		value=prop.getProperty(key);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return value;  

	}
}
