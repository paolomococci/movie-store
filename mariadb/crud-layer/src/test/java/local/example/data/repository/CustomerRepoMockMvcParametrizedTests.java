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

package local.example.data.repository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class CustomerRepoMockMvcParametrizedTests {

	private static String CUSTOMER_TEST_STRING = 
			"{\"name\":\"John\",\"nickname\":\"jumper\",\"surname\":\"Do\",\"phone\":\"123-654321987\",\"mobile\":\"385498746242\",\"email\":\"johndoe@localhost.localdomain\",\"birthday\":\"2000-12-12\",\"active\":\"true\"}";

	private static String UPDATE_CUSTOMER_TEST_STRING = 
			"{\"name\":\"James\",\"nickname\":\"fly\",\"surname\":\"Jump\",\"phone\":\"321-654321987\",\"mobile\":\"386542587531\",\"email\":\"jamesjump@localhost.localdomain\",\"birthday\":\"2000-11-11\",\"active\":\"true\"}";
	private static URI uri;

	@Autowired
	MockMvc mockMvc;
	
	@Test
	@Order(1)
	@DisplayName("create a record into customer's data table")
	void createTest() 
			throws Exception {
		MvcResult mvcResult = mockMvc
			.perform(post("/customers").content(CUSTOMER_TEST_STRING))
			.andExpect(status().isCreated())
			.andReturn();
		setUri(new URI(mvcResult.getResponse().getHeader("Location")));
	}

	@Order(2)
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("read a record from the customer's data table identifying it from the uri")
	void readTest(String uri) 
			throws Exception {
		mockMvc.perform(get(uri))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value("John"))
			.andExpect(jsonPath("$.nickname").value("jumper"))
			.andExpect(jsonPath("$.surname").value("Do"))
			.andExpect(jsonPath("$.phone").value("123-654321987"))
			.andExpect(jsonPath("$.mobile").value("385498746242"))
			.andExpect(jsonPath("$.email").value("johndoe@localhost.localdomain"))
			.andExpect(jsonPath("$.birthday").value("2000-12-12"))
			.andExpect(jsonPath("$.active").value(true));
	}

	@Order(3)
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("update a record into the customer's data table identifying it from the uri")
	void putTest(String uri) 
			throws Exception {
		mockMvc.perform(put(uri)
			.content(UPDATE_CUSTOMER_TEST_STRING))
			.andExpect(status().isNoContent()); 
		mockMvc.perform(get(uri))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value("James"))
			.andExpect(jsonPath("$.nickname").value("fly"))
			.andExpect(jsonPath("$.surname").value("Jump"))
			.andExpect(jsonPath("$.phone").value("321-654321987"))
			.andExpect(jsonPath("$.mobile").value("386542587531"))
			.andExpect(jsonPath("$.email").value("jamesjump@localhost.localdomain"))
			.andExpect(jsonPath("$.birthday").value("2000-11-11"))
			.andExpect(jsonPath("$.active").value(true));
	}

	@Order(4)
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("partial update a record into the customer's data table identifying it from the uri")
	void patchTest(String uri) 
			throws Exception {
		mockMvc.perform(patch(uri)
			.content("{\"active\":false}"))
			.andExpect(status().isNoContent()); 
		mockMvc.perform(get(uri))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.active").value(false));
	}

	@Order(5)
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("delete a record from the customer's data table identifying it from the uri")
	void deleteTest(String uri) 
			throws Exception {
		mockMvc.perform(delete(uri))
			.andExpect(status().isNoContent());
	}

	@Order(6)
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("try to read a deleted record from the customer's data table identifying it from the uri")
	void notFoundTest(String uri) 
			throws Exception {
		mockMvc.perform(get(uri))
			.andExpect(status().isNotFound());
	}

	private static URI getUri() {
		return uri;
	}

	private static void setUri(URI uri) {
		CustomerRepoMockMvcParametrizedTests.uri = uri;
	}
	
	private static Stream<String> initUri() {
		return Stream.of(CustomerRepoMockMvcParametrizedTests.getUri().getPath());
	}
}
