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

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 100, message = "size range of this field is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z-]*$", 
			message = "only the characters `a-z`, `A-Z` and `-` are allowed"
			)
	private String name;

	@Getter
	@Setter
	@Size(max = 100, message = "max of this field is 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z-]*$", 
			message = "only the characters `a-z`, `A-Z` and `-` are allowed"
			)
	private String nickname;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 100, message = "size range of this field is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z-]*$", 
			message = "only the characters `a-z`, `A-Z` and `-` are allowed"
			)
	private String surname;

	@Getter
	@Setter
	@Size(max = 20, message = "max of this field is 20 characters")
	@Pattern(
			regexp = "^[0-9-]*$", 
			message = "only the characters `0-9` and `-` are allowed"
			)
	private String phone;

	@Getter
	@Setter
	@NotNull
	@Size(min = 12, max = 20, message = "size range of this field is 12 to 20 characters")
	@Pattern(
			regexp = "^[0-9-]*$", 
			message = "only the characters `0-9` and `-` are allowed"
			)
	private String mobile;

	@Getter
	@Setter
	@NotNull
	@Email
	@Size(min = 5, max = 50, message = "size range of this field is 5 to 50 characters")
	private String email;

	@Getter
	@Setter
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Past(groups = java.sql.Date.class)
	private Date birthday;

	@Getter
	@Setter
	@NotNull
	private Boolean active;

	@Getter
	private Timestamp updated;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "address_fk")
	private Address customerAddress;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "store_fk")
	private Store customerStore;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "customer")
	private List<Rental> rentals;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "paymentCustomer")
	private List<Payment> payments;
}
