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

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(
		name = "ISO3166",
		uniqueConstraints = @UniqueConstraint(columnNames = {"SIGNATURE"})
)
public class Iso3166 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@Size(min = 3, max = 100, message = "size range of this field is 3 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `_` and `-` are allowed"
			)
	@Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(100)")
	private String name;

	@Getter
	@Setter
	@Column(name = "CODE", unique = true, nullable = false, columnDefinition = "VARCHAR(3)")
	private String code;

	@Getter
	@Setter
	@Size(min = 2, max = 3, message = "range of this field is 2 to 3 characters")
	@Pattern(
			regexp = "^[A-Z]*$", 
			message = "only the characters`A-Z` are allowed"
			)
	@Column(name = "SIGNATURE", unique = true, nullable = false, columnDefinition = "VARCHAR(3)")
	private String signature;

	@Getter
	@Setter
	@Column(name = "UPDATED")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate updated;
	
	@Getter
	@Setter
	@Column(name = "COUNTRIES")
	@OneToMany(mappedBy = "iso3166")
	private List<Country> countries;
}
