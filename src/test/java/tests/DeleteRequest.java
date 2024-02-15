package tests;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import core.Utils;
import io.restassured.response.Response;

public class DeleteRequest extends TestBase{

	
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
		
		
		String id = postResponse.jsonPath().getString("id");
		
		Response deleteResponse = given()
                .header("Authorization", "Bearer " + bearerToken) 
                .header("Content-Type", "application/json") 
                .post("https://gorest.co.in/public/v2/users/"+id);
		verifyEquals(deleteResponse.getStatusCode(), 404);
		
		
        
    }
	
}
