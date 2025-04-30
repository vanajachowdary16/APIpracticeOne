package Day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidations {
	
	@Test
	public void JsonSchemaValidation() {
		
		given()
		
		  .when()
		    .get("http://localhost:3000/store")
		  
		    .then()
		      .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("booksjsonschema.json"));
		
	}

}
