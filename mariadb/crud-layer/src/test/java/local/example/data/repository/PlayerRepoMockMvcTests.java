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

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerRepoMockMvcTests {
	
	private static String PLAYER_TEST_STRING = 
			"{\"name\":\"John\",\"nickname\":\"one\",\"surname\":\"Do\"}";
	private static URI uri;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	PlayerRestRepository playerRestRepository;

	@Test
	void contextTest() 
			throws Exception {
		assertThat(playerRestRepository).isNotNull();
	}
	
	@Test
	void existenceTest() 
			throws Exception {
		mockMvc
			.perform(get("/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$._links.players").exists());
	}
	
	@Test
	void crudTest() 
			throws Exception {
		
		/* create a record */
		MvcResult mvcResult = mockMvc
			.perform(post("/players").content(PLAYER_TEST_STRING))
			.andExpect(status().isCreated())
			.andReturn();
		setUri(new URI(mvcResult.getResponse().getHeader("Location")));

		/* read record */
		mockMvc.perform(get(PlayerRepoMockMvcTests.getUri().getPath())) 
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value("John"))
			.andExpect(jsonPath("$.nickname").value("one"))
			.andExpect(jsonPath("$.surname").value("Do"));

		/* complete update record */
		mockMvc.perform(put(PlayerRepoMockMvcTests.getUri().getPath())
			.content("{\"name\":\"James\",\"nickname\":\"two\",\"surname\":\"Jump\"}"))
			.andExpect(status().isNoContent()); 
		mockMvc.perform(get(PlayerRepoMockMvcTests.getUri().getPath()))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value("James"))
			.andExpect(jsonPath("$.nickname").value("two"))
			.andExpect(jsonPath("$.surname").value("Jump"));

		/* partial update record */
		mockMvc.perform(patch(PlayerRepoMockMvcTests.getUri().getPath())
			.content("{\"name\":\"James\"}"))
			.andExpect(status().isNoContent()); 
		mockMvc.perform(get(PlayerRepoMockMvcTests.getUri().getPath()))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value("James"));

		/* delete record */
		mockMvc.perform(delete(PlayerRepoMockMvcTests.getUri().getPath()))
			.andExpect(status().isNoContent());
		mockMvc.perform(get(PlayerRepoMockMvcTests.getUri().getPath()))
			.andExpect(status().isNotFound());
	}

	private static URI getUri() {
		return uri;
	}

	private static void setUri(URI uri) {
		PlayerRepoMockMvcTests.uri = uri;
	}
}
