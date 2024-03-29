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

import local.moviestore.publisher.data.model.Content;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class ContentControllerTests {

	private static Content content;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Content> contents = RestAssured.given()
				.when().get("/content")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Content.class);
		Assertions.assertTrue(contents.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		ContentControllerTests.setContent(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"subject\":\"something\"}")
				.post("/content")
				.then()
				.statusCode(201)
				.extract()
				.as(Content.class));
		Assertions.assertNotNull(ContentControllerTests.getContent().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Content temporaryContent  = RestAssured.given()
				.when()
				.get("/content/{id}", ContentControllerTests.getContent().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Content.class);
		Assertions.assertNotNull(temporaryContent.getId());
		Assertions.assertTrue(temporaryContent.getSubject().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Content> contents = RestAssured.given()
				.when().get("/content")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Content.class);
		Assertions.assertFalse(contents.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"subject\":\"something else\"}")
				.put("/content/{id}", ContentControllerTests.getContent().getId())
				.then()
		.statusCode(204);
		Content temporaryContent  = RestAssured.given()
				.when()
				.get("/content/{id}", ContentControllerTests.getContent().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Content.class);
		Assertions.assertTrue(temporaryContent.getSubject().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/content/{id}", ContentControllerTests.getContent().getId())
				.then()
				.statusCode(204);
	}

	protected static Content getContent() {
		return content;
	}

	protected static void setContent(Content content) {
		ContentControllerTests.content = content;
	}
}
