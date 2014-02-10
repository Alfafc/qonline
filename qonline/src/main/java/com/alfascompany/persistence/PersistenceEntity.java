package com.alfascompany.persistence;

import com.alfascompany.utils.TimeUtils;

public abstract class PersistenceEntity<T> {

	public static final String DATE_FORMAT = "yyMMddHHmmssSSS";
	private String id;
	private String lastModifiedDate;

	public String getId() {
		return id;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate() {
		this.lastModifiedDate = TimeUtils.getCurrentTimeString();
	}

	public abstract void validate() throws NotValidEntityException;
}
