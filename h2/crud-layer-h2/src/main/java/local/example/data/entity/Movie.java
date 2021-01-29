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

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MOVIE")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private long id;

	@Getter
	@Setter
	@Size(min = 1, max = 100, message = "size range of this field is 1 to 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z0-9_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `0-9`, `_` and `-` are allowed"
			)
	@Column(name = "TITLE", nullable = false, columnDefinition = "VARCHAR(100)")
	private String title;

	@Getter
	@Setter
	@Size(max = 100, message = "max of this field is 100 characters")
	@Pattern(
			regexp = "^[a-zA-Z0-9_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `0-9`, `_` and `-` are allowed"
			)
	@Column(name = "SUBTITLE", columnDefinition = "VARCHAR(100)")
	private String subtitle;

	@Getter
	@Setter
	@Size(min = 5, max = 255, message = "size range of this field is 5 to 255 characters")
	@Pattern(
			regexp = "^[a-zA-Z0-9_-]*$", 
			message = "only the characters `a-z`, `A-Z`, `0-9`, `_` and `-` are allowed"
			)
	@Column(name = "DESCRIPTION", nullable = false, columnDefinition = "VARCHAR(255)")
	private String description;

	@Getter
	@Setter
	@Column(name = "DEBUT", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Past(groups = java.sql.Date.class)
	private LocalDate debut;

	@Getter
	@Setter
	@Column(name = "DURATION", nullable = false)
	@JsonFormat(pattern = "HH:mm:ss")
	private Time duration;

	@Getter
	@Setter
	@Column(name = "COST", nullable = false)
	@PositiveOrZero
	private Double cost;

	@Getter
	@Setter
	@Column(name = "RENT", nullable = false)
	@PositiveOrZero
	private Double rent;

	@Getter
	@Setter
	@Column(name = "RANTING", nullable = false)
	@Range(min = 0L, max = 1L, message = "fields between zero and one are allowed")
	private Double rating;

	@Getter
	@Setter
	@Column(name = "UPDATED")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate updated;
	
	@Getter
	@Setter
	@Column(name = "LANGUAGE")
	@ManyToOne
	@JoinColumn(name = "language_fk")
	private Language language;
	
	@Getter
	@Setter
	@Column(name = "INVENTORIES")
	@OneToMany(mappedBy = "movie")
	private List<Inventory> inventories;
	
	@Getter
	@Setter
	@Column(name = "CATEGORIES")
	@ManyToMany
	@JoinTable(
			name = "movie_category",
			joinColumns = {@JoinColumn(name = "movie_id")},
			inverseJoinColumns = {@JoinColumn(name = "category_id")})
	private List<Category> categories;
	
	@Getter
	@Setter
	@Column(name = "CONTENTS")
	@ManyToMany
	@JoinTable(
			name = "movie_content",
			joinColumns = {@JoinColumn(name = "movie_id")},
			inverseJoinColumns = {@JoinColumn(name = "content_id")})
	private List<Category> contents;
	
	@Getter
	@Setter
	@Column(name = "PLAYERS")
	@ManyToMany
	@JoinTable(
			name = "movie_player",
			joinColumns = {@JoinColumn(name = "movie_id")},
			inverseJoinColumns = {@JoinColumn(name = "player_id")})
	private List<Category> players;
}
