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

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class PaymentRepoMockMvcParametrizedTests {

	private static String PAYMENT_TEST_STRING = "{\"amount\":0.0,\"payed\":\"\"}";
	private static URI uri;

	@Autowired
	MockMvc mockMvc;
	
	@Test
	@Order(1)
	@DisplayName("create a record into payment's data table")
	void createTest() throws 
			Exception, 
			DataIntegrityViolationException, 
			ConstraintViolationException {
		MvcResult mvcResult = mockMvc
			.perform(post("/payments").content(PAYMENT_TEST_STRING))
			.andExpect(status().isCreated())
			.andReturn();
		setUri(new URI(mvcResult.getResponse().getHeader("Location")));
	}

	@Order(2)
	@Disabled
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("read a record from the payment's data table identifying it from the uri")
	void readTest(String uri) 
			throws Exception {
		mockMvc.perform(get(uri))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.amount").value(0.0))
			.andExpect(jsonPath("$.payed").value(""));
	}

	@Order(3)
	@Disabled
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("update a record into the payment's data table identifying it from the uri")
	void putTest(String uri) 
			throws Exception {
		mockMvc.perform(put(uri)
			.content("{\"amount\":0.0,\"payed\":\"\"}"))
			.andExpect(status().isNoContent()); 
		mockMvc.perform(get(uri))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.amount").value(0.0))
			.andExpect(jsonPath("$.payed").value(""));
	}

	@Order(4)
	@Disabled
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("partial update a record into the payment's data table identifying it from the uri")
	void patchTest(String uri) 
			throws Exception {
		mockMvc.perform(patch(uri)
			.content("{\"payed\":\"\"}"))
			.andExpect(status().isNoContent()); 
		mockMvc.perform(get(uri))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.payed").value(""));
	}

	@Order(5)
	@Disabled
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("delete a record from the payment's data table identifying it from the uri")
	void deleteTest(String uri) 
			throws Exception {
		mockMvc.perform(delete(uri))
			.andExpect(status().isNoContent());
	}

	@Order(6)
	@Disabled
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("try to read a deleted record from the payment's data table identifying it from the uri")
	void notFoundTest(String uri) 
			throws Exception {
		mockMvc.perform(get(uri))
			.andExpect(status().isNotFound());
	}

	private static URI getUri() {
		return uri;
	}

	private static void setUri(URI uri) {
		PaymentRepoMockMvcParametrizedTests.uri = uri;
	}
	
	private static Stream<String> initUri() {
		return Stream.of(PaymentRepoMockMvcParametrizedTests.getUri().getPath());
	}
}
