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

import local.moviestore.publisher.data.model.Category;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class CategoryControllerTests {

	private static Category category;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Category> categories = RestAssured.given()
				.when().get("/category")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Category.class);
		Assertions.assertTrue(categories.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		CategoryControllerTests.setCategory(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something\"}")
				.post("/category")
				.then()
				.statusCode(201)
				.extract()
				.as(Category.class));
		Assertions.assertNotNull(CategoryControllerTests.getCategory().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		
	}

	@Test
	@Order(4)
	public void readAllTest() {
		
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
				.delete("/category/{id}", CategoryControllerTests.getCategory().getId())
				.then()
				.statusCode(204);
	}

	public static Category getCategory() {
		return category;
	}

	public static void setCategory(Category category) {
		CategoryControllerTests.category = category;
	}
}
