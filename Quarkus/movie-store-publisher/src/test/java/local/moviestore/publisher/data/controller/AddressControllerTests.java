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
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import local.moviestore.publisher.data.model.Address;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class AddressControllerTests {

	private static Address address;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Address> addresses = RestAssured.given()
				.when().get("/address")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Address.class);
		Assertions.assertTrue(addresses.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		AddressControllerTests.setAddress(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"type\":\"something\"}")
				.post("/address")
				.then()
				.statusCode(201)
				.extract()
				.as(Address.class));
		Assertions.assertNotNull(AddressControllerTests.getAddress().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Address temporaryAddress  = RestAssured.given()
				.when()
				.get("/address/{id}", AddressControllerTests.getAddress().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Address.class);
		Assertions.assertNotNull(temporaryAddress.getId());
		Assertions.assertTrue(temporaryAddress.getType().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Address> addresses = RestAssured.given()
				.when().get("/address")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Address.class);
		Assertions.assertFalse(addresses.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"type\":\"something else\"}")
				.put("/address/{id}", AddressControllerTests.getAddress().getId())
				.then()
				.statusCode(204);
		Address temporaryAddress  = RestAssured.given()
				.when()
				.get("/address/{id}", AddressControllerTests.getAddress().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Address.class);
		Assertions.assertTrue(temporaryAddress.getType().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/address/{id}", AddressControllerTests.getAddress().getId())
				.then()
				.statusCode(204);
	}

	public static Address getAddress() {
		return address;
	}

	public static void setAddress(Address address) {
		AddressControllerTests.address = address;
	}
}
