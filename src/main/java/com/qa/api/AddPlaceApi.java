package com.qa.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import com.qa.util.Payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class AddPlaceApi {
	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String addplaceResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.addPlace())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println("addplaceResponse is : "+addplaceResponse);
		JsonPath json = new JsonPath(addplaceResponse);
		String placeId =json.getString("place_id");
		System.out.println("placeId  is : "+placeId);
		
	}
}
