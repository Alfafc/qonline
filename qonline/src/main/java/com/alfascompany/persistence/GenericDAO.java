package com.alfascompany.persistence;

import com.alfascompany.proccess.RetryingExecutor;

public abstract class GenericDAO<T> extends AbstractDAO {

	public abstract PersistenceEntity<T> getById(final String id);

	protected abstract void saveImpl(PersistenceEntity<T> entity);

	public void save(final PersistenceEntity<T> entity) throws Exception {

		entity.validate();

		entity.setLastModifiedDate();

		RetryingExecutor.execute(4, 150, new Runnable() {

			public void run() {
				saveImpl(entity);
			}
		});
	}

}
