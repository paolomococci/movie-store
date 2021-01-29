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
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(
		name = "CUSTOMER",
		uniqueConstraints = @UniqueConstraint(columnNames = {"MOBILE"})
)
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@Size(min = 1, max = 100, message = "size range of this field is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z-]*$", 
			message = "only the characters `a-z`, `A-Z` and `-` are allowed"
			)
	@Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(100)")
	private String name;

	@Getter
	@Setter
	@Size(max = 100, message = "max of this field is 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z-]*$", 
			message = "only the characters `a-z`, `A-Z` and `-` are allowed"
			)
	@Column(name = "NICKNAME", columnDefinition = "VARCHAR(100)")
	private String nickname;

	@Getter
	@Setter
	@Size(min = 1, max = 100, message = "size range of this field is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z-]*$", 
			message = "only the characters `a-z`, `A-Z` and `-` are allowed"
			)
	@Column(name = "SURNAME", nullable = false, columnDefinition = "VARCHAR(100)")
	private String surname;

	@Getter
	@Setter
	@Size(max = 20, message = "max of this field is 20 characters")
	@Pattern(
			regexp = "^[0-9-]*$", 
			message = "only the characters `0-9` and `-` are allowed"
			)
	@Column(name = "PHONE", columnDefinition = "VARCHAR(20)")
	private String phone;

	@Getter
	@Setter
	@Size(min = 12, max = 20, message = "size range of this field is 12 to 20 characters")
	@Pattern(
			regexp = "^[0-9-]*$", 
			message = "only the characters `0-9` and `-` are allowed"
			)
	@Column(name = "MOBILE", unique = true, nullable = false, columnDefinition = "VARCHAR(20)")
	private String mobile;

	@Getter
	@Setter
	@Email
	@Size(min = 5, max = 50, message = "size range of this field is 5 to 50 characters")
	@Column(name = "EMAIL", nullable = false, columnDefinition = "VARCHAR(50)")
	private String email;

	@Getter
	@Setter
	@Column(name = "BIRTHDAY", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Past(groups = java.sql.Date.class)
	private LocalDate birthday;

	@Getter
	@Setter
	@Column(name = "ACTIVE", nullable = false)
	private Boolean active;

	@Getter
	@Setter
	@Column(name = "UPDATED")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate updated;
	
	@Getter
	@Setter
	@Column(name = "CUSTOMER_ADDRESS")
	@ManyToOne
	@JoinColumn(name = "address_fk")
	private Address customerAddress;
	
	@Getter
	@Setter
	@Column(name = "CUSTOMER_STORE")
	@ManyToOne
	@JoinColumn(name = "store_fk")
	private Store customerStore;
	
	@Getter
	@Setter
	@Column(name = "RENTALS")
	@OneToMany(mappedBy = "customer")
	private List<Rental> rentals;
	
	@Getter
	@Setter
	@Column(name = "PAYMENTS")
	@OneToMany(mappedBy = "paymentCustomer")
	private List<Payment> payments;
}
