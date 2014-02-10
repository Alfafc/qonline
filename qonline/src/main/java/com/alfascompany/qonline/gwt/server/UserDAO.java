package com.alfascompany.qonline.gwt.server;

import com.alfascompany.persistence.GenericDAO;
import com.alfascompany.persistence.PersistenceEntity;
import com.alfascompany.qonline.bean.User;

public class UserDAO extends GenericDAO<User> {

	@Override
	public User getById(final String id) {

		return getFakeUser(id);
	}

	@Override
	protected void saveImpl(final PersistenceEntity<User> entity) {

	}

	private User getFakeUser(final String id) {
		final User user = new User();
		user.setName("Fernando");
		user.setPasswordHash("pass");
		return user;
	}
}
