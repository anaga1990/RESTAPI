package com.qa.api.addplace;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import com.qa.util.Payload;

import io.restassured.RestAssured;


public class AddPlaceApiWithRequestBodyFromOutSide {
	/**
	 * Rest Assured API testing have three categories given , when, then. Given ->
	 * which End point URL to test, path or Query parameters, header and request body need to configured.
	 * When -> resources, HTTP request type need to configured.
	 * Then -> Verify/Validate the Response
	 * in Then() to validated response we need use equalsTo("String") ti use this we need import "static org.hamcrest.Matchers.*"
	 * like Example Code: then().body("scope", equalTo("APP")); here in response you got "scope": "APP" that your trying to validate
	 * 
	 * Note: default/automatically Eclipse not able to import Given, when, then methods related packages because import package type is static
	 * you must manually added "import static io.restassured.RestAssured.*" in import categories
	 * 
	 */
	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.addPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");
	}
}
