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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@NotNull
	@PositiveOrZero
	private Double amount;

	@Getter
	@Setter
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(groups = java.sql.Date.class)
	private Date payed;

	@Getter
	private Timestamp updated;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "rental_fk")
	private Rental rental;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "customer_fk")
	private Customer paymentCustomer;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "staff_fk")
	private Staff paymentStaff;
}
