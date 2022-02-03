package com.dev.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.blog.dto.ResponseDto;
import com.dev.blog.model.Privilege;
import com.dev.blog.model.User;
import com.dev.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("userApiController:save ");
		user.setPrivilege(Privilege.USER);
		int result = userService.save(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
