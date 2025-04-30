package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Day2.Pojo_PostRequest;

//pojo ----serialize--> JSON Object----de-serialize--> pojo

public class SerializationDeserialization {

	@Test(priority=1)
	public void testSerialization() throws JsonProcessingException {
		
		//created java object using pojo class
		Student studentData = new Student();

		studentData.setName("sCOTT");
		studentData.setLocation("france");
		studentData.setPhone("678903222");
		

		String[] courseArray3 = {"c", "c++"};
		
		studentData.setCoursesArray3(courseArray3);
		
		//convert java object -->json object 
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsondata =objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objMapper);
		System.out.println(jsondata);
	}
	//json --> pojo
	@Test
	public void convertJson2Pojo() throws JsonMappingException, JsonProcessingException {
		
		String jsondata = "{\r\n"
				+ "\"name\" : \"Evelyn waugh\",\r\n"
				+ "\"location\" : \"fiction\",\r\n"
				+ "\"phone\" : 12.99,\r\n"
				+ "\"coursesArray3\" :[\"C\" , \"C++\"]\r\n "+ "}";
		
		//convert json data -->pojo deserialization
		
		ObjectMapper objMapper = new ObjectMapper();
		
		Student stupojo = objMapper.readValue(jsondata, Student.class);
		
		System.out.println("name "+stupojo.getName());
		System.out.println("location "+stupojo.getLocation());
		System.out.println("courses" +stupojo.getCoursesArray3()[0]);
		
	}

}
