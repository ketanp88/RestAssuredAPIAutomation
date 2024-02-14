package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import core.Utils;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import java.util.*;

public class PostRequest extends TestBase {

	
		
	@Test
	public void CreateUsersJSONRequest()
	{
		String name = Utils.generateRandomString(5) + " " +Utils.generateRandomString(4);
		String email = name.replace(" ", "")+ "@" + Utils.generateRandomString(5) + ".com";
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", name);
		requestBody.put("email", email);
		requestBody.put("gender", "male");
		requestBody.put("status", "active");
		System.out.println("Request Body: " + requestBody);
				
		given().
			headers("Authorization", "Bearer " + bearerToken).
			accept(ContentType.JSON).
			body(requestBody.toJSONString()).
			post("https://gorest.co.in/public/v2/users").
		then().
			statusCode(201).
			body("name[0]", equalTo(name)).
			body("email[0]", equalTo(email)).
		log().all();
		
	}
	
	
}
