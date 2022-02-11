package com.dev.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
}
