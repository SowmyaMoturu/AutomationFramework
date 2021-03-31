package com.sowmya.core.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.sowmya.core.constants.Constants;

import com.sowmya.core.exceptions.InvalidPropertyException;

public class Configuration {

	private Configuration() {

	}

	
	static Properties properties = new Properties();
	static {
	        try {
	        	properties.load(new FileInputStream(new File(Constants.CONFIG_FILE_PATH)));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	

	public static String get(String key) throws InvalidPropertyException {
		
		String value = properties.getProperty(key);
	
		if (value == null)
			throw new InvalidPropertyException(key);
		else
			return value;
	}

}
