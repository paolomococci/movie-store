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
import local.example.data.model.Address;
import local.example.data.retrieve.RestfulRetriever;
import local.example.data.view.layout.MainLayout;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;

@Route(value = "address", layout = MainLayout.class)
@PageTitle(value = "address view")
public class AddressView 
		extends Main {

	private static final String RESTFUL_URI = "http://127.0.0.1:8080/";

	private final Grid<Address> addressGrid;
	private final RestfulRetriever<Address> addressRestfulRetriever;

	public AddressView() {
		super();
		Paragraph paragraph = new Paragraph();
		H2 subtitle = new H2("address view");
		paragraph.add("this is the list of registered addresses");
		Section section = new Section(subtitle, paragraph);
		this.addressGrid = new Grid<>();
		this.addressGrid.addColumn(Address::getType).setHeader("type").setTextAlign(ColumnTextAlign.START);
		this.addressGrid.addColumn(Address::getName).setHeader("name").setSortable(true);
		this.addressGrid.addColumn(Address::getCivic).setHeader("civic");
		this.addressGrid.addColumn(Address::getPhone).setHeader("phone");
		this.addressRestfulRetriever = new RestfulRetriever<>();
		Button addressRetrieveButton = new Button(
				"recovers all addresses",
				VaadinIcon.ARROW_CIRCLE_DOWN_O.create(),
				listener -> {
					try {
						this.addressGrid.setItems(
								this.addressRestfulRetriever.getListOfItems(URI.create(RESTFUL_URI), "addresses")
						);
					} catch (
							ResponseStatusException | IOException exception) {
						exception.printStackTrace();
					}
				});
		addressRetrieveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		this.add(section);
	}
}
