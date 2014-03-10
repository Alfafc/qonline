package com.alfascompany.qonline.gwt.client;

import java.util.Date;

import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.qonline.services.RaffleService;
import com.alfascompany.qonline.services.RaffleServiceAsync;
import com.alfascompany.ui.AbstractEntityView;
import com.alfascompany.ui.AppStrings;
import com.alfascompany.ui.GUIFactory;
import com.alfascompany.utils.TimeUtils;
import com.google.appengine.api.datastore.Text;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;

public abstract class RaffleAbstractView<ContainerType extends Panel> extends AbstractEntityView<Raffle, ContainerType> {

	private TextBox idTextBox;
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

		entity.setName(getIdTextBox().getText());
		entity.setProfitPercentage(Long.valueOf(getProfitPercentageTextBox().getText()));
		entity.setEndDate(TimeUtils.parseDate(getEndDateTextBox().getText()));
	}

	@Override
	protected void bindEntityToControls(final Raffle entity) {
		getIdTextBox().setText(entity.getId().toString());
		getNameTextBox().setText(entity.getName());
		getProfitPercentageTextBox().setText(entity.getProfitPercentage() + "%");
		getEndDateTextBox().setText(entity.getEndDate().toString());
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

	public TextBox getEndDateTextBox() {

		if (endDateTextBox == null)
			endDateTextBox = GUIFactory.createTextBox(AppStrings.messages.endDate());
		return endDateTextBox;
	}
}
