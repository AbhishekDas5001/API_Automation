package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class TC_Create_Airline_Passenger {
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
		.and().statusLine("HTTP/1.1 200 OK")
		.and().headers(expectedHeaders);
		
	}
	
	
@Test
	
	public void createPassenger()
{
	String url= "https://api.instantwebtools.net/v1/passenger";
	
	  String requestBody = "{\r\n" 
	  + "    \"name\": \"Abhishek Das\",\r\n" 
	  + "    \"trips\": \"500\",\r\n" 
	  + "    \"airline\": \"90400501674\"\r\n"
	  + "}";
	 
	
		
		  Map<String, String> expectedHeaders = new HashMap<String, String>();
		  expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		  expectedHeaders.put("Server", "nginx/1.18.0");
		 

	given().log().all().header("Content-Type", "application/json")
	.and().body(requestBody)
	.when().post(url)
	.then().log().all().assertThat().statusCode(200)
	.and().statusLine("HTTP/1.1 200 OK")
	.and().headers(expectedHeaders);
}	


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


@Test
public void PutPassenger()
{
	String url="https://api.instantwebtools.net/v1/passenger/61ea7402a69bfd4d44363b1f";
	
	String requestBody="{\r\n"
			+ "		\"name\":\"Abhilash\",\r\n"
			+ "		\"trips\":\"888\",\r\n"
			+ "		\"airline\":\"1\"\r\n"
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


