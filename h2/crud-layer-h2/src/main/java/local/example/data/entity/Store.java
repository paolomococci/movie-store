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
@Table(name = "STORE")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@Size(
			min = 1, 
			max = 50, 
			message = "size range of this field is 1 to 50 characters"
			)
	@Pattern(
			regexp = "^[a-zA-Z0-9_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `0-9`, `_` and `-` are allowed"
			)
	@Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(50)")
	private String name;

	@Getter
	@Setter
	@Column(name = "INAUGURATED")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate inaugurated;

	@Getter
	@Setter
	@Column(name = "UPDATED")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate updated;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "address_fk")
	private Address storeAddress;
	
	@Getter
	@Setter
	@Column(name = "TEAMS")
	@OneToMany(mappedBy = "staffStore")
	private List<Staff> teams;
	
	@Getter
	@Setter
	@Column(name = "CUSTOMERS")
	@OneToMany(mappedBy = "customerStore")
	private List<Customer> customers;
	
	@Getter
	@Setter
	@Column(name = "INVENTORIES")
	@OneToMany(mappedBy = "inventoryStore")
	private List<Inventory> inventories;
}
