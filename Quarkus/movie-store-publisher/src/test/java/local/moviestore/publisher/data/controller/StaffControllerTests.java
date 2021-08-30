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

import local.moviestore.publisher.data.model.Staff;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class StaffControllerTests {

	private static Staff staff;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Staff> staffList = RestAssured.given()
				.when().get("/staff")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Staff.class);
		Assertions.assertTrue(staffList.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		StaffControllerTests.setStaff(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"someone\"}")
				.post("/staff")
				.then()
				.statusCode(201)
				.extract()
				.as(Staff.class));
		Assertions.assertNotNull(StaffControllerTests.getStaff().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Staff temporaryStaff  = RestAssured.given()
				.when()
				.get("/staff/{id}", StaffControllerTests.getStaff().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Staff.class);
		Assertions.assertNotNull(temporaryStaff.getId());
		Assertions.assertTrue(temporaryStaff.getName().contentEquals("someone"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Staff> staffList = RestAssured.given()
				.when().get("/staff")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Staff.class);
		Assertions.assertFalse(staffList.isEmpty());
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
				.delete("/staff/{id}", StaffControllerTests.getStaff().getId())
				.then()
				.statusCode(204);
	}

	public static Staff getStaff() {
		return staff;
	}

	public static void setStaff(Staff staff) {
		StaffControllerTests.staff = staff;
	}
}
