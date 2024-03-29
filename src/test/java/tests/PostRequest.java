package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import core.Utils;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
		
		Response postResponse = given()
                .header("Authorization", "Bearer " + bearerToken) 
                .body(requestBody.toJSONString()) 
                .header("Content-Type", "application/json") 
                .post("https://gorest.co.in/public/v2/users");
		verifyEquals(postResponse.getStatusCode(), 201);
		verifyEquals(postResponse.jsonPath().getString("name"), name);
		verifyEquals(postResponse.jsonPath().getString("email"), email);
		verifyEquals(postResponse.jsonPath().getString("gender"), "male");
		verifyEquals(postResponse.jsonPath().getString("status"), "active");
        
    }
	
}
