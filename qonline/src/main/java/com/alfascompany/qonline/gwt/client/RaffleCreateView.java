package com.alfascompany.qonline.gwt.client;

import com.alfascompany.persistence.NotValidEntityException;
import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.services.VOID;
import com.alfascompany.ui.AppStrings;
import com.alfascompany.ui.GUIFactory;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RaffleCreateView extends RaffleView {

	private Button createRaffleButton;

	@Override
	protected void addControlsToContainer(final VerticalPanel container) {
		super.addControlsToContainer(container);

		container.add(getCreateRaffleButton());
	}

	public Button getCreateRaffleButton() {
		if (createRaffleButton == null) {
			createRaffleButton = GUIFactory.createButton(AppStrings.messages.createRaffle());
			createRaffleButton.addClickHandler(new ClickHandler() {

				public void onClick(final ClickEvent event) {
					createRaffle();
				}
			});
		}
		return createRaffleButton;
	}

	private void createRaffle() {

		final Raffle raffle = new Raffle();
		bindControlsToEntity(raffle);

		try {
			raffle.validate();
		} catch (final NotValidEntityException e) {
			Window.alert("(Client side) Create failure with " + e.getMessage());
			return;
		}

		final AsyncCallback<VOID> callback = new AsyncCallback<VOID>() {

			public void onFailure(Throwable caught) {
				Window.alert("(Server side) Create failure with " + caught.getMessage());
			}

			public void onSuccess(VOID result) {
				Window.alert("(Server side) Create successfuly");
			}
		};

		getRaffleService().createRaffle(raffle, callback);
	}
}
