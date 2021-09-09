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
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subtitle;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date comeout;

    @JsonFormat(pattern = "HH:mm:ss")
    private Time duration;

    private Double cost;
    private Double rent;
    private Double rating;
    private Timestamp updated;

    /* references to other entities */

    @ManyToOne
    @JoinColumn(name = "language_fk")
    private Language language;

    @OneToMany(mappedBy = "movie")
    private List<Inventory> inventories;

    @ManyToMany
    @JoinTable(
            name = "movie_category",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "movie_content",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "content_id")})
    private List<Content> contents;

    @ManyToMany
    @JoinTable(
            name = "movie_player",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "player_id")})
    private List<Player> players;

    @ManyToMany
    @JoinTable(
            name = "movie_director",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "director_id")})
    private List<Director> directors;

    @ManyToMany
    @JoinTable(
            name = "movie_producer",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "producer_id")})
    private List<Producer> producers;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public Date getComeout() {
        return comeout;
    }

    public Time getDuration() {
        return duration;
    }

    public Double getCost() {
        return cost;
    }

    public Double getRent() {
        return rent;
    }

    public Double getRating() {
        return rating;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComeout(Date comeout) {
        this.comeout = comeout;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    /* getter and setter to references of other entities */

    public Language getLanguage() {
        return language;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Content> getContents() {
        return contents;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }
}
