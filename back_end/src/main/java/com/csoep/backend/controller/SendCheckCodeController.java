package com.csoep.backend.controller;

import com.csoep.backend.service.mail.CheckCodeService;
import com.csoep.backend.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送验证码接口
 */
@RestController
public class SendCheckCodeController {

	@Autowired
	private CheckCodeService checkCodeService;

	@PostMapping("/send/checkcode")
	public ResponseResult sendCheckCode(
			@RequestParam String ops,
			@RequestParam String email
	) {
		return checkCodeService.sendCheckCode(ops, email);
	}

}
