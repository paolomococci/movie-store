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
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp updated;

    /* references to other entities */

    @ManyToOne
    @JoinColumn(name = "store_fk")
    private Store inventoryStore;

    @ManyToOne
    @JoinColumn(name = "movie_fk")
    private Movie movie;

    @OneToMany(mappedBy = "inventory")
    private List<Rental> rentals;

    public Long getId() {
        return id;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    /* getter and setter to references of other entities */

    public Store getInventoryStore() {
        return inventoryStore;
    }

    public Movie getMovie() {
        return movie;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setInventoryStore(Store inventoryStore) {
        this.inventoryStore = inventoryStore;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }
}
