package com.alfascompany.persistence;

public class NotValidEntityException extends Exception {

	private static final long serialVersionUID = 7035072835871902800L;

	public NotValidEntityException(final String message) {

		super(message);
	}
}
