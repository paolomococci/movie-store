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

package local.example.data.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 100, message = "range of this value is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `_` and `-` are allowed"
			)
	private String name;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 100, message = "range of this value is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `_` and `-` are allowed"
			)
	private String nickname;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 100, message = "range of this value is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `_` and `-` are allowed"
			)
	private String surname;

	@Getter
	private Timestamp updated;
	
	@Getter
	@Setter
	@ManyToMany(mappedBy = "players")
	private List<Movie> movies;
}
