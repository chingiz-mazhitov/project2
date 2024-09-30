package com.andersen.dao;

import com.andersen.entity.Client;
import com.andersen.entity.User;

public interface UserDao {

	void save(User user);

	User findById(Integer id);

	User findWithTickets(Integer id);

	void delete(Integer id);
}
