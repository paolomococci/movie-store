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

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class InventoryRepoMockMvcParametrizedTests {

	private static String INVENTORY_TEST_STRING = "{}";
	private static String uriString;

	@Autowired
	MockMvc mockMvc;
	
	@BeforeAll
	static void init() 
			throws Exception {
		
	}

	@Order(1)
	@ParameterizedTest
	@MethodSource("initUri")
	@DisplayName("sample test")
	void sampleTest() 
			throws Exception {
		
	}
	
	@AfterAll
	static void end() 
			throws Exception {
		
	}

	private static String getUri() {
		return uriString;
	}

	private static void setUri(String uri) {
		InventoryRepoMockMvcParametrizedTests.uriString = uri;
	}
	
	private static Stream<String> initUri() {
		return Stream.of(getUri());
	}
}

