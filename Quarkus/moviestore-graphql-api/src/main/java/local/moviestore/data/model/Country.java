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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Timestamp updated;

    /* references to other entities */

    @ManyToOne
    private Iso3166 iso3166;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

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

    public Iso3166 getIso3166() {
        return iso3166;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setIso3166(Iso3166 iso3166) {
        this.iso3166 = iso3166;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
