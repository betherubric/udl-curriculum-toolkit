/*
 * Copyright 2011-2015 CAST, Inc.
 *
 * This file is part of the UDL Curriculum Toolkit:
 * see <http://udl-toolkit.cast.org>.
 *
 * The UDL Curriculum Toolkit is free software: you can redistribute and/or
 * modify it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * The UDL Curriculum Toolkit is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this software.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cast.isi.panel;

import static org.mockito.Mockito.when;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.junit.Test;

public abstract class SectionCompleteToggleTextLinkTestCase extends
		SectionCompleteToggleLinkTestCase {

	@Test
	public void hasTextLabel() {
		startWicket();
		wicketTester.assertComponent("panel:component:text", Label.class);
	}
	
	@Test
	public void componentIsHiddenWhenConfiguredOff() {
		when(featureService.isSectionToggleTextLinksOn()).thenReturn(false);
		startWicket();
		wicketTester.assertInvisible("panel:component");
	}

	@Override
	protected Panel newComponentTestPanel(String panelId, Component component) {
		return new ComponentTestPanel(panelId, component);
	}

	public class ComponentTestPanel extends Panel {

		private static final long serialVersionUID = 1L;

		public ComponentTestPanel(String id, Component component) {
			super(id);
			add(component);
		}

	}

}