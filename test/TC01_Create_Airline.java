package test;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class TC01_Create_Airline {
	@Test
	public void createAirline()
	{
		String url= "https://api.instantwebtools.net/v1/airlines";
		
		  String requestBody = "{\r\n" 
		  + "    \"id\": \"90400501674\",\r\n" 
		  + "    \"name\": \"Indian Airways\",\r\n" 
		  + "    \"country\": \"India\",\r\n"
	      + "    \"logo\": \"home/qq393/Downloads/Air-India-logo.jpg\",\r\n"
		  + "    \"slogan\": \"From India\",\r\n" 
		  + "    \"head_quaters\": \"Bangalore, India\",\r\n"  
		  + "    \"website\": \"www.airindia.in\",\r\n"  
		  + "    \"established\": \"1997\"\r\n" 
		  + "}";
		 
		
		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "nginx/1.18.0");

		given().log().all().header("Content-Type", "application/json; charset=utf-8")
		.and().body(requestBody)
		.when().post(url)
		.then().log().all().statusCode(200)
		.and().statusLine("HTTP/1.1 200 OK")
		.and().headers(expectedHeaders);
	}	


}


