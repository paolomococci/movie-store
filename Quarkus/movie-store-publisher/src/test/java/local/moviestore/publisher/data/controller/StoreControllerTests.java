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

import local.moviestore.publisher.data.model.Store;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class StoreControllerTests {

	private static Store store;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Store> stores = RestAssured.given()
				.when().get("/store")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Store.class);
		Assertions.assertTrue(stores.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		StoreControllerTests.setStore(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something\"}")
				.post("/store")
				.then()
				.statusCode(201)
				.extract()
				.as(Store.class));
		Assertions.assertNotNull(StoreControllerTests.getStore().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Store temporaryStore  = RestAssured.given()
				.when()
				.get("/store/{id}", StoreControllerTests.getStore().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Store.class);
		Assertions.assertNotNull(temporaryStore.getId());
		Assertions.assertTrue(temporaryStore.getName().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Store> stores = RestAssured.given()
				.when().get("/store")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Store.class);
		Assertions.assertFalse(stores.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something else\"}")
				.put("/store/{id}", StoreControllerTests.getStore().getId())
				.then()
		.statusCode(204);
		Store temporaryStore  = RestAssured.given()
				.when()
				.get("/store/{id}", StoreControllerTests.getStore().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Store.class);
		Assertions.assertTrue(temporaryStore.getName().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/store/{id}", StoreControllerTests.getStore().getId())
				.then()
				.statusCode(204);
	}

	public static Store getStore() {
		return store;
	}

	public static void setStore(Store store) {
		StoreControllerTests.store = store;
	}
}
