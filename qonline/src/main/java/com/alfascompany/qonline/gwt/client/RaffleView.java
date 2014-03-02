package com.alfascompany.qonline.gwt.client;

import com.alfascompany.persistence.NotValidEntityException;
import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.qonline.bean.VOID;
import com.alfascompany.ui.AppStrings;
import com.alfascompany.utils.GUIFactory;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RaffleView extends RaffleAbstractView<VerticalPanel> {

	private Button createRaffleButton;

	public RaffleView() {
		super(new VerticalPanel());
	}

	@Override
	protected void addControlsToContainer(final VerticalPanel container) {

		getIdTextBox().setFocus(true);
		getIdTextBox().selectAll();

		container.add(GUIFactory.createLabel(AppStrings.messages.id()));
		container.add(getIdTextBox());
		container.add(GUIFactory.createLabel(AppStrings.messages.name()));
		container.add(getNameTextBox());
		container.add(GUIFactory.createLabel(AppStrings.messages.profitPercentage()));
		container.add(getProfitPercentageTextBox());
		container.add(GUIFactory.createLines(2));
		container.add(getCreateRaffleButton());
		container.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
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
		bindEntityToControls(raffle);

		try {
			raffle.validate();
		} catch (final NotValidEntityException e) {
			com.google.gwt.user.client.Window.alert("(Client side) Create failure with " + e.getMessage());
			return;
		}

		final AsyncCallback<VOID> callback = new AsyncCallback<VOID>() {

			public void onFailure(Throwable caught) {
				com.google.gwt.user.client.Window.alert("(Server side) Create failure with " + caught.getMessage());
			}

			public void onSuccess(VOID result) {
				com.google.gwt.user.client.Window.alert("(Server side) Create successfuly");
			}
		};

		getRaffleService().createRaffle(raffle, callback);
	}
}
