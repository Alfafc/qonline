package com.alfascompany.persistence;

import java.io.Serializable;

import com.alfascompany.utils.TimeUtils;

public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4041991017243015721L;

	private String key;
	private String creationDate;
	private String lastModifiedDate;

	public String getKey() {
		return key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(final String lastModifiedDate) {

		this.lastModifiedDate = lastModifiedDate;
	}

	public boolean isPersisted() {

		return getCreationDate() != null;
	}

	public abstract void validate() throws NotValidEntityException;

	public void prepareToPersist() {

		final String currentTimeString = TimeUtils.getCurrentTimeString();
		if (!isPersisted())
			setCreationDate(currentTimeString);

		setLastModifiedDate(currentTimeString);
	}

}
