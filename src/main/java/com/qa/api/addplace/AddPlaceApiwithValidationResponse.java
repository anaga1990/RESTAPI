package com.qa.api.addplace;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;


public class AddPlaceApiwithValidationResponse {
	/**
	 * Rest Assured API testing have three categories given , when, then. Given ->
	 * which End point URL to test, path or Query parameters, header and request body need to configured.
	 * When -> resources, HTTP request type need to configured.
	 * Then -> Verify/Validate the Response
	 * in Then() to validated response we need use equalsTo("String") to use this we need import "static org.hamcrest.Matchers.*"
	 * like Example Code: then().body("scope", equalTo("APP")); here in response you got "scope": "APP" that your trying to validate
	 * 
	 * Note: default/automatically Eclipse not able to import Given, when, then methods related packages because import package type is static
	 * you must manually added "import static io.restassured.RestAssured.*" in import categories
	 * 
	 */
	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
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
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");
	}
}
