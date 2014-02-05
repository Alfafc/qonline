package com.alfascompany.qonline.gwt.shared;

import com.alfascompany.persistence.PersistenceEntity;

public class User extends PersistenceEntity {

	private String name;
	private String passwordHash;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(final String passwordHash) {
		this.passwordHash = passwordHash;
	}

}
