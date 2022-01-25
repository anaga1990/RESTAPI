package com.qa.api.oauth2x;

import org.testng.annotations.Test;

import com.qa.api.pojo.GetCourcesPOJO;
import com.qa.api.pojo.WebAutomation;

import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.*;

import java.util.List;

public class Oauth2Test3 {

	@Test
	public void oAuth2xTest() {

		String accessToken = "ya29.A0ARrdaM90mrdc8ep7TbA5wbLf7SyIJALfQqnRccMucC4sRfR4AzKbbhP4XIoDxWMDQbkjzErXVxNH37YACTxcznfTOx25iQHMn8a39HLRqxS45LA3CseYF3eUqofDC5SMSRBw9nKrb0wUiXFWg3dHtQO7S3Crfw";
		GetCourcesPOJO course = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourcesPOJO.class);
		System.out.println(course.getLinkedIn());
		System.out.println(course.getExpertise());
		System.out.println(course.getServices());
		List<WebAutomation> data = course.getCourses().getWebAutomation();
		for (WebAutomation webAutomation : data) {
			String courseTitle=webAutomation.getCourseTitle();
				System.out.println("courseTitle is:>> "+courseTitle);
		}
		
		System.out.println("########################################################");

	}

}
