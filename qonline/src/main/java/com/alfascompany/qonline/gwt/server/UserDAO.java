package com.alfascompany.qonline.gwt.server;

import com.alfascompany.persistence.GenericDAO;
import com.alfascompany.qonline.gwt.shared.User;

public class UserDAO extends GenericDAO<User> {

	@Override
	public User getById(final String id) {

		return getFakeUser(id);
	}

	@Override
	public void save(final User entity) {
	}

	private User getFakeUser(final String id) {
		final User user = new User();
		user.setId(id);
		user.setName("Fernando");
		user.setPasswordHash("pass");
		return user;
	}

}
