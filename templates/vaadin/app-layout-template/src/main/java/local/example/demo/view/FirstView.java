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

package local.example.demo.view;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.demo.view.layout.MainLayout;

@Route(value = "first", layout = MainLayout.class)
@PageTitle(value = "first view")
public class FirstView 
		extends Main {
	
	private static final long serialVersionUID = -8065708225330695536L;

	@SuppressWarnings("unused")
	private static final String RESTFUL_URI = "";

	private final Section section;
	private final H2 subtitle;
	private final Paragraph paragraph;

	public FirstView() {
		super();
		this.paragraph = new Paragraph();
		this.subtitle = new H2("sample of subtitle");
		this.paragraph.add("sample of paragraph");
		this.section = new Section(this.subtitle, this.paragraph);
		this.add(this.section);
	}
}
