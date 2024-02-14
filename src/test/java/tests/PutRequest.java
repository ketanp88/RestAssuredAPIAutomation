package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import core.Utils;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import java.util.*;

public class PutRequest extends TestBase {

	String bearerToken = "123b934dd48340c191d0ee731fac0f54e122ac016798c5dba1bec7f5200ed2b1";
	
	@Test
	public void UpdateUsersRequest()
	{
		//Create Request
		String name = Utils.generateRandomString(5);
		String email = name+ "@" + Utils.generateRandomString(5) + ".com";
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", name);
		requestBody.put("email", email);
		requestBody.put("gender", "male");
		requestBody.put("status", "active");
		
		given().
			headers("Authorization", "Bearer " + bearerToken).
			body(requestBody.toJSONString()).
		when().
			post("https://gorest.co.in/public/v2/users").
		then().
			statusCode(201).
			body("name[0]", equalTo(name)).
			log().all();
		
		
		
		// Update Request
		requestBody.put("name", "Test");
		given().
			headers("Authorization", "Bearer " + bearerToken).
			body(requestBody.toJSONString()).
		when().
			put("https://gorest.co.in/public/v2/users").
		then().
			statusCode(201).
			body("name[0]", equalTo(name)).
		log().all();
	}
	
	
	
	
	
}
