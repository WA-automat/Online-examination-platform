package com.csoep.backend.service.user;

import com.csoep.backend.utils.ResponseResult;

/**
 * 登录服务接口
 */
public interface LoginService {
	public ResponseResult login(String username, String password);
}
