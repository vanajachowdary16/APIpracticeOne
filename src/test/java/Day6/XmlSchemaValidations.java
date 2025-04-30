package Day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class XmlSchemaValidations {
	
	@Test
	public void xmlSchemaValidation() {
		
		given()
		
		  .when()
		    .get("http://restapi.adequateshop.com/api/Traveler")
		    
		    .then()
		      .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Traveller.xsd"));
		      
		
	}

}
