package com.test.springboot.restdbboot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

class TestCreateEmployee {

	private final String CONTEXT_PATH="/api";
	
	@BeforeEach
	void setUp() throws Exception {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=9074;
	}

	@Test
	void test() {
		
		Map<String,Object> employeeDetails= new HashMap<>();
		employeeDetails.put("firstName", "Sam");
		employeeDetails.put("lastName", "Joseph");
		employeeDetails.put("email", "Sam.Jose@gmail.com");
		
		Response response=given().
		contentType("application/json").accept("application/json").
		body(employeeDetails).
		when().
		post(CONTEXT_PATH + "/employees").
		then().
		statusCode(200).
		contentType("application/json").extract().
		response();
		
		
		//String employeeId = response.jsonPath().getString("id");
		String emploName = response.jsonPath().getString("firstName");
		//assertNotNull(employeeId);
		assertEquals(emploName, employeeDetails.get(employeeDetails.keySet().toArray()[0]));
	}

}
