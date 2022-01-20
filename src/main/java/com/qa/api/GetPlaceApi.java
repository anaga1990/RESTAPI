package com.qa.api;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import com.qa.util.ApiProperties;

public class GetPlaceApi {

	/**
	 * Rest Assured API testing have three categories given , when, then. Given ->
	 * which End point URL to test, path or Query parameters, header and request body need to configured.
	 * When -> HTTP request type with resources.
	 * Then -> Verify/Validate the Response
	 * 
	 * Note: default/automatically Eclipse not able to import Given, when, then methods related packages because import package type is static
	 * you must manually added "import static io.restassured.RestAssured.*" in import categories
	 */
	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", ApiProperties.getApiData("placeid"))
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().toString();
		
	}
}
