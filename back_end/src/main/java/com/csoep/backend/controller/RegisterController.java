package com.csoep.backend.controller;

import com.csoep.backend.service.user.RegisterService;
import com.csoep.backend.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册接口
 * 实现用户注册
 */
@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@PostMapping("/user/register")
	public ResponseResult register(
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String confirmPassword,
			@RequestParam String email,
			@RequestParam String phone
	) {
		return registerService.register(username, password, confirmPassword, email, phone);
	}

}
