package com.qa.api.maps;

import org.testng.annotations.Test;

import com.qa.api.map.pojo.AddMapsPojo;
import com.qa.api.map.pojo.Location;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.LinkedList;
import java.util.List;

public class AddPlaceTest2 {

	@Test
	public void addplaceTest() {

		Location local = new Location();
		local.setLng(22.45335);
		local.setLat(-38.386783);

		List<String> types = new LinkedList<>();
		types.add("Feature Play Ground");
		types.add("ground");

		AddMapsPojo pojo = new AddMapsPojo();

		pojo.setLocation(local);
		pojo.setAccuracy(10);
		pojo.setName("Annabathina House");
		pojo.setPhone_number("(+91) 9696234955");
		pojo.setAddress("1st cross, sri krishna road, rich street");
		pojo.setTypes(types);
		pojo.setWebsite("https://demo.qa.com");
		pojo.setLanguage("Englesh-IN");

		RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification responseDataValidation = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		
		RequestSpecification dataPreparation = given().spec(requestSpec).body(pojo);
		
		String response = dataPreparation.when().post("/maps/api/place/add/json").then().log().all().spec(responseDataValidation).extract().response().asString();
		
		System.out.println(response);

	}

}
