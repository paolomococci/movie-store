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

import local.moviestore.publisher.data.model.District;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class DistrictControllerTests {

	private static District district;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<District> districts = RestAssured.given()
				.when().get("/district")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", District.class);
		Assertions.assertTrue(districts.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		DistrictControllerTests.setDistrict(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something\"}")
				.post("/district")
				.then()
				.statusCode(201)
				.extract()
				.as(District.class));
		Assertions.assertNotNull(DistrictControllerTests.getDistrict().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		District temporaryDistrict  = RestAssured.given()
				.when()
				.get("/district/{id}", DistrictControllerTests.getDistrict().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(District.class);
		Assertions.assertNotNull(temporaryDistrict.getId());
		Assertions.assertTrue(temporaryDistrict.getName().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<District> districts = RestAssured.given()
				.when().get("/district")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", District.class);
		Assertions.assertFalse(districts.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something else\"}")
				.put("/district/{id}", DistrictControllerTests.getDistrict().getId())
				.then()
		.statusCode(204);
		District temporaryDistrict  = RestAssured.given()
				.when()
				.get("/district/{id}", DistrictControllerTests.getDistrict().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(District.class);
		Assertions.assertTrue(temporaryDistrict.getName().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/district/{id}", DistrictControllerTests.getDistrict().getId())
				.then()
				.statusCode(204);
	}

	protected static District getDistrict() {
		return district;
	}

	protected static void setDistrict(District district) {
		DistrictControllerTests.district = district;
	}
}
