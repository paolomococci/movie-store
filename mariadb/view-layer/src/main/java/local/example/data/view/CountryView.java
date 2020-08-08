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

package local.example.data.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.data.model.Country;
import local.example.data.retrieve.RestfulRetriever;
import local.example.data.view.layout.MainLayout;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;

@Route(value = "country", layout = MainLayout.class)
@PageTitle(value = "country view")
public class CountryView 
		extends Main {

	private static final String RESTFUL_URI = "http://127.0.0.1:8080/";

	private final Grid<Country> countryGrid;
	private final RestfulRetriever<Country> countryRestfulRetriever;

	public CountryView() {
		super();
		Paragraph paragraph = new Paragraph();
		H2 subtitle = new H2("country view");
		paragraph.add("this is the list of registered countries");
		Section introductionSection = new Section(subtitle, paragraph);
		this.countryGrid = new Grid<>();
		this.countryGrid.addColumn(Country::getName)
				.setHeader("name")
				.setSortable(true)
				.setTextAlign(ColumnTextAlign.START);
		this.countryRestfulRetriever = new RestfulRetriever<>();
		Button countryRetrieveButton = new Button(
				"recovers all countries",
				VaadinIcon.ARROW_CIRCLE_DOWN_O.create(),
				listener -> {
					try {
						this.countryGrid.setItems(
								this.countryRestfulRetriever.getListOfItems(URI.create(RESTFUL_URI), "countries")
						);
					} catch (
							ResponseStatusException | IOException exception) {
						exception.printStackTrace();
					}
				});
		countryRetrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		Section countrySectionView = new Section(countryRetrieveButton, this.countryGrid);
		this.add(introductionSection, countrySectionView);
	}
}
