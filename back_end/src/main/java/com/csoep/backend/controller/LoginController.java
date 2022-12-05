package com.csoep.backend.controller;

import com.csoep.backend.pojo.User;
import com.csoep.backend.service.user.LoginService;
import com.csoep.backend.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 * 实现用户登录
 */
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/user/login")
	public ResponseResult login(
			@RequestParam String username,
			@RequestParam String password
	) {
		// 登录
		return loginService.login(username, password);
	}

}

