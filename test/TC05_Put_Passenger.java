package test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class TC05_Put_Passenger {

	@Test
	public void PutPassenger()
	{
		String url="https://api.instantwebtools.net/v1/passenger/61e907433ece1b5be356bf1f";
		
		String requestBody="{\r\n"
				+ "		\"name\":\"Prakash\",\r\n"
				+ "		\"trips\":\"367\",\r\n"
				+ "		\"airline\":\"5\"\r\n"
				+ "}";
		
		
		  Map<String, String> expectedHeaders = new HashMap<String, String>();
		  expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		  expectedHeaders.put("Server", "nginx/1.18.0");
		 
		
		
		given().log().all().header("Content-Type", "application/json")
		.and().body(requestBody)
		.when().put(url)
		.then().log().all().assertThat().statusCode(200)
		.and().headers(expectedHeaders);
	}
}
