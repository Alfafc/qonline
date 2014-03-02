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

	public void showDialog() {
		
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setAutoHideEnabled(true);
		dialogBox.setText(getTitle());
		dialogBox.setAnimationEnabled(true);
		dialogBox.setModal(true);
		dialogBox.center();

		dialogBox.add(this.container);
		
		dialogBox.show();
	}
}
