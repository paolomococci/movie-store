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

package local.example.data;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Execution(ExecutionMode.SAME_THREAD)
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {
	
	private static String uriString;
	
	@BeforeAll
	static void init() 
			throws Exception {
		setUri(new String("http://127.0.0.1:8080"));
	}
	
	@BeforeEach
	void before() 
			throws Exception {
		System.out.println("Before each execution!");
	}

	@Test
	@Order(value = 1)
	@DisplayName("sample test")
	void sampleTest() 
			throws Exception {
		System.out.println("Sample test!");
		assertAll("math", 
					() -> assertEquals(2, 1+1),
					() -> assertEquals(4, 2*2)
				);
	}

	@ParameterizedTest
	@Order(value = 2)
	@ValueSource(ints = {1})
	void sampleParametrizedTest(Integer index) 
			throws Exception {
		System.out.println("Sample parameter is: " + index);
		assertEquals(1, index);
	}

	@ParameterizedTest
	@Order(value = 3)
	@ValueSource(strings = {"another parameter"})
	void anotherParametrizedTest(String message) 
			throws Exception {
		System.out.println("Another parameter is: " + message);
		assertEquals(17, message.length());
	}

	@ParameterizedTest
	@Order(value = 4)
	@MethodSource("initUri")
	void uriParametrizedTest(String uri) 
			throws Exception {
		System.out.println("URI is: " + uri);
	}

	@ParameterizedTest
	@Order(value = 5)
	@MethodSource("initUri")
	void anotherUriParametrizedTest(String uri) 
			throws Exception {
		System.out.println("URI is: " + uri + "/players");
	}

	@Test
	@Order(value = 6)
	@Disabled
	void sampleDisabledTest() 
			throws Exception {
		System.out.println("Sample disabled!");
	}
	
	@AfterEach
	void after() 
			throws Exception {
		System.out.println("After each execution!");
	}
	
	@AfterAll
	static void end() 
			throws Exception {
		System.out.println("After all execution!");
	}

	public static String getUri() {
		return uriString;
	}

	public static void setUri(String uri) {
		ApplicationTests.uriString = uri;
	}
	
	private static Stream<String> initUri() {
		return Stream.of(getUri());
	}
}
