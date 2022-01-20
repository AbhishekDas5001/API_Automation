package test;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class TC02_Get_Airline {
	@Test(description = "Get Request for all user")
	public static void GetAirline()
	{

		
		  String url = "https://api.instantwebtools.net/v1/airlines/90400501673"; 
		 
		 
		 
		
		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "nginx/1.18.0");
		//expectedHeaders.put("Content-Encoding", "gzip");

		given().log().all()
		.when().get(url)
		.then().log().all().assertThat().statusCode(200)
		//.and().statusLine("HTTP/1.1 200 OK")
		.and().headers(expectedHeaders);
		
	}

}
