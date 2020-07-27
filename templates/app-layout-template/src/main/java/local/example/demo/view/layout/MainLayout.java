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

package local.example.demo.view.layout;

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

import local.example.demo.view.FifthView;
import local.example.demo.view.FirstView;
import local.example.demo.view.FourthView;
import local.example.demo.view.ItemView;
import local.example.demo.view.MainView;
import local.example.demo.view.SecondView;
import local.example.demo.view.ThirdView;

@Push
@CssImport(value = "style.css")
public class MainLayout 
		extends AppLayout 
		implements AfterNavigationObserver {

	private static final long serialVersionUID = 8822844864605786754L;

	private final H1 title;
	private final RouterLink mainView;
	private final RouterLink firstView;
	private final RouterLink secondView;
	private final RouterLink thirdView;
	private final RouterLink fourthView;
	private final RouterLink fifthView;
	private final RouterLink itemView;
	private final UnorderedList unorderedList;
	private final Header header;
	private final Nav nav;

	public MainLayout() {
		super();
		
		this.title = new H1("reactive RESTful web service data accessing");
		
		this.mainView = new RouterLink("main view", MainView.class);
		this.firstView = new RouterLink("first view", FirstView.class);
		this.secondView = new RouterLink("second view", SecondView.class);
		this.thirdView = new RouterLink("third view", ThirdView.class);
		this.fourthView = new RouterLink("fourth view", FourthView.class);
		this.fifthView = new RouterLink("fifth view", FifthView.class);
		this.itemView = new RouterLink("item view", ItemView.class);
		
		this.unorderedList = new UnorderedList(
				new ListItem(this.mainView), 
				new ListItem(this.firstView),  
				new ListItem(this.secondView), 
				new ListItem(this.thirdView), 
				new ListItem(this.fourthView), 
				new ListItem(this.fifthView),  
				new ListItem(this.itemView)
		);
		
		this.header = new Header(new DrawerToggle(), this.title);
		this.nav = new Nav(this.unorderedList);
		
		this.addToNavbar(this.header);
		this.addToDrawer(this.nav);
		this.setPrimarySection(Section.DRAWER);
		this.setDrawerOpened(false);
	}

	private RouterLink[] listLinks() {
		return new RouterLink[] {
				this.mainView, 
				this.firstView,  
				this.secondView, 
				this.thirdView, 
				this.fourthView, 
				this.fifthView,  
				this.itemView
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
