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
@Table(name = "CONTENT")
public class Content {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@Size(max = 255, message = "max of this field is 255 characters")
	@Pattern(
			regexp = "^[a-zA-Z]*[a-zA-Z0-9 -]*[a-zA-Z]*$", 
			message = "only the characters `a-z`, `A-Z`, `_`, `-` and space are allowed"
			)
	@Column(name = "SUBJECT", columnDefinition = "VARCHAR(255)")
	private String subject;

	@Getter
	@Setter
	@Column(name = "UPDATED")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate updated;
	
	@Getter
	@Setter
	@ManyToMany(mappedBy = "contents")
	private List<Movie> movies;
}
