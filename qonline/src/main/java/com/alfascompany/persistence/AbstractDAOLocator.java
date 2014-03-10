package com.alfascompany.persistence;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDAOLocator {

	private final Map<String, AbstractDAO> DAOsMap = new HashMap<String, AbstractDAO>();

	protected AbstractDAOLocator() {

		for (final DAOHolder DAOHolder : register())
			DAOsMap.put(DAOHolder.getClassName(), DAOHolder.getInstance());
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractEntity> GenericDAO<T> getDAO(final Class<T> EntityClass) {

		return (GenericDAO<T>) DAOsMap.get(EntityClass.getName());
	}

	protected abstract DAOHolder[] register();

	public class DAOHolder {

		private final String className;
		private final AbstractDAO instance;

		public String getClassName() {
			return className;
		}

		public AbstractDAO getInstance() {
			return instance;
		}

		public <T extends AbstractEntity> DAOHolder(final Class<T> EntityClass, final GenericDAO<T> instance) {

			this.className = EntityClass.getName();
			this.instance = instance;
		}
	}
}
