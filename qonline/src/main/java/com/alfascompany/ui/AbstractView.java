package com.alfascompany.ui;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

public abstract class AbstractView<ContainerType extends Panel> {

	private ContainerType container;

	public AbstractView(final ContainerType container) {

		this.container = container;
		addControlsToContainer(container);
	}

	public abstract String getTitle();

	protected abstract void addControlsToContainer(final ContainerType container);
	
	public void setContentOf(final Panel panel){
		panel.clear();
		panel.add(container);
	}

	public void showDialog() {
		
		final DialogBox dialogBox = GUIFactory.createDialogBox(getTitle(), true);
		dialogBox.add(this.container);
		dialogBox.show();
	}
}
