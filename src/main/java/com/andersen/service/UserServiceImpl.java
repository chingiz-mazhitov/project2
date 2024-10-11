package com.andersen.service;

import com.andersen.repo.UserRepository;
import com.andersen.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Transactional(readOnly = true)
	@Override
	public User findById(Integer id) {
		Optional<User> result =  userRepository.findById(id);

		User user = null;
		if (result.isPresent()) {
			user = result.get();
		} else {
			log.error("Did not find user id - {}", id);
		}
		return user;
	}

	@Transactional(readOnly = true)
	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
}
