package com.dev.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	@Transactional(readOnly = true)
	public Page<Board> boardlist(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	@Transactional(readOnly = true)
	public Board detailBoard(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("該当投稿がありません");
				});
	}
	
	@Transactional
	public void deleteById(int id) {
		boardRepository.deleteById(id);
	}
	
	@Transactional
	public void update(int id, Board requestBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("該当投稿がありません");
				}); 
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	}
}
