package com.alfascompany.persistence;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDAOLocator {

	private final Map<String, AbstractDAO> DAOsMap = new HashMap<String, AbstractDAO>();

	protected AbstractDAOLocator() {

		registerDAOs();
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractEntity> GenericDAO<T> getGenericDAO(final Class<T> entityClass) {

		return (GenericDAO<T>) DAOsMap.get(entityClass.getName());
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractDAO> T getDAO(final Class<T> DAOClass) {

		return (T) DAOsMap.get(DAOClass.getName());
	}

	protected abstract void registerDAOs();

	public <EntityType extends AbstractEntity> void registerGenericDAO(final Class<EntityType> entityClass,
			final AbstractEntityDescriptor<EntityType> entityDescriptor) {

		DAOsMap.put(entityClass.getName(), new GAEDAO<EntityType>(entityDescriptor));
	}

	public <DAOType extends AbstractDAO> void registerDAO(final Class<DAOType> DAOClass, final DAOType instance) {

		DAOsMap.put(DAOClass.getName(), instance);
	}
}
