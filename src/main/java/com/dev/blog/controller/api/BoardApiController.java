package com.dev.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.blog.config.auth.PrincipalDetail;
import com.dev.blog.dto.ResponseDto;
import com.dev.blog.model.Board;
import com.dev.blog.service.BoardService;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;

	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail piDetail) {
		boardService.save(board, piDetail.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
