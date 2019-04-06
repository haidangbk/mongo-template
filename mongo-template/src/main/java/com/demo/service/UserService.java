package com.demo.service;

import java.util.List;

import com.demo.entities.User;

public interface UserService {
	public List<User> findAllUser();

	public User findUserById(String id);
	
	public void addUser(User user);
		
	public void deleteUser(User user);
	
	public List<User> searchUser(String search);
	
	public void updateUser(User user);
}
