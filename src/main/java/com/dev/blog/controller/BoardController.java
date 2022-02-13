package com.dev.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dev.blog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardservice;
	
	@GetMapping("/")
	public String index(Model model, @PageableDefault(size=3,sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardservice.boardlist(pageable));
		return "index"; //viewResolver
	}
	
	@GetMapping("/board/{id}")
	public String findBydId(@PathVariable int id, Model model) {
		model.addAttribute("board",boardservice.detailBoard(id));
		return "board/detail";
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id,Model model) {
		model.addAttribute("board",boardservice.detailBoard(id));
		return "/board/updateForm";
	}

}
