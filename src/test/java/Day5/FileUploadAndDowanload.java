package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FileUploadAndDowanload {

	@Test
	public void singleFileUpload() {
		  File myfile = new File("C:\\automationpractice\\test1.txt");	
		
		  given()
		    .multiPart("file",myfile)
		    .contentType("multiPart/form-data")
		  
		
		 .when()
		   .post("http://localhost:8080/uploadFile")
		  
		   
		   .then()
		     .statusCode(200)
		     .body("filename", equalTo("test1.txt"))
		     .log().all();
	}
	
	@Test
	public void multipleFilesUpload() {
		  File myfile1 = new File("C:\\automationpractice\\test1.txt");	
		  File myfile2 = new File("C:\\automationpractice\\test2.txt");	
		  
		  File filearr[] = {myfile1,myfile2}; // using array, it wont work for all kinds of api
		
		  given()
		    .multiPart("files",filearr)
		    //.multiPart("files",myfile2)
		    .contentType("multiPart/form-data")
		  
		
		 .when()
		   .post("http://localhost:8080/uploadMultipleFiles")
		  
		   
		   .then()
		     .statusCode(200)
		     .body("[0].filename", equalTo("test1.txt"))
		     .body("[1].filename", equalTo("test2.txt"))
		     .log().all();
	}
	
	@Test(priority=2)
	public void fileDownload() {
		given()
		  
		  .when()
		    .get("http://localhost:8080/downloadfiles/test1.txt")
		  
		    .then()
		     .statusCode(200)
		     .log().body();
	}

}
