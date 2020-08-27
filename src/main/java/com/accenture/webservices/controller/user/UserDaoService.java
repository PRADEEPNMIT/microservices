package com.accenture.webservices.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	
	private static int usersCount = 3 ;
	
	static {
		users.add(new User(1,"Pradeep",new Date()));
		users.add(new User(2,"Nadeem",new Date()));
		users.add(new User(3,"Rahim",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId()==null) {
			++usersCount;
			user.setId(usersCount);
		}
		users.add(user);
		
		return user;
	}
	
	public User findOne(Integer id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	public User DeleteOne(Integer id) {
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
