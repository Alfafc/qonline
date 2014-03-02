package com.alfascompany.qonline.gwt.server;

import java.util.List;

import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.qonline.bean.VOID;
import com.alfascompany.qonline.gwt.client.RaffleService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@RemoteServiceRelativePath("/qonline/raffle")
public class RaffleServiceImpl extends RemoteServiceServlet implements RaffleService {

	private static final long serialVersionUID = -4214505413727960522L;
	private final RaffleDAO dao;

	public RaffleServiceImpl() {
		dao = DAOLocator.instance().getDAO(RaffleDAO.class);
	}

	public VOID createRaffle(final Raffle raffle) throws Exception {

		dao.save(raffle);
		return VOID.value;
	}

	public Raffle getRaffle(final String id) {

		return dao.getById(id);
	}

	public List<Raffle> getRaffles() {
		
		return dao.getRaffles();
	}

}
