/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.moviestore.publisher.data.controller;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import local.moviestore.publisher.data.model.Customer;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class CustomerControllerTests {

	private static Customer customer;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Customer> customers = RestAssured.given()
				.when().get("/customer")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Customer.class);
		Assertions.assertTrue(customers.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		CustomerControllerTests.setCustomer(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"someone\"}")
				.post("/customer")
				.then()
				.statusCode(201)
				.extract()
				.as(Customer.class));
		Assertions.assertNotNull(CustomerControllerTests.getCustomer().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Customer temporaryCustomer  = RestAssured.given()
				.when()
				.get("/customer/{id}", CustomerControllerTests.getCustomer().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Customer.class);
		Assertions.assertNotNull(temporaryCustomer.getId());
		Assertions.assertTrue(temporaryCustomer.getName().contentEquals("someone"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Customer> customers = RestAssured.given()
				.when().get("/customer")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Customer.class);
		Assertions.assertFalse(customers.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"somebody else\"}")
				.put("/customer/{id}", CustomerControllerTests.getCustomer().getId())
				.then()
		.statusCode(204);
		Customer temporaryCustomer  = RestAssured.given()
				.when()
				.get("/customer/{id}", CustomerControllerTests.getCustomer().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Customer.class);
		Assertions.assertTrue(temporaryCustomer.getName().contentEquals("somebody else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/customer/{id}", CustomerControllerTests.getCustomer().getId())
				.then()
				.statusCode(204);
	}

	protected static Customer getCustomer() {
		return customer;
	}

	protected static void setCustomer(Customer customer) {
		CustomerControllerTests.customer = customer;
	}
}
