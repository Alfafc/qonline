package com.alfascompany.qonline.gwt.client;

import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.ui.AbstractEntityView;
import com.alfascompany.utils.GUIFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public abstract class RaffleView extends AbstractEntityView<Raffle> {

	private TextBox idTextBox;
	private TextBox nameTextBox;
	private TextBox profitPercentageTextBox;
	private Button createRaffleButton;

	private final RaffleServiceAsync raffleService = GWT.create(RaffleService.class);

	public RaffleServiceAsync getRaffleService() {
		return raffleService;
	}

	@Override
	public String getTitle() {
		return messages.raffle();
	}

	@Override
	protected void bindControlsToEntity(final Raffle entity) {

		entity.setName(getIdTextBox().getText());
		entity.setProfitPercentage(Long.valueOf(getProfitPercentageTextBox().getText()));
	}

	@Override
	protected void bindEntityToControls(final Raffle entity) {
		getIdTextBox().setText(entity.getId());
		getNameTextBox().setText(entity.getName());
		getProfitPercentageTextBox().setText(entity.getProfitPercentage() + "%");
	}

	public Button getCreateRaffleButton() {
		if (createRaffleButton == null)
			createRaffleButton = GUIFactory.createButton(messages.createRaffle());
		return createRaffleButton;
	}

	public TextBox getProfitPercentageTextBox() {

		if (profitPercentageTextBox == null)
			profitPercentageTextBox = GUIFactory.createTextBox(messages.profitPercentage());
		return profitPercentageTextBox;
	}

	public TextBox getIdTextBox() {

		if (idTextBox == null)
			idTextBox = GUIFactory.createTextBox(messages.id());
		return idTextBox;
	}

	public TextBox getNameTextBox() {

		if (nameTextBox == null)
			nameTextBox = GUIFactory.createTextBox(messages.name());
		return nameTextBox;
	}
}
