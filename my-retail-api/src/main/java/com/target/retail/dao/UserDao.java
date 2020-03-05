package com.target.retail.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.target.retail.entity.user.User;
@Component
public class UserDao implements Dao<User> {
	List<User> users = new ArrayList<User>();

	public UserDao() {
		users.add(new User("admin", "AteRActiTnEM"));
		users.add(new User("storeAdmin", "fArKeNticklE"));
	}

	@Override
	public User get(String username) {
		
		return users.get(0);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User t) {
		users.add(t);

	}

	@Override
	public void update(User t, String[] params) {
		

	}

	@Override
	public void delete(User t) {
		

	}
}
