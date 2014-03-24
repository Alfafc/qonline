package com.alfascompany.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alfascompany.process.Retryable;
import com.alfascompany.process.RetryableFuture;
import com.alfascompany.process.RetryingExecutor;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

public class GAEDAO<T extends AbstractEntity> extends GenericDAO<T> implements Serializable {

	private static final long serialVersionUID = 1223334397881621949L;

	private DatastoreService datastoreService;
	private final AbstractEntityDescriptor<T> entityDescriptor;

	public DatastoreService getDatastoreService() {
		if (datastoreService == null)
			datastoreService = DatastoreServiceFactory.getDatastoreService();
		return datastoreService;
	}

	public GAEDAO() {

		this.entityDescriptor = null;
	}

	protected GAEDAO(final AbstractEntityDescriptor<T> entityDescriptor) {

		this.entityDescriptor = entityDescriptor;
	}

	@Override
	public T getEntityById(final String id) throws Exception {

		final Key key = KeyFactory.createKey(getEntityDescriptor().getKind(), id);
		final Entity entity = RetryingExecutor.execute(4, 150, new RetryableFuture<Entity>() {

			private Entity entity;

			public void run() throws Exception {
				this.entity = getDatastoreService().get(key);
			}

			public Entity getValue() {
				return this.entity;
			}
		});

		return convertToDomainEntity(entity);
	}

	@Override
	public Map<Long, T> getEntities(final List<Long> ids) throws Exception {

		// TODO: hacer que sea lazy la lista que devuelve
		final Map<Key, Entity> entities = RetryingExecutor.execute(4, 150, new RetryableFuture<Map<Key, Entity>>() {

			private Map<Key, Entity> entities;

			public void run() throws Exception {
				this.entities = getDatastoreService().get(buildKeys(ids));
			}

			public Map<Key, Entity> getValue() {
				return this.entities;
			}
		});

		final Map<Long, T> domainEntities = new HashMap<Long, T>(entities.size());

		for (final Entry<Key, Entity> entry : entities.entrySet())
			domainEntities.put(entry.getKey().getId(), convertToDomainEntity(entry.getValue()));
		return domainEntities;
	}

	@Override
	public Iterable<T> getEntities(final AbstractQuery<T> query, final int limit) throws Exception {

		final GAEQuery<T> GAEQuery = (GAEQuery<T>) query;
		final String kind = getEntityDescriptor().getKind();

		final Iterable<Entity> entities = RetryingExecutor.execute(4, 150, new RetryableFuture<Iterable<Entity>>() {

			private Iterable<Entity> entities;

			public void run() throws Exception {
				final Query buildGAEQuery = GAEQuery.buildGAEQuery(kind);

				final FetchOptions options = FetchOptions.Builder.withLimit(limit);
				this.entities = getDatastoreService().prepare(buildGAEQuery).asIterable(options);
			}

			public Iterable<Entity> getValue() {
				return this.entities;
			}
		});

		System.err.println("Trying to convert to domain entities");
		return convertToDomainEntitiesIterable(entities);
	}

	@Override
	public void persist(final T domainEntity) throws Exception {

		domainEntity.validate();

		domainEntity.prepareToPersist();

		RetryingExecutor.execute(4, 150, new Retryable() {

			public void run() {

				getDatastoreService().put(convertToGAEEntity(domainEntity));
			}

		});
	}

	private List<Key> buildKeys(final List<Long> ids) {

		final List<Key> keys = new ArrayList<Key>(ids.size());
		final String kind = getEntityDescriptor().getKind();
		for (final Long id : ids) {
			keys.add(KeyFactory.createKey(kind, id));
		}
		return keys;
	}

	private Entity convertToGAEEntity(final T domainEntity) {

		final Entity entity = new Entity(getEntityDescriptor().getKind());

		for (final Property property : getEntityDescriptor().getEntityProperties()) {
			entity.setProperty(property.getKey(), property.getValue(domainEntity));
		}
		return entity;
	}

	//TODO: sacar
	public T convertToDomainEntity(final Entity entity) {

		final T domainEntity = getEntityDescriptor().getNewDomainEntityInstance();

		for (final Property property : getEntityDescriptor().getEntityProperties()) {
			property.setValue(domainEntity, entity.getProperty(property.getKey()));
		}
		return domainEntity;
	}

	private IterableSerializable<T> convertToDomainEntitiesIterable(final Iterable<Entity> entities) {

		return new IterableSerializable<T>(entities.iterator(), this);
	}

	public AbstractEntityDescriptor<T> getEntityDescriptor() {
		return entityDescriptor;
	}
}
