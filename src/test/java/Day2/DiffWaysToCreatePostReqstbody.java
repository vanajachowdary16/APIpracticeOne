package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DiffWaysToCreatePostReqstbody {
	
	//@Test(priority=1)
	public void testPostUsingHashMap() {
		
		HashMap hashdata = new HashMap();
		
		hashdata.put("name", "Scott");
		hashdata.put("location", "france");
		hashdata.put("phone", "442003231");
		
		String[] courseArray = {"c", "c++"};
		
		hashdata.put("courses", courseArray);
		
		given()
		 .contentType("application/json")
		 .body(hashdata)
		
		 .when()
		   .post("http://localhost:3000/students")
		 
		 
		 .then()
		   .statusCode(201)
		   .body("name", equalTo("Scott"))
		   .body("location", equalTo("France"))
		   .body("phone", equalTo("442003231"))		   
		   .body("courseArray[0]", equalTo("c"))
		   .body("courseArray[1]", equalTo("c++"))
		   .header("Content-Type", "application/json; charset=utf-8")
		   .log().all();
		   
		
	}
	@Test(priority=2)
	public void deleteRecord() {
		given()
		
		 .when()
		   .delete("http://localhost:3000/students/3")
		   
		  .then()
		    .statusCode(200);
	}
	
	//post request body using org.json library
	
	//@Test(priority=1)
	public void testPostUsingJsonLibrary() {
		
		JSONObject jsondata = new JSONObject();
		
		jsondata.put("name", "Scott");
		jsondata.put("location", "france");
		jsondata.put("phone", "442003231");
		
		String[] courseArray2 = {"c", "c++"};
		
		jsondata.put("courses", courseArray2);
		
		given()
		 .contentType("application/json")
		 .body(jsondata.toString())
		
		 .when()
		   .post("http://localhost:3000/students")
		 
		 
		 .then()
		   .statusCode(201)
		   .body("name", equalTo("Scott"))
		   .body("location", equalTo("France"))
		   .body("phone", equalTo("442003231"))		   
		   .body("courseArray2[0]", equalTo("c"))
		   .body("courseArray2[1]", equalTo("c++"))
		   .header("Content-Type", "application/json; charset=utf-8")
		   .log().all();
		   
		
	}
	
	//@Test(priority=1)
	public void testPostUsingPOJO() {
		
		Pojo_PostRequest pojodata = new Pojo_PostRequest();
		
		pojodata.setName("sCOTT");
		pojodata.setLocation("france");
		pojodata.setPhone("678903222");
		
		String[] courseArray3 = {"c", "c++"};
		
		pojodata.setCoursesArray3(courseArray3);
		
		given()
		 .contentType("application/json")
		 .body(pojodata)
		
		 .when()
		   .post("http://localhost:3000/students")
		 
		 
		 .then()
		   .statusCode(201)
		   .body("name", equalTo("Scott"))
		   .body("location", equalTo("France"))
		   .body("phone", equalTo("442003231"))		   
		   .body("courseArray2[0]", equalTo("c"))
		   .body("courseArray2[1]", equalTo("c++"))
		   .header("Content-Type", "application/json; charset=utf-8")
		   .log().all();
		   
		
	}
	
	@Test(priority=1)
	public void testPostUsingExternalJson() throws FileNotFoundException {
		
		File file = new File(".\\body.json");
		FileReader Fr = new FileReader(file);
		JSONTokener jsontokener = new JSONTokener(Fr);
		JSONObject jsonobj = new JSONObject(jsontokener);	
		
		given()
		 .contentType("application/json")
		 .body(jsonobj.toString())
		
		 .when()
		   .post("http://localhost:3000/students")
		 
		 
		 .then()
		   .statusCode(201)
		   .body("name", equalTo("Scott"))
		   .body("location", equalTo("France"))
		   .body("phone", equalTo("442003231"))		   
		   .body("courseArray2[0]", equalTo("c"))
		   .body("courseArray2[1]", equalTo("c++"))
		   .header("Content-Type", "application/json; charset=utf-8")
		   .log().all();
		   
		
	}

}
