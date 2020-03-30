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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	
	@BeforeAll
	static void init() 
			throws Exception {
		System.out.println("");
	}
	
	@BeforeEach
	void before() 
			throws Exception {
		System.out.println("");
	}

	@Test
	@DisplayName("sample test")
	void sampleTest() 
			throws Exception {
		System.out.println("");
	}

	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void sampleParametrizedTest(Integer index) 
			throws Exception {
		
	}

	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void anotherParametrizedTest(Integer index) 
			throws Exception {
		
	}

	@Test
	@Disabled
	void sampleDisabledTest() 
			throws Exception {
		System.out.println("");
	}
	
	@AfterEach
	void after() 
			throws Exception {
		System.out.println("");
	}
	
	@AfterAll
	static void end() 
			throws Exception {
		System.out.println("");
	}
}
