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

import local.moviestore.publisher.data.model.Producer;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class ProducerControllerTests {

	private static Producer producer;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Producer> producers = RestAssured.given()
				.when().get("/producer")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Producer.class);
		Assertions.assertTrue(producers.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		ProducerControllerTests.setProducer(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"someone\"}")
				.post("/producer")
				.then()
				.statusCode(201)
				.extract()
				.as(Producer.class));
		Assertions.assertNotNull(ProducerControllerTests.getProducer().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Producer temporaryProducer  = RestAssured.given()
				.when()
				.get("/producer/{id}", ProducerControllerTests.getProducer().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Producer.class);
		Assertions.assertNotNull(temporaryProducer.getId());
		Assertions.assertTrue(temporaryProducer.getName().contentEquals("someone"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Producer> producers = RestAssured.given()
				.when().get("/producer")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Producer.class);
		Assertions.assertFalse(producers.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"somebody else\"}")
				.put("/producer/{id}", ProducerControllerTests.getProducer().getId())
				.then()
				.statusCode(204);
		Producer temporaryProducer  = RestAssured.given()
				.when()
				.get("/producer/{id}", ProducerControllerTests.getProducer().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Producer.class);
		Assertions.assertTrue(temporaryProducer.getName().contentEquals("somebody else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		
	}

	protected static Producer getProducer() {
		return producer;
	}

	protected static void setProducer(Producer producer) {
		ProducerControllerTests.producer = producer;
	}
}
