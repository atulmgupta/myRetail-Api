package com.target.retail.service.user;

import com.target.retail.entity.user.User;

public interface UserService {

	User loadUserByUsername(String username);
	
}
