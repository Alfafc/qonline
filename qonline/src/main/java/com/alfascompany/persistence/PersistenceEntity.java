package com.alfascompany.persistence;

import com.alfascompany.utils.TimeUtils;

public class PersistenceEntity {

	public static final String DATE_FORMAT = "yyMMddHHmmssSSS";
	private String id;
	private String lastModifiedDate;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate() {
		this.lastModifiedDate = TimeUtils.getCurrentTimeString();
	}
}
