package com.alfascompany.qonline.DAO;

import com.alfascompany.persistence.AbstractDAOLocator;
import com.alfascompany.persistence.GAEDAO;
import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.qonline.bean.RaffleDescriptor;
import com.alfascompany.qonline.bean.User;
import com.alfascompany.qonline.bean.UserDescriptor;

public class DAOLocator extends AbstractDAOLocator {

	private static Object LOCK_OBJECT = new Object();
	private static AbstractDAOLocator instance;

	public static AbstractDAOLocator instance() {

		synchronized (LOCK_OBJECT) {
			if (instance == null)
				instance = new DAOLocator();
			return instance;
		}
	}

	private DAOLocator() {

	}

	@Override
	protected DAOHolder[] register() {
		return new DAOHolder[] {
				new DAOHolder(Raffle.class, GAEDAO.create(new RaffleDescriptor())),
				new DAOHolder(User.class, GAEDAO.create(new UserDescriptor()))
		};
	}
}
