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

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Timestamp updated;

    /* references to other entities */

    @ManyToOne
    @JoinColumn(name = "address_fk")
    private Address storeAddress;

    @OneToMany(mappedBy = "staffStore")
    private List<Staff> teams;

    @OneToMany(mappedBy = "customerStore")
    private List<Customer> customers;

    @OneToMany(mappedBy = "inventoryStore")
    private List<Inventory> inventories;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* getter and setter to references of other entities */

    public Address getStoreAddress() {
        return storeAddress;
    }

    public List<Staff> getTeams() {
        return teams;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setStoreAddress(Address storeAddress) {
        this.storeAddress = storeAddress;
    }

    public void setTeams(List<Staff> teams) {
        this.teams = teams;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }
}
