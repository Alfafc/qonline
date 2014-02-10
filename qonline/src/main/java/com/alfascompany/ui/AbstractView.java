package com.alfascompany.ui;

import com.alfascompany.qonline.gwt.client.Messages;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.DialogBox;

public abstract class AbstractView {

	protected final Messages messages = GWT.create(Messages.class);
	private DialogBox dialogBox;

	public DialogBox getViewContainer() {
		if (dialogBox == null) {

			dialogBox = new DialogBox(true);
			dialogBox.setText(getTitle());
			dialogBox.setAnimationEnabled(true);
			dialogBox.setModal(true);
			dialogBox.center();

			getViewContainerImpl(dialogBox);
		}
		return dialogBox;
	}

	public abstract String getTitle();
	
	protected abstract void getViewContainerImpl(final DialogBox dialogBox);
}
