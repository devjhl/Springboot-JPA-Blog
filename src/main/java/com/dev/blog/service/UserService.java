package com.dev.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dev.blog.model.Privilege;
import com.dev.blog.model.User;
import com.dev.blog.repository.UserRepository;

//Bean 登録(Ioc)
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encode;

	@Transactional(propagation = Propagation.NEVER)
	public void save(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encode.encode(rawPassword);
		user.setPassword(encPassword);
		user.setPrivilege(Privilege.USER);
		userRepository.save(user);
	}

	// DBで存在確認

	@Transactional
	public User idCheck(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	@Transactional
	public User emailCheck(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Transactional
	public void updateUser(User user) {
		System.out.println("service" + user);

		User persistance = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("会員検索失敗");
		});

		String rawPassword = user.getPassword();
		String encPasswoard = encode.encode(rawPassword);

		persistance.setPassword(encPasswoard);
		persistance.setEmail(user.getEmail());
	}
}
