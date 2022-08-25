package com.api.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class APIConfig {

	public static Properties api_config;
	public static Properties api_Endpoints;
	public static RequestSpecification request;
	public static Response response;
	public static ExtentTest test;
	public static ExtentReports report;

	/*
	 * @Description - Reading config file details
	 * @author - Hiral Jogi
	 */ 
	public static void readAPIConfig() throws IOException {
		api_config = new Properties();
		FileInputStream objConfig = new FileInputStream(
				System.getProperty("user.dir") + "/resources/Configuration.properties");
		api_config.load(objConfig);
	}

	/*
	 * @Description - Reading API Endpoint details
	 * @author - Hira Jogi
	 */ 
	public static void readAPIEndpoints() throws IOException {
		api_Endpoints = new Properties();
		FileInputStream objEndpoint = new FileInputStream(
				System.getProperty("user.dir") + "/resources/Endpoints.properties");
		api_Endpoints.load(objEndpoint);
	}

	public static void setBaseURL() throws IOException {
		RestAssured.baseURI = api_config.getProperty("BaseURL");
	}


}
