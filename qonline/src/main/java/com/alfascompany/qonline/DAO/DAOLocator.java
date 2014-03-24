package com.alfascompany.qonline.DAO;

import java.io.Serializable;

import com.alfascompany.persistence.AbstractDAOLocator;
import com.alfascompany.qonline.bean.User;
import com.alfascompany.qonline.bean.UserDescriptor;

public class DAOLocator extends AbstractDAOLocator implements Serializable {

	private static final long serialVersionUID = 5849221360226406089L;

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
	protected void registerDAOs() {

		registerDAO(RaffleDAO.class, new RaffleDAO());
		registerGenericDAO(User.class, new UserDescriptor());
	}
}
