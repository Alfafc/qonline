package com.alfascompany.qonline.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alfascompany.qonline.DAO.DAOLocator;
import com.alfascompany.qonline.DAO.RaffleDAO;
import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.services.VOID;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RaffleServiceImpl extends RemoteServiceServlet implements RaffleService {

	private static final long serialVersionUID = -4214505413727960522L;

	private final RaffleDAO dao;

	public RaffleServiceImpl() {
		dao = DAOLocator.instance().getDAO(RaffleDAO.class);
	}

	public VOID persistRaffle(final Raffle raffle) throws Exception {

		dao.persist(raffle);
		return VOID.value;
	}

	public Raffle getRaffle(final String id) throws Exception {

		return dao.getEntityById(id);
	}

	public List<Raffle> getRaffles() throws Exception {

		// TODO: definir como mierda queremos que funcionen las querys
		// dao.getLastWorldWideRaffles()

		final ArrayList<Raffle> list = new ArrayList<Raffle>();
		final Iterator<Raffle> iterator = dao.getLastWorldWideRaffles().iterator();

		while (iterator.hasNext())
			list.add(iterator.next());

		return list;
	}

}
