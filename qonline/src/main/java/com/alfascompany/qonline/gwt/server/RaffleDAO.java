package com.alfascompany.qonline.gwt.server;

import com.alfascompany.persistence.GenericDAO;
import com.alfascompany.qonline.gwt.shared.Raffle;

public class RaffleDAO extends GenericDAO<Raffle> {

	@Override
	public Raffle getById(final String id) {
		return getFakeRaffle(id);
	}

	@Override
	public void save(Raffle entity) {

	}

	private Raffle getFakeRaffle(String id) {
		final Raffle raffle = new Raffle();
		raffle.setId(id);
		raffle.setName("Name");
		raffle.setPercentageProfit(10f);
		return raffle;
	}

}
