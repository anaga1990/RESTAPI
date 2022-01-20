package com.qa.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ApiProperties {
	public static FileReader fReader;
	public static FileWriter fWriter;
	public static Properties prop;
	private final static String FILE = "/src/main/resources/api.properties";

	public static synchronized String getApiData(String key) {
		String data = null;
		try {
			fReader = new FileReader(System.getProperty("user.dir") + FILE);
			prop = new Properties();
			if (fReader != null) {
				prop.load(fReader);
				data=prop.getProperty(key);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(key+" valus loaded as ---->>>> "+data);
		return data;
	}

	public static synchronized void setApiData(String key, String value) {
		try {
			fWriter = new FileWriter(System.getProperty("user.dir") + FILE);
			prop = new Properties();
			if (key != null && value != null) {
				prop.setProperty(key, value);
				prop.store(fWriter, "updated"+key+"value");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
