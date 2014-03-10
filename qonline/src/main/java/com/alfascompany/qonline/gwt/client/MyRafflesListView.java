package com.alfascompany.qonline.gwt.client;

import java.util.List;

import com.alfascompany.qonline.bean.Raffle;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MyRafflesListView extends RaffleListView {

	@Override
	protected void getRaffles(AsyncCallback<List<Raffle>> asyncCallback) {

		getRaffleService().getRaffles(asyncCallback);
	}

}
