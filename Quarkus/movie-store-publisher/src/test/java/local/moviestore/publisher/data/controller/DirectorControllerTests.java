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

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import local.moviestore.publisher.data.model.Director;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class DirectorControllerTests {

	private static Director director;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Director> directors = RestAssured.given()
				.when().get("/director")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Director.class);
		Assertions.assertTrue(directors.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		DirectorControllerTests.setDirector(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"someone\"}")
				.post("/director")
				.then()
				.statusCode(201)
				.extract()
				.as(Director.class));
		Assertions.assertNotNull(DirectorControllerTests.getDirector().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Director temporaryDirector  = RestAssured.given()
				.when()
				.get("/director/{id}", DirectorControllerTests.getDirector().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Director.class);
		Assertions.assertNotNull(temporaryDirector.getId());
		Assertions.assertTrue(temporaryDirector.getName().contentEquals("someone"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Director> directors = RestAssured.given()
				.when().get("/director")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Director.class);
		Assertions.assertFalse(directors.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"somebody else\"}")
				.put("/director/{id}", DirectorControllerTests.getDirector().getId())
				.then()
				.statusCode(204);
		Director temporaryDirector  = RestAssured.given()
				.when()
				.get("/director/{id}", DirectorControllerTests.getDirector().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Director.class);
		Assertions.assertTrue(temporaryDirector.getName().contentEquals("somebody else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/director/{id}", DirectorControllerTests.getDirector().getId())
				.then()
				.statusCode(204);
	}

	protected static Director getDirector() {
		return director;
	}

	protected static void setDirector(Director director) {
		DirectorControllerTests.director = director;
	}
}
