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

		final RaffleView raffleController = new RaffleView();
		final RaffleList raffleList = new RaffleList();

		final MenuBar menu = GUIFactory.createMenu();
		RootPanel.get().add(menu);

		GUIFactory.createMenuItem(menu, messages.createRaffle(), new ScheduledCommand() {

			public void execute() {
				raffleController.showDialog();
			}
		});

		GUIFactory.createMenuItem(menu, messages.raffleList(), new ScheduledCommand() {

			public void execute() {
				raffleList.showDialog();
			}
		});
	}
}
