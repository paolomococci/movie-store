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
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.data.model.Iso3166;
import local.example.data.retrieve.RestfulRetriever;
import local.example.data.view.layout.MainLayout;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;

@Route(value = "iso3166", layout = MainLayout.class)
@PageTitle(value = "iso3166 view")
public class Iso3166View 
		extends Main {

	private static final String RESTFUL_URI = "http://127.0.0.1:8080/";

	private final Grid<Iso3166> iso3166Grid;
	private final RestfulRetriever<Iso3166> iso3166RestfulRetriever;

	public Iso3166View() {
		super();
		Paragraph paragraph = new Paragraph();
		H2 subtitle = new H2("iso3166 view");
		paragraph.add("this is the list of registered country codes");
		Section section = new Section(subtitle, paragraph);
		this.iso3166Grid = new Grid<>();
		this.iso3166RestfulRetriever = new RestfulRetriever<>();
		Button iso3166RetrieveButton = new Button(
				"recovers all country codes",
				VaadinIcon.ARROW_CIRCLE_DOWN_O.create(),
				listener -> {
					try {
						this.iso3166Grid.setItems(
								this.iso3166RestfulRetriever.getListOfItems(URI.create(RESTFUL_URI), "countryCodes")
						);
					} catch (
							ResponseStatusException | IOException exception) {
						exception.printStackTrace();
					}
				});
		iso3166RetrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		this.add(section);
	}
}
