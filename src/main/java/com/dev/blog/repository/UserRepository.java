package com.dev.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
	public User findByEmail(String email);
}
