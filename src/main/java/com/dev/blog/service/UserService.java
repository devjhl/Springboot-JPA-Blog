package com.dev.blog.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.LoggerFactory;
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

}
