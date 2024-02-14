package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import core.Utils;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import java.util.*;

public class PostRequest extends TestBase {

	String bearerToken = "123b934dd48340c191d0ee731fac0f54e122ac016798c5dba1bec7f5200ed2b1";
		
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
