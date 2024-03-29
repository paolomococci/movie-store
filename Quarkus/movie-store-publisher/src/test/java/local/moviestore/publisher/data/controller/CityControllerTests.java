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

import local.moviestore.publisher.data.model.City;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class CityControllerTests {

	private static City city;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<City> cities = RestAssured.given()
				.when().get("/city")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", City.class);
		Assertions.assertTrue(cities.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		CityControllerTests.setCity(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something\"}")
				.post("/city")
				.then()
				.statusCode(201)
				.extract()
				.as(City.class));
		Assertions.assertNotNull(CityControllerTests.getCity().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		City temporaryCity  = RestAssured.given()
				.when()
				.get("/city/{id}", CityControllerTests.getCity().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(City.class);
		Assertions.assertNotNull(temporaryCity.getId());
		Assertions.assertTrue(temporaryCity.getName().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<City> cities = RestAssured.given()
				.when().get("/city")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", City.class);
		Assertions.assertFalse(cities.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something else\"}")
				.put("/city/{id}", CityControllerTests.getCity().getId())
				.then()
		.statusCode(204);
		City temporaryCity  = RestAssured.given()
				.when()
				.get("/city/{id}", CityControllerTests.getCity().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(City.class);
		Assertions.assertTrue(temporaryCity.getName().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/city/{id}", CityControllerTests.getCity().getId())
				.then()
				.statusCode(204);
	}

	protected static City getCity() {
		return city;
	}

	protected static void setCity(City city) {
		CityControllerTests.city = city;
	}
}
