package com.example.secureweb.service;

import com.example.secureweb.entity.User;

public interface UserService {

	public void saveUser(User user);

	public User findByEmail(String email);

	public boolean isUserAlreadyPresent(User user);
}
