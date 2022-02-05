package com.dev.blog.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.blog.model.User;
import com.dev.blog.repository.UserRepository;

//Bean 登録(Ioc)
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public int save(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : join():" + e.getMessage());
		}
		return -1;
	}

	@Transactional
	public User idDuplicate(String username) {
		User user = userRepository.findByUsername(username).orElseGet(() -> {
			return new User();
		});
		return user;
	}

}
