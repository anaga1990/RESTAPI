package com.qa.api.oauth2x;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Oauth2Test {

	@Test
	public void oAuth2xTest() {

		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWgDcWn23bKfNt9flWfmv7ZUG5nsouPLrbl0nja5oj01KV2eNSp5r-kIwhVhfONr5w&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none#";
		String code = url.split("code=")[1];
		String datacode = code.split("&scope")[0];
		System.out.println("code is : " + datacode);
		String accessTokenResponse = given().log().all()
				.urlEncodingEnabled(false)
				.queryParams("code", datacode)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code")
				.when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();

		System.out.println("accessTokenResponse is " + accessTokenResponse);

		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		String response = given().log().all().queryParam("access_token", accessToken).when()
				.get("https://rahulshettyacademy.com/getCourse.php").asString();

		System.out.println("########################################################");
		System.out.println(response);

	}

}
