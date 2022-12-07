package com.csoep.backend.controller;

import com.csoep.backend.service.user.LoginService;
import com.csoep.backend.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 * 实现用户登录
 */
@Api(value = "登录API")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@ApiOperation("登录功能")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "用户名"),
			@ApiImplicitParam(name = "password", value = "用户密码")
	})
	@PostMapping("/user/login")
	public ResponseResult login(
			@RequestParam String username,
			@RequestParam String password
	) {
		// 登录
		return loginService.login(username, password);
	}

}

