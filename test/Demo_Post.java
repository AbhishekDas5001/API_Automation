package test;

//import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.mapper.ObjectMapper;

public class Demo_Post {
	private String name;
	private String trips;
	private String airline;

	public String getName() {
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getTrips() {
		return name;
	}
	public void setTrips(String trips)
	{
		this.trips = trips;
	}
	
	public String getAirline() {
		return name;
	}
	public void setAirline(String airline)
	{
		this.airline = airline;
	}

	@Test
	public void CreatePassengerForAirline()
	{
		String url= "https://api.instantwebtools.net/v1/passenger";

		Demo_Post demo= new Demo_Post();
		demo.setName("Abhishek");
		demo.setTrips("5000");
		demo.setAirline("90400501674");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		/*
		 * given().log().all().header("Content-Type", "application/json")
		 * .and().body(demo) .when().post(url)
		 * .then().log().all().assertThat().statusCode(200);
		 */
	}

}
