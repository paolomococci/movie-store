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

package local.example.data.view.layout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;

import local.example.data.view.AddressView;
import local.example.data.view.CategoryView;
import local.example.data.view.CityView;
import local.example.data.view.ContentView;
import local.example.data.view.CountryView;
import local.example.data.view.CustomerView;
import local.example.data.view.DistrictView;
import local.example.data.view.InventoryView;
import local.example.data.view.Iso3166View;
import local.example.data.view.LanguageView;
import local.example.data.view.MainView;
import local.example.data.view.MovieView;
import local.example.data.view.PaymentView;
import local.example.data.view.PlayerView;
import local.example.data.view.RentalView;
import local.example.data.view.StaffView;
import local.example.data.view.StoreView;

@Push
@CssImport(value = "style.css")
public class MainLayout 
		extends AppLayout 
		implements AfterNavigationObserver {
	
	private final H1 title;
	private final RouterLink mainView;
	
	private final RouterLink addressView;
	private final RouterLink categoryView;
	private final RouterLink cityView;
	private final RouterLink contentView;
	private final RouterLink coutryView;
	private final RouterLink customerView;
	private final RouterLink districtView;
	private final RouterLink inventoryView;
	private final RouterLink iso3166View;
	private final RouterLink languageView;
	private final RouterLink movieView;
	private final RouterLink paymentView;
	private final RouterLink playerView;
	private final RouterLink rentalView;
	private final RouterLink staffView;	
	private final RouterLink storeView;

	public MainLayout() {
		super();
		this.title = new H1("reactive RESTful web service data accessing");
		this.mainView = new RouterLink("main view", MainView.class);
		this.addressView = new RouterLink("address view", AddressView.class);
		this.categoryView = new RouterLink("category view", CategoryView.class);
		this.cityView = new RouterLink("city view", CityView.class);
		this.contentView = new RouterLink("content view", ContentView.class);
		this.coutryView = new RouterLink("country view", CountryView.class);
		this.customerView = new RouterLink("customer view", CustomerView.class);
		this.districtView = new RouterLink("district view", DistrictView.class);
		this.inventoryView = new RouterLink("inventory view", InventoryView.class);
		this.iso3166View = new RouterLink("iso3166 view", Iso3166View.class);
		this.languageView = new RouterLink("language view", LanguageView.class);
		this.movieView = new RouterLink("movie view", MovieView.class);
		this.paymentView = new RouterLink("payment view", PaymentView.class);
		this.playerView = new RouterLink("player view", PlayerView.class);
		this.rentalView = new RouterLink("rental view", RentalView.class);
		this.staffView = new RouterLink("staff view", StaffView.class);
		this.storeView = new RouterLink("store view", StoreView.class);

		UnorderedList unorderedList = new UnorderedList(
				new ListItem(this.mainView),
				new ListItem(this.addressView),
				new ListItem(this.categoryView),
				new ListItem(this.cityView),
				new ListItem(this.contentView),
				new ListItem(this.coutryView),
				new ListItem(this.customerView),
				new ListItem(this.districtView),
				new ListItem(this.inventoryView),
				new ListItem(this.iso3166View),
				new ListItem(this.languageView),
				new ListItem(this.movieView),
				new ListItem(this.paymentView),
				new ListItem(this.playerView),
				new ListItem(this.rentalView),
				new ListItem(this.staffView),
				new ListItem(this.storeView)
		);

		Header header = new Header(new DrawerToggle(), this.title);
		Nav nav = new Nav(unorderedList);
		
		this.addToNavbar(header);
		this.addToDrawer(nav);
		this.setPrimarySection(Section.DRAWER);
		this.setDrawerOpened(false);
	}

	private RouterLink[] listLinks() {
		return new RouterLink[] {
				this.mainView, 
				this.addressView,  
				this.categoryView, 
				this.cityView, 
				this.contentView, 
				this.coutryView,  
				this.customerView, 
				this.districtView, 
				this.inventoryView, 
				this.iso3166View, 
				this.languageView, 
				this.movieView, 
				this.paymentView, 
				this.playerView, 
				this.rentalView, 
				this.staffView, 
				this.storeView
				};
	}

	@Override
	public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
		for (final RouterLink link : this.listLinks()) {
			if (link.getHighlightCondition().shouldHighlight(link, afterNavigationEvent)) {
				this.title.setText(link.getText());
			}
		}
	}
}
