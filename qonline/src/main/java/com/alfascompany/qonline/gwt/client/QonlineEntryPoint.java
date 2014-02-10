package com.alfascompany.qonline.gwt.client;

import com.alfascompany.utils.GUIFactory;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;

public class QonlineEntryPoint implements EntryPoint {

	private final Messages messages = GWT.create(Messages.class);

	public void onModuleLoad() {

		final RaffleController raffleController = new RaffleController();
		final MenuBar menu = GUIFactory.createMenu();

		GUIFactory.createMenuItem(menu, messages.createRaffle(), new ScheduledCommand() {

			public void execute() {
				raffleController.getViewContainer().show();
			}
		});

		RootPanel.get().add(menu);
	}

}
