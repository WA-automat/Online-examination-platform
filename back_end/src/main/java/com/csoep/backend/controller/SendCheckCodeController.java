package com.csoep.backend.controller;

import com.csoep.backend.service.mail.CheckCodeService;
import com.csoep.backend.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送验证码接口
 */
@Api(value = "发送验证码API")
@RestController
public class SendCheckCodeController {

	@Autowired
	private CheckCodeService checkCodeService;

	@ApiOperation("发送验证码功能")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ops", value = "验证码操作"),
			@ApiImplicitParam(name = "email", value = "用户邮箱")
	})
	@GetMapping("/send/checkcode")
	public ResponseResult sendCheckCode(
			@RequestParam String ops,
			@RequestParam String email
	) {
		return checkCodeService.sendCheckCode(ops, email);
	}

}
