package com.alfascompany.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alfascompany.process.Retryable;
import com.alfascompany.process.RetryableFuture;
import com.alfascompany.process.RetryingExecutor;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public final class GAEDAO<T extends AbstractEntity> extends GenericDAO<T> {

	private DatastoreService datastoreService;
	private final AbstractEntityDescriptor<T> entityDescriptor;

	public DatastoreService getDatastoreService() {
		if (datastoreService == null)
			datastoreService = DatastoreServiceFactory.getDatastoreService();
		return datastoreService;
	}

	private GAEDAO(final AbstractEntityDescriptor<T> entityDescriptor) {

		this.entityDescriptor = entityDescriptor;
	}

	public static <EntityType extends AbstractEntity> GAEDAO<EntityType> create(
			final AbstractEntityDescriptor<EntityType> entityDescriptor) {
		return new GAEDAO<EntityType>(entityDescriptor);
	}

	@Override
	public T getEntityById(final String id) throws Exception {

		final Key key = KeyFactory.createKey(entityDescriptor.getKind(), id);
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
	public Iterable<T> getEntities(final AbstractQuery<T> query) throws Exception {

		final GAEQuery<T> GAEQuery = (GAEQuery<T>) query;
		final String kind = entityDescriptor.getKind();

		final Iterable<Entity> entities = RetryingExecutor.execute(4, 150, new RetryableFuture<Iterable<Entity>>() {

			private Iterable<Entity> entities;

			public void run() throws Exception {
				this.entities = getDatastoreService().prepare(GAEQuery.buildGAEQuery(kind)).asIterable();
			}

			public Iterable<Entity> getValue() {
				return this.entities;
			}
		});

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
		final String kind = entityDescriptor.getKind();
		for (final Long id : ids) {
			keys.add(KeyFactory.createKey(kind, id));
		}
		return keys;
	}

	private Entity convertToGAEEntity(final T domainEntity) {

		final Entity entity = new Entity(entityDescriptor.getKind());

		for (final Property property : entityDescriptor.getEntityProperties()) {
			entity.setProperty(property.getKey(), property.getValue(domainEntity));
		}
		return entity;
	}

	private T convertToDomainEntity(final Entity entity) {

		final T domainEntity = entityDescriptor.getNewDomainEntityInstance();

		for (final Property property : entityDescriptor.getEntityProperties()) {
			property.setValue(domainEntity, entity.getProperty(property.getKey()));
		}
		return domainEntity;
	}

	private Iterable<T> convertToDomainEntitiesIterable(final Iterable<Entity> entities) {

		final Iterator<Entity> iterator = entities.iterator();

		return new Iterable<T>() {

			public Iterator<T> iterator() {

				return new Iterator<T>() {

					public boolean hasNext() {
						return iterator.hasNext();
					}

					public T next() {
						return convertToDomainEntity(iterator.next());
					}

					public void remove() {
						iterator.remove();
					}
				};
			}
		};
	}
}
