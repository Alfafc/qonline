package com.alfascompany.qonline.gwt.client;

import com.alfascompany.ui.AppStrings;
import com.alfascompany.ui.GUIFactory;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RaffleView extends RaffleAbstractView<VerticalPanel> {

	public RaffleView() {
		super(GUIFactory.createVerticalPanel());
	}

	@Override
	protected void addControlsToContainer(final VerticalPanel container) {
	
		getKeyTextBox().setFocus(true);
		getKeyTextBox().selectAll();
	
		container.add(GUIFactory.createLabel(AppStrings.messages.key()));
		container.add(getKeyTextBox());
		container.add(GUIFactory.createLabel(AppStrings.messages.name()));
		container.add(getNameTextBox());
		container.add(GUIFactory.createLabel(AppStrings.messages.profitPercentage()));
		container.add(getProfitPercentageTextBox());
		container.add(GUIFactory.createLabel(AppStrings.messages.endDate()));
		container.add(getEndDateTextBox());
		container.add(GUIFactory.createLines(2));
		container.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
	}

}
