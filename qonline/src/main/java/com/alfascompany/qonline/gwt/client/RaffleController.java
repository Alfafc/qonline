package com.alfascompany.qonline.gwt.client;

import com.alfascompany.persistence.NotValidEntityException;
import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.qonline.bean.VOID;
import com.alfascompany.utils.GUIFactory;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RaffleController extends RaffleView {

	@Override
	protected void getViewContainerImpl(final DialogBox dialogBox) {

		getIdTextBox().setFocus(true);
		getIdTextBox().selectAll();

		final VerticalPanel panel = new VerticalPanel();
		panel.add(GUIFactory.createLabel(messages.id()));
		panel.add(getIdTextBox());
		panel.add(GUIFactory.createLabel(messages.name()));
		panel.add(getNameTextBox());
		panel.add(GUIFactory.createLabel(messages.percentageProfit()));
		panel.add(getPercentageProfitTextBox());
		panel.add(GUIFactory.createLines(2));
		panel.add(getCreateRaffleButton());
		panel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		
		dialogBox.add(panel);

		getCreateRaffleButton().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {

				
				final Raffle raffle = new Raffle();
				bindEntityToControls(raffle);
				
				try {
					raffle.validate();
				} catch (final NotValidEntityException e) {
					
					return;
				}
				
				final AsyncCallback<VOID> callback = new AsyncCallback<VOID>() {
					
					public void onFailure(Throwable caught) {
						com.google.gwt.user.client.Window.alert("Create failure with " + caught.getMessage());
					}
					
					public void onSuccess(VOID result) {
						com.google.gwt.user.client.Window.alert("Create succes with " + result.a);
					}
					
				};
				
				getRaffleService().createRaffle(raffle, callback);
			}
		});
	}

}
