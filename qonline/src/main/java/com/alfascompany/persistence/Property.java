package com.alfascompany.persistence;

public abstract class Property {

	private final String key;

	public String getKey() {
		return key;
	}

	protected Property(final String key) {

		this.key = key;
	}

	protected abstract Accessor getAccessor();

	public Object getValue(final AbstractEntity entity) {

		return getAccessor().getValue(entity);
	}

	public void setValue(final AbstractEntity entity, final Object value) {

		getAccessor().setValue(entity, value);
	}
}