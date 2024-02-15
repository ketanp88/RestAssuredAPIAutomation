package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import core.Utils;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static org.hamcrest.Matchers.*;
import java.util.*;

public class PutRequest extends TestBase {

	String bearerToken = "123b934dd48340c191d0ee731fac0f54e122ac016798c5dba1bec7f5200ed2b1";
	
	@Test
	public void UpdateUsersRequest()
	{
		//Create Request
		String name = Utils.generateRandomString(5) + " " +Utils.generateRandomString(4);
		String email = name.replace(" ", "")+ "@" + Utils.generateRandomString(5) + ".com";
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", name);
		requestBody.put("email", email);
		requestBody.put("gender", "male");
		requestBody.put("status", "active");
		System.out.println("Request Body: " + requestBody);
		
		Response response = given()
                .header("Authorization", "Bearer " + bearerToken) 
                .body(requestBody.toJSONString()) 
                .header("Content-Type", "application/json") 
                .post("https://gorest.co.in/public/v2/users");
         
        String id = response.jsonPath().getString("id");
		
		// Update Request
		requestBody.put("name", "Test");
		
		Response putResponse = given()
        		.header("Authorization", "Bearer " + bearerToken) 
        		.body(requestBody.toJSONString()) 
        		.header("Content-Type", "application/json") 
        		.put("https://gorest.co.in/public/v2/users/"+id);
        		
		verifyEquals(putResponse.getStatusCode(), 200);
		verifyEquals(putResponse.jsonPath().getString("name"), "Test");
		
	}
	
	
	
	
	
}
