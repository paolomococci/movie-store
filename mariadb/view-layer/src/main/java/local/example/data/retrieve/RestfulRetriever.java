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

package local.example.data.retrieve;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class RestfulRetriever<T> {

	public List<T> getListOfItems(URI uri, String follow) 
			throws JsonMappingException, JsonProcessingException {
		List<T> types = new ArrayList<>();
		var traverson = new Traverson(uri, MediaTypes.HAL_JSON);
		TraversalBuilder traversalBuilder = traverson.follow(follow);
		var parameterizedTypeReference = new ParameterizedTypeReference<CollectionModel<T>>() {};
		CollectionModel<T> collectionModelOfTypes = traversalBuilder.toObject(parameterizedTypeReference);
		Collection<T> collectionOfTypes = collectionModelOfTypes.getContent();
		for (T type : collectionOfTypes) {
			types.add(type);
		}
		return types;
	}
}
