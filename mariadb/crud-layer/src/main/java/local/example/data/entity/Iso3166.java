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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "iso3166")
public class Iso3166 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@NotNull
	@Size(min = 3, max = 100, message = "size range of this field is 3 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `_` and `-` are allowed"
			)
	private String name;

	@Getter
	@Setter
	@NotNull
	@Min(4)
	@Max(894)
	@Column(unique = true)
	private Integer code;

	@Getter
	@Setter
	@NotNull
	@Column(unique = true)
	@Size(min = 2, max = 3, message = "range of this field is 2 to 3 characters")
	@Pattern(
			regexp = "^[A-Z]*$", 
			message = "only the characters`A-Z` are allowed"
			)
	private String signature;

	@Getter
	private Timestamp updated;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "iso3166")
	private List<Country> countries;
}
