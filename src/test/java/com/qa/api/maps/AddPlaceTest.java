package com.qa.api.maps;

import org.testng.annotations.Test;

import com.qa.api.map.pojo.AddMapsPojo;
import com.qa.api.map.pojo.Location;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.LinkedList;
import java.util.List;

public class AddPlaceTest {

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

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().header("Content-Type", "application/json").queryParam("key", "qaclick123").body(pojo)
				.when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().asString();

		System.out.println(response);
	}

}
