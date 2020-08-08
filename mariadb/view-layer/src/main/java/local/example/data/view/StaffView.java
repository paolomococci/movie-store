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

import local.example.data.model.Staff;
import local.example.data.retrieve.RestfulRetriever;
import local.example.data.view.layout.MainLayout;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;

@Route(value = "staff", layout = MainLayout.class)
@PageTitle(value = "staff view")
public class StaffView 
		extends Main {

	private static final String RESTFUL_URI = "http://127.0.0.1:8080/";

	private final Grid<Staff> staffGrid;
	private final RestfulRetriever<Staff> staffRestfulRetriever;

	public StaffView() {
		super();
		Paragraph paragraph = new Paragraph();
		H2 subtitle = new H2("staff view");
		paragraph.add("this is the list of registered teams");
		Section introductionSection = new Section(subtitle, paragraph);
		this.staffGrid = new Grid<>();
		this.staffGrid.addColumn(Staff::getName)
				.setHeader("name")
				.setSortable(true)
				.setTextAlign(ColumnTextAlign.START);
		this.staffGrid.addColumn(Staff::getNickname).setHeader("nickname");
		this.staffGrid.addColumn(Staff::getSurname).setHeader("surname");
		this.staffGrid.addColumn(Staff::getEmail).setHeader("email");
		this.staffGrid.addColumn(Staff::getMobile).setHeader("mobile");
		this.staffRestfulRetriever = new RestfulRetriever<>();
		Button staffRetrieveButton = new Button(
				"recovers all teams",
				VaadinIcon.ARROW_CIRCLE_DOWN_O.create(),
				listener -> {
					try {
						this.staffGrid.setItems(
								this.staffRestfulRetriever.getListOfItems(URI.create(RESTFUL_URI), "teams")
						);
					} catch (
							ResponseStatusException | IOException exception) {
						exception.printStackTrace();
					}
				});
		staffRetrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		Section staffSectionView = new Section(staffRetrieveButton, this.staffGrid);
		this.add(introductionSection, staffSectionView);
	}
}
