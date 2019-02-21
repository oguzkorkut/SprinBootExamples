package com.okorkut.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService2 {

	private static List<User> users = new ArrayList<User>();

	static {
		users.add(new User(1, "Oğuz", new Date()));
		users.add(new User(2, "Mehmet", new Date()));
		users.add(new User(3, "Vakkas", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (users.size() == 0) {
			user.setId(1);
		} else {
			user.setId(users.get(users.size() - 1).getId() + 1);
		}

		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteUserById(Integer id) {
		
		Iterator<User> iterator = users.iterator();
		
		while (iterator.hasNext()) {
			User user = iterator.next();
			
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
			
		}
		
		return null;
	}

}
