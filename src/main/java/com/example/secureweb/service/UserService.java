package com.example.secureweb.service;

import com.example.secureweb.entity.User;

public interface UserService {

	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);
}
