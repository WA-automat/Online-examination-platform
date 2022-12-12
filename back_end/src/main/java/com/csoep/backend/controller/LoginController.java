package com.csoep.backend.controller;

import com.csoep.backend.service.user.LoginService;
import com.csoep.backend.service.user.ResetService;
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
 * 补充：重置密码的API
 */
@Api(value = "登录API")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private ResetService resetService;

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

	@ApiOperation("重置密码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "email", value = "邮箱"),
			@ApiImplicitParam(name = "checkCode", value = "验证码"),
			@ApiImplicitParam(name = "password", value = "用户密码"),
			@ApiImplicitParam(name = "confirmPassword", value = "确认密码")
	})
	@PostMapping("/user/reset")
	public ResponseResult resetPassword(
			@RequestParam String email,
			@RequestParam String checkCode,
			@RequestParam String password,
			@RequestParam String confirmPassword
	) {
		// 密码
		return resetService.resetPassword(email, checkCode, password, confirmPassword);
	}

}

