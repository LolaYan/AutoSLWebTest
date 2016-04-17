/**
 * 
 */
package com.LottoNZ.AutoSLWebTest.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * Note: Load the application.prperties from config folder
 * 		 LoadProperty by name in order to get the value of it
 */
public class PropertyLoader {
	
	private static final String PROP_FILE = "./config/application.properties";
	private static FileInputStream fs;
	private static Properties props = new Properties();    
	
	private PropertyLoader() 
	{
		
	}

	public static String loadProperty(String name) {
		String value = "";
		setFilePath();
		loadFS();
		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}
	
	public static void setFilePath(){
		try {
			fs = new FileInputStream(PROP_FILE);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void loadFS(){
		try {
			props.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
