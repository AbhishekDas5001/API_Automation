package test;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
//import com.fasterxml.jackson.databind.ObjectMapper; 
//import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.MatcherAssert.assertThat;


public class TC_Create_Airline_Passenger {
	String generatedId = RandomStringUtils.randomNumeric(12);
	@Test
	public void createAirline()

	{
		String url= "https://api.instantwebtools.net/v1/airlines";

		JSONObject requestBody = new JSONObject();
		requestBody.put("id", generatedId);
		requestBody.put("name", "Indian Airways");
		requestBody.put("country","India" );
		requestBody.put("logo", "home/qq393/Downloads/Air-India-logo.jpg");
		requestBody.put("slogan", "From India");
		requestBody.put("head_quaters", "Bangalore, India");
		requestBody.put("website", "www.airindia.in");
		requestBody.put("established", "1932");

		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "nginx/1.18.0");

		given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json; charset=utf-8")
		.and().body(requestBody.toString())
		.when().post(url)
		.then().log().all().statusCode(200)
		.and().statusLine("HTTP/1.1 200 OK")
		.and().headers(expectedHeaders);
	}	



	@Test(dependsOnMethods = {"createAirline"})
	public void getAirline()
	{


		String url = "https://api.instantwebtools.net/v1/airlines/" + generatedId; 


		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "nginx/1.18.0");

		given().relaxedHTTPSValidation().log().all()
		.when().get(url)
		.then().log().all().assertThat().statusCode(200)
		.and().statusLine("HTTP/1.1 200 OK")
		.and().headers(expectedHeaders);
		System.out.println("abhishek" +generatedId);

	}


	@Test(dependsOnMethods = { "createAirline"} )

	public void createPassenger()
	{
		String url= "https://api.instantwebtools.net/v1/passenger";

		JSONObject requestBody = new JSONObject();
		requestBody.put("name", "Abhishek Das");
		requestBody.put("trips", "5004");
		requestBody.put("airline",generatedId  );

		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "nginx/1.18.0");

		given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
		.and().body(requestBody.toString())
		.when().post(url)
		.then().log().all().assertThat().statusCode(200)
		.and().statusLine("HTTP/1.1 200 OK")
		.and().headers(expectedHeaders);

		// assertThat("clientId should be same as expected", response.path("_id").toString(), equals("abhi"));
	}	



	@Test(dependsOnMethods ={"createPassenger", "createAirline"} ) 


	public void getUserDetails() { 

		RequestSpecification requestSpec = new RequestSpecBuilder().build();
		requestSpec.baseUri("https://instantwebtools.net");
		requestSpec.basePath("/fake-rest-api"); 
		Response response = given().spec(requestSpec) .when() .get("/" + generatedId);
		System.out.println("path value:" + response.path("data._id"));


		String id= String.valueOf(response.path("data._id")); 
		System.out.println("id value" +id);
		 // updatePassenger(id);

		//RestAssured.baseURI="http://api.instantwebtools.net";

		
		/*
		 * String Resp=given(). when(). get("/v1/passenger/"). then().
		 * assertThat().statusCode(200).and(). contentType(ContentType.JSON).and().
		 * header("Server", "nginx/1.18.0").and(). extract(). response().asString();
		 * 
		 * System.out.println("Response is\t"+Resp);
		 */
		 
	}





	@Test (dependsOnMethods = {"getUserDetails"}) 
	public void updatePassenger(String id)
	{

		String url="https://api.instantwebtools.net/v1/passenger/" + id;


		JSONObject requestBody = new JSONObject(); 
		requestBody.put("name", "ABHI00");

		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json; charset=utf-8");
		expectedHeaders.put("Server", "nginx/1.18.0");


		given().relaxedHTTPSValidation().log().all()
		.header("Content-Type","application/json") .and()
		.body(requestBody.toString()) .when().patch(url)
		.then().log().all().assertThat().statusCode(200)
		.and().headers(expectedHeaders);

      
	}


	@Test(enabled = false)
	public void modifyPassenger()
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

	@Test(enabled = false)
	public void deletePassenger()
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













