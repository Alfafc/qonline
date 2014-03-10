package com.alfascompany.persistence;

public interface Accessor {

	Object getValue(final AbstractEntity entity);

	void setValue(final AbstractEntity entity, final Object value);
}