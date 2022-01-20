package com.qa.util;

public class Payload {
	public static String addPlace() {
		long randomDigit=UtilApi.getRandomNumber(6666666666L, 9999999999L);
		String randomMobile = String.valueOf(randomDigit);
		String addplaceJson = "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.323394,\r\n"
				+ "    \"lng\": 33.42232\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 40,\r\n"
				+ "  \"name\": \"xyz house\",\r\n"
				+ "  \"phone_number\": \"(+91) "+randomMobile+"\",\r\n"
				+ "  \"address\": \"#22, devasandra main road, KR Puram, India\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"house\",\r\n"
				+ "    \"in apartements\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"https://rahulshettyacademy.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
		return addplaceJson;
	}
	
	public static String updatePlace(String placeId) {
		String city = "Bangaloure";
		long randomDigit=UtilApi.getRandomNumber(1L, 1000L);
		String houseNumber = String.valueOf(randomDigit);
		String updatePlaceJson = "{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\": \""+houseNumber+", hsr layout, "+city+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
		return updatePlaceJson;
	}
	
	public static String mockAmazonCart() {
		String jsonData = "{\r\n"
				+ "  \"cart\": {\r\n"
				+ "    \"totalAmount\": 61299,\r\n"
				+ "    \"website\": \"amazon.in\"\r\n"
				+ "  },\r\n"
				+ "  \"ItemsMenu\": [\r\n"
				+ "    {\r\n"
				+ "      \"item\": \"dove soap\",\r\n"
				+ "      \"price\": \"150\",\r\n"
				+ "      \"quantity\": 2\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"item\": \"Windows10 OS\",\r\n"
				+ "      \"price\": \"3999\",\r\n"
				+ "      \"quantity\": 1\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"item\": \"Iphone 7Plus\",\r\n"
				+ "      \"price\": \"57000\",\r\n"
				+ "      \"quantity\": 1\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		return jsonData;
	}
	
	public static String courses() {
		String jsonData="{\r\n"
				+ "	\"dashboard\": {\r\n"
				+ "		\"purchaseAmount\": 910,\r\n"
				+ "		\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "	},\r\n"
				+ "	\"courses\": [\r\n"
				+ "		{\r\n"
				+ "			\"title\": \"Selenium Python\",\r\n"
				+ "			\"price\": 50,\r\n"
				+ "			\"copies\": 6\r\n"
				+ "		},\r\n"
				+ "		{\r\n"
				+ "			\"title\": \"Cypress\",\r\n"
				+ "			\"price\": 40,\r\n"
				+ "			\"copies\": 4\r\n"
				+ "		},\r\n"
				+ "		{\r\n"
				+ "			\"title\": \"RPA\",\r\n"
				+ "			\"price\": 45,\r\n"
				+ "			\"copies\": 10\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}\r\n"
				+ "";
		return jsonData;
	}
}
