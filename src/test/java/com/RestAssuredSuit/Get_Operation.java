package com.RestAssuredSuit;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Get_Operation {

//----- scenario_01: get all Employee details
	@Test
	public void get_all_EmployeeDetails() {
		System.out.println("--------*---------*--GET REQUEST--------*---------*-");
		System.out.println("Get all EmployeeDetails");

		Response resp = given().contentType("application/json").accept(ContentType.JSON).when()
				.get("http://localhost:3000/EmployeeDetails").then().statusCode(200).log().all().extract().response();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is " + statusCode + " and Test is Passed!!!");
		System.out.println("\n--------*---------*--GET REQUEST--------*---------*-");

	}

//----- Sce_02: Search Employee by lastName (jamila)
	@Test
	public void search_Employee_By_lastName() {
		System.out.println("--------*---------*--GET REQUEST--------*---------*-");
		System.out.println("search employee by lastName (jamila)");
		Response resp = given().contentType("application/json").accept(ContentType.JSON).when()
				.get(" http://localhost:3000/EmployeeDetails?lastName=jamila").then().statusCode(200).log().all()
				.extract().response();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is " + statusCode + " and Test is Passed!!!");
		System.out.println("\n--------*---------*--GET REQUEST--------*---------*-");
	}

//------------ Sce_02: Search Employee by id (18350)
	@Test
	public void search_Employee_By_id() {
		System.out.println("--------*---------*--GET REQUEST--------*---------*-");
		System.out.println("search employee by id (18350)");
		Response resp = given().contentType("application/json").accept(ContentType.JSON).when()
				.get(" http://localhost:3000/EmployeeDetails?id=18350").then().statusCode(200).log().all()
				.extract().response();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is " + statusCode + " and Test is Passed!!!");
		System.out.println("\n--------*---------*--GET REQUEST--------*---------*-");
	}

}



