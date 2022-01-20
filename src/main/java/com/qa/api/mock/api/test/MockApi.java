package com.qa.api.mock.api.test;

import com.qa.util.Payload;

import io.restassured.path.json.JsonPath;

public class MockApi {
	public static void main(String[] args) {
		JsonPath jsonPath = new JsonPath(Payload.courses());
		System.out.println("########## Print No of courses returned by API");
		int count = jsonPath.getInt("courses.size()");
		System.out.println(count);
		System.out.println("###############  Print Purchase Amount");
		int totalAmount = jsonPath.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		System.out.println("############### Print Title of the first course");
		String coursesData = jsonPath.getString("courses[0].title");
		System.out.println(coursesData);

		System.out.println("#############    Print All course titles and their respective Prices   ##########");
		for (int i = 0; i < count; i++) {
			String title = jsonPath.get("courses[" + i + "].title");
			int price = jsonPath.getInt("courses[" + i + "].price");
			System.out.println("title is : " + title + " , price is : " + price);
		}

		System.out.println("@@@@@@@@@@@@@@@@@   Print no of copies sold by RPA Course");
		for (int i = 0; i < count; i++) {
			String title = jsonPath.get("courses[" + i + "].title");
			if (title.equals("RPA")) {
				int coursesCopiesCount = jsonPath.get("courses[" + i + "].copies");
				System.out.println("coursesCopiesCount is : " + coursesCopiesCount);
				break;
			}
		}

		System.out.println(" ############### Verify if Sum of all Course prices matches with Purchase Amount");
		int actualAmount = 0;
		for (int i = 0; i < count; i++) {
			int price = jsonPath.getInt("courses[" + i + "].price");
			int numberOfcopies = jsonPath.getInt("courses[" + i + "].copies");
			actualAmount = actualAmount + (price * numberOfcopies);
		}
		System.out.println("Item Wise Tootal amount is : " + actualAmount + " , totalAmount is : " + totalAmount);

	}
}
