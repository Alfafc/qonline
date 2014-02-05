package com.alfascompany.persistence;

public abstract class GenericDAO<T> extends AbstractDAO {

	public abstract T getById(final String id);

	public abstract void save(final T entity);
}
