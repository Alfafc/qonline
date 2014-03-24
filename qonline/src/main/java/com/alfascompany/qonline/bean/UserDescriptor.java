package com.alfascompany.qonline.bean;

import com.alfascompany.persistence.AbstractEntityDescriptor;
import com.alfascompany.persistence.GenericAccessor;
import com.alfascompany.persistence.Property;

public class UserDescriptor extends AbstractEntityDescriptor<User> {

	public final Property passwordHashProperty = createProperty("pashas", new GenericAccessor<User, String>() {

		@Override
		public String getTypedValue(final User entity) {
			return entity.getPasswordHash();
		}

		@Override
		public void setTypedValue(final User entity, final String value) {
			entity.setPasswordHash(value);
		}
	});

	public final Property nameProperty = createProperty("name", new GenericAccessor<User, String>() {

		@Override
		public String getTypedValue(final User entity) {
			return entity.getName();
		}

		@Override
		public void setTypedValue(final User entity, final String value) {
			entity.setName(value);
		}
	});

	@Override
	public String getKind() {
		return "user";
	}

	@Override
	public Property[] getEntityProperties() {
		return mergeWithDefaultEntityProperties(new Property[] {
				passwordHashProperty, nameProperty
		});
	}

	@Override
	public User getNewDomainEntityInstance() {
		return new User();
	}

}
