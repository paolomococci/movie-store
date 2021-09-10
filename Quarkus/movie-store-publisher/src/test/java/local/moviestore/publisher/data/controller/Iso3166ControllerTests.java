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

import local.moviestore.publisher.data.model.Iso3166;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class Iso3166ControllerTests {

	private static Iso3166 iso3166;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Iso3166> iso3166List = RestAssured.given()
				.when().get("/iso3166")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Iso3166.class);
		Assertions.assertTrue(iso3166List.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		Iso3166ControllerTests.setIso3166(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something\"}")
				.post("/iso3166")
				.then()
				.statusCode(201)
				.extract()
				.as(Iso3166.class));
		Assertions.assertNotNull(Iso3166ControllerTests.getIso3166().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Iso3166 temporaryIso3166  = RestAssured.given()
				.when()
				.get("/iso3166/{id}", Iso3166ControllerTests.getIso3166().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Iso3166.class);
		Assertions.assertNotNull(temporaryIso3166.getId());
		Assertions.assertTrue(temporaryIso3166.getName().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Iso3166> iso3166List = RestAssured.given()
				.when().get("/iso3166")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Iso3166.class);
		Assertions.assertFalse(iso3166List.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something else\"}")
				.put("/iso3166/{id}", Iso3166ControllerTests.getIso3166().getId())
				.then()
		.statusCode(204);
		Iso3166 temporaryIso3166  = RestAssured.given()
				.when()
				.get("/iso3166/{id}", Iso3166ControllerTests.getIso3166().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Iso3166.class);
		Assertions.assertTrue(temporaryIso3166.getName().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/iso3166/{id}", Iso3166ControllerTests.getIso3166().getId())
				.then()
				.statusCode(204);
	}

	protected static Iso3166 getIso3166() {
		return iso3166;
	}

	protected static void setIso3166(Iso3166 iso3166) {
		Iso3166ControllerTests.iso3166 = iso3166;
	}
}
