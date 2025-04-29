package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {
	
	//@Test
	public void testCookies() {
		
		given()
		 
		
		.when()
		  .get("https://www.google.com/")
		
		
		  .then()
		   //.cookie("AEC","AVcja2fNJhiDPQ12K4gS7YjnaPeaHRWSCVwV5ait4ojEg39_eBEOGg89A4s")
		   .log().all();
	}
	
	@Test
	public void testGetCookieInfo() {
		
		Response resp=given()
		
		  .when()
		    .get("https://www.google.com/");
		
		  //String cookie_value = resp.getCookie("AEC");
		  
		  //System.out.println("The value of cookie is '" +cookie_value +"'");
		  
		  //get all cookies info
		  
		Map<String, String> cookies_values= resp.getCookies();
	
		//System.out.println(cookies_values.keySet());
		
		for(String key : cookies_values.keySet()) {
			
			 String cookie_value = resp.getCookie(key);
			 System.out.println(key + " : " +cookie_value);
			
		}
		
		
	}

}
