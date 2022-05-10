package com.RestAssuredSuit;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post_Operation {


		
		//----Add a record in customersDetails
				@Test
				public void Add_a_record_in_customersDetails() {
					System.out.println("--------*---------*--POST REQUEST--------*---------*-");
					System.out.println("Add a Record in customersTable");
					
					HashMap data = new HashMap();
					data.put("customerID", "208");
					data.put("department", "science"); 
					data.put("address", "bronx");
					data.put("customerName", "LamineKandi");
					data.put("customerNumber", "34789290"); 
					data.put("address", "new york");
					
					
					//----- resources
					Response resp = 
							given().	
								contentType("application/json").
								contentType(ContentType.JSON).
								body(data).
								
					//---- operation to be performed
							when().
								post("http://localhost:3000/CustomersDetails").
								
					//------Validation	
							then().
								statusCode(201).
								log().all().
								extract().response();
						String jsonString = resp.asPrettyString();
						int statusCode = resp.getStatusCode();
						Assert.assertEquals(statusCode, 201);
						System.out.println("a new Rrecord is insterted successfully"+data.toString());
		
				}
		
}
