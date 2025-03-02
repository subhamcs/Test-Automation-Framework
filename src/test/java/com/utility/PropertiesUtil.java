package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	//read properties file
	
	public static String readProperty(Env env, String propertyName){
		File propFile = Paths.get(System.getProperty("user.dir"), "config", env + ".properties").toFile(); // act as pointer to the file where that is in the system.(this will work regardsless of the OS )
		FileReader fileReader = null; //
		Properties properties = new Properties(); 
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = properties.getProperty(propertyName.toUpperCase());
		System.out.println(value);
		return value;
	}
	

}
