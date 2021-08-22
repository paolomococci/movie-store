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
@Table(name = "MOVIE")
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
	private List<Category> contents;

	@ManyToMany
	@JoinTable(
			name = "movie_player",
			joinColumns = {@JoinColumn(name = "movie_id")},
			inverseJoinColumns = {@JoinColumn(name = "player_id")})
	private List<Category> players;

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
}
