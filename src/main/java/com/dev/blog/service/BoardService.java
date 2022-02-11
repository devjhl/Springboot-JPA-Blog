package com.dev.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.blog.model.Board;
import com.dev.blog.model.User;
import com.dev.blog.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void save(Board board,User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}

}
