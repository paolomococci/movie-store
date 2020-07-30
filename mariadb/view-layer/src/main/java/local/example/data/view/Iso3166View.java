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

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.data.view.layout.MainLayout;

@Route(value = "iso3166", layout = MainLayout.class)
@PageTitle(value = "iso3166 view")
public class Iso3166View 
		extends Main {

	private static final long serialVersionUID = 9076892825614946696L;

	@SuppressWarnings("unused")
	private static final String RESTFUL_URI = "";

	public Iso3166View() {
		super();
		// TODO
	}
}
