package com.andersen.service;

import com.andersen.entity.User;

public interface UserService {

	void save(User user);

	User findById(Integer id);

	void delete(Integer id);

}
