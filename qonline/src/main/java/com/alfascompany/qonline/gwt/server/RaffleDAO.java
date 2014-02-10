package com.alfascompany.qonline.gwt.server;

import com.alfascompany.persistence.GenericDAO;
import com.alfascompany.persistence.PersistenceEntity;
import com.alfascompany.qonline.bean.Raffle;

public class RaffleDAO extends GenericDAO<Raffle> {

	@Override
	public Raffle getById(final String id) {
		return getFakeRaffle(id);
	}

	@Override
	protected void saveImpl(final PersistenceEntity<Raffle> entity) {

	}

	@Deprecated
	private Raffle getFakeRaffle(final String id) {
		final Raffle raffle = new Raffle();
		raffle.setName("Name");
		raffle.setProfitPercentage(10f);
		return raffle;
	}

}
