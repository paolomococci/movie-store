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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String name;
    private String civic;
    private String phone;
    private Timestamp updated;

    /* references to other entities */

    @ManyToOne
    @JoinColumn(name = "district_fk")
    private District district;

    @OneToMany(mappedBy = "storeAddress")
    private List<Store> stores;

    @OneToMany(mappedBy = "staffAddress")
    private List<Staff> staff;

    @OneToMany(mappedBy = "customerAddress")
    private List<Customer> residents;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getCivic() {
        return civic;
    }

    public String getPhone() {
        return phone;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCivic(String civic) {
        this.civic = civic;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /* getter and setter to references of other entities */

    public District getDistrict() {
        return district;
    }

    public List<Store> getStores() {
        return stores;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public List<Customer> getResidents() {
        return residents;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    public void setResidents(List<Customer> residents) {
        this.residents = residents;
    }
}
