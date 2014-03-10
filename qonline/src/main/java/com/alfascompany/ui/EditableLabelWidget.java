package com.alfascompany.ui;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditableLabelWidget extends Widget {

	private Label label;
	private TextBox textbox;

	public EditableLabelWidget(){
		
		this.label = new Label();
		this.textbox = new TextBox();
		
//		this.label.nolll
	}
	
	public void setText(final String value) {

		textbox.setText(value);
		label.setText(value);
	}

}
