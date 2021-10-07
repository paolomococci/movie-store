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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "RENTAL")
public class Rental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@NotNull
	@Column(name = "RENT")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(groups = java.sql.Date.class)
	private LocalDate rent;

	@Getter
	@Setter
	@NotNull
	@Column(name = "BACK")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Future(groups = java.sql.Date.class)
	private LocalDate back;

	@Getter
	@Setter
	@Column(name = "UPDATED")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate updated;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "inventory_fk")
	private Inventory inventory;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "customer_fk")
	private Customer customer;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "staff_fk")
	private Staff staff;
	
	@Getter
	@Setter
	@Column(name = "PAYMENTS")
	@OneToMany(mappedBy = "rental")
	private List<Payment> payments;
}
