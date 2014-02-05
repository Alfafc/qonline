package com.alfascompany.qonline.gwt.client;

import com.alfascompany.qonline.gwt.shared.Raffle;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;

public class RaffleController {

	private TextBox nameTextBox;
	private TextBox percentageProfitTextBox;

	public FlowPanel getContainer(final Raffle raffle) {

		getNameTextBox().setText(raffle.getName());
		getPercentageProfitTextBox().setText(raffle.getPercentageProfit() + "%");

		final FlowPanel panel = new FlowPanel();
		panel.add(getNameTextBox());
		panel.add(getPercentageProfitTextBox());
		return panel;
	}

	public TextBox getPercentageProfitTextBox() {

		if (percentageProfitTextBox == null)
			percentageProfitTextBox = new TextBox();
		return percentageProfitTextBox;
	}

	public TextBox getNameTextBox() {

		if (nameTextBox == null)
			nameTextBox = new TextBox();
		return nameTextBox;
	}

}
