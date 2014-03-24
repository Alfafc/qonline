package com.alfascompany.persistence;

import java.util.List;
import java.util.Map;

public abstract class GenericDAO<EntityType extends AbstractEntity> extends AbstractDAO {

	public abstract EntityType getEntityById(final String id) throws Exception;

	public abstract Map<Long, EntityType> getEntities(final List<Long> ids) throws Exception;

	public abstract Iterable<EntityType> getEntities(final AbstractQuery<EntityType> query, final int limit)
			throws Exception;

	public abstract void persist(final EntityType domainEntity) throws Exception;

}
