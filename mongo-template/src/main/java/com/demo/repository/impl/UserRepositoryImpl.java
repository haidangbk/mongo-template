package com.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.demo.entities.User;
import com.demo.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<User> findAllUser() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public User findUserById(String id) {
		return mongoTemplate.findById(id, User.class);
	}

	@Override
	public void addUser(User user) {
		mongoTemplate.insert(user);
	}

	@Override
	public void deleteUser(User user) {
		mongoTemplate.remove(user);
	}

	@Override
	public List<User> searchUser(String search) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex(search));
		return mongoTemplate.find(query, User.class);
	}

	@Override
	public void updateUser(User user) {
		mongoTemplate.save(user);
		
	}

}