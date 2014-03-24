package com.alfascompany.persistence;

public abstract class AbstractEntityDescriptor<EntityType extends AbstractEntity> {

	public final Property idProperty = createProperty("Key", new GenericAccessor<EntityType, String>() {

		@Override
		public String getTypedValue(final EntityType entity) {
			return entity.getKey();
		}

		@Override
		public void setTypedValue(final EntityType entity, final String value) {
			entity.setKey(value);
		}

	});

	public final Property creationDateProperty = createProperty("cd", new GenericAccessor<EntityType, String>() {

		@Override
		public String getTypedValue(final EntityType entity) {
			return entity.getCreationDate();
		}

		@Override
		public void setTypedValue(final EntityType entity, final String value) {
			entity.setCreationDate(value);
		}

	});

	public final Property lastModifiedDateProperty = createProperty("lmd", new GenericAccessor<EntityType, String>() {

		@Override
		public String getTypedValue(final EntityType entity) {
			return entity.getLastModifiedDate();
		}

		@Override
		public void setTypedValue(final EntityType entity, final String value) {
			entity.setLastModifiedDate(value);
		}

	});

	public abstract String getKind();

	public abstract Property[] getEntityProperties();

	public abstract EntityType getNewDomainEntityInstance();

	protected Property[] mergeWithDefaultEntityProperties(final Property[] properties) {

		final Property[] defaultProperties = getDefaultEntityProperties();
		final Property[] allProperties = new Property[defaultProperties.length + properties.length];

		int index = 0;
		while (index < allProperties.length) {

			final Property property;
			if (index < defaultProperties.length)
				property = defaultProperties[index];
			else
				property = properties[index - defaultProperties.length];

			allProperties[index++] = property;
		}

		return allProperties;
	}

	protected <PropertyType> Property createProperty(final String key,
			final GenericAccessor<EntityType, PropertyType> accesor) {
		return GenericProperty.create(key, accesor);
	}

	private Property[] getDefaultEntityProperties() {

		return new Property[] {
				idProperty, creationDateProperty, lastModifiedDateProperty
		};
	}

}
