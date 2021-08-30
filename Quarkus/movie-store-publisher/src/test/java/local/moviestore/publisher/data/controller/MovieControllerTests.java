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

import local.moviestore.publisher.data.model.Movie;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class MovieControllerTests {

	private static Movie movie;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Movie> movies = RestAssured.given()
				.when().get("/movie")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Movie.class);
		Assertions.assertTrue(movies.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		MovieControllerTests.setMovie(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"title\":\"some title\"}")
				.post("/movie")
				.then()
				.statusCode(201)
				.extract()
				.as(Movie.class));
		Assertions.assertNotNull(MovieControllerTests.getMovie().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Movie temporaryMovie  = RestAssured.given()
				.when()
				.get("/movie/{id}", MovieControllerTests.getMovie().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Movie.class);
		Assertions.assertNotNull(temporaryMovie.getId());
		Assertions.assertTrue(temporaryMovie.getTitle().contentEquals("some title"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Movie> movies = RestAssured.given()
				.when().get("/movie")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Movie.class);
		Assertions.assertFalse(movies.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"title\":\"some other title\"}")
				.put("/movie/{id}", MovieControllerTests.getMovie().getId())
				.then()
		.statusCode(204);
		Movie temporaryMovie  = RestAssured.given()
				.when()
				.get("/movie/{id}", MovieControllerTests.getMovie().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Movie.class);
		Assertions.assertTrue(temporaryMovie.getTitle().contentEquals("some other title"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/movie/{id}", MovieControllerTests.getMovie().getId())
				.then()
				.statusCode(204);
	}

	public static Movie getMovie() {
		return movie;
	}

	public static void setMovie(Movie movie) {
		MovieControllerTests.movie = movie;
	}
}
