package com.alfascompany.persistence;

import com.alfascompany.utils.TimeUtils;

public abstract class AbstractEntity {

	private Long id;
	private String creationDate;
	private String lastModifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
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
