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

import local.moviestore.publisher.data.model.Rental;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class RentalControllerTests {

	private static Rental rental;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Rental> rentals = RestAssured.given()
				.when().get("/rental")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Rental.class);
		Assertions.assertTrue(rentals.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		RentalControllerTests.setRental(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{}")
				.post("/rental")
				.then()
				.statusCode(201)
				.extract()
				.as(Rental.class));
		Assertions.assertNotNull(RentalControllerTests.getRental().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Rental temporaryRental  = RestAssured.given()
				.when()
				.get("/rental/{id}", RentalControllerTests.getRental().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Rental.class);
		Assertions.assertNotNull(temporaryRental.getId());
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Rental> rentals = RestAssured.given()
				.when().get("/rental")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Rental.class);
		Assertions.assertFalse(rentals.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/rental/{id}", RentalControllerTests.getRental().getId())
				.then()
				.statusCode(204);
	}

	public static Rental getRental() {
		return rental;
	}

	public static void setRental(Rental rental) {
		RentalControllerTests.rental = rental;
	}
}
