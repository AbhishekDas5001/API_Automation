package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

public class TC04_Patch_Passenger {
	@Test
	public static void PatchPassenger()
	{
		String url="https://api.instantwebtools.net/v1/passenger/61e907433ece1b5be356bf1f";
		
		String requestBody="{\r\n" 
				  + "    \"name\": \"Akash \"\r\n" 
				  + "}";
	
		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "nginx/1.18.0");
	
	given().log().all().header("Content-Type", "application/json")
	.and().body(requestBody)
	.when().patch(url)
	.then().log().all().assertThat().statusCode(200)
	.and().headers(expectedHeaders);

}
}
		
