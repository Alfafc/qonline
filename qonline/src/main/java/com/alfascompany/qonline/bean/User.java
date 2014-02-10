package com.alfascompany.qonline.bean;

import java.io.Serializable;

import com.alfascompany.persistence.NotValidEntityException;
import com.alfascompany.persistence.PersistenceEntity;

public class User extends PersistenceEntity<User> implements Serializable {

	private static final long serialVersionUID = 5435777658240099076L;

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

	@Override
	public void validate() throws NotValidEntityException {

	}
}
