package com.target.retail.service.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.target.retail.dao.UserDao;
import com.target.retail.entity.user.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userRepo;
	
	@Override
	public User loadUserByUsername(String username) {
		return userRepo.get(username);
		
	}

}
