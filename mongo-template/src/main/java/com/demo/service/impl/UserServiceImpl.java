package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAllUser() {
		return userRepository.findAllUser();
	}

	@Override
	public User findUserById(String id) {
		return userRepository.findUserById(id);
	}

	@Override
	public void addUser(User user) {
		userRepository.addUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.deleteUser(user);		
	}

	@Override
	public List<User> searchUser(String search) {
		return userRepository.searchUser(search);
	}

	@Override
	public void updateUser(User user) {
		userRepository.updateUser(user);		
	}
	
}
