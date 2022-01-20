package com.qa.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import com.qa.util.ApiProperties;
import com.qa.util.Payload;

import io.restassured.RestAssured;


public class UpdatePlaceApi {
	
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
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.updatePlace(ApiProperties.getApiData("placeid")))
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		System.out.println("execution Completed");
	}
}
