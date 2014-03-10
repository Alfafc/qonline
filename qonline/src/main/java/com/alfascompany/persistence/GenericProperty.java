package com.alfascompany.persistence;

public class GenericProperty<EntityType extends AbstractEntity, PropertyType> extends Property {

	private final GenericAccessor<EntityType, PropertyType> accessor;

	private GenericProperty(final String key, final GenericAccessor<EntityType, PropertyType> accessor) {
		super(key);

		this.accessor = accessor;
	}

	public static <EntityType2 extends AbstractEntity, PropertyType2> GenericProperty<EntityType2, PropertyType2> create(
			final String key, final GenericAccessor<EntityType2, PropertyType2> accesor) {

		return new GenericProperty<EntityType2, PropertyType2>(key, accesor);
	}

	@Override
	protected Accessor getAccessor() {
		return accessor;
	}

	public PropertyType getTypedValue(final EntityType entity) {

		return accessor.getTypedValue(entity);
	}

	public void setTypedValue(final EntityType entity, final PropertyType value) {

		accessor.setTypedValue(entity, value);
	}
}
