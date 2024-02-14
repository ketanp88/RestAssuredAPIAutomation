package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetRequest extends TestBase {

	@Test
	public void GetUsersRequest()
	{
		Response response = get("https://gorest.co.in/public/v2/users");
		verifyEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void GetUsers()
	{
		given().
		accept("application/json").
		get("https://gorest.co.in/public/v2/users").
	then().
		statusCode(200)
		.log().all();
	}
	
	@Test
	public void GetCommentsRequestComments()
	{
		given().
			accept("application/json").
			get("https://gorest.co.in/public/v2/comments").
		then().
			statusCode(200)
			.body("name[0]", containsString("Sarada"))
			.body("name", hasItems("Sarada Chopra", "Dhanpati Chattopadhyay", "Devagya Dutta"))
			.log().all();
	}
	
	@Test
	public void GetCommentsRequestCommentsWithParam()
	{
		given().
			accept("application/json").
			params("name", "Aalok Pillai").
			get("https://gorest.co.in/public/v2/comments").
		then().
			statusCode(200)
			.body("name", hasItems("Aalok Pillai"))
			.log().all();
	}
	
}
