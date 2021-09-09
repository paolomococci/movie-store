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

package local.moviestore.publisher.data.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "staff")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String nickname;
	private String surname;
	private String phone;
	private String mobile;

	@Email
	private String email;

	private String username;
	private String password;
	private Boolean active;
	private Timestamp updated;

	/* references to other entities */

	@ManyToOne
	@JoinColumn(name = "address_fk")
	private Address staffAddress;

	@ManyToOne
	@JoinColumn(name = "store_fk")
	private Store staffStore;

	@OneToMany(mappedBy = "staff")
	private List<Rental> rentals;

	@OneToMany(mappedBy = "paymentStaff")
	private List<Payment> payments;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}

	public String getSurname() {
		return surname;
	}

	public String getPhone() {
		return phone;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getActive() {
		return active;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	/* getter and setter to references of other entities */

	public Address getStaffAddress() {
		return staffAddress;
	}

	public Store getStaffStore() {
		return staffStore;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setStaffAddress(Address staffAddress) {
		this.staffAddress = staffAddress;
	}

	public void setStaffStore(Store staffStore) {
		this.staffStore = staffStore;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
}
