package com.alfascompany.qonline.gwt.server;

import com.alfascompany.qonline.gwt.client.RaffleService;
import com.alfascompany.qonline.gwt.shared.Raffle;
import com.alfascompany.qonline.gwt.shared.User;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RaffleServiceImpl extends RemoteServiceServlet implements RaffleService {

	private static final long serialVersionUID = -4214505413727960522L;

	public Raffle createRaffle(final User user, final String name, final float percentageProfit) {

		final Raffle raffle = new Raffle();
		raffle.setName(name);
		raffle.setPercentageProfit(percentageProfit);

		DAOLocator.instance().getDAO(RaffleDAO.class).save(raffle);

		return raffle;
	}

	public Raffle getRaffle(String id) {

		return DAOLocator.instance().getDAO(RaffleDAO.class).getById(id);
	}

}
