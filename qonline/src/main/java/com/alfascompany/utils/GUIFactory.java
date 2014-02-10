package com.alfascompany.utils;

import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class GUIFactory {

	public static TextBox createTextBox(final String text) {
		final TextBox textBox = new TextBox();
		textBox.setText(text);
		return textBox;
	}

	public static Button createButton(final String text, final ClickHandler handler) {

		final Button button = createButton(text);
		button.addClickHandler(handler);
		return button;
	}

	public static Button createButton(final String text) {
		final Button button = new Button();
		button.setText(text);
		return button;
	}

	public static MenuItem createMenuItem(final MenuBar parentMenu, final String text, final ScheduledCommand command) {

		final MenuItem menuItem = new MenuItem(text, parentMenu);
		menuItem.setScheduledCommand(command);

		parentMenu.addItem(menuItem);
		return menuItem;
	}

	public static Label createLabel(final String text) {
		return new Label(text, true);
	}

	public static Widget createLines(int countLines) {

		final StringBuilder stringBuilder = new StringBuilder();
		while (countLines-- > 0)
			stringBuilder.append("<BR>");
		return new HTML(stringBuilder.toString());
	}

	public static MenuBar createMenu() {
		return new MenuBar();
	}
}
