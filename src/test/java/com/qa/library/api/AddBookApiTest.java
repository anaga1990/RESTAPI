package com.qa.library.api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.data.ApiJsonDataUtil;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddBookApiTest {

	/**
	 * Rest Assured API testing have three categories given , when, then. Given ->
	 * which End point URL to test, path or Query parameters, header and request
	 * body need to configured. When -> resources, HTTP request type need to
	 * configured. Then -> Verify/Validate the Response in Then() to validated
	 * response we need use equalsTo("String") to use this we need import "static
	 * org.hamcrest.Matchers.*" like Example Code: then().body("scope",
	 * equalTo("APP")); here in response you got "scope": "APP" that your trying to
	 * validate
	 * 
	 * Note: default/automatically Eclipse not able to import Given, when, then
	 * methods related packages because import package type is static you must
	 * manually added "import static io.restassured.RestAssured.*" in import
	 * categories
	 * 
	 */
	@Test(dataProvider ="addbookDataProvider")
	public void addBook(String bookName, String bookLocationNumber) {
		RestAssured.baseURI = "http://216.10.245.166";
		String addBookResponse = given().log().all().header("Content-Type", "application/json")
				.body(ApiJsonDataUtil.addBook(bookName, bookLocationNumber)).when().post("Library/Addbook.php").then()
				.log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("######################################################################################");
		System.out.println("addBookResponse"+addBookResponse);
		System.out.println("######################################################################################");
		JsonPath json = new JsonPath(addBookResponse);
		String addedBookReferenceId = json.get("ID");
		System.out.println("######################################################################################");
		System.out.println(addedBookReferenceId);
		System.out.println("############################ FINISHED ###############################");
	}

	@DataProvider(name ="addbookDataProvider")
	public Object[][] addBookData() {
		Object[][] bookData = new Object[][] { { "Selenium for web", "1000" }, { "RestAssured for Api", "1001" },
				{ "TestNg for Testing", "1002" }, { "JAVA 8 ", "1003" }, { "JAVA 11", "1004" }, { "CUCUMBER 5.X", "1005" },
				{ "SOAPUI 5.6X", "1006" } };

		return bookData;
	}

}
