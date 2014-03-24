package com.alfascompany.qonline.gwt.client;

import java.util.List;

import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.ui.GUIFactory;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.VerticalPanel;

public abstract class RaffleListView extends RaffleAbstractView<VerticalPanel> {

	private Grid grid;

	public RaffleListView() {
		super(GUIFactory.createVerticalPanel());
	}

	@Override
	protected void addControlsToContainer(final VerticalPanel container) {

		final Grid grid = getGrid();
		getRaffles(new AsyncCallback<List<Raffle>>() {

			public void onSuccess(final List<Raffle> raffles) {

				Window.alert("(Server side) Getting raffles succeded [" + raffles.size() + "]");
				fillGrid(grid, raffles);
			}

			public void onFailure(final Throwable caught) {
				Window.alert("(Server side) Getting raffles failed [" + caught + "]");
			}
		});
		container.add(grid);
	}

	protected abstract void getRaffles(AsyncCallback<List<Raffle>> asyncCallback);

	private Grid getGrid() {

		if (grid == null)
			grid = new Grid();
		return grid;
	}

	private void fillGrid(final Grid grid, final Iterable<Raffle> raffles) {
		int rowIndex = 0;
		int columnIndex;
		for (final Raffle raffle : raffles) {
			final RaffleEditView raffleView = new RaffleEditView();
			raffleView.bindEntityToControls(raffle);

			columnIndex = 0;
			grid.resize(rowIndex + 1, 3);
			grid.setWidget(rowIndex, columnIndex++, raffleView.getKeyTextBox());
			grid.setWidget(rowIndex, columnIndex++, raffleView.getNameTextBox());
			grid.setWidget(rowIndex, columnIndex++, raffleView.getProfitPercentageTextBox());
			rowIndex++;
		}
	}
}
