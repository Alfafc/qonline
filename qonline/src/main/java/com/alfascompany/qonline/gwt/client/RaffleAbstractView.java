package com.alfascompany.qonline.gwt.client;

import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.qonline.services.RaffleService;
import com.alfascompany.qonline.services.RaffleServiceAsync;
import com.alfascompany.ui.AbstractEntityView;
import com.alfascompany.ui.AppStrings;
import com.alfascompany.ui.GUIFactory;
import com.alfascompany.utils.TimeUtils;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;

public abstract class RaffleAbstractView<ContainerType extends Panel> extends AbstractEntityView<Raffle, ContainerType> {

	private TextBox keyTextBox;
	private TextBox nameTextBox;
	private TextBox profitPercentageTextBox;
	private TextBox endDateTextBox;
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

		entity.setKey(getKeyTextBox().getText());
		entity.setName(getKeyTextBox().getText());
		entity.setProfitPercentage(Long.valueOf(getProfitPercentageTextBox().getText()));
		entity.setEndDate(TimeUtils.parseDate(getEndDateTextBox().getText()));
	}

	@Override
	protected void bindEntityToControls(final Raffle entity) {
		getKeyTextBox().setText(entity.getKey());
		getNameTextBox().setText(entity.getName());
		getProfitPercentageTextBox().setText(entity.getProfitPercentage() + "%");
		getEndDateTextBox().setText(entity.getEndDateAsString());
	}

	public TextBox getProfitPercentageTextBox() {

		if (profitPercentageTextBox == null)
			profitPercentageTextBox = GUIFactory.createTextBox("12");
		return profitPercentageTextBox;
	}

	public TextBox getKeyTextBox() {

		if (keyTextBox == null)
			keyTextBox = GUIFactory.createTextBox(AppStrings.messages.key());
		return keyTextBox;
	}

	public TextBox getNameTextBox() {

		if (nameTextBox == null)
			nameTextBox = GUIFactory.createTextBox(AppStrings.messages.name());
		return nameTextBox;
	}

	public TextBox getEndDateTextBox() {

		if (endDateTextBox == null)
			endDateTextBox = GUIFactory.createTextBox("140409202355895");
		return endDateTextBox;
	}
}
