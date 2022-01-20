package com.qa.api.addplace;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
public class AddPlaceApi {
	/**
	 * Rest Assured API testing have three categories given , when, then. Given ->
	 * which End point URL to test, path or Query parameters and request body need to configured.
	 * When -> resources, HTTP request type need to configured.
	 * Then -> Verify/Validate the Response
	 * 
	 * Note: default/automatically Eclipse not able to import Given, when, then methods related packages because import package type is static
	 * you must manually added "import static io.restassured.RestAssured.*" in import categories
	 */
	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.300094,\r\n"
				+ "    \"lng\": 33.347362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 16,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 966 893 3937\",\r\n"
				+ "  \"address\": \"22, kr layout, 1st cross\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"https://rahulshettyacademy.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}")
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200);
		
	}
}
