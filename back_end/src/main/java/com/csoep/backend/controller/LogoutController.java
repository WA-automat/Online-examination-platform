package com.csoep.backend.controller;

import com.csoep.backend.service.user.LogoutService;
import com.csoep.backend.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "注销API")
@RestController
public class LogoutController {

	@Autowired
	private LogoutService logoutService;

	@ApiOperation(value = "注销登录")
	@GetMapping("/user/logout")
	public ResponseResult logout() {
		return logoutService.logout();
	}

}
