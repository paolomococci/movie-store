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

package local.example.demo.retrieve;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import local.example.demo.model.Item;

public class ItemRestfulRetriever {

	public static Item getIdentifiedItem(URI uri, Long id) 
			throws JsonMappingException, JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(uri+"/"+id, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(response.getBody());
		Item item = new Item();
		item.setId(id);
		item.setCode(jsonNode.path("code").toString());
		item.setName(jsonNode.path("nome").toString());
		return item;
	}

	public static List<Item> getItems(URI uri) 
			throws JsonMappingException, JsonProcessingException {
		List<Item> items = new ArrayList<Item>();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String[]> response = restTemplate.getForEntity(uri, String[].class);
		List<String> entities = Arrays.asList(response.getBody());
		ObjectMapper objectMapper = new ObjectMapper();
		for (String entity : entities) {
			JsonNode jsonNode = objectMapper.readTree(entity);
			Item item = new Item(
					Long.valueOf(jsonNode.path("id").toPrettyString()), 
					jsonNode.path("code").toPrettyString(), 
					jsonNode.path("name").toPrettyString()
			);
			items.add(item);
		} 
		return items;
	}
}
