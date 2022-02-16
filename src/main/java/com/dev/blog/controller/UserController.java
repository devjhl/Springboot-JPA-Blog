package com.dev.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.blog.model.User;
import com.dev.blog.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}

	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}

	@PostMapping("/auth/idCheck")
	@ResponseBody
	public String idCheck(@RequestBody String username) {
		String checkRst;
		User idCnt =  userService.idCheck(username);
		if(idCnt != null) {//あり
			checkRst = "F"; 
			}
		else { // なし
			checkRst = "S"; 
			}
		return checkRst;
	}
	
	@PostMapping("/auth/emailCheck")
	@ResponseBody
	public String emailCheck(@RequestBody String email) {
		String checkRst;
		User emailCnt =  userService.emailCheck(email);
		if(emailCnt != null) {//あり
			checkRst = "F"; 
			}
		else { // なし
			checkRst = "S"; 
			}
		return checkRst;
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	 
}
