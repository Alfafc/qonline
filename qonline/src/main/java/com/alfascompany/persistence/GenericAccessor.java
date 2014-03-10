package com.alfascompany.persistence;

public abstract class GenericAccessor<EntityType extends AbstractEntity, PropertyType> implements Accessor {

	public abstract PropertyType getTypedValue(final EntityType entity);

	public abstract void setTypedValue(final EntityType entity, final PropertyType value);

	@SuppressWarnings("unchecked")
	public Object getValue(final AbstractEntity entity) {
		return getTypedValue((EntityType) entity);
	}

	@SuppressWarnings("unchecked")
	public void setValue(final AbstractEntity entity, final Object value) {

		setTypedValue((EntityType) entity, (PropertyType) value);
	}
}
