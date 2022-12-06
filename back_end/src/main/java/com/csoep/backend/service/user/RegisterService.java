package com.csoep.backend.service.user;

import com.csoep.backend.utils.ResponseResult;

/**
 * 注册接口
 */
public interface RegisterService {
	public ResponseResult register(String username,
	                               String password,
	                               String confirmPassword,
	                               String email,
	                               String phone,
	                               String checkCode);
}
