package Day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.config.XmlConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class ParsingXMLResponse {

	@Test
	public void testXMLResponse() {
		//approach one
		
		given()
		
		  .when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		  
		    .then()
		      .statusCode(200)
		      .header("Content-Type", "application/xml; charset=utf-8")
		      .body("TravelerinformationResponse.page", equalTo("1"))
		      .body("TravelerinformationResponse.travellers.Travelerinformation[0].name", equalTo("Vijay bharath reddy"));		
	}
	
	public void testXMLResponseApproach2() {
		//approach one
		Response res = given()
		
		  .when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		Assert.assertEquals(res.xmlPath().get("TravelerinformationResponse.page").toString(), 1);
		String name = res.xmlPath().get("TravelerinformationResponse.travellers.Travelerinformation[0].name").toString();
		Assert.assertEquals(name, "vijay bharath reddy");
		    
	}
	
	public void testXmlBody() {
		//approach one
		Response res2 = given()
				
				.when()
				  .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		XmlPath xmlObj =new XmlPath(res2.asString());
		List<String> Travellers = xmlObj.getList("TravelerinformationResponse.travellers.Travelerinformation");
		Assert.assertEquals(Travellers.size(), 10);
		//verify traveller name is presence in the response
		List<String> TravellerNames = xmlObj.getList("TravelerinformationResponse.travellers.Travelerinformation.name");
		
		boolean status = false;
		for(String travelername : TravellerNames)
		{
			if(travelername.equals("vijay barath reddy")) {
			status = true;
			break;
			}
		}
		Assert.assertEquals(status, true);
		
}
}

