package com.alfascompany.qonline.gwt.server;

import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.qonline.bean.VOID;
import com.alfascompany.qonline.gwt.client.RaffleService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@RemoteServiceRelativePath("/qonline/raffle")
public class RaffleServiceImpl extends RemoteServiceServlet implements RaffleService {

	private static final long serialVersionUID = -4214505413727960522L;

	public VOID createRaffle(final Raffle raffle) throws Exception {

		DAOLocator.instance().getDAO(RaffleDAO.class).save(raffle);
		return new VOID("SIIII SERVIDOR");
	}

	public Raffle getRaffle(final String id) {

		return DAOLocator.instance().getDAO(RaffleDAO.class).getById(id);
	}

}
