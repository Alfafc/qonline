package com.alfascompany.qonline.gwt.client;

import java.util.List;

import com.alfascompany.qonline.bean.Raffle;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RaffleList extends RaffleAbstractView<VerticalPanel> {

	private Grid grid;

	public RaffleList() {
		super(new VerticalPanel());
	}

	@Override
	protected void addControlsToContainer(final VerticalPanel container) {

		final Grid grid = getGrid();

		getRaffles(new AsyncCallback<List<Raffle>>() {

			public void onSuccess(final List<Raffle> raffles) {

				int rowIndex = 0;
				int columnIndex;
				for (final Raffle raffle : raffles) {
					final RaffleView raffleView = new RaffleView();
					raffleView.bindEntityToControls(raffle);

					columnIndex = 0;
					grid.setWidget(rowIndex, columnIndex, raffleView.getIdTextBox());
					grid.setWidget(rowIndex, columnIndex++, raffleView.getNameTextBox());
					grid.setWidget(rowIndex, columnIndex++, raffleView.getProfitPercentageTextBox());
					rowIndex++;
				}

			}

			public void onFailure(final Throwable caught) {

			}
		});

		container.add(grid);
	}

	private void getRaffles(final AsyncCallback<List<Raffle>> callback) {

		getRaffleService().getRaffles(callback);
	}

	private Grid getGrid() {

		if (grid == null)
			grid = new Grid(5, 5);
		return grid;
	}

}
