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
		name = "CATEGORY",
		uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"})
)
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@Size(min = 3, max = 50, message = "size range of this field is 3 to 50 characters")
	@Pattern(
			regexp = "^[a-zA-Z_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `_` and `-` are allowed"
			)
	@Column(name = "NAME", unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
	private String name;

	@Getter
	@Setter
	@Size(max = 200, message = "max field is 200 characters")
	@Pattern(
			regexp = "^[a-zA-Z]*[a-zA-Z0-9 -]*[a-zA-Z]*$", 
			message = "only the characters `a-z`, `A-Z`, `_`, `-` and space are allowed"
			)
	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(200)")
	private String description;

	@Getter
	@Setter
	@Column(name = "UPDATED")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate updated;
	
	@Getter
	@Setter
	@Column(name = "MOVIES")
	@ManyToMany(mappedBy = "categories")
	private List<Movie> movies;
}
