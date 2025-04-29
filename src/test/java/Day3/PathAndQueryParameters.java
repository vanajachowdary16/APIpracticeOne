package Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {
	
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	public void testQueryAndPathParameters() {
		
		given()
		 .pathParam("mypath", "users")  //path params
		 .queryParam("page", 2)
		 .queryParam("id", 5)
		 
		
		  .when()
		    .get("https://reqres.in/api/{mypath}")
		  
		   .then()
		     .statusCode(200)
		     .log().all();
		
	}

}
