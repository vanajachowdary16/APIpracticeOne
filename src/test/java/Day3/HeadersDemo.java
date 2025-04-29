package Day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	
	//@Test
		public void testHeader() {
			
			given()
			 
			
			.when()
			  .get("https://www.google.com/")
			
			
			  .then()
			   //.cookie("AEC","AVcja2fNJhiDPQ12K4gS7YjnaPeaHRWSCVwV5ait4ojEg39_eBEOGg89A4s")
			   .header("Content-Type", "text/html; charset=ISO-8859-1")
			   .and()
			   .header("server", "gws");
		}
		
		       @Test
				public void getHeaders() {
					
				Response res = given()
					           .when()
					            .get("https://www.google.com/");
				
				//String header_value = res.getHeader("Content-Type");
				
				//System.out.println(header_value);
				
				//get all headers info
				
				Headers myHeaders = res.getHeaders();
				
				for(Header hd : myHeaders)
				{
					System.out.println(hd.getName()+ "  "+hd.getValue());
				}
					
					
				}

}
