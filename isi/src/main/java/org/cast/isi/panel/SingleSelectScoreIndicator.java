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

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.cast.cwm.data.Response;
import org.cast.isi.component.ScoreIcon;

/**
 * Display an icon and text indicating the user's success on a single-select multiple choice response.
 * @author bgoldowsky
 *
 */
public class SingleSelectScoreIndicator extends Panel {

	private static final long serialVersionUID = 1L;

	public SingleSelectScoreIndicator(String id, IModel<Response> model) {
		this(id, model, true);
	}
	
	public SingleSelectScoreIndicator(String id, IModel<Response> model, boolean showTryCount) {
		super(id, model);
		add(new ScoreIcon("icon", model));
		add(new Label("text", new PropertyModel<String>(model, "triesOrdinal")).setVisibilityAllowed(showTryCount));
		setOutputMarkupId(true);
		setOutputMarkupPlaceholderTag(true);
	}
	
	@Override
	protected void onConfigure() {
		// Score indicator is visible only if the response has been scored.
		setVisible(getModel().getObject() != null && getModel().getObject().getScore() != null);
		super.onConfigure();
	}
	
	@SuppressWarnings("unchecked")
	IModel<Response> getModel() {
		return (IModel<Response>) getDefaultModel();
	}

}
