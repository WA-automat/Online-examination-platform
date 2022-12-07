package com.csoep.backend.controller;

import com.csoep.backend.service.user.RegisterService;
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
 * 注册接口
 * 实现用户注册
 */
@Api(value = "注册API")
@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@ApiOperation("注册功能")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "用户名"),
			@ApiImplicitParam(name = "password", value = "用户密码"),
			@ApiImplicitParam(name = "confirmPassword", value = "用户确认密码"),
			@ApiImplicitParam(name = "email", value = "用户邮箱"),
			@ApiImplicitParam(name = "phone", value = "用户手机号码"),
			@ApiImplicitParam(name = "checkCode", value = "邮箱验证码")
	})
	@PostMapping("/user/register")
	public ResponseResult register(
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String confirmPassword,
			@RequestParam String email,
			@RequestParam String phone,
			@RequestParam String checkCode
	) {
		return registerService.register(username, password, confirmPassword, email, phone, checkCode);
	}

}
