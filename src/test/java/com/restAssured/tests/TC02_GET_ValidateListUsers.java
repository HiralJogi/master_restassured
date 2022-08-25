package com.restAssured.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.base.APIConfig;

import io.restassured.response.Response;

public class TC02_GET_ValidateListUsers extends APIConfig {

	@BeforeClass
	public void startUp() throws IOException {
		APIConfig.readAPIConfig();
		APIConfig.readAPIEndpoints();
		APIConfig.setBaseURL();
	}

	@Test(description = "Validate details for all the users available on the given page is being displayed as expected.")
	public void get_ValidateAllUserData() {
		String baseURI = APIConfig.api_config.getProperty("BaseURL");
		String getUserEndPoint = APIConfig.api_Endpoints.getProperty("getUsers");
		Response response = given().when().get(baseURI + getUserEndPoint);

		// Verifying status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		// verifying response body is not null
		String resBody = response.getBody().asString();
		Assert.assertTrue(resBody != null, "Response body is not null which is correct.");
	}

	@AfterClass
	void tearDown() {
		System.out.println("Execution completed.");
	}
}
