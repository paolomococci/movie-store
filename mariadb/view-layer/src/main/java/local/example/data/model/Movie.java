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

package local.example.data.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie 
		extends RepresentationModel<Movie> {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String title;

	@Getter
	@Setter
	private String subtitle;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	private Date comeout;

	@Getter
	@Setter
	private Time duration;

	@Getter
	@Setter
	private Double cost;

	@Getter
	@Setter
	private Double rent;

	@Getter
	@Setter
	private Double rating;
}
