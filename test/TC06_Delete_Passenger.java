package test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class TC06_Delete_Passenger {
	@Test
	public void DeletePassenger()
	{
String url = "https://api.instantwebtools.net/v1/passenger/61e907433ece1b5be356bf1f"; 
		 
		 
		 
		
		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "nginx/1.18.0");
		//expectedHeaders.put("Content-Encoding", "gzip");

		given().log().all()
		.when().delete(url)
		.then().log().all().assertThat().statusCode(200)
		//.and().statusLine("HTTP/1.1 200 OK")
		.and().headers(expectedHeaders);
		
	}

}
