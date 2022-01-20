package com.qa.api.data;


public class ApiJsonDataUtil {
	
	/**
	 * addBook(name, aisle) here name = Book Name, aisle = ra
	 *
	 */
	public static String addBook(String name, String aisle) {
		String jsonData="{\r\n"
				+ "  \"name\": \""+name+"\",\r\n"
				+ "  \"isbn\": \"test\",\r\n"
				+ "  \"aisle\": \""+aisle+"\",\r\n"
				+ "  \"author\": \"Annabathina Nagarjuna\"\r\n"
				+ "}";
		return jsonData;
	}
}
