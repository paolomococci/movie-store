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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(
		name = "ADDRESS",
		uniqueConstraints = @UniqueConstraint(columnNames = {"PHONE"})
)
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@Size(max = 255, message = "max of this field is 255 characters")
	@Pattern(
			regexp = "^[a-zA-Z]*$", 
			message = "only the characters `a-z` and `A-Z` characters"
			)
	private String type;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 100, message = "size range of this field is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `_` and `-` are allowed"
			)
	private String name;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 10, message = "size range of this field is 1 to 10 characters")
	@Pattern(
			regexp = "^[a-zA-Z0-9-]*$", 
			message = "only the characters `a-z`, `A-Z`, `0-9` and `-` are allowed"
			)
	private String civic;

	@Getter
	@Setter
	@Size(max = 25, message = "max of this field is 25 characters")
	@Pattern(
			regexp = "^[0-9-]*$", 
			message = "only the characters `0-9` and `-` are allowed"
			)
	@Column(name = "PHONE", unique = true, nullable = false, columnDefinition = "VARCHAR(25)")
	private String phone;

	@Getter
	@Setter
	@Column(name = "UPDATED")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate updated;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "district_fk")
	private District district;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "storeAddress")
	private List<Store> stores;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "staffAddress")
	private List<Staff> staff;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "customerAddress")
	private List<Customer> residents;
}
