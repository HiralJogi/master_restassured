package com.restAssured.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.base.APIConfig;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC03_POST_ValidateCreateUser {
	@BeforeClass
	public void startUp() throws IOException {
		APIConfig.readAPIConfig();
		APIConfig.readAPIEndpoints();
		APIConfig.setBaseURL();
	}

	@Test(description = "Validate new user is being created successully as per mentioned details.")
	public void test_user_created_successfully_using_post_api_method1_body_from_json_file() throws Exception {
		String end_point = APIConfig.api_Endpoints.getProperty("createUser");
		String body = "{\n" + "  \"name\": \"Hiral\",\n" + "  \"job\": \"Test Lead\"\n" + "}";
		String baseURI = APIConfig.api_config.getProperty("BaseURL");

		Response response = given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(body).when().post(baseURI + end_point);

		// Verifying status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		//Assert.assertEquals(statusCode, 200); // For error validation uncomment this line

		// verifying response body is not null
		String resBody = response.getBody().asString();
		Assert.assertTrue(resBody != null, "Response body is not null which is correct.");

	}
	
	@AfterClass
	void tearDown() {
		System.out.println("Execution completed.");
	}
}