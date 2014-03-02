package com.alfascompany.qonline.gwt.server;

import java.util.ArrayList;
import java.util.List;

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

	public List<Raffle> getRaffles() {
		return getFakeRaffles();
	}
	
	@Deprecated
	public List<Raffle> getFakeRaffles() {

		final List<Raffle> raffles = new ArrayList<Raffle>();
		raffles.add(getById("1"));
		raffles.add(getById("2"));
		raffles.add(getById("3"));
		raffles.add(getById("4"));
		raffles.add(getById("5"));
		return raffles;
	}

}
