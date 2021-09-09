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
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rent;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date back;

    private Timestamp updated;

    /* references to other entities */

    @ManyToOne
    @JoinColumn(name = "inventory_fk")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "customer_fk")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_fk")
    private Staff staff;

    @OneToMany(mappedBy = "rental")
    private List<Payment> payments;

    public Long getId() {
        return id;
    }

    public Date getRent() {
        return rent;
    }

    public Date getBack() {
        return back;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setRent(Date rent) {
        this.rent = rent;
    }

    public void setBack(Date back) {
        this.back = back;
    }

    /* getter and setter to references of other entities */

    public Inventory getInventory() {
        return inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
