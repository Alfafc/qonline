package com.alfascompany.persistence;

public abstract class AbstractEntityDescriptor<EntityType extends AbstractEntity> {

	public abstract String getKind();

	public abstract Property[] getEntityProperties();

	public abstract EntityType getNewDomainEntityInstance();

	protected <PropertyType> Property createProperty(final String key,
			final GenericAccessor<EntityType, PropertyType> accesor) {
		return GenericProperty.create(key, accesor);
	}

	protected Property createIdProperty() {

		return createProperty("id", new GenericAccessor<EntityType, Long>() {

			@Override
			public Long getTypedValue(final EntityType entity) {
				return entity.getId();
			}

			@Override
			public void setTypedValue(final EntityType entity, final Long value) {
				entity.setId(value);
			}

		});
	}

	protected Property createCreationDateProperty() {

		return createProperty("cd", new GenericAccessor<EntityType, String>() {

			@Override
			public String getTypedValue(final EntityType entity) {
				return entity.getCreationDate();
			}

			@Override
			public void setTypedValue(final EntityType entity, final String value) {
				entity.setCreationDate(value);
			}

		});
	}

	protected Property createLastModifiedDateProperty() {

		return createProperty("lmd", new GenericAccessor<EntityType, String>() {

			@Override
			public String getTypedValue(final EntityType entity) {
				return entity.getLastModifiedDate();
			}

			@Override
			public void setTypedValue(final EntityType entity, final String value) {
				entity.setLastModifiedDate(value);
			}

		});
	}
}
