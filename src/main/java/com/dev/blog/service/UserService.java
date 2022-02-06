package com.dev.blog.service;

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
	
	public User idCheck(String username) {
		User user = userRepository.findByUsername(username); 
		return user; 
	}
	
	public User emailCheck(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}


}
