package com.alfascompany.qonline.bean;

import com.alfascompany.persistence.AbstractEntityDescriptor;
import com.alfascompany.persistence.Property;
import com.alfascompany.persistence.GenericAccessor;

public class UserDescriptor extends AbstractEntityDescriptor<User> {

	@Override
	public String getKind() {
		return "user";
	}

	@Override
	public Property[] getEntityProperties() {
		return new Property[] {
				createIdProperty(), createCreationDateProperty(), createLastModifiedDateProperty(),
				createProperty("name", new GenericAccessor<User, String>() {

					@Override
					public String getTypedValue(final User entity) {
						return entity.getName();
					}

					@Override
					public void setTypedValue(final User entity, final String value) {
						entity.setName(value);
					}
				}), createProperty("pashas", new GenericAccessor<User, String>() {

					@Override
					public String getTypedValue(final User entity) {
						return entity.getPasswordHash();
					}

					@Override
					public void setTypedValue(final User entity, final String value) {
						entity.setPasswordHash(value);
					}
				})
		};
	}

	@Override
	public User getNewDomainEntityInstance() {
		return new User();
	}

}
