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

package local.moviestore.data.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date payed;

    private Timestamp updated;

    /* references to other entities */

    @ManyToOne
    @JoinColumn(name = "rental_fk")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "customer_fk")
    private Customer paymentCustomer;

    @ManyToOne
    @JoinColumn(name = "staff_fk")
    private Staff paymentStaff;

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getPayed() {
        return payed;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPayed(Date payed) {
        this.payed = payed;
    }

    /* getter and setter to references of other entities */

    public Rental getRental() {
        return rental;
    }

    public Customer getPaymentCustomer() {
        return paymentCustomer;
    }

    public Staff getPaymentStaff() {
        return paymentStaff;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public void setPaymentCustomer(Customer paymentCustomer) {
        this.paymentCustomer = paymentCustomer;
    }

    public void setPaymentStaff(Staff paymentStaff) {
        this.paymentStaff = paymentStaff;
    }
}
