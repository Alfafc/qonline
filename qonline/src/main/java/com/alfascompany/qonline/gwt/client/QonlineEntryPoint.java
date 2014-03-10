package com.alfascompany.qonline.gwt.client;

import com.alfascompany.ui.AppStrings;
import com.alfascompany.ui.GUIFactory;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class QonlineEntryPoint implements EntryPoint {

	private RaffleCreateView raffleView;
	private MyRafflesListView myRafflesListView;
	private WordWideRafflesListView wordWideRafflesListView;

	public void onModuleLoad() {

		final RootPanel rootPanel = RootPanel.get();

		final MenuBar menu = GUIFactory.createMenu();
		rootPanel.add(menu);

		final VerticalPanel principalPanel = GUIFactory.createVerticalPanel();
		principalPanel.addStyleName("centered");
		rootPanel.add(principalPanel);

		GUIFactory.createMenuItem(menu, AppStrings.messages.createRaffle(), new ScheduledCommand() {

			public void execute() {

				if (raffleView == null)
					raffleView = new RaffleCreateView();
				raffleView.setContentOf(principalPanel);
			}
		});

		GUIFactory.createMenuItem(menu, AppStrings.messages.myRaffles(), new ScheduledCommand() {

			public void execute() {

				if (myRafflesListView == null)
					myRafflesListView = new MyRafflesListView();
				myRafflesListView.setContentOf(principalPanel);
			}
		});

		GUIFactory.createMenuItem(menu, AppStrings.messages.wordWideRaffles(), new ScheduledCommand() {

			public void execute() {

				if (wordWideRafflesListView == null)
					wordWideRafflesListView = new WordWideRafflesListView();
				wordWideRafflesListView.setContentOf(principalPanel);
			}
		});
	}
}
