package com.dev.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.blog.dto.ReplySaveRequestDto;
import com.dev.blog.model.Board;
import com.dev.blog.model.Reply;
import com.dev.blog.model.User;
import com.dev.blog.repository.BoardRepository;
import com.dev.blog.repository.ReplyRepository;
import com.dev.blog.repository.UserRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void save(Board board,User user) {
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
	
	@Transactional
	public void replySave(ReplySaveRequestDto replySaveRequestDto) {
		
		System.out.println("service"+replySaveRequestDto);
		
		User user = userRepository.findById(replySaveRequestDto.getUserId()).orElseThrow(()->{
			return new IllegalArgumentException("該当idを探せません。");
		});
		
		Board board = boardRepository.findById(replySaveRequestDto.getBoardId()).orElseThrow(()->{
			return new IllegalArgumentException("投稿idを探せません。");
		});
		
		Reply reply = new Reply();
		reply.update(user, board, replySaveRequestDto.getContent());
		
		replyRepository.save(reply);
	}
	@Transactional
	public void replyDelete(int replyId) {
		replyRepository.deleteById(replyId);
	}
}
