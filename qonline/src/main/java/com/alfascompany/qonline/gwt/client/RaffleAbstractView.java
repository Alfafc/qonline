package com.alfascompany.qonline.gwt.client;

import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.ui.AbstractEntityView;
import com.alfascompany.ui.AppStrings;
import com.alfascompany.utils.GUIFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;

public abstract class RaffleAbstractView<ContainerType extends Panel> extends AbstractEntityView<Raffle, ContainerType> {

	private TextBox idTextBox;
	private TextBox nameTextBox;
	private TextBox profitPercentageTextBox;
	private RaffleServiceAsync raffleService;

	public RaffleServiceAsync getRaffleService() {
		if (raffleService == null)
			raffleService = GWT.create(RaffleService.class);
		return raffleService;
	}

	@Override
	public String getTitle() {
		return AppStrings.messages.raffle();
	}

	public RaffleAbstractView(final ContainerType container) {
		super(container);
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

	public TextBox getProfitPercentageTextBox() {

		if (profitPercentageTextBox == null)
			profitPercentageTextBox = GUIFactory.createTextBox(AppStrings.messages.profitPercentage());
		return profitPercentageTextBox;
	}

	public TextBox getIdTextBox() {

		if (idTextBox == null)
			idTextBox = GUIFactory.createTextBox(AppStrings.messages.id());
		return idTextBox;
	}

	public TextBox getNameTextBox() {

		if (nameTextBox == null)
			nameTextBox = GUIFactory.createTextBox(AppStrings.messages.name());
		return nameTextBox;
	}
}
