package com.dev.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dev.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	
}
