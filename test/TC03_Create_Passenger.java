package test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class TC03_Create_Passenger  {
	@Test
	
	public void createPassenger()
{
	String url= "https://api.instantwebtools.net/v1/passenger";
	
	  String requestBody = "{\r\n" 
	  + "    \"name\": \"Abhishek Das\",\r\n" 
	  + "    \"trips\": \"500\",\r\n" 
	  + "    \"airline\": \"90400501674\"\r\n"
	  + "}";
	 
	
		/*
		 * Map<String, String> expectedHeaders = new HashMap<String, String>();
		 * expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		 * expectedHeaders.put("Server", "nginx/1.18.0");
		 */

	given().log().all().header("Content-Type", "application/json")
	.and().body(requestBody)
	.when().post(url)
	.then().log().all().assertThat().statusCode(200);
	//.and().statusLine("HTTP/1.1 200 OK")
	//.and().headers(expectedHeaders);
}	


}
