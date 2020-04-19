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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@NotNull
	@Size(min = 1, max = 100, message = "range of this value is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z0-9_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `0-9`, `_` and `-` are allowed"
			)
	private String title;

	@Getter
	@Setter
	@Size(min = 1, max = 100, message = "range of this value is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z0-9_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `0-9`, `_` and `-` are allowed"
			)
	private String subtitle;

	@Getter
	@Setter
	@NotNull
	@Size(min = 5, max = 255, message = "range of this value is 5 to 255 characters")
	@Pattern(
			regexp = "^[a-zA-Z0-9_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `0-9`, `_` and `-` are allowed"
			)
	private String desciption;

	@Getter
	@Setter
	@NotNull
	private Date comeout;

	@Getter
	@Setter
	@NotNull
	@Positive
	private Time duration;

	@Getter
	@Setter
	@NotNull
	@PositiveOrZero
	private Double cost;

	@Getter
	@Setter
	@NotNull
	@PositiveOrZero
	private Double rent;

	@Getter
	@Setter
	@NotNull
	@PositiveOrZero
	private Double rating;

	@Getter
	private Timestamp updated;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "language_fk")
	private Language language;
	
	@Getter
	@Setter
	@ManyToMany
	@JoinTable(
			name = "movie_category",
			joinColumns = {@JoinColumn(name = "movie_id")},
			inverseJoinColumns = {@JoinColumn(name = "category_id")})
	private List<Category> categories;
	
	@Getter
	@Setter
	@ManyToMany
	@JoinTable(
			name = "movie_content",
			joinColumns = {@JoinColumn(name = "movie_id")},
			inverseJoinColumns = {@JoinColumn(name = "content_id")})
	private List<Category> contents;
	
	@Getter
	@Setter
	@ManyToMany
	@JoinTable(
			name = "movie_player",
			joinColumns = {@JoinColumn(name = "movie_id")},
			inverseJoinColumns = {@JoinColumn(name = "player_id")})
	private List<Category> players;
}
