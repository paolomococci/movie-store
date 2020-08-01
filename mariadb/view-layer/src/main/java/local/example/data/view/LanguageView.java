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

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.data.view.layout.MainLayout;

@Route(value = "language", layout = MainLayout.class)
@PageTitle(value = "language view")
public class LanguageView 
		extends Main {

	private static final String RESTFUL_URI = "";

	public LanguageView() {
		super();
		Paragraph paragraph = new Paragraph();
		H2 subtitle = new H2("language view");
		paragraph.add("sample of paragraph");
		Section section = new Section(subtitle, paragraph);
		this.add(section);
	}
}
