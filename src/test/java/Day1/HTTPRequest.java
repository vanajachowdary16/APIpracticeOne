package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequest{
	int id;
	//@Test(priority=1)
	void getUser() {
		
		given()
		
		.when()
		     .get("https://reqres.in/api/users?page=2")
		
		.then()
		      .statusCode(200)
		      .body("page",equalTo(2))
		      .log().all();
		
	}
	@Test
	void createUser() {
		
		@SuppressWarnings("rawtypes")
		HashMap data = new HashMap();
		data.put("name", "pavan");
		data.put("job", "trainer");
		
		given()
		 .contentType("application/json")
		 .body(data)
		
		.when()
		  .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id");
		
		/*.then()
		  .statusCode(201)
		  .log().all();	*/	
	}

}
