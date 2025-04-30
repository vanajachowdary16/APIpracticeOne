package Day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJsonResponseData {
	boolean status = false;

	// @Test(priority=1)
	public void testJsonResponse() {

		// Apraoch one

		given().contentType("ContentType.JSON")

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).header("Content-Type", "application/json; charset=utf-8")
				.body("books[3].title", equalTo("The lord of the rings"));

	}

	public void testJsonResponseAproach2() {

		Response res = given().contentType("ContentType.JSON")

				.when().get("https://reqres.in/api/users?page=2");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");

		String bookname = res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "The lord of the rings");
	}

	public void testJsonResponseAproach3() {

		Response res2 = given().contentType("ContentType.JSON").when().get("https://reqres.in/api/users?page=2");
		// JSONObject class

		JSONObject Jo = new JSONObject(res2.toString());

		/*
		 * for(int i=0;i<Jo.getJSONArray("book").length();i++) {
		 * 
		 * String bookTitle =
		 * Jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		 * System.out.println(bookTitle);
		 * 
		 * }
		 */
		
		for (int i = 0; i < Jo.getJSONArray("book").length(); i++) {

			String bookTitle = Jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			if(bookTitle.equals("The lord of the rings")) {
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);
		double totalPrice =0;
		for (int i = 0; i < Jo.getJSONArray("book").length(); i++) {

			String price = Jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			if(price.equals("The lord of the rings")) {
				totalPrice=totalPrice+Double.parseDouble(price);
				
			}
			System.out.println("total price is: "+totalPrice);
			
			Assert.assertEquals(totalPrice, 53.92);
		}
	}

}
