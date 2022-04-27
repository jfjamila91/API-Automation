package com.RestAssuredSuit;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Put_Operation {


//--Update a record in EmployeeDetails
	@Test
	public void update_a_record_in_EmployeeDetails() {
		System.out.println("--------*---------*--GET REQUEST--------*---------*-");
		System.out.println("Update a record in EmployeeDetails........");
		
		HashMap data = new HashMap();
		data.put("employeeNumber", "347893");
		data.put("lastName", "rahman");
		data.put("firstName", "farin");
		data.put("Id", "168");
		
		
		Response respons = 
		given().
			contentType("application/json").
			contentType(ContentType.JSON).
			body(data).
		when().
			put("http://localhost:3000/EmployeeDetails").
		then().

			statusCode(200).
			log().all().
			extract().response();
		int statusCode = respons.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is '"+statusCode+"' and is passed");
	}
}
