package com.alfascompany.qonline.gwt.server;

import java.util.HashMap;
import java.util.Map;

import com.alfascompany.persistence.AbstractDAO;
import com.alfascompany.persistence.GenericDAO;

public class DAOLocator {

	private static Object LOCK_OBJECT = new Object();
	private static DAOLocator instance;
	private final Map<String, AbstractDAO> DAOsMap = new HashMap<String, AbstractDAO>();

	public static DAOLocator instance() {

		synchronized (LOCK_OBJECT) {
			if (instance == null)
				instance = new DAOLocator();
			return instance;
		}
	}

	private DAOLocator() {

		register(RaffleDAO.class, new RaffleDAO());
		register(UserDAO.class, new UserDAO());
	}

	public <T> T getDAO(final Class<T> DAOClass) {

		return (T) DAOsMap.get(DAOClass.getName());
	}

	private <T> void register(final Class<T> DAOClass, final T instance) {

		DAOsMap.put(DAOClass.getName(), (AbstractDAO) instance);
	}
}
