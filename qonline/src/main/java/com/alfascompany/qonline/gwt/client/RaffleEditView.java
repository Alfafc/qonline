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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class RaffleEditView extends RaffleView {
	private Button saveRaffleButton;
	private Label idLabel;
	private Label nameLabel;
	private Label profitPercentageLabel;

	@Override
	protected void addControlsToContainer(final VerticalPanel container) {

		container.add(GUIFactory.createLabel(AppStrings.messages.key()));
		container.add(getIdLabel());
		container.add(GUIFactory.createLabel(AppStrings.messages.name()));
		container.add(getNameLabel());
		container.add(GUIFactory.createLabel(AppStrings.messages.profitPercentage()));
		container.add(getProfitPercentageLabel());
		container.add(getProfitPercentageTextBox());
		container.add(GUIFactory.createLines(2));
		container.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);

//		getProfitPercentageTextBox().setVisible(false);

		container.add(getSaveRaffleButton());
	}

	private Widget getIdLabel() {

		if (idLabel == null) {
			idLabel = GUIFactory.createLabel();
		}
		return idLabel;
	}

	private Widget getNameLabel() {

		if (nameLabel == null) {
			nameLabel = GUIFactory.createLabel();
		}
		return nameLabel;
	}

	private Widget getProfitPercentageLabel() {

		if (profitPercentageLabel == null) {
			profitPercentageLabel = GUIFactory.createLabel();
//			profitPercentageLabel.addClickListener(new ClickListener() {
//
//				@Deprecated
//				public void onClick(final Widget sender) {
//
//					profitPercentageLabel.setVisible(false);
//					getProfitPercentageTextBox().setVisible(true);
//				}
//			});
//			getProfitPercentageTextBox().addBlurHandler(new BlurHandler() {
//
//				public void onBlur(BlurEvent event) {
//					profitPercentageLabel.setVisible(true);
//					getProfitPercentageTextBox().setVisible(false);
//				}
//			});
		}
		return profitPercentageLabel;
	}

	public Button getSaveRaffleButton() {
		if (saveRaffleButton == null) {
			saveRaffleButton = GUIFactory.createButton(AppStrings.messages.save());
			saveRaffleButton.addClickHandler(new ClickHandler() {

				public void onClick(final ClickEvent event) {
					saveRaffle();
				}
			});
		}
		return saveRaffleButton;
	}

	private void saveRaffle() {

		final Raffle raffle = new Raffle();
		bindEntityToControls(raffle);

		try {
			raffle.validate();
		} catch (final NotValidEntityException e) {
			Window.alert("(Client side) Save failure with [" + e + "]");
			return;
		}

		final AsyncCallback<VOID> callback = new AsyncCallback<VOID>() {

			public void onFailure(final Throwable caught) {
				Window.alert("(Server side) Save failure with [" + caught + "]");
			}

			public void onSuccess(final VOID result) {
				Window.alert("(Server side) Save successfuly");
			}
		};

		getRaffleService().persistRaffle(raffle, callback);
	}

}
